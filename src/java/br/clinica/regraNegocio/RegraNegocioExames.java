
package br.clinica.regraNegocio;

import br.clinica.entidades.Exames;
import br.clinica.persistencia.InterfaceRepositorioExames;
import br.clinica.persistencia.RepositorioExames;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author manoel
 */
public class RegraNegocioExames implements InterfaceRegraNegocioExames {

    private InterfaceRepositorioExames rne;
    
    public RegraNegocioExames() {
        this.rne = new RepositorioExames();
    }
    
    @Override
    public void agendarExame(Exames exame) throws ExceptionRegraNegocioAgendarExame {
        if(exame == null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getDataExame()==null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getHoraExame()==null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getTipoExame()==null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        if(exame.getPaciente().getCpf()==null) {
            throw new ExceptionRegraNegocioAgendarExame();
        }
        else {
            exame.getPaciente().getExames().add(exame);
            rne.agendarExame(exame);
        }
    }
    @Override
    public Exames filtrarExameCpfPaciente(Long cpf) throws ExceptionRegraNegocioFiltrarExame {
        Exames exame = new Exames();
         if(cpf==null) {
             throw new ExceptionRegraNegocioFiltrarExame();
         }
         else {
            exame = rne.filtrarExameCpfPaciente(cpf);
         }
         return exame;
    }

    @Override
    public List<Exames> filtrarExameNomePaciente(String nome) throws ExceptionRegraNegocioFiltrarExame {
        List<Exames>exames = new ArrayList<>();
          if(nome == null) {
              throw new ExceptionRegraNegocioFiltrarExame();
          }
          else {
             exames = rne.filtrarExameNomePaciente(nome);
          }
          return exames;
    }

@Override
    public void atualizarExame(Exames exame) throws ExceptionRegraNegocioAtualizarExames {
         if(exame == null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(exame.getDataExame()==null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(exame.getHoraExame()==null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(exame.getTipoExame()==null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        if(exame.getPaciente().getCpf()==null) {
            throw new ExceptionRegraNegocioAtualizarExames();
        }
        else {
            rne.atualizarExame(exame);
        }
    }

    @Override
    public void deletarExame(Long cpfPaciente) throws ExceptionRegraNegocioDeletarExames {
        if(cpfPaciente == null) {
            throw new ExceptionRegraNegocioDeletarExames();
        }
        else {
            rne.deletarExame(cpfPaciente);
        }
    }
    
}
