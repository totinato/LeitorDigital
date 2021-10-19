package Model;

import java.util.List;

import Controller.EmpresaDao;

public class Empresa {
	private String Nome;
	private String Endereco;
	private String Cnpj;
	private String Cep;
	private String Ramo; 
	private String Agrotoxico;
	private String Toxidade;
	private int ID;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	EmpresaDao dao=new EmpresaDao();
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereço) {
		Endereco = endereço;
	}
	public String getCnpj() {
		return Cnpj;
	}
	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	public String getCep() {
		return Cep;
	}
	public void setCep(String cep) {
		Cep = cep;
	}
	public String getRamo() {
		return Ramo;
	}
	public void setRamo(String ramo) {
		Ramo = ramo;
	}
	public String getAgrotoxico() {
		return Agrotoxico;
	}
	public void setAgrotoxico(String agrotoxico) {
		Agrotoxico = agrotoxico;
	}
	public String getToxidade() {
		return Toxidade;
	}
	public void setToxidade(String toxidade) {
		Toxidade = toxidade;
	}
	
	public List<Empresa> Achartodos(){
		List<Empresa> b=dao.findAll();
		return b;
	}

}
