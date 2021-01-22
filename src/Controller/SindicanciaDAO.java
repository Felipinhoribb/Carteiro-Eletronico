package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.Conexao;
import Model.Sindicancia;

public class SindicanciaDAO {

	public SindicanciaDAO() {
		// TODO Auto-generated constructor stub
	}

	public void salvarSindicancia(Sindicancia sind) {

		// Abertura de conexão com o banco de dados
		Connection conn = Conexao.getConnection();
		PreparedStatement pstm = null;

		// Inserção de dados na tabela Dependencia
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

}
