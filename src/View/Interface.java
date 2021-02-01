package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import java.awt.List;
import java.awt.Panel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

import Connection.Conexao;
import Controller.DependenciaDAO;
import Controller.MilitarDAO;
import Controller.SindicanciaDAO;
import Model.Dependencia;
import Model.Graduacao;
import Model.Militar;
import Model.Sindicancia;

import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Interface {

	// Todas as declarações dos componentes do sistema
	private JFrame frmCartEletronico;

	private JTextField txtNumDiex, txtDependencia, txtOM, txtNomeGuerra, txtIdentidade, txtCaixa, txtContato,
			txtTipoEnvio, txtCep, txtPesquisa, txtPesqDpdncia, txtPesqPtclo, txtBuscarMessage;

	private JButton btnCancelMil, btnSaveMil, btnAlterMil, btnRmvMil, btnAlterDpdncia, btnRmvDpdncia, btnSaveDpdncia,
			btnAddPrtclo, btnCancelDpdncia, btnAlterPrtclo, btnRmvPrtclo, btnSavePrtclo, btnCancelPtrclo,
			btnCancelMessage, btnSaveMessage, btnCancelPesqMil, btnCancPesqDpdncia, btnCancelPesqPtclo,
			btnBuscarMessage, btnCancelPesqMessage, btnSrchMil, btnSrchDpdncia, btnSrchPtclo, btnAlterMessage,
			btnRmvMessage, btnSrchMessage, btnAddMil, btnAddDpdncia;

	private JLabel lblDependencia, lblTitleMil, lblNumDiex, lblEstado, lblTipoEnvio, lblCep, lblProtocolista,
			lblPesqMil, lblPesqDpdncia, lblPesqPtclo, lblBuscarMessage, lblData;

	JDateChooser dcEncaminhamento, dcSindicancia;

	private JComboBox<Object> cbxDependencia, cbxGraduacao, cbxEstado, cbxProtocolista;
	private JComboBox<Militar> cbxSindicante;

	private JRadioButton rdbDiex, rdbNud, rdbDiexMessage, rdbOficio, rdbNudMessage;

	private JTable tblMil, tblDependencia, tblSindicancia;;

	private JScrollPane scrlpDependecia;

	private JTextField txtNumMessage, txtRemetente, txtDestinatario, txtCidade;
	private JTable table_1;
	private JTextField textField;
	private JTextField txtSigla;
	private JLabel lblSigla;

	private boolean insert, update = false;
	private JTextField txtSindicado;
	
	
	private ArrayList<Dependencia> listaDependencia = new ArrayList<Dependencia>();
	private ArrayList<Graduacao> listaGraduacao = new ArrayList<Graduacao>();
	private ArrayList<Militar> listaMilitar = new ArrayList<Militar>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// here you can put the selected theme class name in JTattoo
					UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Interface window = new Interface();
					window.frmCartEletronico.setVisible(true);
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();

		// Listagem dos campos Dependencia e Graduação dos Combobox
		DependenciaDAO daoDep = new DependenciaDAO();
		MilitarDAO daoMil = new MilitarDAO();

		listaDependencia = (ArrayList<Dependencia>) daoDep.listar();
		listaGraduacao = (ArrayList<Graduacao>) daoMil.listarGraduacao();
		listaMilitar = (ArrayList<Militar>) daoMil.listar();

		cbxDependencia.removeAll();

		for (Dependencia d : listaDependencia) {
			cbxDependencia.addItem(d);
		}

		cbxGraduacao.removeAll();

		for (Graduacao g : listaGraduacao) {
			cbxGraduacao.addItem(g);
		}
		
		cbxSindicante.removeAll();

		for (Militar m : listaMilitar) {
			cbxSindicante.addItem(m);
		}

		carregarTabelaDependencia();
		carregarTabelaMilitar();
		carregarTabelaSindicancia();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCartEletronico = new JFrame();
		frmCartEletronico
				.setIconImage(Toolkit.getDefaultToolkit().getImage(Interface.class.getResource("/img/army.png")));
		frmCartEletronico.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		frmCartEletronico.setTitle("Carteiro Eletrônico");
		frmCartEletronico.setBounds(100, 100, 877, 597);
		frmCartEletronico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartEletronico.setLocationRelativeTo(null);
		frmCartEletronico.getContentPane().setLayout(null);

		JTabbedPane mainTabs = new JTabbedPane(JTabbedPane.TOP);
		mainTabs.setBounds(0, 0, 867, 568);
		frmCartEletronico.getContentPane().add(mainTabs);

		Panel pnlMilitares = new Panel();
		mainTabs.addTab(" Militares", new ImageIcon(Interface.class.getResource("/img/military-rank.png")),
				pnlMilitares, null);
		pnlMilitares.setLayout(null);

		JLabel lblNomeGuerra = new JLabel("Nome de Guerra:");
		lblNomeGuerra.setBounds(199, 76, 109, 15);
		lblNomeGuerra.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlMilitares.add(lblNomeGuerra);

		txtNomeGuerra = new JTextField();
		txtNomeGuerra.setBounds(316, 72, 234, 23);
		txtNomeGuerra.setEnabled(false);
		txtNomeGuerra.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtNomeGuerra.setColumns(10);
		pnlMilitares.add(txtNomeGuerra);

		JLabel lblIdentidade = new JLabel("Identidade:");
		lblIdentidade.setBounds(236, 107, 72, 15);
		lblIdentidade.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlMilitares.add(lblIdentidade);

		txtIdentidade = new JTextField();
		txtIdentidade.setBounds(316, 103, 234, 23);
		txtIdentidade.setEnabled(false);
		txtIdentidade.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtIdentidade.setColumns(10);
		pnlMilitares.add(txtIdentidade);

		JLabel lblGraduacao = new JLabel("Graduação:");
		lblGraduacao.setBounds(234, 138, 74, 15);
		lblGraduacao.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlMilitares.add(lblGraduacao);

		cbxGraduacao = new JComboBox();
		cbxGraduacao.setModel(new DefaultComboBoxModel(new String[] { "Selecione a graduação" }));
		cbxGraduacao.setBounds(316, 133, 234, 23);
		cbxGraduacao.setEnabled(false);
		pnlMilitares.add(cbxGraduacao);

		lblDependencia = new JLabel("Dependência:");
		lblDependencia.setBounds(220, 169, 88, 15);
		lblDependencia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlMilitares.add(lblDependencia);

		lblTitleMil = new JLabel("Cadastro de Militares");
		lblTitleMil.setBounds(300, 12, 250, 37);
		lblTitleMil.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		pnlMilitares.add(lblTitleMil);

		cbxDependencia = new JComboBox();
		cbxDependencia.setModel(new DefaultComboBoxModel(new String[] { "Selecione a dependência" }));
		cbxDependencia.setBounds(316, 166, 234, 23);
		cbxDependencia.setEnabled(false);
		pnlMilitares.add(cbxDependencia);

		btnAddMil = new JButton("   Incluir");
		btnAddMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddMil.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddMil.setBounds(12, 22, 109, 27);
		btnAddMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomeGuerra.setEnabled(true);
				txtIdentidade.setEnabled(true);
				cbxGraduacao.setEnabled(true);
				cbxDependencia.setEnabled(true);
				btnSaveMil.setEnabled(true);
				btnCancelMil.setEnabled(true);
				btnAlterMil.setEnabled(false);
				btnRmvMil.setEnabled(false);
				btnSrchMil.setEnabled(false);

				insert = true;
			}
		});
		pnlMilitares.add(btnAddMil);

		btnAlterMil = new JButton("   Alterar");
		btnAlterMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterMil.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterMil.setBounds(12, 62, 109, 27);
		btnAlterMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// Verifica se o usuário selecionou algum registro da tabela
				if (txtNomeGuerra.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o militar que deseja alterar na tabela!",
							"Informação", JOptionPane.INFORMATION_MESSAGE);
				} else {
					txtNomeGuerra.setEnabled(true);
					txtIdentidade.setEnabled(true);
					cbxGraduacao.setEnabled(true);
					cbxDependencia.setEnabled(true);
					btnSaveMil.setEnabled(true);
					btnCancelMil.setEnabled(true);
					btnAddMil.setEnabled(false);
					btnRmvMil.setEnabled(false);
					btnSrchMil.setEnabled(false);

					update = true;
				}
			}
		});
		pnlMilitares.add(btnAlterMil);

		btnRmvMil = new JButton("  Remover");
		btnRmvMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvMil.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvMil.setBounds(12, 100, 109, 27);
		btnRmvMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomeGuerra.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o militar que deseja remover na tabela!",
							"Informação", JOptionPane.INFORMATION_MESSAGE);
				} else {

					MilitarDAO milDAO = new MilitarDAO();
					Militar objMil = new Militar();

					int linha = tblMil.getSelectedRow();
					objMil = milDAO.listar().get(linha);

					milDAO.excluirMilitar(objMil);
					carregarTabelaMilitar();
				}
			}
		});
		pnlMilitares.add(btnRmvMil);

		btnSaveMil = new JButton("  Salvar");
		btnSaveMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Militar objMil = new Militar();
				MilitarDAO milDAO = new MilitarDAO();

				if (insert) {

					objMil.setNomeGuerra(txtNomeGuerra.getText());
					objMil.setIdentidade(Integer.parseInt(txtIdentidade.getText()));
					objMil.setGraduacao(cbxGraduacao.getSelectedIndex());
					
					//Recuperação da Dependência escolhido pelo usuário
					Dependencia objDependencia = new Dependencia();
					objDependencia = (Dependencia) cbxDependencia.getSelectedItem();
					int id = objDependencia.getIdDependencia();
					
					objMil.setDependencia(id);

					milDAO.salvarMilitar(objMil);
					carregarTabelaMilitar();

				} else {

					int linha = tblMil.getSelectedRow();
					objMil = milDAO.listar().get(linha);

					objMil.setNomeGuerra(txtNomeGuerra.getText());
					objMil.setIdentidade(Integer.parseInt(txtIdentidade.getText()));
					objMil.setGraduacao(cbxGraduacao.getSelectedIndex());
					objMil.setDependencia(cbxDependencia.getSelectedIndex());

					milDAO.alterarMilitar(objMil);
					carregarTabelaMilitar();
				}
			}
		});
		btnSaveMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveMil.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSaveMil.setBounds(664, 87, 104, 27);
		btnSaveMil.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSaveMil.setEnabled(false);
		pnlMilitares.add(btnSaveMil);

		btnCancelMil = new JButton("Cancelar");
		btnCancelMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelMil.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCancelMil.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelMil.setBounds(664, 147, 106, 27);
		btnCancelMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				formatarCamposMilitares();
			}
		});
		btnCancelMil.setEnabled(false);
		pnlMilitares.add(btnCancelMil);

		JScrollPane scrlpMil = new JScrollPane();
		scrlpMil.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrlpMil.setBounds(12, 272, 841, 253);
		pnlMilitares.add(scrlpMil);

		tblMil = new JTable();
		tblMil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Militar objMil = new Militar();
				MilitarDAO milDAO = new MilitarDAO();

				int linha = tblMil.getSelectedRow();

				objMil = milDAO.listar().get(linha);

				txtNomeGuerra.setText(objMil.getNomeGuerra());
				txtIdentidade.setText(String.valueOf(objMil.getIdentidade()));
				cbxGraduacao.setSelectedIndex(objMil.getGraduacao());
				cbxDependencia.setSelectedIndex(objMil.getDependencia());
			}
		});
		tblMil.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome de Guerra", "Identidade", "Gradua\u00E7\u00E3o", "Depend\u00EAncia" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblMil.getColumnModel().getColumn(0).setResizable(false);
		tblMil.getColumnModel().getColumn(0).setPreferredWidth(52);
		tblMil.getColumnModel().getColumn(1).setResizable(false);
		tblMil.getColumnModel().getColumn(1).setPreferredWidth(171);
		tblMil.getColumnModel().getColumn(2).setResizable(false);
		tblMil.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblMil.getColumnModel().getColumn(3).setResizable(false);
		tblMil.getColumnModel().getColumn(3).setPreferredWidth(99);
		tblMil.getColumnModel().getColumn(4).setResizable(false);
		tblMil.getColumnModel().getColumn(4).setPreferredWidth(198);
		scrlpMil.setViewportView(tblMil);

		lblPesqMil = new JLabel("Pesquisa:");
		lblPesqMil.setVisible(false);
		lblPesqMil.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblPesqMil.setBounds(12, 241, 61, 15);
		pnlMilitares.add(lblPesqMil);

		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarMilitar(txtPesquisa.getText());
			}
		});
		txtPesquisa.setVisible(false);
		txtPesquisa.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtPesquisa.setColumns(10);
		txtPesquisa.setBounds(80, 237, 525, 23);
		pnlMilitares.add(txtPesquisa);

		btnCancelPesqMil = new JButton("Cancelar");
		btnCancelPesqMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqMil.setVisible(false);
				txtPesquisa.setVisible(false);
				btnCancelPesqMil.setVisible(false);
				btnAddMil.setEnabled(true);
				btnAlterMil.setEnabled(true);
				btnRmvMil.setEnabled(true);

				carregarTabelaMilitar();
			}
		});
		btnCancelPesqMil.setVisible(false);
		btnCancelPesqMil.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelPesqMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelPesqMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelPesqMil.setAlignmentX(0.5f);
		btnCancelPesqMil.setBounds(626, 234, 104, 27);
		pnlMilitares.add(btnCancelPesqMil);

		btnSrchMil = new JButton(" Pesquisa");
		btnSrchMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqMil.setVisible(true);
				txtPesquisa.setVisible(true);
				btnCancelPesqMil.setVisible(true);
				btnAddMil.setEnabled(false);
				btnAlterMil.setEnabled(false);
				btnRmvMil.setEnabled(false);
			}
		});
		btnSrchMil.setIcon(new ImageIcon(Interface.class.getResource("/img/lupa.png")));
		btnSrchMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSrchMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnSrchMil.setBounds(12, 138, 109, 27);
		pnlMilitares.add(btnSrchMil);

		Panel pnlDependencias = new Panel();
		mainTabs.addTab(" Dependências", new ImageIcon(Interface.class.getResource("/img/army.png")), pnlDependencias,
				null);
		pnlDependencias.setLayout(null);

		JLabel lblNomeDaDependncia = new JLabel("Nome da Dependência:");
		lblNomeDaDependncia.setBounds(161, 80, 149, 15);
		lblNomeDaDependncia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlDependencias.add(lblNomeDaDependncia);

		txtDependencia = new JTextField();
		txtDependencia.setBounds(318, 76, 234, 23);
		txtDependencia.setEnabled(false);
		txtDependencia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtDependencia.setColumns(10);
		pnlDependencias.add(txtDependencia);

		JLabel lblOm = new JLabel("OM:");
		lblOm.setBounds(285, 140, 25, 15);
		lblOm.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlDependencias.add(lblOm);

		txtOM = new JTextField();
		txtOM.setBounds(318, 136, 234, 23);
		txtOM.setEnabled(false);
		txtOM.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtOM.setColumns(10);
		pnlDependencias.add(txtOM);

		JLabel lblContato = new JLabel("Contato:");
		lblContato.setBounds(257, 170, 53, 15);
		lblContato.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		pnlDependencias.add(lblContato);

		JLabel lblTitleDepndcia = new JLabel("Cadastro de Dependências");
		lblTitleDepndcia.setBounds(266, 12, 319, 37);
		lblTitleDepndcia.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		pnlDependencias.add(lblTitleDepndcia);

		btnAddDpdncia = new JButton("   Incluir");
		btnAddDpdncia.setBounds(12, 22, 109, 27);
		btnAddDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDependencia.setEnabled(true);
				txtSigla.setEnabled(true);
				txtOM.setEnabled(true);
				txtContato.setEnabled(true);
				btnSaveDpdncia.setEnabled(true);
				btnCancelDpdncia.setEnabled(true);
				btnAlterDpdncia.setEnabled(false);
				btnRmvDpdncia.setEnabled(false);
				btnSrchDpdncia.setEnabled(false);

				insert = true;
			}
		});
		pnlDependencias.add(btnAddDpdncia);

		btnAlterDpdncia = new JButton("  Alterar");
		btnAlterDpdncia.setBounds(12, 60, 109, 27);
		btnAlterDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verifica se o usuário selecionou algum registro da tabela
				if (txtDependencia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a dependência que deseja alterar na tabela!",
							"Informação", JOptionPane.INFORMATION_MESSAGE);
				} else {
					txtDependencia.setEnabled(true);
					txtSigla.setEnabled(true);
					txtOM.setEnabled(true);
					txtContato.setEnabled(true);
					btnSaveDpdncia.setEnabled(true);
					btnCancelDpdncia.setEnabled(true);
					btnAddDpdncia.setEnabled(false);
					btnRmvDpdncia.setEnabled(false);
					btnSrchDpdncia.setEnabled(false);

					update = true;
				}
			}
		});
		pnlDependencias.add(btnAlterDpdncia);

		btnRmvDpdncia = new JButton(" Remover");
		btnRmvDpdncia.setBounds(12, 98, 109, 27);
		btnRmvDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtDependencia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a dependência que deseja alterar na tabela!",
							"Informação", JOptionPane.INFORMATION_MESSAGE);
				} else {

					Dependencia objDep = new Dependencia();
					DependenciaDAO depDAO = new DependenciaDAO();

					int linha = tblDependencia.getSelectedRow();
					objDep = depDAO.listar().get(linha);

					depDAO.excluirDependencia(objDep);
				}
			}
		});
		pnlDependencias.add(btnRmvDpdncia);

		txtContato = new JTextField();
		txtContato.setBounds(318, 167, 234, 23);
		txtContato.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtContato.setEnabled(false);
		txtContato.setColumns(10);
		pnlDependencias.add(txtContato);

		btnSaveDpdncia = new JButton("  Salvar");
		btnSaveDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Dependencia objDep = new Dependencia();
				DependenciaDAO depDAO = new DependenciaDAO();

				if (insert) {

					objDep.setNomeDependencia(txtDependencia.getText());
					objDep.setSiglaDependencia(txtSigla.getText());
					objDep.setOmDependencia(txtOM.getText());
					objDep.setContatoDependencia(txtContato.getText());

					depDAO.salvarDependencia(objDep);

				} else if (update) {

					int linha = tblDependencia.getSelectedRow();
					objDep = depDAO.listar().get(linha);

					objDep.setNomeDependencia(txtDependencia.getText());
					objDep.setSiglaDependencia(txtSigla.getText());
					objDep.setOmDependencia(txtOM.getText());
					objDep.setContatoDependencia(txtContato.getText());

					depDAO.alterarDependencia(objDep);
				}

				carregarTabelaDependencia();
			}
		});
		btnSaveDpdncia.setBounds(641, 77, 109, 27);
		btnSaveDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSaveDpdncia.setEnabled(false);
		pnlDependencias.add(btnSaveDpdncia);

		btnCancelDpdncia = new JButton(" Cancelar");
		btnCancelDpdncia.setBounds(641, 136, 109, 27);
		btnCancelDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				formatarCamposDepndcia();
			}
		});
		btnCancelDpdncia.setEnabled(false);
		pnlDependencias.add(btnCancelDpdncia);

		scrlpDependecia = new JScrollPane();
		scrlpDependecia.setBounds(12, 248, 841, 277);
		pnlDependencias.add(scrlpDependecia);

		tblDependencia = new JTable();
		tblDependencia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Dependencia objDep = new Dependencia();
				DependenciaDAO depDAO = new DependenciaDAO();

				int linha = tblDependencia.getSelectedRow();
				objDep = depDAO.listar().get(linha);

				txtDependencia.setText(objDep.getNomeDependencia());
				txtSigla.setText(objDep.getSiglaDependencia());
				txtOM.setText(objDep.getOmDependencia());
				txtContato.setText(objDep.getContatoDependencia());
			}
		});
		tblDependencia.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Depend\u00EAncia", "Sigla", "OM", "Contato" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrlpDependecia.setViewportView(tblDependencia);

		lblPesqDpdncia = new JLabel("Pesquisar:");
		lblPesqDpdncia.setVisible(false);
		lblPesqDpdncia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblPesqDpdncia.setBounds(12, 217, 66, 15);
		pnlDependencias.add(lblPesqDpdncia);

		txtPesqDpdncia = new JTextField();
		txtPesqDpdncia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				pesquisarDependencia(txtPesqDpdncia.getText());
			}
		});
		txtPesqDpdncia.setVisible(false);
		txtPesqDpdncia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtPesqDpdncia.setColumns(10);
		txtPesqDpdncia.setBounds(83, 213, 530, 23);
		pnlDependencias.add(txtPesqDpdncia);

		btnCancPesqDpdncia = new JButton("Cancelar");
		btnCancPesqDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqDpdncia.setVisible(false);
				txtPesqDpdncia.setVisible(false);
				btnCancPesqDpdncia.setVisible(false);
				btnAddDpdncia.setEnabled(true);
				btnAlterDpdncia.setEnabled(true);
				btnRmvDpdncia.setEnabled(true);
			}
		});
		btnCancPesqDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancPesqDpdncia.setVisible(false);
		btnCancPesqDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancPesqDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancPesqDpdncia.setBounds(624, 210, 109, 27);
		pnlDependencias.add(btnCancPesqDpdncia);

		btnSrchDpdncia = new JButton(" Pesquisa");
		btnSrchDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqDpdncia.setVisible(true);
				txtPesqDpdncia.setVisible(true);
				btnCancPesqDpdncia.setVisible(true);
				btnAddDpdncia.setEnabled(false);
				btnAlterDpdncia.setEnabled(false);
				btnRmvDpdncia.setEnabled(false);
			}
		});
		btnSrchDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/lupa.png")));
		btnSrchDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSrchDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnSrchDpdncia.setBounds(12, 136, 109, 27);
		pnlDependencias.add(btnSrchDpdncia);

		txtSigla = new JTextField();
		txtSigla.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtSigla.setEnabled(false);
		txtSigla.setColumns(10);
		txtSigla.setBounds(318, 107, 234, 23);
		pnlDependencias.add(txtSigla);

		lblSigla = new JLabel("Sigla da Dependência:");
		lblSigla.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblSigla.setBounds(161, 111, 149, 15);
		pnlDependencias.add(lblSigla);

		Panel pnlProtocolos = new Panel();
		pnlProtocolos.setLayout(null);
		mainTabs.addTab(" Sindicância", new ImageIcon(Interface.class.getResource("/img/antenna.png")), pnlProtocolos,
				null);

		lblNumDiex = new JLabel("Número:");
		lblNumDiex.setVisible(false);
		lblNumDiex.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblNumDiex.setBounds(282, 96, 56, 15);
		pnlProtocolos.add(lblNumDiex);

		txtNumDiex = new JTextField();
		txtNumDiex.setEnabled(false);
		txtNumDiex.setVisible(false);
		txtNumDiex.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtNumDiex.setColumns(10);
		txtNumDiex.setBounds(343, 92, 97, 23);
		pnlProtocolos.add(txtNumDiex);

		JLabel lblSindicante = new JLabel("Sindicante:");
		lblSindicante.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblSindicante.setBounds(263, 125, 72, 18);
		pnlProtocolos.add(lblSindicante);

		cbxSindicante = new JComboBox();
		cbxSindicante.setModel(new DefaultComboBoxModel(new String[] {"Selecione o sindicante"}));
		cbxSindicante.setEnabled(false);
		cbxSindicante.setBounds(343, 122, 283, 23);
		pnlProtocolos.add(cbxSindicante);

		JLabel lblSindicado = new JLabel("Sindicado:");
		lblSindicado.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblSindicado.setBounds(269, 160, 89, 15);
		pnlProtocolos.add(lblSindicado);

		JLabel lblProtocolosDeSindicncia = new JLabel("Protocolos de Sindicância");
		lblProtocolosDeSindicncia.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		lblProtocolosDeSindicncia.setBounds(268, 12, 309, 37);
		pnlProtocolos.add(lblProtocolosDeSindicncia);

		rdbDiex = new JRadioButton("DIEX");
		rdbDiex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbNud.setSelected(false);
				txtNumDiex.setVisible(true);
				lblNumDiex.setVisible(true);
				txtNumDiex.setEnabled(true);
				lblNumDiex.setEnabled(true);
			}
		});
		rdbDiex.setEnabled(false);
		rdbDiex.setBounds(343, 61, 64, 23);
		pnlProtocolos.add(rdbDiex);

		rdbNud = new JRadioButton("NUD");
		rdbNud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbDiex.setSelected(false);
				txtNumDiex.setVisible(false);
				lblNumDiex.setVisible(false);
			}
		});
		rdbNud.setEnabled(false);
		rdbNud.setBounds(421, 61, 64, 23);
		pnlProtocolos.add(rdbNud);

		JLabel lblDataSindicancia = new JLabel("Data da Sindicância:");
		lblDataSindicancia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblDataSindicancia.setBounds(203, 191, 132, 15);
		pnlProtocolos.add(lblDataSindicancia);

		JLabel lblCaixa = new JLabel("Caixa:");
		lblCaixa.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblCaixa.setBounds(480, 191, 41, 15);
		pnlProtocolos.add(lblCaixa);

		txtCaixa = new JTextField();
		txtCaixa.setEnabled(false);
		txtCaixa.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtCaixa.setColumns(10);
		txtCaixa.setBounds(529, 187, 97, 23);
		pnlProtocolos.add(txtCaixa);

		btnAddPrtclo = new JButton("   Incluir");
		btnAddPrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddPrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddPrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddPrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbDiex.setEnabled(true);
				rdbNud.setEnabled(true);
				cbxSindicante.setEnabled(true);
				txtSindicado.setEnabled(true);
				dcSindicancia.setEnabled(true);
				txtCaixa.setEnabled(true);
				btnSavePrtclo.setEnabled(true);
				btnCancelPtrclo.setEnabled(true);
				btnAddPrtclo.setEnabled(true);
				btnRmvPrtclo.setEnabled(false);
				btnAlterPrtclo.setEnabled(false);
				btnSrchPtclo.setEnabled(false);
				
				insert = true;
			}
		});
		btnAddPrtclo.setBounds(12, 22, 110, 27);
		pnlProtocolos.add(btnAddPrtclo);

		btnAlterPrtclo = new JButton("  Alterar");
		btnAlterPrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterPrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterPrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterPrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verifica se o usuário selecionou algum registro da tabela
				if (cbxSindicante.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Selecione a sindicância que deseja alterar na tabela!",
							"Informação", JOptionPane.INFORMATION_MESSAGE);
				} else {
					rdbDiex.setEnabled(true);
					rdbNud.setEnabled(true);
					cbxSindicante.setEnabled(true);
					txtSindicado.setEnabled(true);
					dcSindicancia.setEnabled(true);
					txtCaixa.setEnabled(true);
					btnSavePrtclo.setEnabled(true);
					btnCancelPtrclo.setEnabled(true);
					btnAddPrtclo.setEnabled(false);
					btnRmvPrtclo.setEnabled(false);
					btnSrchPtclo.setEnabled(false);
					
					update = true;
				}
			}
		});
		btnAlterPrtclo.setBounds(12, 60, 110, 27);
		pnlProtocolos.add(btnAlterPrtclo);

		btnRmvPrtclo = new JButton(" Remover");
		btnRmvPrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvPrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvPrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvPrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbxSindicante.getSelectedIndex() == 0) {
					System.out.println("Selecione um registro para a remoção!");
				} else {
					// Remove o registro
					SindicanciaDAO sindDAO = new SindicanciaDAO();
					Sindicancia objSind = new Sindicancia();

					int linha = tblSindicancia.getSelectedRow();
					objSind = sindDAO.listar().get(linha);

					sindDAO.excluirSindicancia(objSind);
					carregarTabelaSindicancia();
				}
			}
		});
		btnRmvPrtclo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRmvPrtclo.setBounds(12, 96, 110, 27);
		pnlProtocolos.add(btnRmvPrtclo);

		btnSavePrtclo = new JButton("  Salvar");
		btnSavePrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sindicancia objSind = new Sindicancia();
				SindicanciaDAO sindDAO = new SindicanciaDAO();
				
				if (rdbDiex.isSelected()) {
					objSind.setIdDocumento(1);
				} else {
					objSind.setIdDocumento(2);
				}
				
				if (insert) {

					objSind.setNumDiex(Integer.parseInt(txtNumDiex.getText()));
					
					//Recuperação do Sindicante escolhido pelo usuário
					Militar objMilitar = new Militar();
					objMilitar = (Militar) cbxSindicante.getSelectedItem();
					int id = objMilitar.getIdMilitar();
					
					objSind.setSindicante(id);
					objSind.setSindicado(txtSindicado.getText());
					objSind.setData_sindicancia(dcSindicancia.getDate());
					objSind.setCaixa(Integer.parseInt(txtCaixa.getText()));
					
					sindDAO.salvarSindicancia(objSind);

				} else {
					
					int linha = tblSindicancia.getSelectedRow();
					objSind = sindDAO.listar().get(linha);

					objSind.setNumDiex(Integer.parseInt(txtNumDiex.getText()));
					
					//Recuperação do Sindicante escolhido pelo usuário
					Militar objMilitar = new Militar();
					objMilitar = (Militar) cbxSindicante.getSelectedItem();
					int id = objMilitar.getIdMilitar();
					
					objSind.setSindicante(id);
					objSind.setSindicado(txtSindicado.getText());
					objSind.setData_sindicancia(dcSindicancia.getDate());
					objSind.setCaixa(Integer.parseInt(txtCaixa.getText()));
					
					sindDAO.alterarSindicancia(objSind);
				}
				
				carregarTabelaSindicancia();
			}
		});
		btnSavePrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSavePrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSavePrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSavePrtclo.setEnabled(false);
		btnSavePrtclo.setBounds(700, 96, 110, 27);
		pnlProtocolos.add(btnSavePrtclo);

		btnCancelPtrclo = new JButton(" Cancelar");
		btnCancelPtrclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelPtrclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelPtrclo.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelPtrclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				formatarCamposPrtclo();
			}
		});
		btnCancelPtrclo.setEnabled(false);
		btnCancelPtrclo.setBounds(700, 155, 110, 27);
		pnlProtocolos.add(btnCancelPtrclo);

		JScrollPane scrlpProtocolo = new JScrollPane();
		scrlpProtocolo.setBounds(12, 276, 841, 249);
		pnlProtocolos.add(scrlpProtocolo);

		tblSindicancia = new JTable();
		tblSindicancia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sindicancia objSind = new Sindicancia();
				SindicanciaDAO sindDAO = new SindicanciaDAO();

				int linha = tblSindicancia.getSelectedRow();

				objSind = sindDAO.listar().get(linha);

				if (objSind.getIdDocumento() == 1) {
					rdbDiex.setSelected(true);
				} else {
					rdbNud.setSelected(true);
				}
				
				txtNumDiex.setText(String.valueOf(objSind.getNumDiex()));
				
				int index = 0;
				
				for (Militar mil : listaMilitar) {
					
					index++;
					
					if (mil.getIdMilitar() == objSind.getSindicante()) {
						break;
					}
				}
				
				cbxSindicante.setSelectedIndex(index);
				txtSindicado.setText(objSind.getSindicado());
				dcSindicancia.setDate(objSind.getData_sindicancia());
				txtCaixa.setText(String.valueOf(objSind.getCaixa()));
			}
		});
		tblSindicancia.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "DIEX", "Sindicante", "Sindicado", "Data", "Caixa" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrlpProtocolo.setViewportView(tblSindicancia);

		lblPesqPtclo = new JLabel("Pesquisa:");
		lblPesqPtclo.setVisible(false);
		lblPesqPtclo.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblPesqPtclo.setBounds(12, 245, 64, 15);
		pnlProtocolos.add(lblPesqPtclo);

		txtPesqPtclo = new JTextField();
		txtPesqPtclo.setVisible(false);
		txtPesqPtclo.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtPesqPtclo.setColumns(10);
		txtPesqPtclo.setBounds(81, 241, 515, 23);
		pnlProtocolos.add(txtPesqPtclo);

		btnCancelPesqPtclo = new JButton(" Cancelar");
		btnCancelPesqPtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqPtclo.setVisible(false);
				txtPesqPtclo.setVisible(false);
				btnCancelPesqPtclo.setVisible(false);
				btnAddPrtclo.setEnabled(true);
				btnAlterPrtclo.setEnabled(true);
				btnRmvPrtclo.setEnabled(true);
			}
		});
		btnCancelPesqPtclo.setVisible(false);
		btnCancelPesqPtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelPesqPtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelPesqPtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelPesqPtclo.setBounds(607, 238, 110, 27);
		pnlProtocolos.add(btnCancelPesqPtclo);

		btnSrchPtclo = new JButton("Pesquisa");
		btnSrchPtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblPesqPtclo.setVisible(true);
				txtPesqPtclo.setVisible(true);
				btnCancelPesqPtclo.setVisible(true);
				btnAddPrtclo.setEnabled(false);
				btnAlterPrtclo.setEnabled(false);
				btnRmvPrtclo.setEnabled(false);
			}
		});
		btnSrchPtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/lupa.png")));
		btnSrchPtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSrchPtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSrchPtclo.setAlignmentX(0.5f);
		btnSrchPtclo.setBounds(12, 130, 110, 27);
		pnlProtocolos.add(btnSrchPtclo);

		dcSindicancia = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
		dcSindicancia.setBounds(343, 187, 119, 23);
		pnlProtocolos.add(dcSindicancia);
		dcSindicancia.setEnabled(false);
		
		txtSindicado = new JTextField();
		txtSindicado.setEnabled(false);
		txtSindicado.setBounds(343, 155, 283, 23);
		pnlProtocolos.add(txtSindicado);
		txtSindicado.setColumns(10);

		Panel pnlCorrespondencia = new Panel();
		pnlCorrespondencia.setLayout(null);
		mainTabs.addTab(" Correspondências", new ImageIcon(Interface.class.getResource("/img/email.png")),
				pnlCorrespondencia, null);

		JLabel lblNumMessage = new JLabel("Número:");
		lblNumMessage.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblNumMessage.setBounds(254, 96, 54, 15);
		pnlCorrespondencia.add(lblNumMessage);

		txtNumMessage = new JTextField();
		txtNumMessage.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtNumMessage.setEnabled(false);
		txtNumMessage.setColumns(10);
		txtNumMessage.setBounds(316, 92, 92, 23);
		pnlCorrespondencia.add(txtNumMessage);

		JLabel lblRemetente = new JLabel("Remetente:");
		lblRemetente.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblRemetente.setBounds(233, 127, 75, 15);
		pnlCorrespondencia.add(lblRemetente);

		txtRemetente = new JTextField();
		txtRemetente.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtRemetente.setEnabled(false);
		txtRemetente.setColumns(10);
		txtRemetente.setBounds(316, 123, 296, 23);
		pnlCorrespondencia.add(txtRemetente);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblCidade.setBounds(259, 189, 49, 15);
		pnlCorrespondencia.add(lblCidade);

		JLabel lblTitleMessage = new JLabel("Protocolo de Correspondências");
		lblTitleMessage.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		lblTitleMessage.setBounds(241, 12, 371, 37);
		pnlCorrespondencia.add(lblTitleMessage);

		JButton btnAddMessage = new JButton("   Incluir");
		btnAddMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbDiexMessage.setEnabled(true);
				rdbNudMessage.setEnabled(true);
				rdbOficio.setEnabled(true);
				dcEncaminhamento.setEnabled(true);
				txtRemetente.setEnabled(true);
				txtDestinatario.setEnabled(true);
				txtCidade.setEnabled(true);
				cbxEstado.setEnabled(true);
				txtCep.setEnabled(true);
				txtTipoEnvio.setEnabled(true);
				cbxProtocolista.setEnabled(true);
				btnSaveMessage.setEnabled(true);
				btnCancelMessage.setEnabled(true);
				btnAlterMessage.setEnabled(false);
				btnRmvMessage.setEnabled(false);
				btnSrchMessage.setEnabled(false);
			}
		});
		btnAddMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddMessage.setBounds(12, 22, 109, 27);
		pnlCorrespondencia.add(btnAddMessage);

		btnAlterMessage = new JButton("  Alterar");
		btnAlterMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Verifica se o usuário selecionou algum registro da tabela
				if (!txtNomeGuerra.getText().isEmpty()) {
					System.out.println("Selecione um registro!");
				} else {
					rdbDiexMessage.setEnabled(true);
					rdbNudMessage.setEnabled(true);
					rdbOficio.setEnabled(true);
					dcEncaminhamento.setEnabled(true);
					txtRemetente.setEnabled(true);
					txtDestinatario.setEnabled(true);
					txtCidade.setEnabled(true);
					cbxEstado.setEnabled(true);
					txtCep.setEnabled(true);
					txtTipoEnvio.setEnabled(true);
					cbxProtocolista.setEnabled(true);
					btnSaveMessage.setEnabled(true);
					btnCancelMessage.setEnabled(true);
					btnAlterMessage.setEnabled(false);
					btnRmvMessage.setEnabled(false);
					btnSrchMessage.setEnabled(false);
				}
			}
		});
		btnAlterMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterMessage.setBounds(12, 60, 109, 27);
		pnlCorrespondencia.add(btnAlterMessage);

		btnRmvMessage = new JButton(" Remover");
		btnRmvMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtRemetente.getText().isEmpty()) {
					System.out.println("Selecione um registro para a remoção!");
				} else {
					// Remove o registro
				}
			}
		});
		btnRmvMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvMessage.setBounds(12, 98, 109, 27);
		pnlCorrespondencia.add(btnRmvMessage);

		btnSaveMessage = new JButton("  Salvar");
		btnSaveMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSaveMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSaveMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveMessage.setEnabled(false);
		btnSaveMessage.setAlignmentX(0.5f);
		btnSaveMessage.setBounds(709, 145, 104, 27);
		pnlCorrespondencia.add(btnSaveMessage);

		btnCancelMessage = new JButton("Cancelar");
		btnCancelMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				formatarCamposMessage();
			}
		});
		btnCancelMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelMessage.setEnabled(false);
		btnCancelMessage.setAlignmentX(0.5f);
		btnCancelMessage.setBounds(709, 205, 106, 27);
		pnlCorrespondencia.add(btnCancelMessage);

		JScrollPane scrlpMessage = new JScrollPane();
		scrlpMessage.setBounds(12, 345, 841, 180);
		pnlCorrespondencia.add(scrlpMessage);

		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Documento", "N\u00BA", "Remetente", "Destinat\u00E1rio", "Data", "Envio" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(88);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(45);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(177);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(170);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(74);
		table_1.getColumnModel().getColumn(6).setResizable(false);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(47);
		scrlpMessage.setViewportView(table_1);

		rdbDiexMessage = new JRadioButton("DIEX");
		rdbDiexMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbNudMessage.setSelected(false);
				rdbOficio.setSelected(false);
				txtNumMessage.setEnabled(true);
			}
		});
		rdbDiexMessage.setEnabled(false);
		rdbDiexMessage.setBounds(316, 61, 64, 23);
		pnlCorrespondencia.add(rdbDiexMessage);

		rdbOficio = new JRadioButton("OFÍCIO");
		rdbOficio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbDiexMessage.setSelected(false);
				rdbNudMessage.setSelected(false);
				txtNumMessage.setEnabled(true);
			}
		});
		rdbOficio.setEnabled(false);
		rdbOficio.setBounds(395, 61, 75, 23);
		pnlCorrespondencia.add(rdbOficio);

		rdbNudMessage = new JRadioButton("NUD");
		rdbNudMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbDiexMessage.setSelected(false);
				rdbOficio.setSelected(false);
				txtNumMessage.setEnabled(false);
			}
		});
		rdbNudMessage.setEnabled(false);
		rdbNudMessage.setBounds(486, 61, 64, 23);
		pnlCorrespondencia.add(rdbNudMessage);

		JLabel lblDestinatario = new JLabel("Destinatário:");
		lblDestinatario.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblDestinatario.setBounds(228, 158, 80, 15);
		pnlCorrespondencia.add(lblDestinatario);

		txtDestinatario = new JTextField();
		txtDestinatario.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtDestinatario.setEnabled(false);
		txtDestinatario.setColumns(10);
		txtDestinatario.setBounds(316, 154, 296, 23);
		pnlCorrespondencia.add(txtDestinatario);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtCidade.setEnabled(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(316, 186, 168, 23);
		pnlCorrespondencia.add(txtCidade);

		cbxEstado = new JComboBox();
		cbxEstado.setEnabled(false);
		cbxEstado.setBounds(548, 186, 64, 23);
		pnlCorrespondencia.add(cbxEstado);

		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblEstado.setBounds(496, 189, 49, 15);
		pnlCorrespondencia.add(lblEstado);

		lblTipoEnvio = new JLabel("Tipo de Envio:");
		lblTipoEnvio.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblTipoEnvio.setBounds(408, 217, 91, 15);
		pnlCorrespondencia.add(lblTipoEnvio);

		txtTipoEnvio = new JTextField();
		txtTipoEnvio.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtTipoEnvio.setEnabled(false);
		txtTipoEnvio.setColumns(10);
		txtTipoEnvio.setBounds(507, 214, 105, 23);
		pnlCorrespondencia.add(txtTipoEnvio);

		txtCep = new JTextField();
		txtCep.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtCep.setEnabled(false);
		txtCep.setColumns(10);
		txtCep.setBounds(316, 214, 80, 23);
		pnlCorrespondencia.add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblCep.setBounds(278, 218, 30, 15);
		pnlCorrespondencia.add(lblCep);

		lblProtocolista = new JLabel("Protocolista:");
		lblProtocolista.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblProtocolista.setBounds(228, 249, 80, 15);
		pnlCorrespondencia.add(lblProtocolista);

		cbxProtocolista = new JComboBox();
		cbxProtocolista.setEnabled(false);
		cbxProtocolista.setBounds(316, 246, 296, 23);
		pnlCorrespondencia.add(cbxProtocolista);

		btnSrchMessage = new JButton(" Pesquisa");
		btnSrchMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBuscarMessage.setVisible(true);
				txtBuscarMessage.setVisible(true);
				btnBuscarMessage.setVisible(true);
				btnCancelPesqMessage.setVisible(true);
				btnAddMessage.setEnabled(false);
				btnAlterMessage.setEnabled(false);
				btnRmvMessage.setEnabled(false);
			}
		});
		btnSrchMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/lupa.png")));
		btnSrchMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSrchMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnSrchMessage.setAlignmentX(0.5f);
		btnSrchMessage.setBounds(12, 136, 109, 27);
		pnlCorrespondencia.add(btnSrchMessage);

		lblBuscarMessage = new JLabel("Pesquisa:");
		lblBuscarMessage.setVisible(false);
		lblBuscarMessage.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblBuscarMessage.setBounds(12, 313, 64, 15);
		pnlCorrespondencia.add(lblBuscarMessage);

		txtBuscarMessage = new JTextField();
		txtBuscarMessage.setVisible(false);
		txtBuscarMessage.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtBuscarMessage.setColumns(10);
		txtBuscarMessage.setBounds(78, 309, 545, 23);
		pnlCorrespondencia.add(txtBuscarMessage);

		btnBuscarMessage = new JButton("  Buscar");
		btnBuscarMessage.setVisible(false);
		btnBuscarMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/lupa.png")));
		btnBuscarMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnBuscarMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnBuscarMessage.setAlignmentX(0.5f);
		btnBuscarMessage.setBounds(634, 306, 104, 27);
		pnlCorrespondencia.add(btnBuscarMessage);

		btnCancelPesqMessage = new JButton("Cancelar");
		btnCancelPesqMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblBuscarMessage.setVisible(false);
				txtBuscarMessage.setVisible(false);
				btnBuscarMessage.setVisible(false);
				btnCancelPesqMessage.setVisible(false);
				btnAddMessage.setEnabled(true);
				btnAlterMessage.setEnabled(true);
				btnRmvMessage.setEnabled(true);
			}
		});
		btnCancelPesqMessage.setVisible(false);
		btnCancelPesqMessage.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelPesqMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelPesqMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelPesqMessage.setAlignmentX(0.5f);
		btnCancelPesqMessage.setBounds(749, 306, 104, 27);
		pnlCorrespondencia.add(btnCancelPesqMessage);

		lblData = new JLabel("Data:");
		lblData.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblData.setBounds(426, 96, 33, 15);
		pnlCorrespondencia.add(lblData);

		dcEncaminhamento = new JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
		dcEncaminhamento.setBounds(465, 92, 147, 23);
		pnlCorrespondencia.add(dcEncaminhamento);
		dcEncaminhamento.setEnabled(false);

		JLabel lblNmeroDeRastreio = new JLabel("Número de Rastreio:");
		lblNmeroDeRastreio.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblNmeroDeRastreio.setBounds(178, 279, 130, 15);
		pnlCorrespondencia.add(lblNmeroDeRastreio);

		textField = new JTextField();
		textField.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBounds(316, 276, 234, 23);
		pnlCorrespondencia.add(textField);
	}

	// Método que carrega a tabela de dependências
	private void carregarTabelaDependencia() {

		DefaultTableModel modelo = (DefaultTableModel) tblDependencia.getModel();
		modelo.setNumRows(0);

		tblDependencia.getColumnModel().getColumn(0).setResizable(false);
		tblDependencia.getColumnModel().getColumn(0).setPreferredWidth(62);
		tblDependencia.getColumnModel().getColumn(1).setResizable(false);
		tblDependencia.getColumnModel().getColumn(1).setPreferredWidth(228);
		tblDependencia.getColumnModel().getColumn(2).setResizable(false);
		tblDependencia.getColumnModel().getColumn(2).setPreferredWidth(94);
		tblDependencia.getColumnModel().getColumn(3).setResizable(false);
		tblDependencia.getColumnModel().getColumn(3).setPreferredWidth(157);
		tblDependencia.getColumnModel().getColumn(4).setResizable(false);
		tblDependencia.getColumnModel().getColumn(4).setPreferredWidth(103);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDependencia.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		try {

			Connection conn = Conexao.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs;

			String sql = "SELECT * FROM Dependencia;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				modelo.addRow(new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5) });
			}

			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar Tabela! " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Método que carrega a tabela de militares
	private void carregarTabelaMilitar() {

		DefaultTableModel modelo = (DefaultTableModel) tblMil.getModel();
		modelo.setNumRows(0);

		tblMil.getColumnModel().getColumn(0).setResizable(false);
		tblMil.getColumnModel().getColumn(0).setPreferredWidth(52);
		tblMil.getColumnModel().getColumn(1).setResizable(false);
		tblMil.getColumnModel().getColumn(1).setPreferredWidth(171);
		tblMil.getColumnModel().getColumn(2).setResizable(false);
		tblMil.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblMil.getColumnModel().getColumn(3).setResizable(false);
		tblMil.getColumnModel().getColumn(3).setPreferredWidth(99);
		tblMil.getColumnModel().getColumn(4).setResizable(false);
		tblMil.getColumnModel().getColumn(4).setPreferredWidth(198);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblMil.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		try {

			Connection conn = Conexao.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			String sql = "SELECT Militar.id_militar, Militar.nome_guerra, Militar.identidade, Graduacao.descricao, Dependencia.nome_dependencia FROM db_postman.Militar \n"
					+ "INNER JOIN db_postman.Graduacao ON Militar.fk_graduacao = Graduacao.id_graduacao\n"
					+ "INNER JOIN db_postman.Dependencia ON Militar.fk_dependencia = Dependencia.id_dependencia;";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5) });
			}

			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao carregar Tabela Militar! " + ex, "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Método que carrega a tabela de sindicâncias
		private void carregarTabelaSindicancia() {

			DefaultTableModel modelo = (DefaultTableModel) tblSindicancia.getModel();
			modelo.setNumRows(0);

			tblSindicancia.getColumnModel().getColumn(0).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(0).setPreferredWidth(61);
			tblSindicancia.getColumnModel().getColumn(1).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(1).setPreferredWidth(78);
			tblSindicancia.getColumnModel().getColumn(2).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(2).setPreferredWidth(167);
			tblSindicancia.getColumnModel().getColumn(3).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(3).setPreferredWidth(174);
			tblSindicancia.getColumnModel().getColumn(4).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(4).setPreferredWidth(101);
			tblSindicancia.getColumnModel().getColumn(5).setResizable(false);
			tblSindicancia.getColumnModel().getColumn(5).setPreferredWidth(63);

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			tblSindicancia.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
			tblSindicancia.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
			tblSindicancia.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
			tblSindicancia.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
			tblSindicancia.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
			tblSindicancia.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);

			try {

				Connection conn = Conexao.getConnection();
				PreparedStatement pstm = null;
				ResultSet rs = null;

				String sql = "SELECT Sindicancia.id_sindicancia, Documento.descricao, Sindicancia.num_diex, Militar.nome_guerra, Sindicancia.sindicado, Sindicancia.data_sindicancia, Sindicancia.caixa FROM Sindicancia\n" + 
						"INNER JOIN Militar ON Sindicancia.fk_militar = Militar.id_militar\n" + 
						"INNER JOIN Documento ON Sindicancia.fk_documento = Documento.id_documento;";
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();

				while (rs.next()) {

					modelo.addRow(
							new Object[] { rs.getInt(1), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7) });
				}

				Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao carregar Tabela Sindicância!" + ex, "Erro",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	
	// Método que busca os registros no banco
	private void pesquisarMilitar(String nomeMilitar) {

		DefaultTableModel modelo = (DefaultTableModel) tblMil.getModel();
		modelo.setNumRows(0);

		tblMil.getColumnModel().getColumn(0).setResizable(false);
		tblMil.getColumnModel().getColumn(0).setPreferredWidth(52);
		tblMil.getColumnModel().getColumn(1).setResizable(false);
		tblMil.getColumnModel().getColumn(1).setPreferredWidth(171);
		tblMil.getColumnModel().getColumn(2).setResizable(false);
		tblMil.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblMil.getColumnModel().getColumn(3).setResizable(false);
		tblMil.getColumnModel().getColumn(3).setPreferredWidth(99);
		tblMil.getColumnModel().getColumn(4).setResizable(false);
		tblMil.getColumnModel().getColumn(4).setPreferredWidth(198);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblMil.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblMil.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		try {

			Connection conn = Conexao.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			String sql = "SELECT Militar.id_militar, Militar.nome_guerra, Militar.identidade, Graduacao.descricao, Dependencia.nome_dependencia FROM db_postman.Militar \n"
					+ "INNER JOIN db_postman.Graduacao ON Militar.fk_graduacao = Graduacao.id_graduacao\n"
					+ "INNER JOIN db_postman.Dependencia ON Militar.fk_dependencia = Dependencia.id_dependencia\n"
					+ "WHERE db_postman.Militar.nome_guerra LIKE ?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + nomeMilitar + "%");
			rs = pstm.executeQuery();

			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5) });
			}

			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar Pesquisa! " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Método que busca os registros no banco
	private void pesquisarDependencia(String nomeDependencia) {

		DefaultTableModel modelo = (DefaultTableModel) tblDependencia.getModel();
		modelo.setNumRows(0);
		
		tblDependencia.getColumnModel().getColumn(0).setResizable(false);
		tblDependencia.getColumnModel().getColumn(0).setPreferredWidth(62);
		tblDependencia.getColumnModel().getColumn(1).setResizable(false);
		tblDependencia.getColumnModel().getColumn(1).setPreferredWidth(228);
		tblDependencia.getColumnModel().getColumn(2).setResizable(false);
		tblDependencia.getColumnModel().getColumn(2).setPreferredWidth(94);
		tblDependencia.getColumnModel().getColumn(3).setResizable(false);
		tblDependencia.getColumnModel().getColumn(3).setPreferredWidth(157);
		tblDependencia.getColumnModel().getColumn(4).setResizable(false);
		tblDependencia.getColumnModel().getColumn(4).setPreferredWidth(103);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tblDependencia.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		tblDependencia.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

		try {

			Connection conn = Conexao.getConnection();
			PreparedStatement pstm = null;
			ResultSet rs = null;

			String sql = "SELECT * FROM db_postman.Dependencia WHERE db_postman.Dependencia.nome_dependencia LIKE ?;";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + nomeDependencia + "%");
			rs = pstm.executeQuery();

			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) });
			}

			Conexao.closeConnection(conn, (com.mysql.jdbc.PreparedStatement) pstm, rs);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao realizar Pesquisa! " + ex, "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Método que limpa os campos da página Militares
	private void formatarCamposMilitares() {

		// esvazia os campos
		txtNomeGuerra.setText("");
		txtIdentidade.setText("");
		txtSigla.setText("");
		cbxGraduacao.setSelectedIndex(0);
		cbxDependencia.setSelectedIndex(0);

		// desabilita os campos e botões
		btnSaveMil.setEnabled(false);
		btnCancelMil.setEnabled(false);
		btnAddMil.setEnabled(true);
		btnAlterMil.setEnabled(true);
		btnRmvMil.setEnabled(true);
		btnSrchMil.setEnabled(true);
		txtNomeGuerra.setEnabled(false);
		txtIdentidade.setEnabled(false);

		cbxGraduacao.setEnabled(false);
		cbxDependencia.setEnabled(false);

		insert = false;
		update = false;
	}

	// Método que limpa os campos da página Dependencia
	private void formatarCamposDepndcia() {

		// esvazia os campos
		txtDependencia.setText("");
		txtSigla.setText("");
		txtOM.setText("");
		txtContato.setText("");

		// desabilita os campos e botões
		btnSaveDpdncia.setEnabled(false);
		btnCancelDpdncia.setEnabled(false);
		btnAddDpdncia.setEnabled(true);
		btnAlterDpdncia.setEnabled(true);
		btnRmvDpdncia.setEnabled(true);
		btnSrchDpdncia.setEnabled(true);
		txtDependencia.setEnabled(false);
		txtSigla.setEnabled(false);
		txtOM.setEnabled(false);
		txtContato.setEnabled(false);

		insert = false;
		update = false;
	}

	// Método que limpa os campos da página Protocolo
	private void formatarCamposPrtclo() {

		//esvazia os campos
		rdbDiex.setSelected(false);
		rdbNud.setSelected(false);
		lblNumDiex.setVisible(false);
		txtNumDiex.setText("");
		cbxSindicante.setSelectedIndex(0);
		txtSindicado.setText("");
		dcSindicancia.setDate(null);
		txtCaixa.setText("");
		
		// desabilita campos e botões
		rdbDiex.setEnabled(false);
		rdbNud.setEnabled(false);
		txtNumDiex.setVisible(false);
		cbxSindicante.setEnabled(false);
		txtSindicado.setEnabled(false);
		dcSindicancia.setEnabled(false);
		txtCaixa.setEnabled(false);
		btnCancelPtrclo.setEnabled(false);
		btnSavePrtclo.setEnabled(false);
		
		btnAddPrtclo.setEnabled(true);
		btnAlterPrtclo.setEnabled(true);
		btnRmvPrtclo.setEnabled(true);
		btnSrchPtclo.setEnabled(true);

		insert = false;
		update = false;
	}

	// Método que limpa os campos da página Protocolo
	private void formatarCamposMessage() {

		// Desabilita campos e botões
		rdbDiexMessage.setEnabled(false);
		rdbNudMessage.setEnabled(false);
		rdbOficio.setEnabled(false);
		dcEncaminhamento.setEnabled(false);
		txtRemetente.setEnabled(false);
		txtDestinatario.setEnabled(false);
		txtCidade.setEnabled(false);
		cbxEstado.setEnabled(false);
		txtCep.setEnabled(false);
		txtTipoEnvio.setEnabled(false);
		cbxProtocolista.setEnabled(false);
		btnSaveMessage.setEnabled(false);
		btnCancelMessage.setEnabled(false);
		btnAlterMessage.setEnabled(true);
		btnRmvMessage.setEnabled(true);
		btnSrchMessage.setEnabled(true);
		rdbNudMessage.setSelected(false);
		rdbOficio.setSelected(false);
		rdbDiexMessage.setSelected(false);
		txtNumMessage.setEnabled(false);

		insert = false;
		update = false;
	}
}
