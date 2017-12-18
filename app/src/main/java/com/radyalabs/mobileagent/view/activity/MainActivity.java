package com.radyalabs.mobileagent.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.radyalabs.mobileagent.R;
import com.radyalabs.mobileagent.data.cache.CacheManager;
import com.radyalabs.mobileagent.data.cache.AppDatabase;
import com.radyalabs.mobileagent.helper.Constant;
import com.radyalabs.mobileagent.model.api.Product;
import com.radyalabs.mobileagent.view.adapter.ProductListAdapter;
import com.radyalabs.mobileagent.viewmodel.ProductListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.list_product)
    RecyclerView listProduct;

    private ProductListViewModel viewModel;
    private LinearLayoutManager linearLayoutManager;
    private ProductListAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewModel = ViewModelProviders.of(this).get(ProductListViewModel.class);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new ProductListAdapter();

        listProduct.setLayoutManager(linearLayoutManager);
        listProduct.setAdapter(adapter);

        db = AppDatabase.getDatabase(getApplicationContext());

        loadProductList();

        adapter.setOnItemClickListener((adapterView, view, i, l) ->{
            Product.Products product = adapter.getData().get(i);
            startActivity(new Intent(getApplicationContext(), ProductDetailActivity.class)
                    .putExtra("product", product));
        });

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void loadProductList() {

        viewModel.showLoading(this, false);
        viewModel.getProductList(getApplicationContext(), db, Constant.CACHE_PRODUCT);
        viewModel.getApiResponse().observe(this, apiResponse -> {

            viewModel.dismissLoading();

            if (apiResponse != null) {
                Product data = (Product) apiResponse.getData();

                if (data != null) {
                    if (data.getStatus().equals(Constant.SUCCESS)) {
                        if (data.getProducts().size() != 0) {
                            adapter.getData().clear();

                            for (int i = 0; i < data.getProducts().size(); i++) {
                                adapter.getData().add(data.getProducts().get(i));
                                adapter.notifyItemInserted(adapter.getData().size() - 1);
                            }
                            adapter.notifyDataSetChanged();

                            CacheManager.checkCache(db, Constant.CACHE_PRODUCT);
                            CacheManager.storeCache(db, Constant.CACHE_PRODUCT, new Gson().toJson(data));
                        }
                    } else {
                        viewModel.showToast(getApplicationContext(), data.getAlerts().getMessage());
                    }
                }

            }

        });

    }

}
