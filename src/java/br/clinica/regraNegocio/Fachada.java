
package br.clinica.regraNegocio;

import br.clinica.entidades.Consultas;
import br.clinica.entidades.Exames;
import br.clinica.entidades.Medicos;
import br.clinica.entidades.Pacientes;
import br.clinica.entidades.Usuarios;
import java.util.List;

public interface Fachada {
    
    public void cadastrarPaciente(Pacientes paciente)throws ExceptionRegraNegocioPacientesCadastrar;
    
    public Pacientes buscarPacienteCpf(Long cpf)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public List<Pacientes> buscarPacienteNome(String nome)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    public void atualizarPaciente(Pacientes paciente)throws ExceptionRegraNegocioAtualizarPacientes;
    
    public void deletarPaciente(Long cpf)throws ExceptionRegraNegocioDeletarPacientes;
    
    public boolean checarLoginPaciente(Long cpfPaciente)throws ExceptionRegraNegocioPacienteBuscarPaciente;
    
    
    
    
    public void cadastrarMedicos(Medicos medico)throws ExceptionRegraNegocioCadastrarMedicos;
    
    public Medicos buscarMedicoCpf(Long cpf)throws ExceptionRegraNegocioBuscarMedicos;
    
    public List<Medicos> buscarMedicoNome(String nome)throws ExceptionRegraNegocioBuscarMedicos;
    
    public void atualizarMedico(Medicos medico)throws ExceptionRegraNegocioAtualizarMedicos;
    
    public void deletarMedico(Long cpf)throws ExceptionRegraNegocioDeletarMedicos;
    
    public boolean checarLoginMedico(Long cpfMedico)throws ExceptionRegraNegocioBuscarMedicos;
   
   
   
    
    public void agendarConsulta(Consultas consulta)throws ExceptionRegraNegocioAgendarConsultas;
    
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public Consultas filtrarConsultaCpfPaciente(Long cpf)throws ExceptionRegraNegocioFiltrarConsultas;
    
    public void atualizarConsulta(Consultas consulta)throws ExceptionRegraNegocioAtualizarConsultas;
    
    public void deletarConsulta(Long cpfPaciente)throws ExceptionRegraNegocioDeletarConsultas;
    
    public List<Consultas> filtrarNomeMedico(String nomeMedico)throws ExceptionRegraNegocioFiltrarConsultas;
    
    
    public void agendarExame(Exames exame)throws ExceptionRegraNegocioAgendarExame;
    
    public Exames filtrarExameCpfPaciente(Long cpf)throws ExceptionRegraNegocioFiltrarExame;
    
    public List<Exames> filtrarExameNomePaciente(String nome)throws ExceptionRegraNegocioFiltrarExame;
    
    public void atualizarExame(Exames exame)throws ExceptionRegraNegocioAtualizarExames;
    
    public void deletarExame(Long cpfPaciente)throws ExceptionRegraNegocioDeletarExames;
    
    
    public void cadastrarUsuario(Usuarios usuario)throws ExceptionRegraNegocioCadastrarUsuarios;
    
    public Usuarios buscarUsuarioSenhaNome(String senha,String nome)throws ExceptionRegraNegociofiltrarUsuarios;
    
    public Usuarios filtrarUsuarioCpf(String cpf)throws ExceptionRegraNegociofiltrarUsuarios;
    
    public void atualizarUsuario(Usuarios usuario)throws ExceptionRegraNegocioAtualizarUsuarios;
    
    public void deletarUsuario(String cpf)throws ExceptionRegraNegocioDeletarUsuarios;

    public boolean checarLoginUsuario(String cpfUsuario)throws ExceptionRegraNegociofiltrarUsuarios;
   
}

    

