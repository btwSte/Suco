package br.com.sucos;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list_view;
    SucoAdapter adapter;
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list_view = (ListView) findViewById(R.id.list_view);
        //cria adapter
        adapter = new SucoAdapter(this, new ArrayList<Suco>());

        //definir adapter na lista
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, Detalhes.class);

                Suco s = adapter.getItem(i);
                intent.putExtra("nome",s.getNome());
                intent.putExtra("foto",s.getFoto());
                intent.putExtra("descricao",s.getDescricao());
                intent.putExtra("preco",s.getPreco());
                intent.putExtra("sabor",s.getSabor());

                startActivity(intent);

            }
        });


        //preencher lista
        new AsyncTask<Void, Void, Void>() {
            ArrayList<Suco> lstSuco = new ArrayList<Suco>();

            @Override
            protected Void doInBackground(Void... voids) {
                String retornoJson = Http.get("http://10.0.2.2/inf3m/TurmaB/Projeto/cms/api.php");
                Log.d("TAG", retornoJson);

                try {
                    JSONArray jsonArray = new JSONArray(retornoJson);

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);

                        //alterar campos assim como esta no banco
                        Suco s = Suco.create(item.getString("nome"), item.getString("imagem") , item.getString("descricao"), item.getString("preco"), item.getString("sabor"));
                        lstSuco.add(s);
                    }

                    Log.d("TAG", lstSuco.size() + "");

                } catch (Exception ex) {
                    Log.e("ERRO", ex.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                adapter.addAll(lstSuco);
            }
        }.execute();




        };


}
