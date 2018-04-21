package br.com.caelum.casadocodigo.dagger.inject;

import javax.inject.Singleton;

import br.com.caelum.casadocodigo.activity.CarrinhoActivity;
import br.com.caelum.casadocodigo.activity.DetalhesLivroFragment;
import br.com.caelum.casadocodigo.dagger.module.CasaDoCodigoModule;
import dagger.Component;

/**
 * Created by android7392 on 21/04/18.
 */
@Singleton
@Component(modules = CasaDoCodigoModule.class)
public interface CasaDoCodigoComponent {
    void inject(DetalhesLivroFragment fragment);
    void inject(CarrinhoActivity activity);
}
