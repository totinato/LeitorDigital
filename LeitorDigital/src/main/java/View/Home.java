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
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import Model.Usuario;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public Home(Usuario u) {
		setTitle("AgroVisual - Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 239);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPerfil = new JMenu("Perfil");
		mnPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnPerfil);
		
		JMenu mnNveis = new JMenu("Editar");

		mnNveis.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNveis);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnSobre);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblUsuarioNivel = new JLabel("Usuario Nivel:"+u.getPermissao());
		lblUsuarioNivel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNivel = new JLabel("ID: "+u.getID());
		mnNveis.setEnabled(true);
		
		JMenuItem opcUsuario = new JMenuItem("Usuarios");
		opcUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DadosFuncionarios t=new DadosFuncionarios(u.getPermissao());
				t.show();
			}
		});
		mnNveis.add(opcUsuario);
		
		JMenuItem opcEmpresa = new JMenuItem("Empresas");
		opcEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DadosEmpresa t=new DadosEmpresa(u.getPermissao());
				t.show();
			}
		});
		mnNveis.add(opcEmpresa);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.this.dispose();
				TelaInicial t=new TelaInicial();
				t.show();
			}
		});
		mnSair.setForeground(Color.RED);
		menuBar.add(mnSair);
		if(u.getPermissao()==3) {
			JOptionPane.showMessageDialog(null,"seja bem vindo Administrador "+u.getNome());
		}
		if(u.getPermissao()==2) {
			JOptionPane.showMessageDialog(null,"seja bem vindo Usuario "+u.getNome());
			opcUsuario.setEnabled(false);
			
			
		}
		if(u.getPermissao()==1) {
			JOptionPane.showMessageDialog(null,"seja bem vindo visitante "+u.getNome());
			opcUsuario.setEnabled(false);
			
		}
		lblNivel.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("Seja bem-vindo(a)");
		
		JLabel lblNome = new JLabel("Nome: "+u.getNome());
		lblNome.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(142, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(134))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(85)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNivel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblUsuarioNivel, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
								.addGap(76)))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblUsuarioNivel, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNivel)
					.addGap(4)
					.addComponent(lblNome)
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(44))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
