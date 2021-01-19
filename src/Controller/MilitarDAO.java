package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Connection.Conexao;
import Model.Dependencia;
import Model.Graduacao;
import Model.Militar;

//Class DAO - Data Acess Object

public class MilitarDAO {

	public MilitarDAO() {
		// TODO Auto-generated constructor stub
	}

	//Método para salvar Militares
	public void salvarMilitar(Militar mil) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "INSERT INTO Militar (nome_guerra, identidade, fk_graduacao, fk_dependencia) values (?, ?, ?, ?);";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, mil.getNomeGuerra());
			pstm.setInt(2, mil.getIdentidade());
			pstm.setInt(3, mil.getGraduacao());
			pstm.setInt(4, mil.getDependencia());
			pstm.execute();

			JOptionPane.showMessageDialog(null, "Militar salvo com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar militar!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		}

	}

	//Método para alterar Militares
	public void alterarMilitar(Militar mil) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "UPDATE Militar SET nome_guerra = ?, identidade = ?, fk_graduacao = ?, fk_dependencia = ? "
					+ "WHERE id_militar = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, mil.getNomeGuerra());
			pstm.setInt(2, mil.getIdentidade());
			pstm.setInt(3, mil.getGraduacao());
			pstm.setInt(4, mil.getDependencia());
			pstm.setInt(5, mil.getIdMilitar());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Militar alterado com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Militar!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	//Método para excluir Militares
	public void excluirMilitar(Militar mil) {

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {

			String sql = "DELETE FROM Militar WHERE id_militar = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, mil.getIdMilitar());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Militar removido com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao remover militar!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	//Método para Listar o campo Graduação
	public List<Graduacao> listarGraduacao() {

		List<Graduacao> listaGraduacao = new ArrayList<Graduacao>();

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Graduacao;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				// Os atributos do Model Graduacao recebe os resultados retornados do Banco de
				// Dados
				// (Resultset)
				Graduacao grad = new Graduacao();
				grad.setIdGraduacao(rs.getInt(1));
				grad.setNomeGraduacao(rs.getString(2));
				listaGraduacao.add(grad);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Dependência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);
		}

		return listaGraduacao;
	}

	//Método para Listar todos os Militares
	public List<Militar> listar() {

		List<Militar> listaGraduacao = new ArrayList<Militar>();

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {

			String sql = "SELECT * FROM Militar";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				Militar mil = new Militar();
				mil.setIdMilitar(rs.getInt(1));
				mil.setNomeGuerra(rs.getString(2));
				mil.setIdentidade(rs.getInt(3));
				mil.setGraduacao(rs.getInt(4));
				mil.setDependencia(rs.getInt(5));

				listaGraduacao.add(mil);
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Militar!" + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);
		}

		return listaGraduacao;
	}

}
