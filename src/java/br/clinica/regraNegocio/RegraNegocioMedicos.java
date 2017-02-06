
package br.clinica.regraNegocio;

import br.clinica.entidades.Medicos;
import br.clinica.persistencia.InterfaceRepositorioMedicos;
import br.clinica.persistencia.RepositorioMedicos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoel
 */
public class RegraNegocioMedicos implements InterfaceRegraNegocioMedicos {
     private InterfaceRepositorioMedicos rm;
     
       public RegraNegocioMedicos() {
           this.rm = new RepositorioMedicos();
       }
    
    @Override
    public void cadastrarMedicos(Medicos medico) throws ExceptionRegraNegocioCadastrarMedicos {
        if(medico == null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getNome()== null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getCpf()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
        if(medico.getCrm()==null) {
            throw new ExceptionRegraNegocioCadastrarMedicos();
        }
         try {
             if(buscarMedicoCpf(medico.getCpf())!=null) {
                 throw new ExceptionRegraNegocioCadastrarMedicos();
             }
             else {
                 rm.cadastrarMedicos(medico);
             }} catch (ExceptionRegraNegocioBuscarMedicos ex) {
             Logger.getLogger(RegraNegocioMedicos.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public Medicos buscarMedicoCpf(Long cpf) throws ExceptionRegraNegocioBuscarMedicos {
        Medicos medico = new Medicos();
        if(cpf == null){
           throw new ExceptionRegraNegocioBuscarMedicos();
       }
       else {
          medico = rm.buscarMedicoCpf(cpf);
       }       
        return medico;
    }

    @Override
    public List<Medicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {
        List<Medicos> listaMedicos = null;
        if(nome == null) {
          throw new ExceptionRegraNegocioBuscarMedicos();
        }
        else {
            listaMedicos = rm.buscarMedicoNome(nome);
        }
        return listaMedicos;
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionRegraNegocioAtualizarMedicos {
        if(medico == null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getNome()== null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(medico.getCrm()==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }
        if(rm.buscarMedicoCpf(medico.getCpf())==null) {
            throw new ExceptionRegraNegocioAtualizarMedicos();
        }  
        else {
            rm.atualizarMedico(medico);
        }
       
    }

    @Override
    public void deletarMedico(Long cpf) throws ExceptionRegraNegocioDeletarMedicos {
        if(cpf == null) {
           throw new ExceptionRegraNegocioDeletarMedicos();
       }
         try {
             if(buscarMedicoCpf(cpf)==null) {
                 throw new ExceptionRegraNegocioDeletarMedicos();
             }
             else {
                 rm.deletarMedico(cpf);
             } } catch (ExceptionRegraNegocioBuscarMedicos ex) {
             Logger.getLogger(RegraNegocioMedicos.class.getName()).log(Level.SEVERE, null, ex);
         }
       }
       

    public InterfaceRepositorioMedicos getRm() {
        return rm;
    }

    public void setRm(InterfaceRepositorioMedicos rm) {
        this.rm = rm;
    }

    @Override
    public boolean checarLoginMedico(Long cpfMedico) throws ExceptionRegraNegocioBuscarMedicos {
       boolean loginMedico= false; 
        if(cpfMedico==null) {
            throw new ExceptionRegraNegocioBuscarMedicos();
        }
        else {
            loginMedico = this.rm.checarLoginMedico(cpfMedico);
        }
        return loginMedico;
    }
     
}
