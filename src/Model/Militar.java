package Model;

public class Militar {

	private int idMilitar;
	private String nomeGuerra;
	private int identidade;
	private String graduacao;
	private String dependencia;
	
	public Militar() {
		// TODO Auto-generated constructor stub
	}


	public int getIdMilitar() {
		return idMilitar;
	}

	public void setIdMilitar(int idMilitar) {
		this.idMilitar = idMilitar;
	}

	public String getNomeGuerra() {
		return nomeGuerra;
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public int getIdentidade() {
		return identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}


	@Override
	public String toString() {
		return "Militar [idMilitar=" + idMilitar + ", nomeGuerra=" + nomeGuerra + ", identidade=" + identidade
				+ ", graduacao=" + graduacao + ", dependencia=" + dependencia + "]";
	}
	
	
}
