package com.example.recyclerviewdemo02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.recyclerviewdemo02.data.Product;
import com.example.recyclerviewdemo02.data.ProductViewModel;
import com.example.recyclerviewdemo02.databinding.ActivityMainBinding;
import com.example.recyclerviewdemo02.ui.MyAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyAdapter adapter;
    private ProductViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(ProductViewModel.class);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(model);
        binding.recyclerView.setAdapter(adapter);

        binding.add.setOnClickListener(view -> {
            if (TextUtils.isEmpty(binding.name.getText())
                    || TextUtils.isEmpty(binding.price.getText())) {
                Toast.makeText(this, "请输入名称和价格", Toast.LENGTH_SHORT).show();
                return;
            }
            String name = binding.name.getText().toString();
            String price = binding.price.getText().toString();

            Product product = new Product();
            product.setName(name);
            product.setPrice(Float.parseFloat(price));

            model.add(product);
        });

        model.getList().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.notifyDataSetChanged();
            }
        });
    }
}