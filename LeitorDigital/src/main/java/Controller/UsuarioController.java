package Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import Model.Usuario;

public class UsuarioController {
	public String gerarHash(File arquivo) throws Exception {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    FileInputStream fis = new FileInputStream(arquivo);
	    byte[] dataBytes = new byte[1024];
	    int nread = 0;
	    while ((nread = fis.read(dataBytes)) != -1) {
	        md.update(dataBytes, 0, nread);
	    }
	    byte[] mdbytes = md.digest();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < mdbytes.length; i++) {
	        sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	    return sb.toString();
	}
}