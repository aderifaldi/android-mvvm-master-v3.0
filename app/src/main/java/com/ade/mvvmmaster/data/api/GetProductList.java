package com.ade.mvvmmaster.data.api;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ade.mvvmmaster.R;
import com.ade.mvvmmaster.data.cache.AppDatabase;
import com.ade.mvvmmaster.model.api.ApiResponse;
import com.ade.mvvmmaster.model.api.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by RadyaLabs PC on 29/11/2017.
 */

public class GetProductList extends BaseApi {

    private AppDatabase db;
    private int cacheType;

    //Todo: Get Product List
    public LiveData<ApiResponse> getProduct(Context context, AppDatabase db, int cacheType) {
        this.db = db;
        this.cacheType = cacheType;

        liveData = new MutableLiveData<>();
        Call<Product> call = mApiService.loadProduct();

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                try {
                    ApiResponse<Product> data = new ApiResponse<>();
                    data.setData(response.body());
                    liveData.setValue(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Product> call, @NonNull Throwable t) {

                Toast.makeText(context, R.string.connection_problem_message, Toast.LENGTH_SHORT).show();

                Product product = loadCache();

                if (product != null) {
                    ApiResponse<Product> data = new ApiResponse<>();
                    data.setData(product);
                    liveData.setValue(data);
                } else {
                    ApiResponse<Throwable> throwable = new ApiResponse<>();
                    throwable.setError(t);
                    liveData.setValue(throwable);
                }

            }
        });

        return liveData;
    }

    private Product loadCache() {
        try {
            JsonObject json = new JsonParser().parse(db.cacheDao().loadCacheById(cacheType).json).getAsJsonObject();
            return new GsonBuilder().create().fromJson(json, Product.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
