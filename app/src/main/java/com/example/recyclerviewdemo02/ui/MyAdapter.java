package com.example.recyclerviewdemo02.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.example.recyclerviewdemo02.data.Product;
import com.example.recyclerviewdemo02.data.ProductViewModel;
import com.example.recyclerviewdemo02.databinding.CellBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private CellBinding binding;
    private ProductViewModel viewModel;

    public MyAdapter(ProductViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CellBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        List<Product> list = viewModel.getList().getValue();
        if (list.size() > 0) {
            Product product = list.get(position);
            binding.name.setText(product.getName());
            binding.price.setText(product.getPrice() + "¥");
            binding.index.setText(String.valueOf(position + 1));
        }
    }

    @Override
    public int getItemCount() {
        List<Product> list = viewModel.getList().getValue();
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private CellBinding binding;

        public MyViewHolder(@NonNull CellBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
    }
}
