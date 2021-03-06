
package br.clinica.regraNegocio;

import br.clinica.entidades.Consultas;
import br.clinica.entidades.Exames;
import br.clinica.entidades.Medicos;
import br.clinica.entidades.Pacientes;
import br.clinica.entidades.Usuarios;
import java.util.List;

public class FachadaImplementa implements Fachada {
    private InterfaceRegraNegocioPacientes pacientes;
    private InterfaceRegraNegocioMedicos medicos;
    private InterfaceRegaNegocioConsultas consultas;
    private InterfaceRegraNegocioExames exames;
    private InterfaceRegraNegocioUsuarios usuarios;
    
      public FachadaImplementa(){
          this.pacientes = new RegraNegocioPaciente();
          this.medicos = new RegraNegocioMedicos();
          this.consultas = new RegraNegocioConsultas();
          this.exames = new RegraNegocioExames();
          this.usuarios = new RegraNegocioUsuarios();
      }

    @Override
    public void cadastrarPaciente(Pacientes paciente) throws ExceptionRegraNegocioPacientesCadastrar {
       pacientes.cadastrarPaciente(paciente);
    }

    @Override
    public Pacientes buscarPacienteCpf(Long cpf) throws ExceptionRegraNegocioPacienteBuscarPaciente {
        return pacientes.buscarPacienteCpf(cpf);
    }

    @Override
    public List<Pacientes> buscarPacienteNome(String nome) throws ExceptionRegraNegocioPacienteBuscarPaciente {
       return pacientes.buscarPacienteNome(nome);
    }

    @Override
    public void atualizarPaciente(Pacientes paciente) throws ExceptionRegraNegocioAtualizarPacientes {
        pacientes.atualizarPaciente(paciente);
    }

    @Override
    public void deletarPaciente(Long cpf) throws ExceptionRegraNegocioDeletarPacientes {
        pacientes.deletarPaciente(cpf);
    }

    @Override
    public boolean checarLoginPaciente(Long cpfPaciente) throws ExceptionRegraNegocioPacienteBuscarPaciente {
       return this.pacientes.checarLoginPaciente(cpfPaciente);
    }

    
    
    
    
    @Override
    public void cadastrarMedicos(Medicos medico) throws ExceptionRegraNegocioCadastrarMedicos {
        medicos.cadastrarMedicos(medico);
    }

    @Override
    public Medicos buscarMedicoCpf(Long cpf) throws ExceptionRegraNegocioBuscarMedicos {
       return medicos.buscarMedicoCpf(cpf);
    }

    @Override
    public List<Medicos> buscarMedicoNome(String nome) throws ExceptionRegraNegocioBuscarMedicos {
        return medicos.buscarMedicoNome(nome);
    }

    @Override
    public void atualizarMedico(Medicos medico) throws ExceptionRegraNegocioAtualizarMedicos {
        medicos.atualizarMedico(medico);
    }

    @Override
    public void deletarMedico(Long cpf) throws ExceptionRegraNegocioDeletarMedicos {
      medicos.deletarMedico(cpf);
    }
    @Override
    public boolean checarLoginMedico(Long cpfMedico) throws ExceptionRegraNegocioBuscarMedicos {
       return this.medicos.checarLoginMedico(cpfMedico);
    }

    
    
    @Override
    public void agendarConsulta(Consultas consulta) throws ExceptionRegraNegocioAgendarConsultas {
        consultas.agendarConsulta(consulta);
    }

    @Override
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente) throws ExceptionRegraNegocioFiltrarConsultas {
        return this.consultas.filtrarConsultaNomePaciente(nomePaciente);
    }

    @Override
    public Consultas filtrarConsultaCpfPaciente(Long cpf) throws ExceptionRegraNegocioFiltrarConsultas {
        return this.consultas.filtrarConsultaCpfPaciente(cpf);
    }

    @Override
    public void atualizarConsulta(Consultas consulta) throws ExceptionRegraNegocioAtualizarConsultas {
       this.consultas.atualizarConsulta(consulta);
    }

    @Override
    public void deletarConsulta(Long cpfPaciente) throws ExceptionRegraNegocioDeletarConsultas {
        this.consultas.deletarConsulta(cpfPaciente);
    }
    
    @Override
    public List<Consultas> filtrarNomeMedico(String nomeMedico) throws ExceptionRegraNegocioFiltrarConsultas {
        return this.consultas.filtrarNomeMedico(nomeMedico);
    }
    
    @Override
    public void agendarExame(Exames exame) throws ExceptionRegraNegocioAgendarExame {
        this.exames.agendarExame(exame);
    }

    @Override
    public Exames filtrarExameCpfPaciente(Long cpf) throws ExceptionRegraNegocioFiltrarExame {
        return this.exames.filtrarExameCpfPaciente(cpf);
    }

    @Override
    public List<Exames> filtrarExameNomePaciente(String nome) throws ExceptionRegraNegocioFiltrarExame {
        return this.exames.filtrarExameNomePaciente(nome);
    }

    @Override
    public void atualizarExame(Exames exame) throws ExceptionRegraNegocioAtualizarExames {
        this.exames.atualizarExame(exame);
    }

    @Override
    public void deletarExame(Long cpfPaciente) throws ExceptionRegraNegocioDeletarExames {
        this.exames.deletarExame(cpfPaciente);
    }

    

    @Override
    public void cadastrarUsuario(Usuarios usuario) throws ExceptionRegraNegocioCadastrarUsuarios {
        this.usuarios.cadastrarUsuario(usuario);
    }

    @Override
    public Usuarios buscarUsuarioSenhaNome(String senha, String nome) throws ExceptionRegraNegociofiltrarUsuarios {
        return this.usuarios.buscarUsuarioSenhaNome(senha, nome);
    }

    @Override
    public void atualizarUsuario(Usuarios usuario) throws ExceptionRegraNegocioAtualizarUsuarios {
        this.usuarios.atualizarUsuario(usuario);
    }

    @Override
    public void deletarUsuario(String cpf) throws ExceptionRegraNegocioDeletarUsuarios {
        this.usuarios.deletarUsuario(cpf);
    }

    @Override
    public Usuarios filtrarUsuarioCpf(String cpf) throws ExceptionRegraNegociofiltrarUsuarios {
        return this.usuarios.filtrarUsuarioCpf(cpf);
    }

    @Override
    public boolean checarLoginUsuario(String cpfUsuario) throws ExceptionRegraNegociofiltrarUsuarios {
        return this.usuarios.checarLoginUsuario(cpfUsuario);
    }
 


    
      
    
}
