package businesslogic;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eredua.Eskaria;
import ikuspegia.Kontsola;

public class EskariakFitxategia {
	private final String FITXATEGIAKO_BIDEA = "businesslogic/ESKARIAK.txt";

	public void bilatuTeklatuz() {
		bilatu();
	}

	private void bilatu() {
		List<Eskaria> zerrenda = bezeroakIrakurri();

		for (Eskaria eskaria : zerrenda) {
			{
				Kontsola.inprimatu("\tID Eskaria : " + eskaria.getId());
				Kontsola.inprimatu("\tID bezeroa: " + eskaria.getIdBezero());
				Kontsola.inprimatu("\tID egoera: " + eskaria.getIdEgoera());
				Kontsola.inprimatu("\tEskaera data: " + eskaria.getEskaeraData());
				IO.println();
			}
		}
	}

	private List<Eskaria> bezeroakIrakurri() {
		List<Eskaria> zerrenda = new ArrayList<>();
		try (StringReader irakurriFitxategiakEskariak = new StringReader(Irakurri.irakurriJAR(FITXATEGIAKO_BIDEA));
				BufferedReader zatiHandietanIrakurri = new BufferedReader(irakurriFitxategiakEskariak)) {
			String lerroa;
			while ((lerroa = zatiHandietanIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");
				if (datuak.length >= 4) {
					zerrenda.add(new Eskaria(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(), datuak[3].trim()));
				}
			}
		} catch (IOException arazoa) {
			System.err.println("Errorea fitxategia irakurtzean: " + arazoa.getMessage());
		}
		return zerrenda;
	}

}
