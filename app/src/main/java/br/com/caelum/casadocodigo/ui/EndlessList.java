package br.com.caelum.casadocodigo.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by android7392 on 14/04/18.
 */
abstract class EndlessList extends RecyclerView.OnScrollListener {

    private int qtdTotal;
    private int qtdVisivel;
    private int primeiroVisivel;
    private int totalAnterior;
    private boolean carregando;

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        qtdTotal = manager.getItemCount();
        qtdVisivel = recyclerView.getChildCount();
        primeiroVisivel = manager.findFirstVisibleItemPosition();
        if(carregando){
            if(qtdTotal > totalAnterior){
                totalAnterior = qtdTotal;
                carregando = false;
            }
        }
        int indice = qtdTotal - qtdVisivel - 5;


        if(!carregando && primeiroVisivel >= indice){
            carregaItens();
            carregando = true;
        }
    }

    abstract void carregaItens();


}
