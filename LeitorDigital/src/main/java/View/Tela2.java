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
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;

public class Tela2 extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2 frame = new Tela2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Tela2() {
		setTitle("Dados dos Funcion\u00E1rios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 388);
		
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
				FormSpecs.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("525px"),},
			new RowSpec[] {
				FormSpecs.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("14px"),
				FormSpecs.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("231px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		contentPane.add(lblDados, "2, 2, left, center");
		contentPane.add(scrollPane, "2, 4, center, center");
		
		JButton btVoltar = new JButton("Voltar");
		contentPane.add(btVoltar, "2, 6, center, center");
	}
}
