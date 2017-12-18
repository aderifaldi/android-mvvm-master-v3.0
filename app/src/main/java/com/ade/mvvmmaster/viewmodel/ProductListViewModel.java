package com.ade.mvvmmaster.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ade.mvvmmaster.data.api.GetProductList;
import com.ade.mvvmmaster.data.cache.AppDatabase;
import com.ade.mvvmmaster.model.api.ApiResponse;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class ProductListViewModel extends BaseViewModel implements BaseViewModel.IBaseViewModel {

    //Todo: Return Response
    @NonNull
    public LiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    //Todo: Get Product List
    public void getProductList(Context context, AppDatabase db, int cacheType) {
        GetProductList api = new GetProductList();
        apiResponse.addSource(
                api.getProduct(context, db, cacheType),
                apiResponse -> this.apiResponse.setValue(apiResponse)
        );
    }

    @Override
    public void showLoading(Context context, boolean isCancelable) {
        showProgressLoading(context, isCancelable);
    }

    @Override
    public void dismissLoading() {
        dismissProgressLoading();
    }

    @Override
    public void showAlert(Activity activity, String message) {
        showAlertDialog(activity, message);
    }

    @Override
    public void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
