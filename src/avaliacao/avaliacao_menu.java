
package avaliacao;

import classes.Usuario;
import exames.Exames;
import menus.Menu;
import javax.swing.JOptionPane;


public class avaliacao_menu extends Menu { 
    
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
                    Avaliacoes avaliacoes = new Avaliacoes();
                    avaliacoes.Marcar_Avalicao(u);
                    break;
                case 02:
                    Exames ex = new Exames();
                    ex.Consulta_Exame(u);
                    break;
                case 03:
                    sair = true;
                    break;
            }
        op_menu = null;
        }
    }  
}
