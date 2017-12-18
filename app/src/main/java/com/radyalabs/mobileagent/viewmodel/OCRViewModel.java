package com.radyalabs.mobileagent.viewmodel;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.radyalabs.mobileagent.data.api.GetOCRText;
import com.radyalabs.mobileagent.data.api.GetProductDetail;
import com.radyalabs.mobileagent.model.api.ApiResponse;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class OCRViewModel extends BaseViewModel implements BaseViewModel.IBaseViewModel {

    //Todo: Return Response
    @NonNull
    public LiveData<ApiResponse> getApiResponse() {
        return apiResponse;
    }

    //Todo: Get Product Detail
    public void getOCRText(String url) {
        GetOCRText api = new GetOCRText();
        apiResponse.addSource(
                api.getOCR(url),
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
