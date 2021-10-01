package Controller;

import java.util.List;

import Model.Usuario;

public class UsuarioDao extends DAO {

		
		public void salvar(Usuario p) throws Exception {
			open();
			stmt = con.prepareStatement("insert into Usuario values(null,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setInt(2,p.getPermissao());
			stmt.setInt(3,p.getHashdigital());
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

		}

		public void update(Usuario p) throws Exception {

			open();
			stmt = con.prepareStatement("update Usuario nome = ?, email = ? where idUsuario = ?");
			stmt.setString(1, p.getNome());
			stmt.setInt(2, p.getHashdigital());
			stmt.setInt(3, p.getPermissao());
			stmt.setInt(4, p.getID());

			stmt.execute();
			stmt.close();
			close();

		}

		public Usuario finallByCod(int cod) throws Exception {

				open();
				stmt = con.prepareStatement("select * from Usuario where idUsuario = ? ");
				rs = stmt.executeQuery();			
				Usuario p = null;
				if (rs.next()) {
					//p = new Usuario();
					//p.setIdUsuario(rs.getInt("idUsuario"));
					//p.setNomeUsuario(rs.getString("nomeUsuario"));
					//p.setEmail(rs.getString("email"));				
				}
				close();
				return p;
		}

		/*public List findAll() {
			try {
				open();
				stmt = con.prepareStatement("select * from Usuario");
				rs = stmt.executeQuery();
				List lista = new ArrayList();
				while (rs.next()) {
					Usuario p = new Usuario();
					p.setIdUsuario(rs.getInt("idUsuario"));
					p.setNomeUsuario(rs.getString("nomeUsuario"));
					p.setEmail(rs.getString("email"));
					lista.add(p);
				}
				close();
				return lista;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}

		}*/
}