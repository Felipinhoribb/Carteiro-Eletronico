package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
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

public class Interface {

	private JFrame frmCartEletronico;
	
	private JTextField txtNumDiex, txtDependencia, txtOM, txtNomeGuerra, txtIdentidade, txtDateNascmnto, txtCaixa,
	txtContato;
	
	private JTable tbl, table, table_1;
	
	private JButton btnCancelMil, btnSaveMil, btnAlterMil, btnRmvMil, btnAlterDpdncia, btnRmvDpdncia, btnSaveDpdncia,
	btnAddPrtclo, btnCancelDpdncia, btnAlterPrtclo, btnRmvPrtclo, btnSavePrtclo, btnCancelPtrclo;
	
	private JLabel lblDependencia, lblTitleMil, lblNumDiex;
	
	private JComboBox cbxDependencia, cbxSindicante, cbxSindicado, cbxGraduacao;
	 
	private JRadioButton rdbDiex, rdbNud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//here you can put the selected theme class name in JTattoo
		            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
					Interface window = new Interface();
					window.frmCartEletronico.setVisible(true);
				} catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCartEletronico = new JFrame();
		frmCartEletronico.setFont(new Font("Liberation Serif", Font.BOLD, 14));
		frmCartEletronico.setTitle("Carteiro Eletrônico");
		frmCartEletronico.setBounds(100, 100, 877, 468);
		frmCartEletronico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCartEletronico.setLocationRelativeTo(null);
		frmCartEletronico.getContentPane().setLayout(null);
		
		JTabbedPane mainTabs = new JTabbedPane(JTabbedPane.TOP);
		mainTabs.setBounds(0, 0, 867, 439);
		frmCartEletronico.getContentPane().add(mainTabs);
		
		Panel pnlMilitares = new Panel();
		mainTabs.addTab("Militares", new ImageIcon(Interface.class.getResource("/img/military-rank.png")), pnlMilitares, null);
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
		
		tbl = new JTable();
		tbl.setBounds(12, 222, 843, 159);
		pnlMilitares.add(tbl);
		
		cbxDependencia = new JComboBox();
		cbxDependencia.setBounds(316, 166, 234, 23);
		cbxDependencia.setEnabled(false);
		pnlMilitares.add(cbxDependencia);
		
		JButton btnAddMil = new JButton("   Incluir");
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
			}
		});
		pnlMilitares.add(btnAddMil);
		
		btnAlterMil = new JButton("  Alterar");
		btnAlterMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterMil.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterMil.setBounds(12, 71, 109, 27);
		btnAlterMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Verifica se o usuário selecionou algum registro da tabela
				if (!txtNomeGuerra.getText().isEmpty()) {
					System.out.println("Selecione um registro!");
				} else {
					txtNomeGuerra.setEnabled(true);
					txtIdentidade.setEnabled(true);
					cbxGraduacao.setEnabled(true);
					cbxDependencia.setEnabled(true);
					btnSaveMil.setEnabled(true);
					btnCancelMil.setEnabled(true);
					btnAddMil.setEnabled(false);
					btnRmvMil.setEnabled(false);
				}
			}
		});
		pnlMilitares.add(btnAlterMil);
		
		btnRmvMil = new JButton(" Remover");
		btnRmvMil.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvMil.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvMil.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvMil.setBounds(12, 121, 109, 27);
		btnRmvMil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomeGuerra.getText().isEmpty()) {
					System.out.println("Selecione um registro para a remoção!");
				} else {
					//Remove o registro
				}
			}
		});
		pnlMilitares.add(btnRmvMil);
		
		btnSaveMil = new JButton("  Salvar");
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
				
				//esvazia os campos
				txtNomeGuerra.setText("");
				txtIdentidade.setText("");
				cbxGraduacao.setSelectedIndex(-1);
				cbxDependencia.setSelectedIndex(-1);
				
				//desabilita os campos e botões
				btnSaveMil.setEnabled(false);
				btnCancelMil.setEnabled(false);
				btnAddMil.setEnabled(true);
				btnAlterMil.setEnabled(true);
				btnRmvMil.setEnabled(true);
				txtNomeGuerra.setEnabled(false);
				txtIdentidade.setEnabled(false);
				cbxGraduacao.setEnabled(false);
				cbxDependencia.setEnabled(false);
			}
		});
		btnCancelMil.setEnabled(false);
		pnlMilitares.add(btnCancelMil);
		
		Panel pnlDependencias = new Panel();
		pnlDependencias.setLayout(null);
		mainTabs.addTab("Dependências", new ImageIcon(Interface.class.getResource("/img/army.png")), pnlDependencias, null);
		
		JLabel lblNomeDaDependncia = new JLabel("Nome da Dependência:");
		lblNomeDaDependncia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblNomeDaDependncia.setBounds(161, 80, 149, 15);
		pnlDependencias.add(lblNomeDaDependncia);
		
		txtDependencia = new JTextField();
		txtDependencia.setEnabled(false);
		txtDependencia.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtDependencia.setColumns(10);
		txtDependencia.setBounds(318, 76, 234, 23);
		pnlDependencias.add(txtDependencia);
		
		JLabel lblOm = new JLabel("OM:");
		lblOm.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblOm.setBounds(285, 111, 25, 15);
		pnlDependencias.add(lblOm);
		
		txtOM = new JTextField();
		txtOM.setEnabled(false);
		txtOM.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtOM.setColumns(10);
		txtOM.setBounds(318, 107, 234, 23);
		pnlDependencias.add(txtOM);
		
		JLabel lblContato = new JLabel("Contato:");
		lblContato.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblContato.setBounds(257, 141, 53, 15);
		pnlDependencias.add(lblContato);
		
		JLabel lblTitleDepndcia = new JLabel("Cadastro de Dependências");
		lblTitleDepndcia.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		lblTitleDepndcia.setBounds(266, 12, 319, 37);
		pnlDependencias.add(lblTitleDepndcia);
		
		table_1 = new JTable();
		table_1.setBounds(12, 197, 843, 186);
		pnlDependencias.add(table_1);
		
		JButton btnAddDpdncia = new JButton("   Incluir");
		btnAddDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDependencia.setEnabled(true);
				txtOM.setEnabled(true);
				txtContato.setEnabled(true);
				btnSaveDpdncia.setEnabled(true);
				btnCancelDpdncia.setEnabled(true);
				btnAlterDpdncia.setEnabled(false);
				btnRmvDpdncia.setEnabled(false);
			}
		});
		btnAddDpdncia.setBounds(12, 22, 109, 27);
		pnlDependencias.add(btnAddDpdncia);
		
		btnAlterDpdncia = new JButton("  Alterar");
		btnAlterDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAlterDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnAlterDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/edit.png")));
		btnAlterDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Verifica se o usuário selecionou algum registro da tabela
				if (!txtDependencia.getText().isEmpty()) {
					System.out.println("Selecione um registro!");
				} else {
					txtDependencia.setEnabled(true);
					txtOM.setEnabled(true);
					txtContato.setEnabled(true);
					btnSaveDpdncia.setEnabled(true);
					btnCancelDpdncia.setEnabled(true);
					btnAddDpdncia.setEnabled(false);
					btnRmvDpdncia.setEnabled(false);
				}
			}
		});
		btnAlterDpdncia.setBounds(12, 80, 109, 27);
		pnlDependencias.add(btnAlterDpdncia);
		
		btnRmvDpdncia = new JButton(" Remover");
		btnRmvDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtDependencia.getText().isEmpty()) {
					System.out.println("Selecione um registro para a remoção!");
				} else {
					//Remove o registro
				}
			}
		});
		btnRmvDpdncia.setBounds(12, 136, 109, 27);
		pnlDependencias.add(btnRmvDpdncia);
		
		txtContato = new JTextField();
		txtContato.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtContato.setEnabled(false);
		txtContato.setColumns(10);
		txtContato.setBounds(318, 138, 234, 23);
		pnlDependencias.add(txtContato);
		
		btnSaveDpdncia = new JButton("  Salvar");
		btnSaveDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSaveDpdncia.setEnabled(false);
		btnSaveDpdncia.setBounds(641, 77, 109, 27);
		pnlDependencias.add(btnSaveDpdncia);
		
		btnCancelDpdncia = new JButton(" Cancelar");
		btnCancelDpdncia.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelDpdncia.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelDpdncia.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelDpdncia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//esvazia os campos
				txtDependencia.setText("");
				txtOM.setText("");
				txtContato.setText("");
				
				//desabilita os campos e botões
				btnSaveDpdncia.setEnabled(false);
				btnCancelDpdncia.setEnabled(false);
				btnAddDpdncia.setEnabled(true);
				btnAlterDpdncia.setEnabled(true);
				btnRmvDpdncia.setEnabled(true);
				txtDependencia.setEnabled(false);
				txtOM.setEnabled(false);
				txtContato.setEnabled(false);
			}
		});
		btnCancelDpdncia.setEnabled(false);
		btnCancelDpdncia.setBounds(641, 136, 109, 27);
		pnlDependencias.add(btnCancelDpdncia);
		
		Panel pnlProtocolos = new Panel();
		pnlProtocolos.setLayout(null);
		mainTabs.addTab("Protocolos", new ImageIcon(Interface.class.getResource("/img/antenna.png")), pnlProtocolos, null);
		
		lblNumDiex = new JLabel("N° DIEX:");
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
		cbxSindicante.setEnabled(false);
		cbxSindicante.setBounds(343, 122, 234, 23);
		pnlProtocolos.add(cbxSindicante);
		
		JLabel lblSindicado = new JLabel("Sindicado:");
		lblSindicado.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblSindicado.setBounds(269, 160, 89, 15);
		pnlProtocolos.add(lblSindicado);
		
		JLabel lblProtocolosDeSindicncia = new JLabel("Protocolos de Sindicância");
		lblProtocolosDeSindicncia.setFont(new Font("Liberation Sans", Font.BOLD, 24));
		lblProtocolosDeSindicncia.setBounds(268, 12, 309, 37);
		pnlProtocolos.add(lblProtocolosDeSindicncia);
		
		table = new JTable();
		table.setBounds(12, 249, 843, 134);
		pnlProtocolos.add(table);
		
		cbxSindicado = new JComboBox();
		cbxSindicado.setEnabled(false);
		cbxSindicado.setBounds(343, 155, 234, 23);
		pnlProtocolos.add(cbxSindicado);
		
		rdbDiex = new JRadioButton("DIEX");
		rdbDiex.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		rdbNud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		
		txtDateNascmnto = new JTextField();
		txtDateNascmnto.setEnabled(false);
		txtDateNascmnto.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtDateNascmnto.setColumns(10);
		txtDateNascmnto.setBounds(343, 187, 124, 23);
		pnlProtocolos.add(txtDateNascmnto);
		
		JLabel lblCaixa = new JLabel("Caixa:");
		lblCaixa.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		lblCaixa.setBounds(294, 222, 41, 15);
		pnlProtocolos.add(lblCaixa);
		
		txtCaixa = new JTextField();
		txtCaixa.setEnabled(false);
		txtCaixa.setFont(new Font("Liberation Sans", Font.BOLD, 13));
		txtCaixa.setColumns(10);
		txtCaixa.setBounds(343, 218, 97, 23);
		pnlProtocolos.add(txtCaixa);
		
		JButton btnAddPrtclo = new JButton("   Incluir");
		btnAddPrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAddPrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnAddPrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/plus(1).png")));
		btnAddPrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbDiex.setEnabled(true);
				rdbNud.setEnabled(true);
				cbxSindicante.setEnabled(true);
				cbxSindicado.setEnabled(true);
				txtDateNascmnto.setEnabled(true);
				txtCaixa.setEnabled(true);
				btnSavePrtclo.setEnabled(true);
				btnCancelPtrclo.setEnabled(true);
				btnAddPrtclo.setEnabled(true);
				btnRmvPrtclo.setEnabled(false);
				btnAlterPrtclo.setEnabled(false);
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
					//Verifica se o usuário selecionou algum registro da tabela
					if (!txtNomeGuerra.getText().isEmpty()) {
						System.out.println("Selecione um registro!");
					} else {
						rdbDiex.setEnabled(true);
						rdbNud.setEnabled(true);
						cbxSindicante.setEnabled(true);
						cbxSindicado.setEnabled(true);
						txtDateNascmnto.setEnabled(true);
						txtCaixa.setEnabled(true);
						btnSavePrtclo.setEnabled(true);
						btnCancelPtrclo.setEnabled(true);
						btnAddPrtclo.setEnabled(false);
						btnRmvPrtclo.setEnabled(false);
					}
				}
			});
		btnAlterPrtclo.setBounds(12, 91, 110, 27);
		pnlProtocolos.add(btnAlterPrtclo);
		
		btnRmvPrtclo = new JButton(" Remover");
		btnRmvPrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnRmvPrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnRmvPrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/remove(1).png")));
		btnRmvPrtclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbxSindicante.getSelectedIndex() == -1) {
					System.out.println("Selecione um registro para a remoção!");
				} else {
					//Remove o registro
				}
			}
		});
		btnRmvPrtclo.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRmvPrtclo.setBounds(12, 155, 110, 27);
		pnlProtocolos.add(btnRmvPrtclo);
		
		btnSavePrtclo = new JButton("  Salvar");
		btnSavePrtclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSavePrtclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSavePrtclo.setIcon(new ImageIcon(Interface.class.getResource("/img/check(1).png")));
		btnSavePrtclo.setEnabled(false);
		btnSavePrtclo.setBounds(651, 96, 110, 27);
		pnlProtocolos.add(btnSavePrtclo);
		
		btnCancelPtrclo = new JButton(" Cancelar");
		btnCancelPtrclo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancelPtrclo.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancelPtrclo.setIcon(new ImageIcon(Interface.class.getResource("/img/remove.png")));
		btnCancelPtrclo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Desabilita os botões
				rdbDiex.setSelected(false);
				rdbNud.setSelected(false);
				cbxSindicante.setEnabled(false);
				cbxSindicado.setEnabled(false);
				txtDateNascmnto.setEnabled(false);
				txtCaixa.setEnabled(false);
				btnSavePrtclo.setEnabled(false);
				btnCancelPtrclo.setEnabled(false);
				btnAddPrtclo.setEnabled(true);
				btnRmvPrtclo.setEnabled(true);
				btnAlterPrtclo.setEnabled(true);
				rdbDiex.setEnabled(false);
				rdbNud.setEnabled(false);
				lblNumDiex.setVisible(false);
				txtNumDiex.setVisible(false);
				
				//Limpa todos os campos
				txtDateNascmnto.setText("");
				txtCaixa.setText("");
				cbxSindicante.setSelectedItem(-1);
				cbxSindicado.setSelectedItem(-1);
				txtDateNascmnto.setEnabled(false);
				txtCaixa.setEnabled(false);
			}
		});
		btnCancelPtrclo.setEnabled(false);
		btnCancelPtrclo.setBounds(651, 155, 110, 27);
		pnlProtocolos.add(btnCancelPtrclo);
	}
}
