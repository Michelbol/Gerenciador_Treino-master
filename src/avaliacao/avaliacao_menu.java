
package avaliacao;

import classes.Usuario;
import dao.DaoAtleta;
import menus.Menu;
import javax.swing.JOptionPane;


public class avaliacao_menu extends Menu { 
	DaoAtleta atleta = new DaoAtleta();
    //Menu das avaliações tem opções de marcar e consultas as avaliações
	@Override
    public void menu(Usuario u){
        while(!sair){
            while(op_menu == null || op_menu.equals("")){
                op_menu = JOptionPane.showInputDialog(""
                          + "01 - Marcar Avaliação\n"
                          + "02 - Minhas Avaliações\n"
                          + "03 - Voltar Menu");
            }
            op = Integer.parseInt(op_menu);
            switch(op){
                case 01:
                    atleta.Marcar_Avalicao(u);
                    break;
                case 02:
                    atleta.Consulta_Exame(u);
                    break;
                case 03:
                    sair = true;
                    break;
            }
        op_menu = null;
        }
    }  
}
