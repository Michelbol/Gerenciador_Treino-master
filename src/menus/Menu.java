
package menus;

import java.sql.Connection;

import aplicações.Conexao_Banco;
import classes.Usuario;

	public class Menu {
		static Connection con = Conexao_Banco.getConnection(); 
	    //atributos
	    public int op;
	    public boolean sair;
	    public String op_menu;
	    
	    public void menu(Usuario u){
	    	
	    }
    

}
