package com.example.lpe.listamercado;

import android.widget.EditText;

import com.example.lpe.listamercado.modelo.Produto;

/**
 * Created by natal on 28/11/16.
 */

public class AddProdutoHelper {
    private final EditText campoProduto;
    private final EditText campoQuantidade;

    public AddProdutoHelper(AddProdutoActivity activity){
        campoProduto = (EditText) activity.findViewById(R.id.add_item_produto);
        campoQuantidade = (EditText) activity.findViewById(R.id.add_item_qtd);
    }

    public Produto getProduto() {
        Produto produto = new Produto();
        produto.setProduto(campoProduto.getText().toString());
        produto.setQuantidade(Integer.parseInt(campoQuantidade.getText().toString()));
        return produto;
    }
}
