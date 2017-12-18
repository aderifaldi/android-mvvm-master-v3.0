package com.ade.mvvmmaster.model.api;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Hizkia on 16/01/2017.
 */
@NoArgsConstructor
@Data
public class ApiResponse<T> {
    private T data;
    private T error;
}
