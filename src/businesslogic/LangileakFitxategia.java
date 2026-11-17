package businesslogic;

import java.io.*;
import java.util.*;
import eredua.Langileak;
import ikuspegia.Kontsola;

public class LangileakFitxategia {

	private final String FITXATEGIA_BIDEA = "./src/businesslogic/langileak.txt";
	private String bilatzekoBalioaIzena;
	private String bilatzekoBalioaId;
	private String bilatzekoBalioaAbizena;
	private Boolean topatuDa;

	public void bilatuTeklatuz() {
		eskatu();
		bilatu();

	}

	private void eskatu() {
		Kontsola.inprimatu("Sartu bilatzeko izena (Eman 'enter' baliorik ez badakizu) : ");
		IO.println();
		bilatzekoBalioaIzena = kontrolagailua.Teklatua.irakurri().trim();
		Kontsola.inprimatu("Sartu bilatzeko abizena (Eman 'enter' baliorik ez badakizu) : ");
		bilatzekoBalioaAbizena = kontrolagailua.Teklatua.irakurri().trim();
		Kontsola.inprimatu("Sartu bilatzeko id (Eman 'enter' baliorik ez badakizu) : ");
		bilatzekoBalioaId = kontrolagailua.Teklatua.irakurri().trim();
	}

	private void bilatu() {
		topatuDa = false;
		List<Langileak> zerrenda = langileakIrakurri();

		for (Langileak langileak : zerrenda) {

			if ((bilatzekoBalioaIzena != null && langileak.getIzena().equalsIgnoreCase(bilatzekoBalioaIzena))
					|| (bilatzekoBalioaAbizena != null
							&& langileak.getAbizena().trim().equalsIgnoreCase(bilatzekoBalioaAbizena))
					|| (bilatzekoBalioaId != null && langileak.getId().trim().equals(bilatzekoBalioaId)))

			{

				topatuDa = true;

				Kontsola.inprimatu("\tIzena: " + langileak.getIzena());
				Kontsola.inprimatu("\tAbizena: " + langileak.getAbizena());
				Kontsola.inprimatu("\tTelefonoa: " + langileak.getTelefonoa());
				Kontsola.inprimatu("\tAlta Eguna: " + langileak.getAltaeguna());

			}
		}

		if (topatuDa == false) {
			Kontsola.inprimatu("\tEz da langilerik aurkitu.");
		}
	}

	private List<Langileak> langileakIrakurri() {

		List<Langileak> zerrenda = new ArrayList<>();

		try (FileReader irakurriFitxategiBezeroak = new FileReader(FITXATEGIA_BIDEA);
				BufferedReader zatiHandietanIrakurri = new BufferedReader(irakurriFitxategiBezeroak)) {
			String lerroa;
			while ((lerroa = zatiHandietanIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");

				if (datuak.length >= 6) {
					zerrenda.add(new Langileak(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(), datuak[4].trim(),
							datuak[3].trim(), datuak[5].trim()));
				}
			}
		} catch (IOException akatza) {
			System.err.println("Akatza fitxategia irakurtzean: " + akatza.getMessage());
		}
		return zerrenda;
	}

}
