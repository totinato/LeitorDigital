package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class EditarEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpresa;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	private JTextField txtRamo;
	private JTextField txtAgrotoxico;
	private JTextField txtToxidade;
	public EditarEmpresa() {
		setTitle("Editar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 546);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenu mnNveis = new JMenu("Editar");
		menuBar.add(mnNveis);
		
		JMenuItem opcUsuario = new JMenuItem("Usuario");
		mnNveis.add(opcUsuario);
		
		JMenuItem opcEmpresa = new JMenuItem("Empresa");
		mnNveis.add(opcEmpresa);
		
		JMenu mnSobre = new JMenu("Sobre");
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(36, 36, 96, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Empresa:");
		lblNewLabel_2.setBounds(36, 84, 96, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(138, 81, 230, 20);
		txtEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CNPJ");
		lblNewLabel_1.setBounds(36, 135, 96, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(138, 132, 230, 20);
		txtCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		txtCNPJ.setColumns(10);
		contentPane.add(txtCNPJ);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setBounds(36, 186, 96, 14);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(138, 183, 230, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(36, 237, 96, 14);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(138, 234, 230, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ramo:");
		lblNewLabel_5.setBounds(36, 288, 96, 14);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		txtRamo = new JTextField();
		txtRamo.setBounds(138, 285, 230, 20);
		contentPane.add(txtRamo);
		txtRamo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Agrot\u00F3xico:");
		lblNewLabel_6.setBounds(36, 339, 96, 14);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		txtAgrotoxico = new JTextField();
		txtAgrotoxico.setBounds(138, 336, 230, 20);
		contentPane.add(txtAgrotoxico);
		txtAgrotoxico.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("N\u00EDvel de Toxicidade:");
		lblNewLabel_7.setBounds(36, 390, 96, 14);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);
		
		txtToxidade = new JTextField();
		txtToxidade.setBounds(138, 387, 230, 20);
		contentPane.add(txtToxidade);
		txtToxidade.setColumns(10);
		
		JLabel lblID = new JLabel("New label");
		lblID.setBounds(138, 36, 46, 14);
		contentPane.add(lblID);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(86, 437, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(249, 437, 89, 23);
		contentPane.add(btnExcluir);
	}
}
