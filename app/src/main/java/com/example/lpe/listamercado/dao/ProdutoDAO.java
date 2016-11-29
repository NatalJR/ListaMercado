package com.example.lpe.listamercado.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lpe.listamercado.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natal on 28/11/16.
 */

public class ProdutoDAO extends SQLiteOpenHelper{

    public ProdutoDAO(Context context) {
        super(context, "ListaCompras", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE ListaCompras (id INTEGER PRIMARY KEY, produto TEXT NOT NULL, quantidade INTEGER NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS ListaCompras";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("produto", produto.getProduto());
        dados.put("quantidade", produto.getQuantidade());

        db.insert("ListaCompras", null, dados);
    }

    public List<Produto> listProdutos() {
        String sql = "SELECT * FROM ListaCompras";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Produto> produtos = new ArrayList<Produto>();

        while(c.moveToNext()){
            Produto produto = new Produto();
            produto.setId(c.getLong(c.getColumnIndex("id")));
            produto.setProduto(c.getString(c.getColumnIndex("produto")));
            produto.setQuantidade(c.getInt(c.getColumnIndex("quantidade")));

            produtos.add(produto);
        }
        c.close();

        return produtos;
    }

    public void remove(Produto produto) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {produto.getId().toString()};
        db.delete("ListaCompras", "id = ?", params);
    }
}
