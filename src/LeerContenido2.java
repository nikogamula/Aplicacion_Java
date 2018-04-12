import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.util.StringUtils;

public class LeerContenido2 {

	
	private static final String CADENA_XML = "<hosts>\n" + 
			"        <host> %s </host>\n" + 
			"        <domain>iad.ctcd.junta-andalucia.es</domain>\n" + 
			"        <ip> %s </ip>\n" + 
			"        <descr></descr>\n" + 
			"        <aliases></aliases>\n" + 
			"    </hosts>";
	
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader fr = new FileReader(archivo);
		BufferedReader bf = new BufferedReader(fr);
		while((cadena=bf.readLine()) != null) {
			
			StringTokenizer tokenizer = new StringTokenizer(cadena, ",");
			
			String dns[] = new String[5];
			for (int i=0;tokenizer.hasMoreTokens();i++) {
				
				String token = tokenizer.nextToken();
				
				dns[i] = token;
				
			}//fin while
			
			
			String xmldns = String.format(CADENA_XML, dns[0], dns[1]);
			
			
			
			System.out.println(xmldns);
		}
		bf.close();
	}
		
	public static void main(String[] args) throws IOException {
		muestraContenido("/home/niko.gamula.ext/Factoria/Ficheros/dns.csv");
	}
}