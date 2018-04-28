package br.com.caelum.casadocodigo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.casadocodigo.api.WebClient;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.LivroAdapter;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.modelo.Livros;
import butterknife.BindView;

/**
 * Created by android7392 on 14/04/18.
 */
public class ListaLivrosFragment extends Fragment {
    public List<Livro> livros = new ArrayList<>();

    @BindView(R.id.lista_livros_teste)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_lista_livros,container,false);
//        ButterKnife.bind(this,view);
        recyclerView = (RecyclerView) view.findViewById(R.id.lista_livros_teste);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setAdapter(new LivroAdapter(livros));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    public void populaListaCom(final Livros livros_populate) {

//        this.livros.clear();
        this.livros.addAll(livros_populate.getLivros());
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.setOnScrollListener(new EndlessList() {
            @Override
            void carregaItens() {
                new WebClient().getLivros(ListaLivrosFragment.this.livros.size(),20);
            }
        });
    }







}
