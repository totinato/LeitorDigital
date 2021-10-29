package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.UsuarioController;
import Controller.UsuarioDao;
import Model.Usuario;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class DadosFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public DadosFuncionarios(int a) {
		setTitle("Editar Usu\u00E1rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblUsuarioNivel = new JLabel("Registro de Usu\u00E1rios");
		lblUsuarioNivel.setBounds(32, 19, 118, 14);
		
		JLabel lblDados = new JLabel("Dados do Usu\u00E1rio");
		lblDados.setBounds(32, 263, 101, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 288, 452, 159);
		
		tabelateste = new JTable();

		scrollPane.setViewportView(tabelateste);
		tabelateste.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabelateste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelateste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		List<Usuario> c=new Usuario().Achartodos();
		Object[][] ob=new String[c.size()][4];
        int i=0;
        for (Usuario mov : c) {
            ob[i][0]=String.valueOf(mov.getID());
            ob[i][1]=String.valueOf(mov.getNome());
            ob[i][2]=String.valueOf(mov.getHashdigital());
            ob[i][3]=String.valueOf(mov.getPermissao());
            i++;
        }
		tabelateste.setModel(new DefaultTableModel(
			ob,
			new String[] {
				"ID", "Nome", "Hash", "Nível"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelateste.getColumnModel().getColumn(0).setResizable(false);
		tabelateste.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabelateste.getColumnModel().getColumn(1).setResizable(false);
		tabelateste.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelateste.getColumnModel().getColumn(2).setResizable(false);
		tabelateste.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabelateste.getColumnModel().getColumn(3).setResizable(false);
		tabelateste.getColumnModel().getColumn(3).setPreferredWidth(100);
		tabelateste.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 84, 520, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(45, 6, 60, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00EDvel");
		lblNewLabel_3.setBounds(168, 6, 60, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Hash");
		lblNewLabel_1.setBounds(259, 6, 95, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(6, 26, 105, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblHash = new JLabel("Aguardando Hash");
		lblHash.setBounds(259, 31, 232, 15);
		panel.add(lblHash);
		
		JLabel lblDigitalConf = new JLabel("Digital N\u00E3o Inserida");
		lblDigitalConf.setBounds(259, 52, 95, 14);
		lblDigitalConf.setForeground(Color.RED);
		panel.add(lblDigitalConf);
		
		JButton btSalvar = new JButton("Salvar Dados");
		btSalvar.setEnabled(false);
		btSalvar.setBounds(6, 77, 105, 23);
		panel.add(btSalvar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.setEnabled(false);
		btExcluir.setBounds(132, 77, 96, 23);
		panel.add(btExcluir);
		
		JButton btnDigital = new JButton("Inserir Digital");
		btnDigital.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
			      file.setMultiSelectionEnabled(true);
			      FileNameExtensionFilter  imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
			      file.setFileFilter(imageFilter);
			      file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			      file.setFileHidingEnabled(false);
			      if (file.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			         java.io.File f = file.getSelectedFile();
			         UsuarioController u=new UsuarioController();
						try {
							String i=u.gerarHash(f);
							lblHash.setText(i);
							lblDigitalConf.setForeground(new Color(34, 139, 34));
							if(lblDigitalConf.getText()=="Digital Carregada Com Sucesso") {
								JOptionPane.showConfirmDialog(null, "Digital Atualizada Salve para confirmar");
								
							}
							lblDigitalConf.setText("Digital Carregada Com Sucesso");
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
		}});
		JLabel lblID = new JLabel("");
		lblID.setBounds(443, 6, 46, 14);
		panel.add(lblID);
		JSpinner txtPermissao = new JSpinner();
		txtPermissao.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		txtPermissao.setBounds(132, 26, 96, 20);
		panel.add(txtPermissao);
		tabelateste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					if(e.getClickCount() == 1){
			            Object obj= tabelateste.getValueAt(tabelateste.getSelectedRow(),0);
			            txtNome.setText((String) tabelateste.getValueAt(tabelateste.getSelectedRow(),1));
			            txtPermissao.setValue((Integer.parseInt(tabelateste.getValueAt(tabelateste.getSelectedRow(),3).toString())));
			            lblID.setText((String) tabelateste.getValueAt(tabelateste.getSelectedRow(),0));
			            lblHash.setText((String) tabelateste.getValueAt(tabelateste.getSelectedRow(),2));
						lblDigitalConf.setForeground(new Color(34, 139, 34));
						lblDigitalConf.setText("Digital Carregada Com Sucesso");
						btExcluir.setEnabled(true);
						btSalvar.setEnabled(true);
						

			        }
				
			}
		});
		btnDigital.setBounds(259, 77, 95, 23);
		panel.add(btnDigital);
		
		JButton btnNovoUsuario = new JButton("Inserir Novo Usu\u00E1rio");
		btnNovoUsuario.setBounds(379, 77, 131, 23);
		panel.add(btnNovoUsuario);
		
		JLabel lbl = new JLabel("ID:");
		lbl.setBounds(425, 6, 46, 14);
		panel.add(lbl);
		
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.setBounds(264, 240, 63, 23);
		contentPane.add(btLimpar);
		contentPane.add(lblDados);
		contentPane.add(lblUsuarioNivel);
		contentPane.add(scrollPane);
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText()!="" && (Integer)txtPermissao.getValue()!=0 && lblHash.getText()!="Aguardando Hash") {
				Usuario u=new Usuario();
				u.setHashdigital(lblHash.getText());
				u.setID(Integer.parseInt(lblID.getText()));
				u.setNome(txtNome.getText());
				u.setPermissao(Integer.parseInt(txtPermissao.getValue().toString()));
				u.Salvar();
				JOptionPane.showMessageDialog(null,"Usuario Salvo Com Sucesso");
				}else {
					JOptionPane.showMessageDialog(null,"Preencha Todos os Campos");
				}
			}
		});
		btnNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText()!="" && (Integer)txtPermissao.getValue()!=0 && lblHash.getText()!="Aguardando Hash") {
					Usuario u=new Usuario();
					u.setHashdigital(lblHash.getText());
					u.setNome(txtNome.getText());
					u.setPermissao(Integer.parseInt(txtPermissao.getValue().toString()));
					u.Adicionar();
					JOptionPane.showMessageDialog(null,"Usuario Inserido Com Sucesso");
				}else {
					JOptionPane.showMessageDialog(null,"Preencha Todos os Campos");
				}
			}
		});
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(lblID.getText()!="") {
				int input = JOptionPane.showConfirmDialog(null, 
		                "Tem Certeza?", "Essa e uma ação Permanente",JOptionPane.YES_NO_CANCEL_OPTION);
				if(input==0) {
					Usuario u=new Usuario();
					u.setHashdigital(lblHash.getText());
					u.setID(Integer.parseInt(lblID.getText()));
					u.setNome(txtNome.getText());
					u.setPermissao(Integer.parseInt(txtPermissao.getValue().toString()));
					u.Excluir();
					JOptionPane.showMessageDialog(null,"Usuario Deletado Com Sucesso");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum usuario foi carregado para exclusão");
			}
		}
		});
		
	}
}
