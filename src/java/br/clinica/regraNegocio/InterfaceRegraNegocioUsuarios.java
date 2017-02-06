
package br.clinica.regraNegocio;

import br.clinica.entidades.Usuarios;

/**
 *
 * @author manoel
 */
public interface InterfaceRegraNegocioUsuarios {
    
    public void cadastrarUsuario(Usuarios usuario)throws ExceptionRegraNegocioCadastrarUsuarios;
    
    public Usuarios buscarUsuarioSenhaNome(String senha,String nome)throws ExceptionRegraNegociofiltrarUsuarios;
    
    public Usuarios filtrarUsuarioCpf(String cpf)throws ExceptionRegraNegociofiltrarUsuarios;
    
    public void atualizarUsuario(Usuarios usuario)throws ExceptionRegraNegocioAtualizarUsuarios;
    
    public void deletarUsuario(String cpf)throws ExceptionRegraNegocioDeletarUsuarios;
    
    public boolean checarLoginUsuario(String cpfUsuario)throws ExceptionRegraNegociofiltrarUsuarios;
}
