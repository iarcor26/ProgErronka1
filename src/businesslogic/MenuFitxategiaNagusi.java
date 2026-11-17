package businesslogic;

import java.io.*;
import java.util.*;
import eredua.Langileak;
import ikuspegia.Kontsola;

public class MenuFitxategiaNagusi {

	private final String FITXATEGIA_BIDEA = "./src/businesslogic/langileak.txt";

	public void bilatuTeklatuz() {

		bilatu();

	}

	private void bilatu() {

		List<Langileak> zerrenda = langileakIrakurri();

		for (Langileak langileak : zerrenda) {

			Kontsola.inprimatu("\tIzena: " + langileak.getIzena());
			Kontsola.inprimatu("\tAbizena: " + langileak.getAbizena());
			Kontsola.inprimatu("\tEmaila: " + langileak.getEmaila());
			IO.println();

		}

	}

	private List<Langileak> langileakIrakurri() {

		List<Langileak> zerrenda = new ArrayList<>();

		try (FileReader fr = new FileReader(FITXATEGIA_BIDEA); BufferedReader br = new BufferedReader(fr)) {
			String lerroa;
			br.readLine();

			while ((lerroa = br.readLine()) != null) {
				String[] datuak = lerroa.split("\t");

				if (datuak.length >= 6) {
					zerrenda.add(new Langileak(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(), datuak[4].trim(),
							datuak[3].trim(), datuak[5].trim()));
				}
			}
		} catch (IOException akatza) {
			System.err.println("Errorea fitxategia irakurtzean: " + akatza.getMessage());
		}
		return zerrenda;
	}

}
