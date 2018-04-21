package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.caelum.casadocodigo.R;
import butterknife.BindView;

/**
 * Created by android7392 on 21/04/18.
 */
public class DetalhesLivroFragment extends Fragment {
    @BindView(R.id.detalhes_livro_foto)
    ImageView foto;
    @BindView(R.id.detalhes_livro_nome)
    TextView nome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhes_livro,container,false);
        return view;
    }
}
