package com.PRM392.hongvietbui.assignment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.PRM392.hongvietbui.assignment.Adapters.CategoryAdapter;
import com.PRM392.hongvietbui.assignment.Models.Category;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Danh sách các category
        List<Category> categories = Arrays.asList(
                new Category(R.drawable.ic_pharmacy, "Pharmacy"),
                new Category(R.drawable.ic_registry, "Registry"),
                new Category(R.drawable.ic_cartwheel, "Cartwheel"),
                new Category(R.drawable.ic_clothing, "Clothing"),
                new Category(R.drawable.ic_shoes, "Shoes"),
                new Category(R.drawable.ic_accessories, "Accessories"),
                new Category(R.drawable.ic_clothing, "Clothing"),
                new Category(R.drawable.ic_home, "Home"),
                new Category(R.drawable.ic_patlo_gardern, "Patio & Garden")
        );
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3)); // 3 cột
        recyclerView.setAdapter(new CategoryAdapter(categories));
    }
}
