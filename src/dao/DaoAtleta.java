package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import aplicações.Conexao_Banco;
import avaliacao.avaliacao_menu_horario;
import classes.Aula_Diaria;
import classes.Exercicios_Dia;
import classes.Minhas_Medidas;
import classes.Usuario;
import dieta.Dieta;
import exames.Exames;

public class DaoAtleta {
	//Conexão
    Connection con = Conexao_Banco.getConnection();
    //Atributos
    private String data_hora;
    String q;
    String status = "";
    boolean avaliacao;  
    
    public boolean Marcar_Avalicao(Usuario u){
    	avaliacao_menu_horario hora = new avaliacao_menu_horario();
        data_hora = hora.hora_avaliacao(); 
         q = "insert into avaliacao(idUsuario, Dia_avaliacao) "
             + "values ("+u.getIdusuario()+", "+"'"+ data_hora +"')";
         try{
             Statement st = con.createStatement();
             st.executeUpdate(q);
             status = "Registro incluido com sucesso";
             avaliacao = true;
         }catch(SQLException e){
             status = "Não foi possivel alterar o registro erro: " +e.getMessage()+" sql executado "+ q;
             System.out.println(status);
             avaliacao = false;
         }
         return avaliacao;
     }

    public void Aulas_Dia(){
    	Calendar c = Calendar.getInstance();
    	Aula_Diaria ad = new Aula_Diaria();
    	ArrayList<Aula_Diaria> Horario_Aulas = new ArrayList<Aula_Diaria>();
        q = "select ad.Aula_Nome, ad.Horario_Aula, s.Dia from aulas_diarias ad " +
            "inner join semana s on ad.idsemana = s.idSemana "+
            "where ad.idSemana = " + c.get(Calendar.DAY_OF_WEEK);
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                ad.setNome_Aula(rs.getString("Aula_Nome"));
                ad.setHora_Aula(rs.getString("Horario_Aula"));
                ad.setDia_Aula(rs.getString("Dia"));
                Horario_Aulas.add(ad);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
        if (Horario_Aulas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Infelizmente não temos nenhuma aula hoje");
        }else{
            JOptionPane.showMessageDialog(null,Horario_Aulas.toArray());
        }
    }

    public void exerc_diario_atleta(Usuario u){
    	Exercicios_Dia ed = new Exercicios_Dia();;
    	ArrayList<Exercicios_Dia> exercicios_dia = new ArrayList<Exercicios_Dia>();
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

    public void Consuta_Medidas(Usuario u){
        Minhas_Medidas mm = new Minhas_Medidas();
        q = "select * from minhas_medidas where idUsuario =" + u.getIdusuario();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);           
            while(rs.next()){ 
                mm.setPeito(rs.getDouble("Peito"));
                mm.setBiceps_Esq(rs.getDouble("Biceps_Esq"));
                mm.setBiceps_Dir(rs.getDouble("Biceps_Dir"));
                mm.setAnt_Braco_Esq(rs.getDouble("Ant_Braco_Esq"));                        
                mm.setAnt_Braco_Dir(rs.getDouble("Ant_Braco_Dir"));
                mm.setCoxa_Esq(rs.getDouble("Coxa_Esq"));
                mm.setCoxa_Dir(rs.getDouble("Coxa_Dir"));
                mm.setPanturrilha_Esq(rs.getDouble("Panturrilha_Esq"));
                mm.setPanturrilha_Dir(rs.getDouble("Panturrilha_Dir"));
                mm.setGordura(rs.getDouble("Gordura"));
                mm.setAbdomen(rs.getDouble("Abdomen"));
                mm.setAltura(rs.getDouble("Altura"));
                mm.setPeso(rs.getDouble("Peso"));
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }
JOptionPane.showMessageDialog(null, mm.toString());
}

    public void Verifica_Dieta_Usuario (Usuario u){
    	Dieta d = new Dieta();
        ArrayList<Dieta> dieta = new ArrayList<Dieta>();
        q = "select s.Dia as Dia, d.Refeicao, d.Descricao from dieta d " +
            "inner join semana s on s.idSemana = d.idDieta " +
            "inner join usuario u on u.idUsuario = d.idUsuario " +
            "where "+u.getIdusuario()+" = d.idUsuario";
        System.out.println(q);
        try{ 
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);            
            while(rs.next()){
                d.setDia_Semana(rs.getString("dia"));
                d.setRefeicao(rs.getString("Refeicao"));
                d.setDescricao(rs.getString("descricao"));
                dieta.add(d);
            }
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println(status);
        }        
        JOptionPane.showMessageDialog(null, dieta.toArray());
    }
   
    public void Consulta_Exame(Usuario u){
        ArrayList<Exames> meus_exames = new ArrayList<Exames>();
        Exames ex = new Exames();
        q = "select av.idAvaliacao as Codigo, av.Dia_avaliacao as Seu_Exame from avaliacao av\n" +
            "where idusuario ="+ u.getIdusuario() +";";
        try{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(q);           
        while(rs.next()){ 
            ex.setIdavaliacao(rs.getInt("Codigo"));
            ex.setDia_avaliacao(rs.getString("Seu_Exame"));
            meus_exames.add(ex);
        }
        }catch(SQLException e){
        status = e.getMessage();
        System.out.println(status);
        }
        JOptionPane.showMessageDialog(null, meus_exames.toArray());
    }

    public void Sair_Sistemas(Usuario u){
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
