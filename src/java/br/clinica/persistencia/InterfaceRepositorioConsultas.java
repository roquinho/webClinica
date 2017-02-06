
package br.clinica.persistencia;

import br.clinica.entidades.Consultas;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioConsultas {
   
    public void agendarConsulta(Consultas consulta);
    
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente);
    
    public Consultas filtrarConsultaCpfPaciente(Long cpf);
    
    public void atualizarConsulta(Consultas consulta);
    
    public void deletarConsulta(Long cpfPaciente);
    
    public List<Consultas> filtrarNomeMedico(String nomeMedico);
}
