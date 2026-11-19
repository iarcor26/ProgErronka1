package businesslogic;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eredua.BezeroTelefonoak;
import ikuspegia.Kontsola;

public class TelefonoakFitxategia {

	private final String FITXATEGIAKO_BIDEA = "businesslogic/BEZERO_TELEFONOAK.txt";

	public void bilatuTeklatuz() {
		bilatu();
	}

	private void bilatu() {
		List<BezeroTelefonoak> zerrenda = telefonoakIrakurri();

		for (BezeroTelefonoak bezeroTelefonoak : zerrenda) {
			{
				Kontsola.inprimatu("\tID: " + bezeroTelefonoak.getIdBezero());
				Kontsola.inprimatu("\tZenbakia: " + bezeroTelefonoak.getZenbakia());

				IO.println();
			}
		}
	}

	private List<BezeroTelefonoak> telefonoakIrakurri() {
		List<BezeroTelefonoak> zerrenda = new ArrayList<>();
		try (StringReader irakurriFitxategiaTelefonoak = new StringReader(Irakurri.irakurriJAR(FITXATEGIAKO_BIDEA));
				BufferedReader zatiHandiakIrakurri = new BufferedReader(irakurriFitxategiaTelefonoak)) {
			String lerroa;
			zatiHandiakIrakurri.readLine();

			while ((lerroa = zatiHandiakIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");
				if (datuak.length >= 3) {
					zerrenda.add(new BezeroTelefonoak(datuak[1].trim(), datuak[2].trim()));
				}
			}
		} catch (IOException arazoa) {
			System.err.println("Errorea fitxategia irakurtzean: " + arazoa.getMessage());
		}
		return zerrenda;
	}

}
