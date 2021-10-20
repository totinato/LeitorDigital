package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Controller.UsuarioDao;
import Model.Usuario;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DadosFuncionarios extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;
	private JTextField txtNome;
	private JTextField txtPermissao;

	/**
	 * Launch the application.
	 */
	public DadosFuncionarios(int a) {
		setTitle("Editor de Funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 519);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnPerfil);
		
		JMenu mnNveis = new JMenu("Editar");
		mnNveis.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNveis);
		
		JMenuItem opcUsuario = new JMenuItem("Usuario");
		mnNveis.add(opcUsuario);
		
		JMenuItem opcEmpresa = new JMenuItem("Empresa");
		mnNveis.add(opcEmpresa);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblUsuarioNivel = new JLabel("Registro de Funcionarios");
		lblUsuarioNivel.setBounds(32, 19, 118, 14);
		
		JLabel lblDados = new JLabel("Dados do funcionario");
		lblDados.setBounds(32, 263, 101, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 288, 452, 165);
		
		tabelateste = new JTable();
		tabelateste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

					if(e.getClickCount() == 1){
			            Object obj= tabelateste.getValueAt(tabelateste.getSelectedRow(),0);
			            txtNome.setText((String) tabelateste.getValueAt(tabelateste.getSelectedRow(),1));
			            txtPermissao.setText((String) tabelateste.getValueAt(tabelateste.getSelectedRow(),3));
			            /*Usuario u=null;
			            u.pegarusuario(obj.toString());*/

			        }
				
			}
		});
		scrollPane.setViewportView(tabelateste);
		tabelateste.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabelateste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelateste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		List<Usuario> c=new Usuario().Achartodos();
		List y=null;
		int cont=0;
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
				"ID", "Nome", "Hash", "Permissao"
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
		panel.setBounds(174, 83, 243, 100);
		contentPane.add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Nome");
		panel.add(lblNewLabel, "2, 2, center, default");
		
		JLabel lblNewLabel_3 = new JLabel("Permissao");
		panel.add(lblNewLabel_3, "6, 2, center, default");
		
		txtNome = new JTextField();
		panel.add(txtNome, "2, 4, fill, default");
		txtNome.setColumns(10);
		
		txtPermissao = new JTextField();
		panel.add(txtPermissao, "6, 4, fill, default");
		txtPermissao.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar Dados");
		panel.add(btSalvar, "2, 8");
		
		JButton btExcluir = new JButton("Excluir");
		panel.add(btExcluir, "6, 8");
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.setBounds(264, 240, 63, 23);
		contentPane.add(btLimpar);
		contentPane.add(lblDados);
		contentPane.add(lblUsuarioNivel);
		contentPane.add(scrollPane);
	}
}
