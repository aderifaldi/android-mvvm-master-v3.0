package com.ade.mvvmmaster.data.api;

import com.ade.mvvmmaster.model.api.Product;
import com.ade.mvvmmaster.model.api.ProductDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by aderifaldi on 08/08/2016.
 */
public interface ApiService {

    @GET("products.json")
    Call<Product> loadProduct();

    @GET("products/{id}.json")
    Call<ProductDetail> loadProductDetail(@Path("id") String id);

}
