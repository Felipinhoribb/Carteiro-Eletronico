package Model;

public class Graduacao {

	private int idGraduacao;
	private String nomeGraduacao;
	
	public Graduacao() {
		// TODO Auto-generated constructor stub
	}

	public int getIdGraduacao() {
		return idGraduacao;
	}

	public void setIdGraduacao(int idGraduacao) {
		this.idGraduacao = idGraduacao;
	}

	public String getNomeGraduacao() {
		return nomeGraduacao;
	}

	public void setNomeGraduacao(String nomeGraduacao) {
		this.nomeGraduacao = nomeGraduacao;
	}

	@Override
	public String toString() {
		return nomeGraduacao;
	}

}
