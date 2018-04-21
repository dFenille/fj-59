package br.com.caelum.casadocodigo.dagger.module;

import javax.inject.Singleton;

import br.com.caelum.casadocodigo.modelo.Carrinho;
import dagger.Module;
import dagger.Provides;

/**
 * Created by android7392 on 21/04/18.
 */
@Module
public class CasaDoCodigoModule {

    @Provides
    @Singleton
    public Carrinho getCarrinho(){
        return new Carrinho();
    }
}
