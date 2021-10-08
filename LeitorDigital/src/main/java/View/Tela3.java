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
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JButton;

public class Tela3 extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;
	private JTextField txtNome;
	private JTextField txtSetor;
	private JTextField txtPermissao;
	private JTextField txtCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela3 frame = new Tela3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Tela3() {
		setTitle("Editor de Funcion\u00E1rios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 519);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Perfil");
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenu mnNveis = new JMenu("Editar");
		mnNveis.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNveis);
		
		JMenu mnNewMenu_1_1 = new JMenu("Sobre");
		mnNewMenu_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuarioNivel = new JLabel("Registro de Funcionarios");
		
		JLabel lblDados = new JLabel("Dados do funcionario");
		
		JScrollPane scrollPane = new JScrollPane();
		
		tabelateste = new JTable();
		scrollPane.setViewportView(tabelateste);
		tabelateste.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabelateste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelateste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelateste.setModel(new DefaultTableModel(
			new Object[][] {
				{"Tela", "FX550", "SP", "2"},
				{"Retrovisor", "M9J", "RJ", "3"},
				{"Aviao", "F15", "MG", "1"},
				{"Carro", "F1", "SC", "7"},
			},
			new String[] {
				"Nome", "Setor", "Cargo", "Permissao"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
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
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("27px"),
				ColumnSpec.decode("496px:grow"),},
			new RowSpec[] {
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				RowSpec.decode("152px:grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("165px"),}));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "2, 3, center, center");
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
		
		JLabel lblNewLabel_1 = new JLabel("Setor");
		panel.add(lblNewLabel_1, "4, 2, center, default");
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		panel.add(lblNewLabel_2, "6, 2, center, default");
		
		JLabel lblNewLabel_3 = new JLabel("Permissao");
		panel.add(lblNewLabel_3, "8, 2, center, default");
		
		txtNome = new JTextField();
		panel.add(txtNome, "2, 4, fill, default");
		txtNome.setColumns(10);
		
		txtSetor = new JTextField();
		panel.add(txtSetor, "4, 4, fill, default");
		txtSetor.setColumns(10);
		
		txtCargo = new JTextField();
		panel.add(txtCargo, "6, 4, fill, default");
		txtCargo.setColumns(10);
		
		txtPermissao = new JTextField();
		panel.add(txtPermissao, "8, 4, fill, default");
		txtPermissao.setColumns(10);
		
		JButton btSalvar = new JButton("Salvar Dados");
		panel.add(btSalvar, "4, 8");
		
		JButton btExcluir = new JButton("Excluir");
		panel.add(btExcluir, "6, 8");
		
		JButton btLimpar = new JButton("Limpar");
		contentPane.add(btLimpar, "2, 5, center, center");
		contentPane.add(lblDados, "2, 6, left, top");
		contentPane.add(lblUsuarioNivel, "2, 2, left, top");
		contentPane.add(scrollPane, "2, 8, center, center");
	}
}
