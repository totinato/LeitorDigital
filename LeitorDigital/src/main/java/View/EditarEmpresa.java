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

import Model.Empresa;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmpresa;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	private JTextField txtRamo;
	private JTextField txtAgrotoxico;
	private JTextField txtToxidade;
	public EditarEmpresa(Empresa e) {
		setTitle("AgroVisual - Editar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 446, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 36, 122, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Empresa:");
		lblNewLabel_2.setBounds(10, 84, 122, 14);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(138, 81, 230, 20);
		txtEmpresa.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		txtEmpresa.setText(e.getNome());
		
		JLabel lblNewLabel_1 = new JLabel("CNPJ");
		lblNewLabel_1.setBounds(10, 135, 122, 14);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(138, 132, 230, 20);
		txtCNPJ.setHorizontalAlignment(SwingConstants.LEFT);
		txtCNPJ.setColumns(10);
		txtCNPJ.setText(e.getCnpj());
		contentPane.add(txtCNPJ);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setBounds(10, 186, 122, 14);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setText(e.getEndereco());
		txtEndereco.setBounds(138, 183, 230, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CEP:");
		lblNewLabel_4.setBounds(10, 237, 122, 14);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(138, 234, 230, 20);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);
		txtCEP.setText(e.getCep());
		
		JLabel lblNewLabel_5 = new JLabel("Ramo:");
		lblNewLabel_5.setBounds(10, 288, 122, 14);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_5);
		
		txtRamo = new JTextField();
		txtRamo.setBounds(138, 285, 230, 20);
		contentPane.add(txtRamo);
		txtRamo.setColumns(10);
		txtRamo.setText(e.getRamo());
		
		JLabel lblNewLabel_6 = new JLabel("Agrot\u00F3xico:");
		lblNewLabel_6.setBounds(10, 339, 122, 14);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		txtAgrotoxico = new JTextField();
		txtAgrotoxico.setBounds(138, 336, 230, 20);
		contentPane.add(txtAgrotoxico);
		txtAgrotoxico.setColumns(10);
		txtAgrotoxico.setText(e.getAgrotoxico());
		
		JLabel lblNewLabel_7 = new JLabel("N\u00EDvel de Toxicidade:");
		lblNewLabel_7.setBounds(10, 390, 122, 14);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_7);
		
		txtToxidade = new JTextField();
		txtToxidade.setBounds(138, 387, 230, 20);
		contentPane.add(txtToxidade);
		txtToxidade.setColumns(10);
		txtToxidade.setText(e.getToxidade());
		
		JLabel lblID = new JLabel("New label");
		
		lblID.setText(Integer.toString(e.getID()));
		lblID.setBounds(138, 36, 46, 14);
		contentPane.add(lblID);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAgrotoxico.getText()!="" && txtCEP.getText()!="" &&  txtCNPJ.getText()!="" &&  txtEmpresa.getText()!="" &&  txtEndereco.getText()!="" &&  txtRamo.getText()!="" &&  txtToxidade.getText()!="") {
					Empresa empresa=new Empresa();
					empresa.setID(Integer.parseInt(lblID.getText()));
					empresa.setAgrotoxico(txtAgrotoxico.getText());
					empresa.setCep(txtCEP.getText());
					empresa.setCnpj(txtCNPJ.getText());
					empresa.setEndereco(txtEndereco.getText());
					empresa.setNome(txtEmpresa.getText());
					empresa.setRamo(txtRamo.getText());
					empresa.setToxidade(txtToxidade.getText());
					empresa.Atualizar();
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
				}
			}
		});
		btnSalvar.setBounds(86, 437, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, 
		                "Tem Certeza?", "Essa e uma a��o Permanente",JOptionPane.YES_NO_CANCEL_OPTION);
				if(input==0) {
					if(txtAgrotoxico.getText()!="" && txtCEP.getText()!="" &&  txtCNPJ.getText()!="" &&  txtEmpresa.getText()!="" &&  txtEndereco.getText()!="" &&  txtRamo.getText()!="" &&  txtToxidade.getText()!="") {
						Empresa empresa=new Empresa();
						empresa.setID(Integer.parseInt(lblID.getText()));
						empresa.setAgrotoxico(txtAgrotoxico.getText());
						empresa.setCep(txtCEP.getText());
						empresa.setCnpj(txtCNPJ.getText());
						empresa.setEndereco(txtEndereco.getText());
						empresa.setNome(txtEmpresa.getText());
						empresa.setRamo(txtRamo.getText());
						empresa.setToxidade(txtToxidade.getText());
						empresa.excluir();
						JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
					}else {
						JOptionPane.showMessageDialog(null, "Preencha todos os Campos");
					}
				}
				
			}
			
		});
		btnExcluir.setBounds(249, 437, 89, 23);
		contentPane.add(btnExcluir);
	}
}
