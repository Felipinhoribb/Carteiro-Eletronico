package Model;

public class Dependencia {

	private int idDependencia;
	private String siglaDependencia;
	private String nomeDependencia;
	private String omDependencia;
	private String contatoDependencia;
	
	public Dependencia() {
		// TODO Auto-generated constructor stub
	}

	public int getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getNomeDependencia() {
		return nomeDependencia;
	}

	public void setNomeDependencia(String nomeDependencia) {
		this.nomeDependencia = nomeDependencia;
	}
	
	public String getSiglaDependencia() {
		return siglaDependencia;
	}

	public void setSiglaDependencia(String siglaDependencia) {
		this.siglaDependencia = siglaDependencia;
	}

	public String getOmDependencia() {
		return omDependencia;
	}

	public void setOmDependencia(String omDependencia) {
		this.omDependencia = omDependencia;
	}

	public String getContatoDependencia() {
		return contatoDependencia;
	}

	public void setContatoDependencia(String contatoDependencia) {
		this.contatoDependencia = contatoDependencia;
	}

	@Override
	public String toString() {
		
		return nomeDependencia;
		
		/*return "Dependencia [idDependencia=" + idDependencia + ", nomeDependencia=" + nomeDependencia
				+ ", omDependencia=" + omDependencia + ", contatoDependencia=" + contatoDependencia + "]";*/
	}

	
}
