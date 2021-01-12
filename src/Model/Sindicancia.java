package Model;

import java.util.Date;

public class Sindicancia {

	private int idSindicancia;
	private int idDocumento;
	private int numDiex;
	private int idMilitar;
	private String sindicado;
	private Date data_sindicancia;
	private int caixa;
	
	public Sindicancia() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSindicancia() {
		return idSindicancia;
	}

	public void setIdSindicancia(int idSindicancia) {
		this.idSindicancia = idSindicancia;
	}

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public int getNumDiex() {
		return numDiex;
	}

	public void setNumDiex(int numDiex) {
		this.numDiex = numDiex;
	}

	public int getIdMilitar() {
		return idMilitar;
	}

	public void setIdMilitar(int idMilitar) {
		this.idMilitar = idMilitar;
	}

	public String getSindicado() {
		return sindicado;
	}

	public void setSindicado(String sindicado) {
		this.sindicado = sindicado;
	}

	public Date getData_sindicancia() {
		return data_sindicancia;
	}

	public void setData_sindicancia(Date data_sindicancia) {
		this.data_sindicancia = data_sindicancia;
	}

	public int getCaixa() {
		return caixa;
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}

	@Override
	public String toString() {
		return "Sindicancia [idSindicancia=" + idSindicancia + ", idDocumento=" + idDocumento + ", numDiex=" + numDiex
				+ ", idMilitar=" + idMilitar + ", sindicado=" + sindicado + ", data_sindicancia=" + data_sindicancia
				+ ", caixa=" + caixa + "]";
	}

}
