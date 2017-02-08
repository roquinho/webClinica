
package br.clinica.regraNegocio;

import br.clinica.entidades.Consultas;
import br.clinica.persistencia.InterfaceRepositorioConsultas;
import br.clinica.persistencia.RepositorioConsultas;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoel
 */
public class RegraNegocioConsultas implements InterfaceRegaNegocioConsultas {
   
       private InterfaceRepositorioConsultas rc;
        
         public RegraNegocioConsultas() {
             this.rc = new RepositorioConsultas();
         }
         
    @Override
    public void agendarConsulta(Consultas consulta) throws ExceptionRegraNegocioAgendarConsultas {
        if(consulta == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();              
        }
        if(consulta.getPaciente().getNome() == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getPaciente().getCpf() == null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getHoraConsulta()== null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
        if(consulta.getDiaConsulta()== null) {
            throw new ExceptionRegraNegocioAgendarConsultas();
        }
           try {
               if(checarHoraDataConsulta(consulta.getHoraConsulta(), consulta.getDiaConsulta())==true) {
                 throw new ExceptionRegraNegocioAgendarConsultas();
               }
               else {
                   consulta.getPaciente().getConsultas().add(consulta);
                   consulta.getMedico().getConsultas().add(consulta);
                   rc.agendarConsulta(consulta);
               }  } catch (ExceptionRegraNegocioFiltrarConsultas ex) {
               Logger.getLogger(RegraNegocioConsultas.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }

    @Override
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente) throws ExceptionRegraNegocioFiltrarConsultas {
        List<Consultas>consultas = new ArrayList<>();
        
        if(nomePaciente == null) {
         throw new ExceptionRegraNegocioFiltrarConsultas();
    }
       else {
           consultas = rc.filtrarConsultaNomePaciente(nomePaciente);
    }
        return consultas;
    }
    
    @Override
    public Consultas filtrarConsultaCpfPaciente(Long cpf) throws ExceptionRegraNegocioFiltrarConsultas {
        Consultas consulta = new Consultas();
          if(cpf == null) {
              throw new ExceptionRegraNegocioFiltrarConsultas();
          }
                 
          else {
              consulta = rc.filtrarConsultaCpfPaciente(cpf);
          }
          return consulta;
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionRegraNegocioAtualizarConsultas {
       if(consulta == null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(consulta.getPaciente().getNome() == null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(consulta.getPaciente().getCpf() == null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(consulta.getHoraConsulta()== null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        if(consulta.getDiaConsulta()== null) {
            throw new ExceptionRegraNegocioAtualizarConsultas();
        }
        else {
            rc.atualizarConsulta(consulta);
        }
    }

    @Override
    public void deletarConsulta(Long cpfPaciente) throws ExceptionRegraNegocioDeletarConsultas {
        if(cpfPaciente == null) {
            throw new ExceptionRegraNegocioDeletarConsultas();
        }
        else {
            rc.deletarConsulta(cpfPaciente);
        }
    }

    @Override
    public List<Consultas> filtrarNomeMedico(String nomeMedico) throws ExceptionRegraNegocioFiltrarConsultas {
       List<Consultas>consultas = new ArrayList<>();
        
        if(nomeMedico == null) {
         throw new ExceptionRegraNegocioFiltrarConsultas();
    }
       else {
           consultas = rc.filtrarNomeMedico(nomeMedico);
    }
        return consultas;
 
    }

    
    @Override
    public boolean checarHoraDataConsulta(String hora, String data) throws ExceptionRegraNegocioFiltrarConsultas {
        boolean boleano = false;
        
        if(hora == null) {
            throw new ExceptionRegraNegocioFiltrarConsultas();
        }
        if(data == null) {
            throw new ExceptionRegraNegocioFiltrarConsultas();
        }
        else {
            boleano = this.rc.checarHoraDataConsulta(data, hora);
        }
        return boleano;
        
    }
}
