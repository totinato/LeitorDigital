package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Usuario;

public class UsuarioDao extends DAO {

		
		public void salvar(Usuario p) throws Exception {
			open();
			stmt = con.prepareStatement("insert into Usuario values(null,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setInt(2,p.getPermissao());
			stmt.setString(3,p.getHashdigital().toString());
			stmt.execute();
			stmt.close();
			close();
		}

		public void delete(Usuario p) throws Exception {

			open();
			stmt = con.prepareStatement("delete from Usuario where idUsuario = ?");
			stmt.setInt(1, p.getID());
			stmt.execute();
			stmt.close();
			close();
			/**/
		}

		public void update(Usuario p) throws Exception {

			open();
			stmt = con.prepareStatement("update Usuario set nome = ?, email = ? where idUsuario = ?");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getHashdigital().toString());
			stmt.setInt(3, p.getPermissao());
			stmt.setInt(4, p.getID());

			stmt.execute();
			stmt.close();
			close();

		}

		public Usuario finallByCod(String cod) throws Exception {

				open();
				stmt = con.prepareStatement("select * from Usuario where Hash ='"+cod+"'");
				rs = stmt.executeQuery();			
				Usuario p = null;
				if (rs.next()) {
					p = new Usuario();
					p.setNome(rs.getString("Nome"));
					p.setPermissao(rs.getInt("Permissao"));
					p.setID(rs.getInt("ID"));
					p.setHashdigital(rs.getString("Hash"));
				}
				close();
				return p;
		}
		public Usuario finallByCod(int cod) throws Exception {

			open();
			stmt = con.prepareStatement("select * from Usuario where ID ='"+cod+"'");
			rs = stmt.executeQuery();			
			Usuario p = null;
			if (rs.next()) {
				p = new Usuario();
				p.setNome(rs.getString("Nome"));
				p.setPermissao(rs.getInt("Permissao"));
				p.setID(rs.getInt("ID"));
				p.setHashdigital(rs.getString("Hash"));
			}
			close();
			return p;
	}

		public List<Usuario> findAll() {
			try {
				open();
				stmt = con.prepareStatement("select * from Usuario");
				rs = stmt.executeQuery();
				List<Usuario> lista = new ArrayList();
				Usuario p = new Usuario();
				while (rs.next()) {
					p.setNome(rs.getString("Nome"));
					p.setPermissao(rs.getInt("Permissao"));
					p.setID(rs.getInt("ID"));
					p.setHashdigital(rs.getString("Hash"));
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
