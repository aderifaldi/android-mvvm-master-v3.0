package com.radyalabs.mobileagent.viewmodel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.radyalabs.mobileagent.R;
import com.radyalabs.mobileagent.model.api.ApiResponse;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

class BaseViewModel extends ViewModel {

    MediatorLiveData<ApiResponse> apiResponse;
    ProgressDialog progressDialog;

    BaseViewModel() {
        apiResponse = new MediatorLiveData<>();
    }

    //Todo: Show Progress Loading
    void showProgressLoading(Context context, boolean isCancelable) {

        progressDialog = new ProgressDialog(context);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(isCancelable);
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

    }

    //Todo: Dismiss Progress Loading
    void dismissProgressLoading() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    void showAlertDialog(Activity activity, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialog);
        builder.setMessage(message);
        builder.setPositiveButton("Ok", null);
        builder.show();
    }

    public interface IBaseViewModel {

        void showLoading(Context context, boolean isCancelable);
        void dismissLoading();
        void showAlert(Activity activity, String message);
        void showToast(Context context, String message);

    }

}
