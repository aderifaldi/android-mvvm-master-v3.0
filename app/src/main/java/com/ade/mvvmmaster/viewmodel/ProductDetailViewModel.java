package com.ade.mvvmmaster.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ade.mvvmmaster.data.api.GetProductDetail;
import com.ade.mvvmmaster.model.api.ApiResponse;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class ProductDetailViewModel extends BaseViewModel implements BaseViewModel.IBaseViewModel {

    //Todo: Return Response
    @NonNull
    public LiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    //Todo: Get Product Detail
    public void getProductDetail(Context context, String id) {
        GetProductDetail api = new GetProductDetail();
        apiResponse.addSource(
                api.getProductDetail(context, id),
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
