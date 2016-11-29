package com.example.lpe.listamercado;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lpe.listamercado.dao.ProdutoDAO;
import com.example.lpe.listamercado.modelo.Produto;

import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private ListView listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add_list);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddOnList = new Intent(ListaProdutosActivity.this, AddProdutoActivity.class);
                startActivity(intentAddOnList);
             }
        });

        listaProdutos = (ListView) findViewById(R.id.lista_produtos);
        registerForContextMenu(listaProdutos);

    }

    private void loadList() {
        ProdutoDAO dao = new ProdutoDAO(this);
        List<Produto> produtos = dao.listProdutos();

        ArrayAdapter<Produto> adapter = new ArrayAdapter <Produto> (this, android.R.layout.simple_list_item_1, produtos);
        listaProdutos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Produto produto = (Produto) listaProdutos.getItemAtPosition(info.position);

                ProdutoDAO dao = new ProdutoDAO(ListaProdutosActivity.this);
                dao.remove(produto);
                dao.close();

                loadList();

//                Toast.makeText(ListaProdutosActivity.this, "Deletar o produto " + produto.getProduto(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
