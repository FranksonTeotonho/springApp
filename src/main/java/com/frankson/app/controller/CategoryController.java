package com.frankson.app.controller;

import com.frankson.app.model.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list() {
        Category category1 = new Category(1, "Category1");
        Category category2 = new Category(2, "Category2");

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);

        return list;
    }

}
