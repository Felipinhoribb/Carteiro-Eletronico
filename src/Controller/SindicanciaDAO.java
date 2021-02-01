package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.Conexao;
import Model.Graduacao;
import Model.Militar;
import Model.Sindicancia;

public class SindicanciaDAO {

	public SindicanciaDAO() {
		// TODO Auto-generated constructor stub
	}

	public void salvarSindicancia(Sindicancia sind) {

		// Abertura de conexão com o banco de dados
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		// Inserção de dados na tabela Sindicância
		try {

			String sql = "INSERT INTO Sindicancia (fk_documento, num_diex, fk_militar, sindicado, data_sindicancia, caixa) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, sind.getIdDocumento());
			pstm.setInt(2, sind.getNumDiex());
			pstm.setInt(3, sind.getSindicante());
			pstm.setString(4, sind.getSindicado());
			pstm.setDate(5, new java.sql.Date(sind.getData_sindicancia().getTime()));
			pstm.setInt(6, sind.getCaixa());
			pstm.execute();

			JOptionPane.showMessageDialog(null, "Sindicância salva com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar Sindicância!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}

	}

	// Método para alterar sindicâncias
	public void alterarSindicancia(Sindicancia sind) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "UPDATE Sindicancia SET fk_documento = ?, num_diex = ?, fk_militar = ?, sindicado = ?,"
					+ "data_sindicancia = ?, caixa = ? WHERE id_sindicancia = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, sind.getIdDocumento());
			pstm.setInt(2, sind.getNumDiex());
			pstm.setInt(3, sind.getSindicante());
			pstm.setString(4, sind.getSindicado());
			pstm.setDate(5, new java.sql.Date(sind.getData_sindicancia().getTime()));
			pstm.setInt(6, sind.getCaixa());
			pstm.setInt(7, sind.getIdSindicancia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Sindicância alterada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Sindicância!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	// Método para excluir Sindicâncias
	public void excluirSindicancia(Sindicancia sind) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "DELETE FROM Sindicancia WHERE id_sindicancia = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, sind.getIdSindicancia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Sindicância removida com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover sindicância!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	// Método para Listar todos as sindicâncias
	public List<Sindicancia> listar() {

		List<Sindicancia> listaSindicancia = new ArrayList<Sindicancia>();

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM Sindicancia";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				Sindicancia sind = new Sindicancia();
				sind.setIdSindicancia(rs.getInt(1));
				sind.setIdDocumento(rs.getInt(2));
				sind.setNumDiex(rs.getInt(3));
				sind.setSindicante(rs.getInt(4));
				sind.setSindicado(rs.getString(5));
				sind.setData_sindicancia(rs.getDate(6));
				sind.setCaixa(rs.getInt(7));
				

				listaSindicancia.add(sind);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Sindicância!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);
		}

		return listaSindicancia;
	}
}
