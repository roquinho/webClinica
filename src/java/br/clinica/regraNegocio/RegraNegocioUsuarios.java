
package br.clinica.regraNegocio;

import br.clinica.entidades.Usuarios;
import br.clinica.persistencia.InterfaceRepositorioUsuarios;
import br.clinica.persistencia.RepositorioUsuarios;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoel
 */
public class RegraNegocioUsuarios implements InterfaceRegraNegocioUsuarios {

     private InterfaceRepositorioUsuarios ru;
     
     public RegraNegocioUsuarios() {
         this.ru = new RepositorioUsuarios();
     }
    @Override
    public void cadastrarUsuario(Usuarios usuario) throws ExceptionRegraNegocioCadastrarUsuarios {
       if(usuario == null) {
           throw new ExceptionRegraNegocioCadastrarUsuarios();
       }
       if(usuario.getCpf()==null) {
           throw new ExceptionRegraNegocioCadastrarUsuarios();
       }
       if(usuario.getSenha()==null) {
           throw new ExceptionRegraNegocioCadastrarUsuarios();
       }
       if(usuario.getTipoUsuario()==null) {
           throw new ExceptionRegraNegocioCadastrarUsuarios();
       }
         try {
             if(filtrarUsuarioCpf(usuario.getCpf())!=null) {
                 throw new ExceptionRegraNegocioCadastrarUsuarios();
             }
             else {
                 ru.cadastrarUsuario(usuario);
             } } catch (ExceptionRegraNegociofiltrarUsuarios ex) {
             Logger.getLogger(RegraNegocioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public Usuarios buscarUsuarioSenhaNome(String senha, String nome) throws ExceptionRegraNegociofiltrarUsuarios {
        Usuarios usuario = new Usuarios();
        if(senha == null) {
            throw new ExceptionRegraNegociofiltrarUsuarios();
        }
        if(nome == null) {
            throw new ExceptionRegraNegociofiltrarUsuarios();
        }
        else {
           usuario = ru.buscarUsuarioSenhaNome(senha, nome);
        }
        return usuario;
    }
    @Override
    public Usuarios filtrarUsuarioCpf(String cpf) throws ExceptionRegraNegociofiltrarUsuarios {
       Usuarios usuario = new Usuarios();
         if(cpf == null) {
             throw new ExceptionRegraNegociofiltrarUsuarios();
         }
         else {
            usuario = ru.filtrarUsuarioCpf(cpf);
         }
         return usuario;
    }

    @Override
    public void atualizarUsuario(Usuarios usuario) throws ExceptionRegraNegocioAtualizarUsuarios {
        if(usuario == null) {
           throw new ExceptionRegraNegocioAtualizarUsuarios();
       }
       if(usuario.getCpf()==null) {
           throw new ExceptionRegraNegocioAtualizarUsuarios();
       }
       if(usuario.getSenha()==null) {
           throw new ExceptionRegraNegocioAtualizarUsuarios();
       }
       if(usuario.getTipoUsuario()==null) {
           throw new ExceptionRegraNegocioAtualizarUsuarios();
       }
       if(ru.filtrarUsuarioCpf(usuario.getCpf())==null) {
           throw new ExceptionRegraNegocioAtualizarUsuarios();
       }
       else {
          ru.atualizarUsuario(usuario);
       }
    }

    @Override
    public void deletarUsuario(String cpf) throws ExceptionRegraNegocioDeletarUsuarios {
        if(cpf == null) {
            throw new ExceptionRegraNegocioDeletarUsuarios();
        }
         try {
             if(filtrarUsuarioCpf(cpf)==null) {
                 throw new ExceptionRegraNegocioDeletarUsuarios();
             }
             else {
                 ru.deletarUsuario(cpf);
             }} catch (ExceptionRegraNegociofiltrarUsuarios ex) {
             Logger.getLogger(RegraNegocioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public boolean checarLoginUsuario(String cpfUsuario) throws ExceptionRegraNegociofiltrarUsuarios {
      boolean loginUsuario = false; 
        if(cpfUsuario == null) {
            throw new ExceptionRegraNegociofiltrarUsuarios();
        }
        else {
            loginUsuario = this.ru.checarLoginUsuario(cpfUsuario);
        }
        return loginUsuario;
    }


    
}
