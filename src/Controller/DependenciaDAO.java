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

public class DependenciaDAO {

	public DependenciaDAO() {
		// TODO Auto-generated constructor stub
	}

	// Método para salvar Dependências
	public void salvarDependencia(Dependencia dep) {

		// Abertura de conexão com o banco de dados
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		// Inserção de dados na tabela Dependencia
		try {

			String sql = "INSERT INTO Dependencia (nome_dependencia, sigla_dependencia, om_dependencia, contato_dependencia) values (?, ?, ?, ?);";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, dep.getNomeDependencia());
			pstm.setString(2, dep.getSiglaDependencia());
			pstm.setString(3, dep.getOmDependencia());
			pstm.setString(4, dep.getContatoDependencia());
			pstm.execute();

			JOptionPane.showMessageDialog(null, "Dependência salva com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar Dependência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}

	}

	// Método para alterar Dependências
	public void alterarDependencia(Dependencia dep) {

		// Abertura de conexão com o banco de dados
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		// Alteração de dados na tabela dependência
		try {
			String sql = "UPDATE Dependencia SET nome_dependencia = '?', om_dependencia = '?', contato_dependencia = '?'"
					+ "WHERE id_dependencia = ?;";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, dep.getNomeDependencia());
			pstm.setString(2, dep.getOmDependencia());
			pstm.setString(3, dep.getContatoDependencia());
			pstm.setInt(4, dep.getIdDependencia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dependência Alterada com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Alterar Dependência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}
	
	//Método para excluir Dependências
	public void excluirDependencia(Dependencia dep) {
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		try {
			String sql = "DELETE FROM Dependencia WHERE id_dependencia = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, dep.getIdDependencia());
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Dependência Removida com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Remover Dependência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm);
		}
	}

	public List<Dependencia> listar() {

		List<Dependencia> listaDependencia = new ArrayList<Dependencia>();

		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Dependencia;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				// Os atributos do Model Dependencia recebe os resultados retornados do Banco de Dados
				// (Resultset)
				Dependencia dep = new Dependencia();
				dep.setIdDependencia(rs.getInt(1));
				dep.setNomeDependencia(rs.getString(2));
				dep.setOmDependencia(rs.getString(3));
				dep.setContatoDependencia(rs.getString(4));

				listaDependencia.add(dep);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Dependência!", "Erro", JOptionPane.ERROR_MESSAGE);
		} finally {
			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);
		}

		return listaDependencia;
	}

}
