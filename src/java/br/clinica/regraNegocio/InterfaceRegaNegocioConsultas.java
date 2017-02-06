
package br.clinica.regraNegocio;

import br.clinica.entidades.Consultas;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRegaNegocioConsultas {
    
    public void agendarConsulta(Consultas consulta)throws ExceptionRegraNegocioAgendarConsultas;
    
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public Consultas filtrarConsultaCpfPaciente(Long cpf)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public void atualizarConsulta(Consultas consulta)throws ExceptionRegraNegocioAtualizarConsultas;
    
    public void deletarConsulta(Long cpfPaciente)throws ExceptionRegraNegocioDeletarConsultas;
    
    public List<Consultas> filtrarNomeMedico(String nomeMedico)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public boolean checarHoraDataConsulta(String hora, String data)throws ExceptionRegraNegocioFiltrarConsultas;

}
