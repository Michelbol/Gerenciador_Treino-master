
package classes;

import aplicações.Conexao_Banco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exercicios_Dia {
//Conexão
    public Connection con = Conexao_Banco.getConnection();
//Atributos
        private String Dia_Semana;
    private String Nome_Exercicio;
    private String Descricao;
    private String Musculo;
    public String q;
    public String status = "";
//Listas
    ArrayList<Exercicios_Dia> exercicios_dia = new ArrayList<Exercicios_Dia>();
//Get
    public String getDia_Semana() {
        return Dia_Semana;
    }
    public String getNome_Exercicio() {
        return Nome_Exercicio;
    }
    public String getDescricao() {
        return Descricao;
    }
    public String getMusculo() {
        return Musculo;
    }
//Set
    public void setMusculo(String Musculo) {
        this.Musculo = Musculo;
    }
    public void setDia_Semana(String Dia_Semana) {
        this.Dia_Semana = Dia_Semana;
    }    
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }    
    public void setNome_Exercicio(String Nome_Exercicio) {
        this.Nome_Exercicio = Nome_Exercicio;
    }
//Construtor
    public Exercicios_Dia(String Dia_Semana, String Nome_Exercicio, String Descricao, String Musculo) {
        this.Dia_Semana = Dia_Semana;
        this.Nome_Exercicio = Nome_Exercicio;
        this.Descricao = Descricao;
        this.Musculo = Musculo;
    }
    public Exercicios_Dia(){
    }
//toString
    @Override
    public String toString() {
        return "Dia_Semana=" + Dia_Semana + ", Nome_Exercicio=" + Nome_Exercicio + ", Descricao=" + Descricao + ", Musculo=" + Musculo;
    }
     //Objeto
    Exercicios_Dia ed;    
    //Verificando Exercicios Atleta
    public void exerc_diario_atleta(Usuario u){
        exercicios_dia.clear();
        q = "select s.Dia, e.nome_exercicio as Exercicio, m.Nome_Musculo as Musculo, e.Descricao from exercicios_diarios ed " +
        "inner join usuario u on ed.idUsuario = u.idUsuario " +
        "inner join semana s on ed.idSemana = s.idSemana " +
        "inner join exercicios e on ed.idExercicios = e.idExercicios " +
        "inner join musculo m on e.idmusculo = m.idmusculo " +
        "where u.idUsuario = "+ u.getIdusuario();
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                ed = new Exercicios_Dia();
                ed.setDia_Semana(rs.getString("dia"));
                ed.setNome_Exercicio(rs.getString("Exercicio"));
                ed.setDescricao(rs.getString("descricao"));
                ed.setMusculo(rs.getString("Musculo"));
                exercicios_dia.add(ed);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
        JOptionPane.showMessageDialog(null, exercicios_dia.toArray());
    }
}
