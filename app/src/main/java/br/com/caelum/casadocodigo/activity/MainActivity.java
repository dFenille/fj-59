package br.com.caelum.casadocodigo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.API.WebClient;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.modelo.Livro;
import br.com.caelum.casadocodigo.modelo.Livros;

public class MainActivity extends AppCompatActivity implements LivrosDelegate {
    public ListaLivrosFragment listaLivrosFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        listaLivrosFragment = new ListaLivrosFragment();
        transaction.replace(R.id.frame_principal,listaLivrosFragment);
        transaction.commit();

        new WebClient().getLivros(0,20);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void lidaComLivroSelecionado(Livro livro) {

    }

    @Subscribe
    @Override
    public void lidaComSucesso(LivroEvent livros) {
        listaLivrosFragment.populaListaCom(livros.getLivros());
    }

    @Override
    public void lidaComErro(Throwable t) {
        Toast.makeText(this, "Nao foi possivel carregar os Livros", Toast.LENGTH_SHORT).show();
    }
}
