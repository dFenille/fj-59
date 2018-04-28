package br.com.caelum.casadocodigo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.caelum.casadocodigo.R;

/**
 * Created by android7392 on 28/04/18.
 */

public class FormularioCartaoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.formulario_cartao_fragment,container,false);
        return view;
    }
}
