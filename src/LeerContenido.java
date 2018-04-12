import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.util.StringUtils;

public class LeerContenido {

	
	private static final String CADENA_XML = "<staticmap>\n" + 
			"            <mac>%s</mac>\n" + 
			"            <cid></cid>\n" + 
			"            <ipaddr>%s</ipaddr>\n" + 
			"            <hostname>%s</hostname>\n" + 
			"            <descr></descr>\n" + 
			"            <filename></filename>\n" + 
			"            <rootpath></rootpath>\n" + 
			"            <defaultleasetime></defaultleasetime>\n" + 
			"            <maxleasetime></maxleasetime>\n" + 
			"            <gateway></gateway>\n" + 
			"            <domain></domain>\n" + 
			"            <domainsearchlist></domainsearchlist>\n" + 
			"            <ddnsdomain></ddnsdomain>\n" + 
			"            <ddnsdomainprimary></ddnsdomainprimary>\n" + 
			"            <ddnsdomainkeyname></ddnsdomainkeyname>\n" + 
			"            <ddnsdomainkey></ddnsdomainkey>\n" + 
			"            <tftp></tftp>\n" + 
			"            <ldap></ldap>\n" + 
			"        </staticmap>";
	
	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader fr = new FileReader(archivo);
		BufferedReader bf = new BufferedReader(fr);
		while((cadena=bf.readLine()) != null) {
			
			StringTokenizer tokenizer = new StringTokenizer(cadena, ",");
			
			String dhcp[] = new String[5];
			for (int i=0;tokenizer.hasMoreTokens();i++) {
				
				String token = tokenizer.nextToken();
				
				dhcp[i] = token;
				
			}//fin while
			
			
			String xmldhcp = String.format(CADENA_XML, dhcp[3], dhcp[0], dhcp[1]);
			
			
			
			System.out.println(xmldhcp);
		}
		bf.close();
	}
		
	public static void main(String[] args) throws IOException {
		muestraContenido("/home/niko.gamula.ext/Factoria/Ficheros/dhcpdefinitivo.csv");
	}
}
