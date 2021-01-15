package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Connection.Conexao;
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

}
