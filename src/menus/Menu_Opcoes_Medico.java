
package menus;

import classes.Usuario;
import dao.DaoMedico;

import javax.swing.JOptionPane;


public class Menu_Opcoes_Medico extends Menu {
    public void menu(Usuario u){
        while(!sair){
        op = Integer.parseInt(JOptionPane.showInputDialog(""
            + "01 - Avaliações\n"
            + "02 - Dietas\n"
            + "03 - Treino\n"
            + "04 - Menu Atleta\n"
            + "05 - Sair do Sistema\n"));
            switch(op){
                case 1:
                    DaoMedico medico = new DaoMedico();
                    medico.Verifica_Avaliacoes_Medico(u);                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4: 
                    if (u.getIdusuario() != 0 ){
                        Menu menu_Atleta = new Menu_Opcoes_Atleta();
                        menu_Atleta.menu(u);
                    }
                    break;
                case 5:
                    sair = true;
                    break;    
            }
        }
    }
    
}
