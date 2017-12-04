package br.com.sucos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SucoAdapter extends ArrayAdapter<Suco>{
    public SucoAdapter (Context ctx, ArrayList<Suco> lstSuco){
        super(ctx, 0, lstSuco);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_lista, null);
        }

        Suco item = getItem(position);

        TextView nome = v.findViewById(R.id.txt_nome_suco);
        TextView descricao = v.findViewById(R.id.txt_descricao_suco);
        ImageView imagem = v.findViewById(R.id.img_suco);
        TextView preco = v.findViewById(R.id.txt_preco_suco);

        nome.setText(item.getNome());
        descricao.setText(item.getDescricao());
        preco.setText(item.getPreco());
        Picasso.with(getContext()).load("http://10.0.2.2/inf3m/TurmaB/Projeto/cms/" + item.getFoto()).into(imagem);

        return v;
    }
}
