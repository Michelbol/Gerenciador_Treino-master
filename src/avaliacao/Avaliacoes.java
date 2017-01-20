
package avaliacao;

import aplica��es.Conexao_Banco;
import classes.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Avaliacoes {
//Conex�o
    Connection con = Conexao_Banco.getConnection();
//Atributos
    String q;
    static String status = "";
    private String data_hora;
    private String nomeusuario;
    private int idavaliacao;
    boolean avaliacao;
//Construtor
    public Avaliacoes(String data_hora, String nomeusuario, int idavaliacao) {
        this.data_hora = data_hora;
        this.nomeusuario = nomeusuario;
        this.idavaliacao = idavaliacao;
    }
    public Avaliacoes(){
    }
//too String
    @Override
    public String toString() {
        return "Avaliacoes{" + "data_hora=" + data_hora + ", nomeusuario=" + nomeusuario + ", idavaliacao=" + idavaliacao + '}';
    }
    
//objetos
    ArrayList<Avaliacoes> Avaliacoes_Medico = new ArrayList<Avaliacoes>();
    avaliacao_menu_horario hora = new avaliacao_menu_horario();
    
    public boolean Marcar_Avalicao(Usuario u){
       data_hora = hora.hora_avaliacao(); 
        q = "insert into avaliacao(idUsuario, Dia_avaliacao) "
            + "values ("+u.getIdusuario()+", "+"'"+ data_hora +"')";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(q);
            status = "Registro incluido com sucesso";
            avaliacao = true;
        }catch(SQLException e){
            status = "N�o foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
            System.out.println(status);
            avaliacao = false;
        }
        return avaliacao;
    }
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
            status = "N�o foi possivel alterar o registro erro: " +e.getMessage() +" sql executado " + q;
            System.out.println(status);
        }
    JOptionPane.showMessageDialog(null, Avaliacoes_Medico.toArray());
    }
}