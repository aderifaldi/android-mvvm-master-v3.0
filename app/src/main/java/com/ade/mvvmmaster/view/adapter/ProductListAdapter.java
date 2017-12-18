package com.ade.mvvmmaster.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ade.mvvmmaster.BR;
import com.ade.mvvmmaster.R;
import com.ade.mvvmmaster.databinding.ProductListDataBinding;
import com.ade.mvvmmaster.model.api.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by RadyaLabs PC on 11/10/2017.
 */

public class ProductListAdapter extends RecyclerView.Adapter<GenericViewHolder> {
    private List<Product.Products> listItem;
    private AdapterView.OnItemClickListener onItemClickListener;
    private ViewDataBinding binding;

    public ProductListAdapter() {
        listItem = new ArrayList<>();
    }

    public List<Product.Products> getData() {
        return listItem;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public GenericViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.product_item, parent, false);
        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GenericViewHolder holder, int position) {
        Product.Products itemData = listItem.get(position);
        ProductListDataBinding viewModel = new ProductListDataBinding(itemData);
        holder.bindModel(BR.productData, viewModel, position, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }
}
