
package classes;

import javax.swing.JOptionPane;

import dao.DaoMedico;

public class Usuario {
   private String login;
   private String senha;
   private int idusuario;
   private int conexao;
   private int permissao;
   private int dieta;
   private String Nome;

	//get
    public String getLogin() {
        return login;
    }
    public String getSenha() {
        return senha;
    }
    public int getConexao() {
        return conexao;
    }
    public int getIdusuario() {
        return idusuario;
    }
    public int getPermissao() {
        return permissao;
    }
    public int getDieta() {
		return dieta;
	}    
    public String getNome() {
    	return Nome;
    }
    //set
    public void setLogin(String login) {
        if(login == null){
            this.login = "";
        }else{
        this.login = login;
        }
    }
    public void setSenha(String senha) {
        if(senha == null){
            this.senha = "";
        }else{
        this.senha = senha;
        }
    }
    public void setConexao(int conexao) {
        this.conexao = conexao;
    }
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
	public void setDieta(int dieta) {
		this.dieta = dieta;
	}
	public void setNome(String apelido) {
		Nome = apelido;
	}
	
    public void VerificaDieta(Usuario u){
    	int op = 5;
    	if (u.getDieta() == 1){
    	while (op == 5){	
    	op = JOptionPane.showConfirmDialog(null, "Olá "+ u.getLogin() + " Deseja Cadastrar sua Dieta?");
    		if(op == 0){
    			DaoMedico medico = new DaoMedico();
    			medico.criacaoDieta(u);
    		}else if (op == 1){
    			System.out.println("Opção Não!");
    		}else if (op == 2){
    			System.out.println("Cancelaaaaa!!");
    		}else{
    			op = 5;
    			JOptionPane.showConfirmDialog(null, "Não entendemos, Digite novamente por favor.");
    		}
    	}
    	
    	}
    	
    }

}
