
package exames;



public class Exames {
//atributos
    private int idavaliacao;
    private String dia_avaliacao;
//get
    public int getIdavaliacao() {
        return idavaliacao;
    }
    public String getDia_avaliacao() {
        return dia_avaliacao;
    }
//set
    public void setIdavaliacao(int idavaliacao) {
        this.idavaliacao = idavaliacao;
    }
    public void setDia_avaliacao(String dia_avaliacao) {
        this.dia_avaliacao = dia_avaliacao;
    }
//toString
    @Override
    public String toString() {
        return "idavaliacao=" + idavaliacao + ", dia_avaliacao=" + dia_avaliacao;
    }
//Construtores
    public Exames(int idavaliacao, String dia_avaliacao) {
        super();
        this.idavaliacao = idavaliacao;
        this.dia_avaliacao = dia_avaliacao;
    } 
    public Exames() {
        super();
    }
}
