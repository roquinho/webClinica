
package br.clinica.persistencia;

import br.clinica.entidades.Consultas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manoel
 */
public class RepositorioConsultas implements InterfaceRepositorioConsultas {

        private Connection conexao;
	private PreparedStatement stm;
        private ResultSet rs;
           
           public RepositorioConsultas() {
               
           }
    
    @Override
    public void agendarConsulta(Consultas consulta) {
     this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
        try{
          String sql = "insert into consultas"+"(nome_paciente,cpf_paciente,hora_consulta,dia_consulta,nome_medico)"+"values(?,?,?,?,?)";	
            
          this.stm=conexao.prepareStatement(sql);

     this.stm.setString(1,((Consultas) consulta).getPaciente().getNome());
     this.stm.setLong(2,((Consultas) consulta).getPaciente().getCpf());
     this.stm.setString(3,((Consultas) consulta).getHoraConsulta());
     this.stm.setString(4,((Consultas) consulta).getDiaConsulta());
     this.stm.setString(5,((Consultas) consulta).getMedico().getNome());
     
        this.stm.execute();        
        this.stm.close();
        this.conexao.close();
        
        }catch(SQLException e) {
          try {
              throw new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }        
        
    }

    @Override
    public List<Consultas> filtrarConsultaNomePaciente(String nomePaciente) {
        this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
       List<Consultas>consultas = new ArrayList();
         try{	    	 
	  String sql = "select * from consultas where nome_paciente like ?";
          
        this.stm = conexao.prepareStatement(sql);
        this.stm.setString(1,'%'+ nomePaciente+'%');
        this.rs = stm.executeQuery();
                   
       		    while(this.rs.next()){
                        
                            Consultas consulta = new Consultas();
	 		        consulta.getPaciente().setNome(this.rs.getString("nome_paciente"));
	         		consulta.getPaciente().setCpf(this.rs.getLong("cpf_paciente"));
	 			consulta.setHoraConsulta(this.rs.getString("hora_consulta"));
	 			consulta.setDiaConsulta(this.rs.getString("dia_consulta"));
	 			consulta.getMedico().setNome(this.rs.getString("nome_medico"));
	 				consultas.add(consulta);              
	 				}	 					 				
	 			
	 			this.stm.close();
	 			this.rs.close();
                                this.conexao.close();
        }catch(SQLException e) {
          try {
              throw  new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }         
        return consultas;
    }

    @Override
    public Consultas filtrarConsultaCpfPaciente(Long cpf) {
    this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
      Consultas consulta = null;
        try{	    	 
	  String sql = "select * from consultas";	    	
	    this.stm = conexao.prepareStatement(sql);
	        this.rs = stm.executeQuery();
       		    while(this.rs.next()){
	 		if(cpf.equals(this.rs.getLong("cpf_paciente"))){
                            consulta = new Consultas();
	 		        consulta.getPaciente().setNome(this.rs.getString("nome_paciente"));
	         		consulta.getPaciente().setCpf(this.rs.getLong("cpf_paciente"));
	 			consulta.setHoraConsulta(this.rs.getString("hora_consulta"));
	 			consulta.setDiaConsulta(this.rs.getString("dia_consulta"));
	 			consulta.getMedico().setNome(this.rs.getString("nome_medico"));
	 				}
	 					 				
	 			}
	 			this.stm.close();
	 			this.rs.close();
                                this.conexao.close();
        }catch(SQLException e) {
          try {
              throw  new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        return consulta;
    }
    @Override
    public void atualizarConsulta(Consultas consulta) {
        this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
         try{
	    String sql = "update consultas set hora_consulta=?,"+"dia_consulta=? "+"where cpf_paciente=?";
	       this.stm = conexao.prepareStatement(sql);
               
     this.stm.setString(1,((Consultas) consulta).getHoraConsulta());
     this.stm.setString(2,((Consultas) consulta).getDiaConsulta());
     this.stm.setLong(3, ((Consultas) consulta).getPaciente().getCpf());
        
        this.stm.execute();        
        this.stm.close();
        this.conexao.close();
        
        }catch(SQLException e) {
          try {
              throw new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }        
        
    }

    @Override
    public void deletarConsulta(Long cpfPaciente) {
        this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica"); 
         try{
	    	String sql = "select * from consultas";	
		 	this.stm = conexao.prepareStatement(sql);
		 	 this.rs=stm.executeQuery();		 	
		 	  while(this.rs.next()){		  		
	    	            if(cpfPaciente.equals(this.rs.getLong("cpf_paciente"))){	    			    
	    	                String sqlexcluir = "delete from consultas where cpf_paciente =?" ;	    	
	    	                  this.stm = conexao.prepareStatement(sqlexcluir);				
	    	                          this.stm.setLong(1,cpfPaciente);
			                    this.stm.execute();
                             }
                          }
	    	                               this.stm.close();
		 	                          this.rs.close();
                          
                          this.conexao.close();
         }catch(SQLException e) {
           try {
               throw new Exception(e.getMessage());
           } catch (Exception ex) {
               Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
           }

         }
    }

    @Override
    public List<Consultas> filtrarNomeMedico(String nomeMedico) {
        this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
       List<Consultas>consultas = new ArrayList();
         try{	    	 
	  String sql = "select * from consultas where nome_medico like ?";
          
        this.stm = conexao.prepareStatement(sql);
        this.stm.setString(1,'%'+ nomeMedico+'%');
        this.rs = stm.executeQuery();
                   
       		    while(this.rs.next()){
                        
                            Consultas consulta = new Consultas();
	 		        consulta.getPaciente().setNome(this.rs.getString("nome_paciente"));
	         		consulta.getPaciente().setCpf(this.rs.getLong("cpf_paciente"));
	 			consulta.setHoraConsulta(this.rs.getString("hora_consulta"));
	 			consulta.setDiaConsulta(this.rs.getString("dia_consulta"));
	 			consulta.getMedico().setNome(this.rs.getString("nome_medico"));
	 				consultas.add(consulta);              
	 				}	 					 				
	 			
	 			this.stm.close();
	 			this.rs.close();
                                this.conexao.close();
        }catch(SQLException e) {
          try {
              throw  new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }         
        return consultas;

    }
    
    public boolean checarHoraDataConsulta(String data, String hora) {
      this.conexao = new ConexaoBancoDeDados().conectar("root", "12345","localhost", "clinica");
        boolean boleano = false;
        
        try{	    	 
	  String sql = "select * from consultas";	    	
	    this.stm = conexao.prepareStatement(sql);
	        this.rs = stm.executeQuery();
       		    while(this.rs.next()){
                       
	 		if(data.equals(this.rs.getString("dia_consulta"))){
                          if(hora.equals(this.rs.getString("hora_consulta"))) { 
                              boleano = true;
	 		        	}
                        }		 				
	 			}
	 			this.stm.close();
	 			this.rs.close();
                                this.conexao.close();
        }catch(SQLException e) {
          try {
              throw  new Exception(e.getMessage());
          } catch (Exception ex) {
              Logger.getLogger(RepositorioConsultas.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
      
        
        return boleano;  
    }
    
}
