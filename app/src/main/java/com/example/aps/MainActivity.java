package com.example.aps;

import androidx.appcompat.app.AppCompatActivity;
import com.example.aps.R;
import com.example.aps.ItemCompra;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ItemCompra item = new ItemCompra("Feijão" ,30);
    List<ItemCompra> lista_compras = new ArrayList<ItemCompra>();
    lista_compras.add(item);


    private String[] itens = {
            "Natan", "Daniel", "Taynara", "Alex"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.lista_compra);

        //ArrayAdapter cria um adapitador do array.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, itens
                );

        //setAdapter faz aparecer na tela a lista.
        lista.setAdapter(adapter);
    }


}