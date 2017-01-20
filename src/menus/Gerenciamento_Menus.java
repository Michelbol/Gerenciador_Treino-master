
package menus;

import aplicações.Conexao_Banco;
import classes.Conexao_Sistema;
import classes.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Gerenciamento_Menus{
	
    public static void main(String[] args) {
        Connection con = Conexao_Banco.getConnection();
      //atributos
        String status;
        String q;
        //Objetos
        Usuario u = new Usuario();
        Conexao_Sistema cs = new Conexao_Sistema();
            u = cs.Tela_Login(); 
                switch(u.getPermissao()){
                //Menus
                    case 1:
            
                        break;
                    case 2:
                        Menu menu_Atleta = new Menu_Opcoes_Atleta();
                        if (u.getIdusuario() != 0 ){
                        menu_Atleta.menu(u);
                        }
                        break;
                    case 3:
            
                        break;
                    case 4:
                        Menu menu_adm = new Menu_Opcoes_Administrador_Academia();
                        if (u.getIdusuario() != 0 ){
                            menu_adm.menu(u);
                        }
                        break;
                    case 5:
                        Menu menu_medico = new Menu_Opcoes_Medico();
                        if (u.getIdusuario() != 0 ){
                            menu_medico.menu(u);
                        }
                        break;
                }
        //Saindo do Sistema
        q = "update usuario set conexao = 'Offline' where usuario.login = " + "'" + u.getLogin() + "'";
            try{
                Statement st = con.createStatement();
                st.executeUpdate(q);
                status = "Alteração realizada com sucesso";
                System.out.println(status);
            }catch(SQLException e){
                status = "Não foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
                System.out.println(status);
            }
    }
}   


