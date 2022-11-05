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
    TextView total_texto;
    EditText texto_item;
    EditText valor_item;

    Float total_valor = (float) 0;

    NumberFormat format = NumberFormat.getCurrencyInstance();

    List<ItemCompra> listacomp = new ArrayList<>();

    List<String> lista_item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        view_item = findViewById(R.id.lista_compra);
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

        if ( !itemTexto.isEmpty() && valorTexto > 0) {
            listacomp.add(novo_item);
            lista_item.clear();
            total_valor = (float) 0;

            for (ItemCompra item : listacomp) {

                Float valor = item.getValor();
                String texto = String.format(Locale.forLanguageTag("pt-BR"), "%s        %s", item.getProduto(), format.format(valor));

                lista_item.add(texto);
                total_valor = total_valor + valor;

            }


            if (total_valor > 0){

                total_texto.setText(String.format(Locale.forLanguageTag("pt-BR"), "Total: R$ %.2f", total_valor));
            }
            else{
                total_texto.setText("Total: R$ 00,00");
            }


            ArrayAdapter<String> adapter_item = new ArrayAdapter<>(
                    getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1, lista_item
            );


            //setAdapter faz aparecer na tela a lista.
            view_item.setAdapter(adapter_item);
        }


    }

    public void limpar(View view){

        listacomp.clear();
        lista_item.clear();
        total_valor = (float) 0;


        total_texto.setText("Total: R$ 00,00");


        ArrayAdapter<String> adapter_item = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, lista_item
        );


        view_item.setAdapter(adapter_item);
    }




}