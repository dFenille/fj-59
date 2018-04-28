package br.com.caelum.casadocodigo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import br.com.caelum.casadocodigo.CasaDoCodigoApplication;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Autor;
import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Item;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.modelo.TipoDeCompra;
import butterknife.BindView;

/**
 * Created by android7392 on 21/04/18.
 */
public class DetalhesLivroFragment extends Fragment {
    @BindView(R.id.detalhes_livro_foto)
    ImageView foto;
    @BindView(R.id.detalhes_livro_nome)
    TextView nome;
    @Inject
    Carrinho carrinho;
    private Livro livro;
    private TextView autores;
    private TextView descricao;
    private TextView numPaginas;
    private TextView isbn;
    private TextView dataPublicacao;
    private Button botaoComprarFisico;
    private Button botaoComprarEbook;
    private Button botaoComprarAmbos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detalhes_livro,container,false);
        getFields(view);
        Bundle arguments = getArguments();
        livro = (Livro) arguments.getSerializable("livro");
        populaCamposcom(livro);

        CasaDoCodigoApplication app = (CasaDoCodigoApplication) getActivity().getApplication();
        app.getComponent().inject(this);

        botaoComprarFisico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Livro adicionado ao carrinho",Snackbar.LENGTH_SHORT).show();
                carrinho.adiciona(new Item(livro, TipoDeCompra.FISICO));
            }
        });

        return view;
    }

    private void populaCamposcom(Livro livro) {
        nome.setText(livro.getNome());
//        foto.setImageBitmap(livro.getF);

        Picasso.with(getContext())
                .load(livro.getUrlFoto())
                .placeholder(R.drawable.livro)
                .into(foto);

        String listaDeAutores = "";
        for(Autor autor : livro.getAutores()){

            if(listaDeAutores.isEmpty())
                listaDeAutores+=", ";

            listaDeAutores+= autor.getNome();
        }
        autores.setText(listaDeAutores);
        descricao.setText(livro.getDescricao());
        numPaginas.setText(String.valueOf(livro.getNumPaginas()));
        isbn.setText(livro.getISBN());
        dataPublicacao.setText(livro.getDataPublicacao());

        String textoComprarFisico = String.format("Comprar Livro Fisico - R$ %.2f",livro.getValorFisico());
        String textoComprarEbook = String.format("Comprar E-book - R$ %.2f",livro.getValorVirtual());
        String textoComprarAmbos = String.format("Comprar Ambos - R$ %.2f",livro.getValorDoisJuntos());

        botaoComprarFisico.setText(textoComprarFisico);
        botaoComprarEbook.setText(textoComprarEbook);
        botaoComprarAmbos.setText(textoComprarAmbos);
    }

    public void getFields(View view){

        foto = (ImageView) view.findViewById(R.id.detalhes_livro_foto);
        nome = (TextView) view.findViewById(R.id.detalhes_livro_nome);
        autores = (TextView) view.findViewById(R.id.detalhes_livro_autores);
        descricao = (TextView) view.findViewById(R.id.detalhes_livro_descricao);
        numPaginas = (TextView) view.findViewById(R.id.detalhes_livro_num_paginas);
        isbn = (TextView) view.findViewById(R.id.detalhes_livro_isbn);
        dataPublicacao = (TextView) view.findViewById(R.id.detalhes_livro_data_publicacao);
        botaoComprarFisico = (Button) view.findViewById(R.id.detalhes_livro_comprar_fisico);
        botaoComprarEbook = (Button) view.findViewById(R.id.detalhes_livro_comprar_ebook);
        botaoComprarAmbos = (Button) view.findViewById(R.id.detalhes_livro_comprar_ambos);
    }
}
