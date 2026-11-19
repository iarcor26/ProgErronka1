package businesslogic;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eredua.EskariLerroa;

import ikuspegia.Kontsola;

public class EskariLerroakFitxategia {

	private final String FITXATEGIAKO_BIDEA = "businesslogic/ESKARI_LERROAK.txt";

	public void bilatuTeklatuz() {
		bilatu();
	}

	private void bilatu() {
		List<EskariLerroa> zerrenda = eskariLerroIrakurri();

		for (EskariLerroa eskariLerroa : zerrenda) {
			{
				Kontsola.inprimatu("\tID Eskaria : " + eskariLerroa.getIdEskari());
				Kontsola.inprimatu("\tID lerroa: " + eskariLerroa.getIdLerro());
				Kontsola.inprimatu("\tID produktua: " + eskariLerroa.getIdProduktu());
				Kontsola.inprimatu("\tKopurua: " + eskariLerroa.getKopurua());
				Kontsola.inprimatu("\tSalneurria: " + eskariLerroa.getSalneurria() + "€");
				IO.println();
			}
		}
	}

	private List<EskariLerroa> eskariLerroIrakurri() {
		List<EskariLerroa> zerrenda = new ArrayList<>();
		try (StringReader irakurriFitxategiaEskariLerroa = new StringReader(Irakurri.irakurriJAR(FITXATEGIAKO_BIDEA));
				BufferedReader zatiHandiakIrakurri = new BufferedReader(irakurriFitxategiaEskariLerroa)) {
			String lerroa;
			while ((lerroa = zatiHandiakIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");
				if (datuak.length >= 5) {
					zerrenda.add(new EskariLerroa(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(),
							datuak[3].trim(), datuak[4].trim()));
				}
			}
		} catch (IOException arazoa) {
			System.err.println("Errorea fitxategia irakurtzean: " + arazoa.getMessage());
		}
		return zerrenda;
	}

}
