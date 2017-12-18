package com.radyalabs.mobileagent.model.api;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by RadyaLabs PC on 11/10/2017.
 */
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@Data
public class Product extends BaseModel implements Serializable{

    private List<Products> products;

    @NoArgsConstructor
    @Data
    public static class Products implements Serializable {

        private long price;
        private String id;
        private String name;
        private String desc;
        private List<String> images;

    }

}
