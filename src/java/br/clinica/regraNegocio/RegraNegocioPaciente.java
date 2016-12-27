
package br.clinica.regraNegocio;

import br.clinica.entidades.Pacientes;
import br.clinica.persistencia.InterfaceRepositorioPacientes;
import br.clinica.persistencia.RepositorioPacientes;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegraNegocioPaciente implements InterfaceRegraNegocioPacientes{
    
     private InterfaceRepositorioPacientes rp;
    
     public RegraNegocioPaciente() {
         this.rp = new RepositorioPacientes();
     }
     
     
    @Override
    public void cadastrarPaciente(Pacientes paciente)throws ExceptionRegraNegocioPacientesCadastrar {
        if(paciente == null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getNome()== null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
        if(paciente.getCpf()==null) {
            throw new ExceptionRegraNegocioPacientesCadastrar();
        }
         try {
             if(buscarPacienteCpf(paciente.getCpf())!=null) {
                 throw new ExceptionRegraNegocioPacientesCadastrar();
             }
             else {
                 rp.cadastrarPaciente(paciente);
             }
         } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
             Logger.getLogger(RegraNegocioPaciente.class.getName()).log(Level.SEVERE, null, ex);
         }
            }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        Pacientes paciente = new Pacientes();
        
       if(cpf == null){
           throw new ExceptionRegraNegocioPacienteBuscarPaciente();
       }
       else {
          paciente = rp.buscarPacienteCpf(cpf);
       }       
        return paciente;
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
          List<Pacientes> listaPacientes = new ArrayList<>();
        if(nome == null) {
          throw new ExceptionRegraNegocioPacienteBuscarPaciente();
        }
        else {
            listaPacientes = rp.buscarPacienteNome(nome);
        }
        return listaPacientes;
    }

    @Override
    public void atualizarPaciente(Pacientes paciente)throws ExceptionRegraNegocioAtualizarPacientes{
       if(paciente == null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getNome()== null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
        if(paciente.getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarPacientes();
        }
         try {
             if(buscarPacienteCpf(paciente.getCpf())==null) {
                 throw new ExceptionRegraNegocioAtualizarPacientes();
             }
             else {
                 rp.atualizarPaciente(paciente);
             }
         } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
             Logger.getLogger(RegraNegocioPaciente.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    @Override
    public void deletarPaciente(Long cpf)throws ExceptionRegraNegocioDeletarPacientes{
         try {
             if(cpf==null){
                 throw new ExceptionRegraNegocioDeletarPacientes();
             }
             if(buscarPacienteCpf(cpf)==null) {
                 throw new ExceptionRegraNegocioDeletarPacientes();
             }
             else {
                 rp.deletarPaciente(cpf);
             } 
         } catch (ExceptionRegraNegocioPacienteBuscarPaciente ex) {
             Logger.getLogger(RegraNegocioPaciente.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
       
}
