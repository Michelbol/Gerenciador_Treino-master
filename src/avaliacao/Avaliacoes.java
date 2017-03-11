
package avaliacao;
//Classe avaliação é a classe que possui os atributos para as avaliações
public class Avaliacoes {
	//Atributos
    private String data_hora;
    private String nomeusuario;
    private int idavaliacao;   
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
}