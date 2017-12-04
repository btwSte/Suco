package br.com.sucos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detalhes extends AppCompatActivity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detalhes);

        TextView nome = (TextView) findViewById(R.id.txt_nome_suco);
        TextView descricao = (TextView) findViewById(R.id.txt_descricao_suco);
        ImageView imagem = (ImageView) findViewById(R.id.img_suco);
        TextView preco = (TextView) findViewById(R.id.txt_preco_suco);
        TextView sabor = (TextView) findViewById(R.id.txt_sabor_suco);

        Intent intent = getIntent();
        String foto = intent.getStringExtra("foto");

        nome.setText(intent.getStringExtra("nome"));
        descricao.setText(intent.getStringExtra("descricao"));
        Picasso.with(this).load("http://10.0.2.2/inf3m/TurmaB/Projeto/cms/" + foto).into(imagem);
        preco.setText(intent.getStringExtra("preco"));
        sabor.setText(intent.getStringExtra("sabor"));



    }
}
