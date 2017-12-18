package com.radyalabs.mobileagent.data.api;

import com.google.gson.JsonObject;
import com.radyalabs.mobileagent.model.api.OCR;
import com.radyalabs.mobileagent.model.api.Product;
import com.radyalabs.mobileagent.model.api.ProductDetail;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by aderifaldi on 08/08/2016.
 */
public interface ApiService {

    @GET("products.json")
    Call<Product> loadProduct();

    @GET("products/{id}.json")
    Call<ProductDetail> loadProductDetail(@Path("id") String id);

    @Headers("Content-Type: application/json")
    @POST("v1.0/ocr?language=unk")
    Call<OCR> getOCR(@Header("Ocp-Apim-Subscription-Key") String key, @Body JsonObject jsonObject);

}
