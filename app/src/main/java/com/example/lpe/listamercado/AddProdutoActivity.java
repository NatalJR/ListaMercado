package com.example.lpe.listamercado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lpe.listamercado.dao.ProdutoDAO;
import com.example.lpe.listamercado.modelo.Produto;

public class AddProdutoActivity extends AppCompatActivity {


    private AddProdutoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new AddProdutoHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add_items_ok:

                Produto produto = helper.getProduto();
                ProdutoDAO dao = new ProdutoDAO(this);
                dao.insert(produto);
                dao.close();

                Toast.makeText(AddProdutoActivity.this, produto.getQuantidade() + " Unidade(s) de " + produto.getProduto().toUpperCase() +" adicionado(s) a lista!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
