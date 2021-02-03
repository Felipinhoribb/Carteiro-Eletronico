package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.Conexao;
import Model.Correspondencia;

public class CorrespondenciaDAO {

	public CorrespondenciaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	//Método para salvar correspondências
	public void salvarCorrespondencia(Correspondencia corr) {

		// Abertura de conexão com o banco de dados
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		// Inserção de dados na tabela correspondências
		try {

			String sql = "INSERT INTO Correspondencia (fk_documento, num_documento, data_correspondencia, remetente, destinatario, cidade, "
					+ "estado, cep, tipo_envio, fk_militar, num_rastreio) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, corr.getIdDocumento());
			pstm.setInt(2, corr.getNumDocumento());
			pstm.setDate(3, new java.sql.Date(corr.getDataDocumento().getTime()));
			pstm.setString(4, corr.getRemetente());
			pstm.setString(5, corr.getDestinatario());
			pstm.setString(6, corr.getCidade());
			pstm.setInt(7, corr.getEstado());
			pstm.setString(8, corr.getCep());
			pstm.setString(9, corr.getEnvio());
			pstm.setInt(10, corr.getIdProtocolista());
			pstm.setString(11, corr.getNumRastreio());
			pstm.execute();

			JOptionPane.showMessageDialog(null, "Correspondência salva com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar correspondência!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}

	}

	// Método para alterar correspondências
	public void alterarCorrespondencia(Correspondencia corr) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "UPDATE Correspondencia SET fk_documento = ?, num_documento = ?, data_correspondencia = ?, "
					+ "remetente = ?, destinatario = ?, cidade = ?, estado = ?, cep = ?, tipo_envio = ?, fk_militar = ?, num_rastreio = ?"
					+ "WHERE id_Correspondencia = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, corr.getIdDocumento());
			pstm.setInt(2, corr.getNumDocumento());
			pstm.setDate(3, new java.sql.Date(corr.getDataDocumento().getTime()));
			pstm.setString(4, corr.getRemetente());
			pstm.setString(5, corr.getDestinatario());
			pstm.setString(6, corr.getCidade());
			pstm.setInt(7, corr.getEstado());
			pstm.setString(8, corr.getCep());
			pstm.setString(9, corr.getEnvio());
			pstm.setInt(10, corr.getIdProtocolista());
			pstm.setString(11, corr.getNumRastreio());
			pstm.setInt(12, corr.getIdCorrespondencia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Correspondência alterada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Alterar correspondência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	// Método para excluir correspondências
	public void excluirCorrespondencia(Correspondencia corr) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "DELETE FROM Correspondencia WHERE id_correspondencia = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, corr.getIdCorrespondencia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Correspondência removida com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover correspondência!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	// Método para Listar todos as correspondências
	public List<Correspondencia> listar() {

		List<Correspondencia> listaCorrespondencia = new ArrayList<Correspondencia>();

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM Correspondencia";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				Correspondencia corr = new Correspondencia();
				corr.setIdCorrespondencia(rs.getInt(1));
				corr.setIdDocumento(rs.getInt(2));
				corr.setNumDocumento(rs.getInt(3));
				corr.setDataDocumento(rs.getDate(4));
				corr.setRemetente(rs.getString(5));
				corr.setDestinatario(rs.getString(6));
				corr.setCidade(rs.getString(7));
				corr.setEstado(rs.getInt(8));
				corr.setCep(rs.getString(9));
				corr.setEnvio(rs.getString(10));
				corr.setIdProtocolista(rs.getInt(11));
				corr.setNumRastreio(rs.getString(12));

				listaCorrespondencia.add(corr);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Sindicância!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);
		}

		return listaCorrespondencia;
	}

}
