package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.UsuarioController;
import Controller.UsuarioDao;
import Model.Usuario;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.FileFilter;
import java.io.IOException;
import java.math.BigInteger;
import java.awt.event.ActionEvent;


public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			
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
						String i=u.GerarHash(f);
						UsuarioDao logar= new UsuarioDao();
						Usuario login=null;
						login=logar.finallByCod(i);
						if(login!=null) {
							TelaInicial.this.dispose();
							Tela1 t=new Tela1(login);
							t.show();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			         
			      }
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(164)
					.addComponent(btnNewButton)
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(125))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
