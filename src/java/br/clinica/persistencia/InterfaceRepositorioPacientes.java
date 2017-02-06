
package br.clinica.persistencia;

import br.clinica.entidades.Pacientes;
import java.util.List;


public interface InterfaceRepositorioPacientes {
    
    public void cadastrarPaciente(Pacientes paciente);
    
    public Pacientes buscarPacienteCpf(Long cpf);
    
    public List<Pacientes> buscarPacienteNome(String nome);
    
    public void atualizarPaciente(Pacientes paciente);
    
    public void deletarPaciente(Long cpf);
    
    public boolean checarLoginPaciente(Long cpfPaciente);
    
    
}
