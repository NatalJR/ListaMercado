package com.example.lpe.listamercado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lpe.listamercado.modelo.ListaProdutos;

public class AddItemActivity extends AppCompatActivity {

    private AddItemHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        helper = new AddItemHelper(this);

        String [] produtos= {"Produto 1", "Produto 2", "Produto 3", "Produto 4", "Produto 5", "Produto 6", "Produto 7", "Produto 8", "Produto 9", "Produto 10", "Produto 11", "Produto 12", "Produto 13"};
        ListView ListaProdutos = (ListView) findViewById(R.id.add_item_list);
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (this, android.R.layout.simple_list_item_1, produtos);
        ListaProdutos.setAdapter(adapter);
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
                Toast.makeText(AddItemActivity.this, "Produtos adicionados!", Toast.LENGTH_SHORT).show();
//                ListaProdutos lista = helper.listaProdutos();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
