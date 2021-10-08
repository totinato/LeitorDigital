package Controller;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

import Model.Usuario;
import dev.brachtendorf.jimagehash.hash.Hash;
import dev.brachtendorf.jimagehash.hashAlgorithms.*;

public class UsuarioController {
	public void Cadastrar(Usuario usuario) {
		
		
	}
	public String GerarHash(File a) throws IOException {
		HashingAlgorithm hasher = new PerceptiveHash(32);

		Hash hash0 = hasher.hash(a);
		
		return hash0.getHashValue().toString();
		/**/
				
	}

}
