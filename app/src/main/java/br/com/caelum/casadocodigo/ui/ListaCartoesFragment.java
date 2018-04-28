package br.com.caelum.casadocodigo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Cartao;

/**
 * Created by android7392 on 28/04/18.
 */


public class ListaCartoesFragment extends Fragment {

    RecyclerView lista;
    private List<Cartao> cartoes;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_cartoes_fragment,container,false);

        lista = (RecyclerView) view.findViewById(R.id.lista_cartoes);

        return view;
    }
}
