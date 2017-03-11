
package menus;


import classes.Usuario;
import dao.Conexao_Sistema;
import dao.DaoAtleta;

public class Gerenciamento_Menus{
	
    public static void main(String[] args) {
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
            		u.VerificaDieta(u);
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
    DaoAtleta atleta = new DaoAtleta();
    atleta.Sair_Sistemas(u);
    }
}   


