package br.edu.les.module.client.strategy.usuario;

import br.edu.les.module.client.domain.EntidadeDominio;
import br.edu.les.module.client.domain.Usuario;
import br.edu.les.module.client.strategy.IStrategy;
import br.edu.les.module.client.strategy.cliente.ValidaExistenciaPessoa;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.les.module.client.domain.Cliente;
import br.edu.les.module.client.repository.UsuarioRepository;

@Log

@Component
public class ValidaExistenciaUsuario implements IStrategy {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ValidaExistenciaPessoa validaExistenciaPessoa;

    @Override
    public String processar(EntidadeDominio entidade) {

        Cliente cliente = (Cliente) entidade;
        StringBuilder msg = new StringBuilder();

        Usuario usuarioRecebido = cliente.getUsuario();

        Usuario usuarioValidador = usuarioRepository.findByEmail(usuarioRecebido.getEmail());

        if(usuarioValidador != null){
            if(usuarioRecebido.getId() != usuarioValidador.getId()){
                msg.append("Email já cadastrado.");
            }
        }

        if(msg.length()>0){
            log.info("Mensagem de erro: " + msg.toString());
        }

        return msg.toString();
    }
}
