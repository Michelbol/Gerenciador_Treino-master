package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import aplica��es.Conexao_Banco;
import avaliacao.Avaliacoes;
import classes.Usuario;
import dieta.Dieta;

public class DaoMedico {
	Connection con = Conexao_Banco.getConnection();
	//Atributos
    private String data_hora;
    private String nomeusuario;
    private int idavaliacao;
    String q;
    String status = "";

	//objetos
    ArrayList<Avaliacoes> Avaliacoes_Medico = new ArrayList<Avaliacoes>(); 
    ArrayList<Dieta> dieta = new ArrayList<Dieta>();
    
    public void Verifica_Avaliacoes_Medico(Usuario u){
        q = "select a.idAvaliacao, u.Login, a.Dia_avaliacao from avaliacao a "
            + "join usuario u on a.idUsuario = u.idUsuario "
            + "where a.idMedico = " + u.getIdusuario() + " and a.Finalizado = 'NAO'";
        Avaliacoes a;
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        status = "Consulta realizada com sucesso";
            while(rs.next()){
                idavaliacao = rs.getInt("idAvaliacao");
                data_hora = rs.getString("Dia_avaliacao");
                nomeusuario = rs.getString("Login");
                a = new Avaliacoes(data_hora, nomeusuario, idavaliacao);
                Avaliacoes_Medico.add(a);                
        }
        }catch (SQLException e){
            status = "N�o foi possivel alterar o registro erro: " +e.getMessage() +" sql executado " + q;
            System.out.println(status);
        }
    JOptionPane.showMessageDialog(null, Avaliacoes_Medico.toArray());
    }
	
    public void criacaoDieta(Usuario u){
    	Dieta d = new Dieta();
    	d.setTipoDieta(Integer.parseInt(JOptionPane.showInputDialog(null, "01 - Dieta Maromba ou 02 - "
    			+ "Dieta Marmotinha?")));
    	if(d.getTipoDieta() == 1){
    		d.setCafeDaManha(JOptionPane.showInputDialog(null, "Ol�, o que ir� comer no caf� da manh�?"));
        	d.setColacao(JOptionPane.showInputDialog(null, "E ir� comer em sua Cola��o?"));
        	d.setAlmoco(JOptionPane.showInputDialog(null, "Almo�o?"));
        	d.setLancheDaTarde(JOptionPane.showInputDialog(null, "Caf� Da Tarde(N�o vale Coxinha"));
        	d.setJanta(JOptionPane.showInputDialog(null, "Minha janta � meu treino, e a sua?"));
        	d.setCeia(JOptionPane.showInputDialog(null, "E pra finalizar, qual ser� sua ceia?"));
    	}else{
    		d.setCafeDaManha(JOptionPane.showInputDialog(null, "Ol�, o que ir� comer no caf� da manh�?"));
    		d.setAlmoco(JOptionPane.showInputDialog(null, "Almo�o?"));
    		d.setJanta(JOptionPane.showInputDialog(null, "Minha janta � meu treino, e a sua?"));
    	}
    	dieta.add(d);
    	JOptionPane.showMessageDialog(null, dieta.toArray());
    }
}
