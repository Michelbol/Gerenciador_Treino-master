
package menus;

import avaliacao.avaliacao_menu;
import classes.Usuario;
import dao.DaoAtleta;
import javax.swing.JOptionPane;


public class Menu_Opcoes_Atleta extends Menu {   
	DaoAtleta atleta = new DaoAtleta();
    public void menu(Usuario u){
        while(!sair){
            while(op_menu == null || op_menu.equals("")){
            op_menu = JOptionPane.showInputDialog(""
                + "01 - Exercicios De Hoje\n"
                + "02 - Sua dieta\n"
                + "03 - Avaliação\n"
                + "04 - Aula Diarias\n"
                + "05 - Minhas Medidas\n"
                + "06 - Sair do Sistema\n");
            }
            op = Integer.parseInt(op_menu);
                
            switch(op){
                case 1:
                    atleta.exerc_diario_atleta(u);
                    break;
                case 2:
                    atleta.Verifica_Dieta_Usuario(u);
                    break;
                case 3:
                    avaliacao_menu aval = new avaliacao_menu();
                    aval.menu(u);
                    break;
                case 4: 
                    atleta.Aulas_Dia();                    
                    break;
                case 5:
                    atleta.Consuta_Medidas(u);
                    break;
                case 6:
                    sair = true;
                    break;    
            }
            op_menu = null;
        }
    }
    
}
