package br.com.caelum.casadocodigo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.modelo.Livro;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by android7392 on 14/04/18.
 */

public class LivroAdapter extends RecyclerView.Adapter {
    private List<Livro> livros;


    public LivroAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int tipoDeLayout = R.layout.item_livro_impar;

        if(viewType % 2 !=0)
            tipoDeLayout = R.layout.item_livro_par;



        View view = LayoutInflater.from(parent.getContext()).inflate(tipoDeLayout,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Livro livro = livros.get(position);

        viewHolder.nome.setText(livro.getNome());

        Picasso.with(viewHolder.foto.getContext())
                .load(livro.getUrlFoto())
                .placeholder(R.drawable.livro)
                .into(viewHolder.foto);


    }

    @Override
    public int getItemCount() {
        return this.livros.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
//        @BindView(R.id.item_livro_nome)
        TextView nome;
//        @BindView(R.id.item_livro_foto)
        ImageView foto;
        public ViewHolder(View view) {
            super(view);
//            ButterKnife.bind(this,itemView);
            nome = (TextView) view.findViewById(R.id.item_livro_nome);
            foto = (ImageView) view.findViewById(R.id.item_livro_foto);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Livro livro = livros.get(getAdapterPosition());
                    LivrosDelegate delegate = (LivrosDelegate) itemView.getContext();
                    delegate.lidaComLivroSelecionado(livro);
                }
            });
        }


    }



}
