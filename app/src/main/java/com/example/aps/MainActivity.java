package com.example.aps;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.NumberFormat;
import android.icu.util.Currency;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView view_item;
    ListView view_valor;
    TextView total_texto;
    EditText texto_item;
    EditText valor_item;

    Float total_valor = (float) 0;

    NumberFormat format = NumberFormat.getCurrencyInstance();

    List<ItemCompra> listacomp = new ArrayList<>();

    ItemCompra item = new ItemCompra("Feijão" ,30);

    private String[] itens = {
            "Natan", "Daniel", "Taynara", "Alex"
    };

    List<String> lista_item = new ArrayList<>();
    List<String> lista_valores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view_item = findViewById(R.id.lista_compra);
        view_valor = findViewById(R.id.lista_preco);

        total_texto = findViewById(R.id.total);

        texto_item = findViewById(R.id.texto_item);
        valor_item = findViewById(R.id.texto_valor);

        format.setMaximumFractionDigits(2);
        format.setCurrency(Currency.getInstance("BRL"));



    }


    public void salvaritem(View view){

        String itemTexto = texto_item.getText().toString();
        float valorTexto = Float.parseFloat(valor_item.getText().toString());

        ItemCompra novo_item = new ItemCompra(itemTexto ,valorTexto);

        listacomp.add(novo_item);
        lista_item.clear();
        lista_valores.clear();
        total_valor = (float) 0;

        for (ItemCompra item : listacomp) {

            lista_item.add(item.getProduto());

            Float valor = item.getValor();
            lista_valores.add(format.format(valor));

            total_valor = total_valor + valor;

        }


        if (total_valor > 0){

            total_texto.setText(String.format(Locale.forLanguageTag("pt-BR"), "Total: R$ %.2f", total_valor));
        }
        else{
            total_texto.setText("Total: R$ 00,00");
        }


        //ArrayAdapter cria o adaptador do array.
        ArrayAdapter<String> adapter_item = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, lista_item
        );

        ArrayAdapter<String> adapter_valores = new ArrayAdapter<>(
                getApplicationContext(),
                R.layout.simple_item_list_preco,
                R.id.preco , lista_valores
        );



        //setAdapter faz aparecer na tela a lista.
        view_item.setAdapter(adapter_item);
        view_valor.setAdapter(adapter_valores);

    }


}