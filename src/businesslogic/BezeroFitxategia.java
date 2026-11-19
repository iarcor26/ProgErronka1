package businesslogic;

import java.io.*;
import java.util.*;
import eredua.Bezeroak;
import ikuspegia.Kontsola;

public class BezeroFitxategia {

	private final String FITXATEGIAKO_BIDEA = "businesslogic/bezeroak.txt";

	public void bilatuTeklatuz() {
		bilatu();
	}

	private void bilatu() {
		List<Bezeroak> zerrenda = bezeroakIrakurri();

		for (Bezeroak bezeroak : zerrenda) {
			{
				Kontsola.inprimatu("\tID: " + bezeroak.getId());
				Kontsola.inprimatu("\tIzena: " + bezeroak.getIzena());
				Kontsola.inprimatu("\tAbizena: " + bezeroak.getAbizena());
				Kontsola.inprimatu("\tEmaila: " + bezeroak.getEmaila());
				Kontsola.inprimatu("\tHelbidea: " + bezeroak.getHelbidea());
				IO.println();
			}
		}
	}

	private List<Bezeroak> bezeroakIrakurri() {
		List<Bezeroak> zerrenda = new ArrayList<>();
		try (StringReader irakurriFitxategiBezeroak = new StringReader(Irakurri.irakurriJAR(FITXATEGIAKO_BIDEA));
				BufferedReader zatiHandietanIrakurri = new BufferedReader(irakurriFitxategiBezeroak)) {
			String lerroa;
			zatiHandietanIrakurri.readLine();
			while ((lerroa = zatiHandietanIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");
				if (datuak.length >= 5) {
					zerrenda.add(new Bezeroak(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(), datuak[4].trim(),
							datuak[3].trim()));
				}
			}
		} catch (IOException arazoa) {
			System.err.println("Errorea fitxategia irakurtzean: " + arazoa.getMessage());
		}
		return zerrenda;
	}
}
