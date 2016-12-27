
package br.clinica.persistencia;

import br.clinica.entidades.Medicos;
import java.util.List;

/**
 *
 * @author manoel
 */
public interface InterfaceRepositorioMedicos {
    
    public void cadastrarMedicos(Medicos medico);
    
    public Medicos buscarMedicoCpf(Long cpf);
    
    public List<Medicos> buscarMedicoNome(String nome);
    
    public void atualizarMedico(Medicos medico);
    
    public void deletarMedico(Medicos medico);
}
