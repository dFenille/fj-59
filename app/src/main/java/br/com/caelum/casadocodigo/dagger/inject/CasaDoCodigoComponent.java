package br.com.caelum.casadocodigo.dagger.inject;

import javax.inject.Singleton;

import br.com.caelum.casadocodigo.ui.CarrinhoActivity;
import br.com.caelum.casadocodigo.ui.DetalhesLivroFragment;
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
