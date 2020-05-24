package com.frankson.app;

import com.frankson.app.model.Category;
import com.frankson.app.model.Item;
import com.frankson.app.repository.CategoryRepository;
import com.frankson.app.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Informática");
        Category category2 = new Category(null, "Escritório");

        Item item1 = new Item(null, "Computador", 2000.00);
        Item item2 = new Item(null, "Impressora", 800.00);
        Item item3 = new Item(null, "Mouse", 80.00);

        category1.getItems().addAll(Arrays.asList(item1, item2, item3));
        category2.getItems().add(item2);

        item1.getCategories().add(category1);
        item2.getCategories().addAll(Arrays.asList(category1, category2));
        item3.getCategories().add(category1);

        categoryRepository.saveAll(Arrays.asList(category1, category2));
        itemRepository.saveAll(Arrays.asList(item1, item2, item3));
    }
}
