package com.ade.mvvmmaster.data.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.ade.mvvmmaster.R;
import com.ade.mvvmmaster.helper.AppUtility;
import com.ade.mvvmmaster.model.api.ApiResponse;
import com.ade.mvvmmaster.model.api.ProductDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class GetProductDetail extends BaseApi {

    //Todo: Get Product Detail
    public LiveData<ApiResponse> getProductDetail(Context context, String id) {

        liveData = new MutableLiveData<>();
        Call<ProductDetail> call = mApiService.loadProductDetail(id);

        call.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(@NonNull Call<ProductDetail> call, @NonNull Response<ProductDetail> response) {
                try {
                    ApiResponse<ProductDetail> product = new ApiResponse<>();
                    product.setData(response.body());
                    liveData.setValue(product);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductDetail> call, @NonNull Throwable t) {
                AppUtility.logD("GetProductDetail", "on failure : " + t);
                Toast.makeText(context, R.string.connection_problem_message, Toast.LENGTH_SHORT).show();
                ApiResponse<Throwable> throwable = new ApiResponse<>();
                throwable.setError(t);
                liveData.setValue(throwable);
            }
        });

        return liveData;
    }

}
