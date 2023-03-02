package com.company.araa.Inventory.response;

import com.company.araa.Inventory.util.ResponseRest;
import lombok.Data;

@Data
public class CategoryResponseRest extends ResponseRest {
    private  CategoryResponse categoryResponse = new CategoryResponse();

    public CategoryResponseRest(String type, String code, String date) {
        super(type, code, date);
    }

}
