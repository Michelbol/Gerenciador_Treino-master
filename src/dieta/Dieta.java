
package dieta;

public class Dieta {

//Atributos
    private String Dia_Semana;
    private String Refeicao;
    private String Descricao;
    public Dieta(String Dia_Semana, String Refeicao, String Descricao) {
        this.Dia_Semana = Dia_Semana;
        this.Refeicao = Refeicao;
        this.Descricao = Descricao;
    }
    public Dieta(){
    }
    //get
    public String getDia_Semana() {
		return Dia_Semana;
	}
	public String getRefeicao() {
		return Refeicao;
	}
	public String getDescricao() {
		return Descricao;
	}
	//set
	public void setDia_Semana(String dia_Semana) {
		Dia_Semana = dia_Semana;
	}
	public void setRefeicao(String refeicao) {
		Refeicao = refeicao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	@Override
    public String toString() {
        return "Dia_Semana=" + Dia_Semana + ", Refeicao=" + Refeicao + ", Descricao=" + Descricao;
    } 
}
