package br.com.caelum.casadocodigo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.modelo.Cartao;

/**
 * Created by android7392 on 28/04/18.
 */

public class CartaoAdapter extends RecyclerView.Adapter {

    private List<Cartao> cartoes;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cartao,parent,false);
        return new CartaoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Cartao cartao = cartoes.get(position);
        CartaoViewHolder v_holder = (CartaoViewHolder) holder;
        v_holder.nome.setText(cartao.getNomecompleto());
        v_holder.numero.setText(cartao.getNum());
        v_holder.validade.setText(cartao.getValidDate().toString());
        v_holder.cvv.setText(cartao.getCvv());
    }

    @Override
    public int getItemCount() {
        return this.cartoes.size();
    }

    public class CartaoViewHolder extends RecyclerView.ViewHolder{
        TextView nome;
        TextView numero;
        TextView validade;
        TextView cvv;

        public CartaoViewHolder(View itemView) {
            super(itemView);
            nome =(TextView) itemView.findViewById(R.id.titular_cartao_item);
            numero =(TextView) itemView.findViewById(R.id.numero_cartao_item);
            validade =(TextView) itemView.findViewById(R.id.validade_cartao_item);
            cvv =(TextView) itemView.findViewById(R.id.cvv_cartao_item);
        }
    }
}
