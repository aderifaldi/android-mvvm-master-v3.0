package com.radyalabs.mobileagent.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.radyalabs.mobileagent.R;
import com.radyalabs.mobileagent.databinding.ProductDetailActivityBinding;
import com.radyalabs.mobileagent.databinding.ProductDetailDataBinding;
import com.radyalabs.mobileagent.helper.Constant;
import com.radyalabs.mobileagent.model.api.Product;
import com.radyalabs.mobileagent.model.api.ProductDetail;
import com.radyalabs.mobileagent.viewmodel.ProductDetailViewModel;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class ProductDetailActivity extends BaseActivity {

    private ProductDetailActivityBinding productDetailActivityBinding;
    private ProductDetailViewModel viewModel;
    private Product.Products product;
    private ProductDetailDataBinding productDetailDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productDetailActivityBinding = DataBindingUtil.setContentView(this, R.layout.product_detail_activity);

        product = (Product.Products) getIntent().getExtras().getSerializable("product");
        viewModel = ViewModelProviders.of(this).get(ProductDetailViewModel.class);

        loadProductDetail();

    }

    private void loadProductDetail() {

        viewModel.showLoading(this, true);
        viewModel.getProductDetail(getApplicationContext(), product.getId());
        viewModel.getApiResponse().observe(this, apiResponse -> {

            viewModel.dismissLoading();

            if (apiResponse != null) {
                ProductDetail data = (ProductDetail) apiResponse.getData();

                if (data != null){
                    if (data.getStatus().equals(Constant.SUCCESS)) {
                        productDetailDataBinding = new ProductDetailDataBinding(data.getProduct());
                        productDetailActivityBinding.setProductDetailData(productDetailDataBinding);
                    } else {
                        viewModel.showToast(getApplicationContext(), data.getAlerts().getMessage());
                    }
                }

            }

        });

    }

}
