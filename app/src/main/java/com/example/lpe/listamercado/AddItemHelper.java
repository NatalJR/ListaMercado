package com.example.lpe.listamercado;

import android.widget.ListView;

import com.example.lpe.listamercado.modelo.ListaProdutos;

/**
 * Created by natal on 27/11/16.
 */

public class AddItemHelper {

    private final ListView lista;

    public AddItemHelper(AddItemActivity activity) {
        lista = (ListView) activity.findViewById(R.id.add_item_list);
    }

//    public ListaProdutos listaProdutos() {
//        ListaProdutos productList = new ListaProdutos();
//        productList.setProductList(lista.);
//    }
}
