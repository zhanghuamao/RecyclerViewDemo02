package com.example.recyclerviewdemo02.data;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class FakeDataSource {
    private MutableLiveData<List<Product>> listMutableLiveData;
    private List<Product> list;

    public FakeDataSource() {
        listMutableLiveData = new MutableLiveData<>();
        list = new ArrayList<>();
        listMutableLiveData.setValue(list);
    }

    public void add(Product product) {
        list.add(product);
        listMutableLiveData.postValue(list);
    }

    public void delete(int index) {
        if (list.size() < index) {
            return;
        }
        list.remove(index);
        listMutableLiveData.setValue(list);
    }

    public void modify(int index, Product product) {
        if (list.size() < index) {
            return;
        }
        list.set(index, product);
        listMutableLiveData.setValue(list);
    }

    public MutableLiveData<List<Product>> getList() {
        return listMutableLiveData;
    }
}
