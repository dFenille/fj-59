package br.com.caelum.casadocodigo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import javax.inject.Inject;

import br.com.caelum.casadocodigo.CasaDoCodigoApplication;
import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.adapter.ItensAdapter;
import br.com.caelum.casadocodigo.modelo.Carrinho;
import br.com.caelum.casadocodigo.modelo.Item;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CarrinhoActivity extends AppCompatActivity {

    @BindView(R.id.lista_itens_carrinho)
    RecyclerView listaItens;
    @BindView(R.id.valor_carrinho)
    TextView valorTotal;

    @Inject
    Carrinho carrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);
        ButterKnife.bind(this);

        listaItens = (RecyclerView) findViewById(R.id.lista_itens_carrinho);
        valorTotal = (TextView) findViewById(R.id.valor_carrinho);

        CasaDoCodigoApplication app = (CasaDoCodigoApplication) getApplication();
        app.getComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    public void carregaLista(){
        listaItens.setAdapter(new ItensAdapter(carrinho.getItens(),this));
        listaItens.setLayoutManager(new LinearLayoutManager(this));
        double total = 0;
        for(Item item : carrinho.getItens()){
            total += item.getValor();
        }
        valorTotal.setText("R$ "+total);

    }
}
