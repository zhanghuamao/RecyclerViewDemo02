package com.example.recyclerviewdemo02.data;

import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class ProductRepository {
    private FakeDataSource fakeDataSource;

    public ProductRepository() {
        fakeDataSource = new FakeDataSource();
    }

    public void add(Product product) {
        fakeDataSource.add(product);
    }

    public void delete(int index) {
        fakeDataSource.delete(index);
    }

    public void modify(int index, Product product) {
        fakeDataSource.modify(index, product);
    }

    public MutableLiveData<List<Product>> getList() {
        return fakeDataSource.getList();
    }
}
