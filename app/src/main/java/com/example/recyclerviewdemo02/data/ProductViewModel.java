package com.example.recyclerviewdemo02.data;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductViewModel extends ViewModel {
    private ProductRepository repository;

    public ProductViewModel() {
        repository = new ProductRepository();
    }

    public void add(Product product) {
        repository.add(product);
    }

    public void delete(int index) {
        repository.delete(index);
    }

    public void modify(int index, Product product) {
        repository.modify(index, product);
    }

    public MutableLiveData<List<Product>> getList() {
        return repository.getList();
    }
}
