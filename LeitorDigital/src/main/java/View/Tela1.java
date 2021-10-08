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

public class Tela1 extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 frame = new Tela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 519);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Perfil");
		menuBar.add(mnNewMenu);
		
		JMenu mnNveis = new JMenu("Editar");
		menuBar.add(mnNveis);
		
		JMenu mnNewMenu_1_1 = new JMenu("Sobre");
		menuBar.add(mnNewMenu_1_1);
		
		JMenu mnNewMenu_1_1_1 = new JMenu("Ajuda");
		menuBar.add(mnNewMenu_1_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuarioNivel = new JLabel("Usuario Nivel");
		
		JLabel lblDados = new JLabel("Dados do funcion\u00E1rio");
		
		tabelateste = new JTable();
		tabelateste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabelateste.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Tipo", "Dado", "Estado", "N\u00EDvel"
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
		tabelateste.setForeground(Color.LIGHT_GRAY);
		tabelateste.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNivel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tabelateste, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDados)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsuarioNivel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNivel)))
					.addContainerGap(415, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuarioNivel)
						.addComponent(lblNivel))
					.addGap(57)
					.addComponent(lblDados)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabelateste, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(345, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
