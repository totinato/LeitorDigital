package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.lang.model.element.NestingKind;
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

import Model.Empresa;

import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DadosEmpresa extends JFrame {

	private JPanel contentPane;
	private JTable tabelateste;

	/**
	 * Launch the application.
	 */
	public DadosEmpresa(int a) {
		setTitle("AgroVisual - Dados dos Empresa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 581, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDados = new JLabel("Dados do Empresa");
		lblDados.setBounds(15, 19, 101, 14);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 44, 452, 231);
		
		tabelateste = new JTable();
		tabelateste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					if(a==3) {
					Empresa em = new Empresa();
		            em.setID(Integer.parseInt( tabelateste.getValueAt(tabelateste.getSelectedRow(),0).toString()));
		            em.setNome(tabelateste.getValueAt(tabelateste.getSelectedRow(),1).toString());
		            em.setEndereco(tabelateste.getValueAt(tabelateste.getSelectedRow(),2).toString());
		            em.setCnpj(tabelateste.getValueAt(tabelateste.getSelectedRow(),3).toString());
		            em.setCep(tabelateste.getValueAt(tabelateste.getSelectedRow(),4).toString());
		            em.setRamo(tabelateste.getValueAt(tabelateste.getSelectedRow(),5).toString());
		            em.setAgrotoxico(tabelateste.getValueAt(tabelateste.getSelectedRow(),6).toString());
		            em.setToxidade(tabelateste.getValueAt(tabelateste.getSelectedRow(),7).toString());
		            EditarEmpresa ed= new EditarEmpresa(em);
		            ed.show();
					}else {
						JOptionPane.showMessageDialog(null, "Voce nao tem acesso para editar esses dados"+a);
						
					}
		        }
			}
		});
		scrollPane.setViewportView(tabelateste);
		tabelateste.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabelateste.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabelateste.setFont(new Font("Tahoma", Font.PLAIN, 11));
		List<Empresa> c=new Empresa().Achartodos();
		List y=null;
		int cont=0;
		int qtddados=0;
		if(a==1) {
			qtddados=3;
		}else if(a==2) {
			qtddados=6;
		}
		else {
			qtddados=8;
		}
		String[] titulos=new String[qtddados];
		if(a>=1) {
			titulos[0]="ID";
			titulos[1]="Nome";
			titulos[2]="Cep";
		}
		if(a>=2) {
			titulos[3]="Cnpj";
			titulos[4]="Endereço";
			titulos[5]="Ramo";
		}
		if(a>=3) {
			titulos[6]="Agrotoxico";
			titulos[7]="Toxicidade";
		}
		
		Object[][] ob=new String[c.size()][qtddados];
        int i=0;
        for (Empresa mov : c) {
            ob[i][0]=String.valueOf(mov.getID());
            ob[i][1]=String.valueOf(mov.getNome());
            ob[i][2]=String.valueOf(mov.getCep());
            if(a>1) {
	            ob[i][3]=String.valueOf(mov.getCnpj());
	            ob[i][4]=String.valueOf(mov.getEndereco());
	            ob[i][5]=String.valueOf(mov.getRamo());
		            if(a==3) {
		            ob[i][6]=String.valueOf(mov.getAgrotoxico());
		            ob[i][7]=String.valueOf(mov.getToxidade());
		            }
            }
            i++;
        }
        
		
		tabelateste.setModel(new DefaultTableModel(ob,titulos) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabelateste.setForeground(Color.BLACK);
		contentPane.setLayout(null);
		contentPane.add(lblDados);
		contentPane.add(scrollPane);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmpresa addemp=new AddEmpresa();
				addemp.show();
			}
		});
		btnInserir.setBounds(55, 281, 88, 23);
		contentPane.add(btnInserir);
	}
}
