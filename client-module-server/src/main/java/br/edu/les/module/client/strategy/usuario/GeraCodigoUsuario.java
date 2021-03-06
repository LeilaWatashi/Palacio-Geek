package br.edu.les.module.client.strategy.usuario;

import br.edu.les.module.client.domain.Cliente;
import br.edu.les.module.client.domain.EntidadeDominio;
import br.edu.les.module.client.domain.Usuario;
import br.edu.les.module.client.strategy.IStrategy;
import br.edu.les.module.client.util.Util;
import br.edu.les.module.client.util.GeradorCodigo;
import org.springframework.stereotype.Component;

@Component
public class GeraCodigoUsuario implements IStrategy {

    @Override
    public String processar(EntidadeDominio entidade) {

        if(entidade instanceof Cliente || entidade instanceof Usuario) {
            Usuario usuario = null;
            if(entidade instanceof Cliente && Util.isNotNull(((Cliente) entidade).getUsuario())) usuario = ((Cliente) entidade).getUsuario();
            else return null;
            if(entidade instanceof Usuario) usuario = (Usuario) entidade;

            usuario.setCodigo(GeradorCodigo.gerarCodigoUsuario());
        }
        return null;
    }
}
