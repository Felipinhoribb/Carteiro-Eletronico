package Model;

import java.util.Date;

public class Correspondencia {

	private int idCorrespondencia;
	private int idDocumento;
	private int numDocumento;
	private Date dataDocumento;
	private String remetente;
	private String destinatario;
	private String cidade;
	private int estado;
	private String cep;
	private String envio;
	private int idProtocolista;
	private String numRastreio;
	
	public Correspondencia() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCorrespondencia() {
		return idCorrespondencia;
	}

	public void setIdCorrespondencia(int idCorrespondencia) {
		this.idCorrespondencia = idCorrespondencia;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(int numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEnvio() {
		return envio;
	}

	public void setEnvio(String envio) {
		this.envio = envio;
	}

	public int getIdProtocolista() {
		return idProtocolista;
	}

	public void setIdProtocolista(int idProtocolista) {
		this.idProtocolista = idProtocolista;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getNumRastreio() {
		return numRastreio;
	}

	public void setNumRastreio(String numRastreio) {
		this.numRastreio = numRastreio;
	}

	@Override
	public String toString() {
		return "Correspondencia [idCorrespondencia=" + idCorrespondencia + ", idDocumento=" + idDocumento
				+ ", numDocumento=" + numDocumento + ", dataDocumento=" + dataDocumento + ", remetente=" + remetente
				+ ", destinatario=" + destinatario + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep
				+ ", envio=" + envio + ", idProtocolista=" + idProtocolista + ", numRastreio=" + numRastreio
				+ ", getIdCorrespondencia()=" + getIdCorrespondencia() + ", getIdDocumento()=" + getIdDocumento()
				+ ", getNumDocumento()=" + getNumDocumento() + ", getDataDocumento()=" + getDataDocumento()
				+ ", getRemetente()=" + getRemetente() + ", getDestinatario()=" + getDestinatario() + ", getCidade()="
				+ getCidade() + ", getCep()=" + getCep() + ", getEnvio()=" + getEnvio() + ", getIdProtocolista()="
				+ getIdProtocolista() + ", getEstado()=" + getEstado() + ", getNumRastreio()=" + getNumRastreio()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
