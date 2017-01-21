package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import aplicações.Conexao_Banco;
import avaliacao.Avaliacoes;
import classes.Usuario;

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
    

    public void Verifica_Avaliacoes_Medico(Usuario u){
        q = "select a.idAvaliacao, u.Login, a.Dia_avaliacao from avaliacao a "
            + "join usuario u on a.idUsuario = u.idUsuario "
            + "where a.idMedico = " + u.getIdusuario() + " and a.Finalizado = 'NAO'";
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);
        status = "Consulta realizada com sucesso";
            while(rs.next()){
                idavaliacao = rs.getInt("idAvaliacao");
                data_hora = rs.getString("Dia_avaliacao");
                nomeusuario = rs.getString("Login");
                Avaliacoes a = new Avaliacoes(data_hora, nomeusuario, idavaliacao);
                Avaliacoes_Medico.add(a);                
        }
        }catch (SQLException e){
            status = "Não foi possivel alterar o registro erro: " +e.getMessage() +" sql executado " + q;
            System.out.println(status);
        }
    JOptionPane.showMessageDialog(null, Avaliacoes_Medico.toArray());
    }
	
}
