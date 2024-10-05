package com.PRM392.hongvietbui.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.PRM392.hongvietbui.assignment.Adapters.CategoryAdapter;
import com.PRM392.hongvietbui.assignment.Models.Category;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Xử lý sự kiện khi nhấn vào các item trong menu
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_cart) {
            Toast.makeText(this, "Cart clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Navigation clicked", Toast.LENGTH_SHORT).show();
            }
        });

        List<Category> categories = Arrays.asList(
                new Category(R.drawable.ic_pharmacy, "Pharmacy"),
                new Category(R.drawable.ic_registry, "Registry"),
                new Category(R.drawable.ic_cartwheel, "Cartwheel"),
                new Category(R.drawable.ic_clothing, "Clothing"),
                new Category(R.drawable.ic_shoes, "Shoes"),
                new Category(R.drawable.ic_accessories, "Accessories"),
                new Category(R.drawable.ic_clothing, "Clothing"),
                new Category(R.drawable.ic_home, "Home"),
                new Category(R.drawable.ic_patlo_gardern, "Patio & Garden"),
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

        CategoryAdapter adapter = new CategoryAdapter(categories, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Category category) {
                showCategoryDetail(category);
            }
        });


        recyclerView.setAdapter(adapter);
    }

    private void showCategoryDetail(Category category) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("CATEGORY_ID", category.getIconResId());
        startActivity(intent);
    }
}
