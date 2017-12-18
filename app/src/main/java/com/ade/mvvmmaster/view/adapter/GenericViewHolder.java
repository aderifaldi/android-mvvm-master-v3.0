package com.ade.mvvmmaster.view.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Irfan AFif on 10/6/2017.
 */

public class GenericViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private AdapterView.OnItemClickListener onItemClickListener;
    private ViewDataBinding binding;
    private View itemView;
    private int position;

    public GenericViewHolder(ViewDataBinding dataBinding) {
        super(dataBinding.getRoot());
        itemView = dataBinding.getRoot();
        binding = dataBinding;

        itemView.setOnClickListener(this);
    }

    public void bindModel(int modelType, Object obj, int i, AdapterView.OnItemClickListener onItemClick) {
        onItemClickListener = onItemClick;
        position = i;

        binding.setVariable(modelType, obj);
        binding.executePendingBindings();
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick(null, view, position, 0);
    }
}
