package com.company.araa.Inventory.response;

import com.company.araa.Inventory.models.Category;
import lombok.Data;

import java.util.List;
@Data
public class CategoryResponse {
    private List<Category> categories;

}
