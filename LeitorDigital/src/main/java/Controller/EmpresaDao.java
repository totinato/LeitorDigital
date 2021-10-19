package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Empresa;
import Model.Empresa;

public class EmpresaDao extends DAO {

		
		public void salvar(Empresa p) throws Exception {
			open();
			stmt = con.prepareStatement("insert into Empresa values(null,?,?,?,?,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getEndereco());
			stmt.setString(3, p.getCnpj());
			stmt.setString(4, p.getCep());
			stmt.setString(5, p.getRamo());
			stmt.setString(6, p.getAgrotoxico());
			stmt.setString(7, p.getToxidade());
			stmt.execute();
			stmt.close();
			close();
		}

		public void delete(Empresa p) throws Exception {

			open();
			stmt = con.prepareStatement("delete from Empresa where idEmpresa = ?");
			stmt.setInt(1, p.getID());
			stmt.execute();
			stmt.close();
			close();
			/**/
		}

		public void update(Empresa p) throws Exception {

			open();
			stmt = con.prepareStatement("update Empresa set nome = ?, email = ? where idEmpresa = ?");
			stmt.setString(1, p.getNome());
			stmt.setString(1, p.getEndereco());
			stmt.setString(1, p.getCnpj());
			stmt.setString(1, p.getCep());
			stmt.setString(1, p.getRamo());
			stmt.setString(1, p.getAgrotoxico());
			stmt.setString(1, p.getToxidade());
			stmt.setInt(4, p.getID());

			stmt.execute();
			stmt.close();
			close();

		}

		public Empresa finallByCod(String cod) throws Exception {

				open();
				stmt = con.prepareStatement("select * from Empresa where Hash ='"+cod+"'");
				rs = stmt.executeQuery();			
				Empresa p = null;
				if (rs.next()) {
					p = new Empresa();
					p.setID(rs.getInt("ID"));
					p.setNome(rs.getString("Nome"));
					p.setEndereco(rs.getString("Endereco"));
					p.setCnpj(rs.getString("Cnpj"));
					p.setCep(rs.getString("Cep"));
					p.setRamo(rs.getString("Ramo"));
					p.setAgrotoxico(rs.getString("Agrotoxico"));
					p.setToxidade(rs.getString("Toxidade"));
				}
				close();
				return p;
		}
		public Empresa finallByCod(int cod) throws Exception {

			open();
			stmt = con.prepareStatement("select * from Empresa where ID ='"+cod+"'");
			rs = stmt.executeQuery();			
			Empresa p = null;
			if (rs.next()) {
				p = new Empresa();
				p.setID(rs.getInt("ID"));
				p.setNome(rs.getString("Nome"));
				p.setEndereco(rs.getString("Endereco"));
				p.setCnpj(rs.getString("Cnpj"));
				p.setCep(rs.getString("Cep"));
				p.setRamo(rs.getString("Ramo"));
				p.setAgrotoxico(rs.getString("Agrotoxico"));
				p.setToxidade(rs.getString("Toxidade"));
			}
			close();
			return p;
	}

		public List<Empresa> findAll() {
			try {
				open();
				stmt = con.prepareStatement("select * from Empresa");
				rs = stmt.executeQuery();
				List<Empresa> lista = new ArrayList();
				Empresa p = new Empresa();
				while (rs.next()) {
					p.setID(rs.getInt("ID"));
					p.setNome(rs.getString("Nome"));
					p.setEndereco(rs.getString("Endereco"));
					p.setCnpj(rs.getString("Cnpj"));
					p.setCep(rs.getString("Cep"));
					p.setRamo(rs.getString("Ramo"));
					p.setAgrotoxico(rs.getString("Agrotoxico"));
					p.setToxidade(rs.getString("Toxidade"));
					lista.add(p);
				}
				close();
				return lista;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}

		}
	}
