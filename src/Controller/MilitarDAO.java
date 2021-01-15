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
import Model.Militar;

//Class DAO - Data Acess Object

public class MilitarDAO {

	public MilitarDAO() {
		// TODO Auto-generated constructor stub
	}
	
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
			
			JOptionPane.showMessageDialog(null, "Militar salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar militar!", "Erro", JOptionPane.ERROR_MESSAGE);
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
