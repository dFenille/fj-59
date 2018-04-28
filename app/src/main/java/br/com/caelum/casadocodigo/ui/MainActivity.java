package br.com.caelum.casadocodigo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import br.com.caelum.casadocodigo.delegate.LivrosDelegate;
import br.com.caelum.casadocodigo.api.WebClient;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.event.LivroEvent;
import br.com.caelum.casadocodigo.event.NotificationEvent;
import br.com.caelum.casadocodigo.modelo.Livro;

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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetalhesLivroFragment detalhesLivroFragment = criaDetalheCom(livro);
        listaLivrosFragment = new ListaLivrosFragment();
        transaction.replace(R.id.frame_principal,detalhesLivroFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private DetalhesLivroFragment criaDetalheCom(Livro livro) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("livro",livro);
        DetalhesLivroFragment detalhesLivroFragment = new DetalhesLivroFragment();
        detalhesLivroFragment.setArguments(bundle);
        return detalhesLivroFragment;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.vai_para_carrinho){
            Intent vaiParaCarrinho = new Intent(this,CarrinhoActivity.class);
            startActivity(vaiParaCarrinho);
        }
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void recebeNotificacao(NotificationEvent event){
        Toast.makeText(this, event.getMessage().toString(), Toast.LENGTH_SHORT).show();
    }
}
