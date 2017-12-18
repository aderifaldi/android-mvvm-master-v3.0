package com.radyalabs.mobileagent.data.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.radyalabs.mobileagent.helper.AppUtility;
import com.radyalabs.mobileagent.model.api.ApiResponse;
import com.radyalabs.mobileagent.model.api.OCR;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class GetOCRText extends BaseApi {

    //Todo: Get Product List
    public LiveData<ApiResponse> getOCR(String url) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", url);

        liveData = new MutableLiveData<>();
        Call<OCR> call = mApiService.getOCR("eb237171163f463e8cc9c68b6566871b", jsonObject);

        call.enqueue(new Callback<OCR>() {
            @Override
            public void onResponse(@NonNull Call<OCR> call, @NonNull Response<OCR> response) {
                try {
                    ApiResponse<OCR> product = new ApiResponse<>();
                    product.setData(response.body());
                    liveData.setValue(product);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OCR> call, @NonNull Throwable t) {
                AppUtility.logD("GetProductList", "on failure : " + t);
                ApiResponse<Throwable> throwable = new ApiResponse<>();
                throwable.setError(t);
                liveData.setValue(throwable);
            }
        });

        return liveData;
    }

}
