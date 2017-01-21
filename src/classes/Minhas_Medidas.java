
package classes;

public class Minhas_Medidas {
    //Atributos
    private double peito;
    private double Biceps_Esq;
    private double Biceps_Dir;
    private double Ant_Braco_Esq;    
    private double Ant_Braco_Dir;
    private double Coxa_Esq;
    private double Coxa_Dir;
    private double Panturrilha_Esq;
    private double Panturrilha_Dir;
    private double Gordura;
    private double Abdomen;
    private double Altura;
    private double Peso;
//get
	public double getPeito() {
		return peito;
	}
	public double getBiceps_Esq() {
		return Biceps_Esq;
	}
	public double getBiceps_Dir() {
		return Biceps_Dir;
	}
	public double getAnt_Braco_Esq() {
		return Ant_Braco_Esq;
	}
	public double getAnt_Braco_Dir() {
		return Ant_Braco_Dir;
	}
	public double getCoxa_Esq() {
		return Coxa_Esq;
	}
	public double getCoxa_Dir() {
		return Coxa_Dir;
	}
	public double getPanturrilha_Esq() {
		return Panturrilha_Esq;
	}
	public double getPanturrilha_Dir() {
		return Panturrilha_Dir;
	}
	public double getGordura() {
		return Gordura;
	}
	public double getAbdomen() {
		return Abdomen;
	}
	public double getAltura() {
		return Altura;
	}
	public double getPeso() {
		return Peso;
	}
//set
	public void setPeito(double peito) {
		this.peito = peito;
	}
	public void setBiceps_Esq(double biceps_Esq) {
		Biceps_Esq = biceps_Esq;
	}
	public void setBiceps_Dir(double biceps_Dir) {
		Biceps_Dir = biceps_Dir;
	}
	public void setAnt_Braco_Esq(double ant_Braco_Esq) {
		Ant_Braco_Esq = ant_Braco_Esq;
	}
	public void setAnt_Braco_Dir(double ant_Braco_Dir) {
		Ant_Braco_Dir = ant_Braco_Dir;
	}
	public void setCoxa_Esq(double coxa_Esq) {
		Coxa_Esq = coxa_Esq;
	}
	public void setCoxa_Dir(double coxa_Dir) {
		Coxa_Dir = coxa_Dir;
	}
	public void setPanturrilha_Esq(double panturrilha_Esq) {
		Panturrilha_Esq = panturrilha_Esq;
	}
	public void setPanturrilha_Dir(double panturrilha_Dir) {
		Panturrilha_Dir = panturrilha_Dir;
	}
	public void setGordura(double gordura) {
		Gordura = gordura;
	}
	public void setAbdomen(double abdomen) {
		Abdomen = abdomen;
	}
	public void setAltura(double altura) {
		Altura = altura;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}

	@Override
    public String toString() {
        return "Minhas_Medidas{" + "peito=" + peito + ", Biceps_Esq=" + Biceps_Esq + ", Biceps_Dir="
               + Biceps_Dir + ", Ant_Braco_Esq=" + Ant_Braco_Esq + ", Ant_Braco_Dir=" + Ant_Braco_Dir +
                ", Coxa_Esq=" + Coxa_Esq + ", Coxa_Dir=" + Coxa_Dir + ",\n Panturrilha_Esq=" + Panturrilha_Esq +
                ", Panturrilha_Dir=" + Panturrilha_Dir + ", Gordura=" + Gordura + ", Abdomen=" + Abdomen +
                ", Altura=" + Altura + ", Peso=" + Peso + '}';
    }
}
