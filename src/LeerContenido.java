import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerContenido {

	public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
		String cadena;
		FileReader fr = new FileReader(archivo);
		BufferedReader bf = new BufferedReader(fr);
		while((cadena=bf.readLine()) != null) {
			System.out.println(cadena);
		}
		bf.close();
	}
		
	public static void main(String[] args) throws IOException {
		muestraContenido("/home/niko.gamula.ext/Factoria/Ficheros/dhcpdefinitivo.csv");
	}
}
