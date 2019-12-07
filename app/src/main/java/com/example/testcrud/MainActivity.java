package com.example.testcrud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtTitle;
    private ListView listOpciones;
    private ArrayAdapter<String> adapter;
    private int codPosicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtTitle = (TextView) findViewById(R.id.txtTitle);
        this.listOpciones = (ListView) findViewById(R.id.listOpciones);

        String[] values = new String[]{"insertar","ver"};
        this.adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, values);
        this.listOpciones.setAdapter(adapter);

        listOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                if(posicion == 0){
                    abrirInsertarActivity();
                }else{
                    abrirVerActivity();
                }
            }
        });
    }

    private void abrirInsertarActivity() {
        Intent intento = new Intent(MainActivity.this, InsertarActivity.class);
        startActivity(intento);
    }

    private void abrirVerActivity() {
        Intent intento = new Intent(MainActivity.this, VerActivity.class);
        startActivity(intento);
    }
}
