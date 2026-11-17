package businesslogic;

import java.io.*;
import java.util.*;
import ikuspegia.Kontsola;

import eredua.Bezeroak;

public class MenuFitxategiaBezeroak {
	private final String FITXATEGIAKO_BIDEA = "./src/businesslogic/bezeroak.txt";
	private final String FITXATEGIAKO_BIDEA2 = "./src/businesslogic/BEZERO_TELEFONOAK.txt";

	private String telefonoa;
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
		bilatzekoBalioaIzena = kontrolagailua.Teklatua.irakurri().trim();
		Kontsola.inprimatu("Sartu bilatzeko abizena (Eman 'enter' baliorik ez badakizu) : ");
		bilatzekoBalioaAbizena = kontrolagailua.Teklatua.irakurri().trim();
		Kontsola.inprimatu("Sartu bilatzeko id (Eman 'enter' baliorik ez badakizu) : ");
		bilatzekoBalioaId = kontrolagailua.Teklatua.irakurri().trim();
	}

	private void bilatu() {
		topatuDa = false;
		List<Bezeroak> zerrenda = bezeroakIrakurri();
		Map<String, String> telefonoamapa = bezeroTelefonoakIrakurri();
		for (Bezeroak bezeroak : zerrenda) {
			if ((bilatzekoBalioaIzena != null && bezeroak.getIzena().equalsIgnoreCase(bilatzekoBalioaIzena))
					|| (bilatzekoBalioaAbizena != null
							&& bezeroak.getAbizena().trim().equalsIgnoreCase(bilatzekoBalioaAbizena))
					|| (bilatzekoBalioaId != null && bezeroak.getId().trim().equals(bilatzekoBalioaId)))

			{

				topatuDa = true;

				Kontsola.inprimatu("\tIzena: " + bezeroak.getIzena());
				Kontsola.inprimatu("\tAbizena: " + bezeroak.getAbizena());
				Kontsola.inprimatu("\tEmaila: " + bezeroak.getEmaila());
				Kontsola.inprimatu("\tHelbidea: " + bezeroak.getHelbidea());

				telefonoa = telefonoamapa.get(bezeroak.getId().trim());
				Kontsola.inprimatu("\tTelefonoa: " + telefonoa);

			}
		}

		if (topatuDa == false) {
			Kontsola.inprimatu("\tEz da bezerorik aurkitu.");
		}
	}

	private List<Bezeroak> bezeroakIrakurri() {

		List<Bezeroak> zerrenda = new ArrayList<>();

		try (FileReader irakurriFitxategiaBezeroak = new FileReader(FITXATEGIAKO_BIDEA);
				BufferedReader zatiHandiakIrakurri = new BufferedReader(irakurriFitxategiaBezeroak)) {
			String lerroa;
			zatiHandiakIrakurri.readLine();

			while ((lerroa = zatiHandiakIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");

				if (datuak.length >= 5) {
					zerrenda.add(new Bezeroak(datuak[0].trim(), datuak[1].trim(), datuak[2].trim(), datuak[4].trim(),
							datuak[3].trim()));
				}
			}
		} catch (IOException akatza) {
			System.err.println("Errorea fitxategia irakurtzean: " + akatza.getMessage());
		}
		return zerrenda;
	}

	private Map<String, String> bezeroTelefonoakIrakurri() {

		Map<String, String> telefonoMapa = new HashMap<String, String>();

		try (FileReader irakurriFitxategiaBezeroak = new FileReader(FITXATEGIAKO_BIDEA2);
				BufferedReader zatiHandiakIrakurri = new BufferedReader(irakurriFitxategiaBezeroak)) {
			String lerroa;
			zatiHandiakIrakurri.readLine();

			while ((lerroa = zatiHandiakIrakurri.readLine()) != null) {
				String[] datuak2 = lerroa.split("\t");

				if (datuak2.length >= 3) {
					telefonoMapa.put(datuak2[1], datuak2[2]);
				}
			}
		} catch (IOException akatza) {
			System.err.println("Errorea fitxategia irakurtzean: " + akatza.getMessage());
		}
		return telefonoMapa;
	}

}