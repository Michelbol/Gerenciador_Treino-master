package aplica��es;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_Banco {
    public static String status = "";
    
    public static Connection getConnection(){
    Connection con = null;
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://127.0.0.1/mydb?user=root&password=Olacomovaivc1";
        con = DriverManager.getConnection(url);
        status = "Conex�o Aberta!";    
            System.out.println("Conex�o Aberta");
        }catch(SQLException e){
            status = e.getMessage();
            System.out.println("Conex�o Falhou");
        }catch(ClassNotFoundException e){
            status = e.getMessage();
            System.out.println("Conex�o Falhou");
        }catch(Exception e){
            status = e.getMessage();
            System.out.println("Conex�o Falhou");
        }
        return con;
    }
}