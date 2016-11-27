package com.example.lpe.listamercado.modelo;

import android.widget.ListView;

/**
 * Created by natal on 27/11/16.
 */
public class ListaProdutos {
    private Long id;
    private ListView productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ListView getProductList() {
        return productList;
    }

    public void setProductList(ListView productList) {
        this.productList = productList;
    }
}
