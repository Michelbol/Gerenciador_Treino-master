
package dieta;

public class Dieta {

	//Atributos
    private String Dia_Semana;
    private String CafeDaManha;
    private String Colacao;
    private String Almoco;
    private String LancheDaTarde;
    private String Janta;
    private String Ceia;
    private int TipoDieta;
    //get
	public String getDia_Semana() {
		return Dia_Semana;
	}
	public String getCafeDaManha() {
		return CafeDaManha;
	}
	public String getColacao() {
		return Colacao;
	}
	public String getAlmoco() {
		return Almoco;
	}
	public String getLancheDaTarde() {
		return LancheDaTarde;
	}
	public String getJanta() {
		return Janta;
	}
	public String getCeia() {
		return Ceia;
	}
	public int getTipoDieta() {
		return TipoDieta;
	}
	//set
	public void setDia_Semana(String dia_Semana) {
		Dia_Semana = dia_Semana;
	}
	public void setCafeDaManha(String cafeDaManha) {
		CafeDaManha = cafeDaManha;
	}
	public void setColacao(String colacao) {
		Colacao = colacao;
	}
	public void setAlmoco(String almoco) {
		Almoco = almoco;
	}
	public void setLancheDaTarde(String lancheDaTarde) {
		LancheDaTarde = lancheDaTarde;
	}
	public void setJanta(String janta) {
		Janta = janta;
	}
	public void setCeia(String ceia) {
		Ceia = ceia;
	}
	public void setTipoDieta(int tipoDieta) {
		TipoDieta = tipoDieta;
	}
	//Construtor
	public Dieta() {
	
	}
	public Dieta(String dia_Semana, String cafeDaManha, String colacao, String almoco, String lancheDaTarde,
			String janta, String ceia) {
		super();
		Dia_Semana = dia_Semana;
		CafeDaManha = cafeDaManha;
		Colacao = colacao;
		Almoco = almoco;
		LancheDaTarde = lancheDaTarde;
		Janta = janta;
		Ceia = ceia;
	}
	//TooString
	@Override
	public String toString() {
		return "Dieta [Dia_Semana=" + Dia_Semana + ", CafeDaManha=" + CafeDaManha + ", Colacao=" + Colacao + ", Almoco="
				+ Almoco + ", LancheDaTarde=" + LancheDaTarde + ", Janta=" + Janta + ", Ceia=" + Ceia + "]";
	}
    
    
}
