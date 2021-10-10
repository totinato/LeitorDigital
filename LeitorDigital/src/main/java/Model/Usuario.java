package Model;

import java.io.File;
import Controller.UsuarioDao;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import Controller.UsuarioController;
import javafx.util.converter.BigIntegerStringConverter;

public class Usuario {
	private String Nome;
	private int Permissao;
	private File digital;
	private String hashdigital;
	UsuarioDao dao=new UsuarioDao();
	
	
	public String getHashdigital() {
		return hashdigital;
	}
	public void setHashdigital(File digital){
		UsuarioController u= new UsuarioController();
		try {
			hashdigital=u.GerarHash(digital);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setHashdigital(String hash){
		hashdigital=hash;
	}
	/**/
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public int getPermissao() {
		return Permissao;
	}
	public void setPermissao(int permissao) {
		Permissao = permissao;
	}
	public File getDigital() {
		return digital;
	}
	public void setDigital(File digital) {
		this.digital = digital;
	}
	public Usuario pegarusuario(String a) {
		try {
			
			return dao.finallByCod(Integer.parseInt(a));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Usuario p=null;
			return p;
		}
	}
	public List<Usuario> Achartodos(){
		List<Usuario> b=dao.findAll();
		return b;
	}
		
		
	
	
}
