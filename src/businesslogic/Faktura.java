package businesslogic;

import java.io.*;
import java.util.*;

import eredua.Bezeroak;
import eredua.EskariLerroa;
import ikuspegia.Kontsola;

public class Faktura {
	private final String FITXATEGIA_FAKTURAK = "FAKTURAK.txt";
	private final String FITXATEGIA_LERROAK = "businesslogic/ESKARI_LERROAK.txt";
	private final String FITXATEGIA_ESKARIAK = "businesslogic/ESKARIAK.txt";
	private final String FITXATEGIA_BEZEROA = "businesslogic/bezeroak.txt";
	private String bilatuIdBezeroa;
	private String bilatuIdEskaria;
	private Boolean topatuDa;
	private Boolean eskariakIzan;
	private Boolean lerroakIzan;
	private Integer kopurua = 0;
	private Double salneurria;
	private double guztiraBeza = 0.0;
	private double guztira = 0.0;

	public void bilatuTeklatuz() {
		eskatu();
		bilatu();

	}

	private void eskatu() {
		Kontsola.inprimatu("Sartu Bezeroaren id : ");
		bilatuIdBezeroa = kontrolagailua.Teklatua.irakurri().trim();

	}

	private void bilatu() {
		topatuDa = false;
		List<Bezeroak> zerrendaBezero = bezeroakIrakurri();

		for (Bezeroak bezeroak : zerrendaBezero) {

			if ((bilatuIdBezeroa != null && bezeroak.getId().trim().equals(bilatuIdBezeroa))) {

				topatuDa = true;

				Kontsola.inprimatu("\tIzena: " + bezeroak.getIzena() + "\tAbizena: " + bezeroak.getAbizena()
						+ "\tEmaila: " + bezeroak.getEmaila() + "\tHelbidea: " + bezeroak.getHelbidea());
				inprimatuEskariak(bezeroak.getId().trim());

				Kontsola.inprimatu("Aukeratu Eskaria zenbakia: ");
				bilatuIdEskaria = kontrolagailua.Teklatua.irakurri().trim();
				salneurriGuztira();

				Kontsola.inprimatu("\tIzena: " + bezeroak.getIzena() + "\tAbizena: " + bezeroak.getAbizena()
						+ "\tEmaila: " + bezeroak.getEmaila() + "\tHelbidea: " + bezeroak.getHelbidea());

				inprimatuLerroak(bezeroak.getId().trim());

				Kontsola.inprimatu("\tGuztira: \t\t\t\t\t\t" + guztira + " €");
				Kontsola.inprimatu("\tGuztira Bez-a aplikatuta x (%16): \t\t\t" + guztiraBeza + " €");
				if (lerroakIzan) {
					gordeFaktura(bezeroak);
				}
				break;
			}
		}

		if (topatuDa == false) {
			Kontsola.inprimatu("Ez da bezeroa topatu.\n");
		}

	}

	private void inprimatuEskariak(String idBezeroa) {
		Kontsola.inprimatu("\tBEZEROAREN ESKARIAK");
		try (StringReader irakurriFitxategiEskariak = new StringReader(Irakurri.irakurriJAR(FITXATEGIA_ESKARIAK));
				BufferedReader zatiHandiakIrakurri = new BufferedReader(irakurriFitxategiEskariak)) {

			String lerroa;
			zatiHandiakIrakurri.readLine();

			eskariakIzan = false;
			while ((lerroa = zatiHandiakIrakurri.readLine()) != null) {
				String[] datuak = lerroa.split("\t");
				if (datuak.length >= 2 && datuak[1].trim().equals(idBezeroa)) {
					eskariakIzan = true;

					Kontsola.inprimatu("\tEskaria ID: " + datuak[0] + "\tBezeroaren ID: " + datuak[1] + "\tData: "
							+ datuak[3] + "\n");
				}
			}
			if (eskariakIzan == false) {
				Kontsola.inprimatu("\tBezero honek ez du eskariik.\n");
			}
		} catch (IOException akatza) {
			System.err.println("Errorea eskariak irakurtzean: " + akatza.getMessage());
		}
	}

	private List<EskariLerroa> eskariLerroIrakurri() {
		List<EskariLerroa> zerrenda = new ArrayList<>();
		try (StringReader fr = new StringReader(Irakurri.irakurriJAR(FITXATEGIA_LERROAK)); BufferedReader br = new BufferedReader(fr)) {
			String lerroa;
			br.readLine();
			while ((lerroa = br.readLine()) != null) {
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

	private List<Bezeroak> bezeroakIrakurri() {
		List<Bezeroak> zerrenda = new ArrayList<>();

		try (StringReader irakurriFitxategiaBezeroak = new StringReader(Irakurri.irakurriJAR(FITXATEGIA_BEZEROA));
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

	private void salneurriGuztira() {

		List<EskariLerroa> lerroak = eskariLerroIrakurri();
		guztira = 0;
		lerroakIzan = false;

		Kontsola.inprimatu(bilatuIdEskaria);

		for (EskariLerroa lerroa : lerroak) {
			if (lerroa.getIdEskari().equals(bilatuIdEskaria)) {
				lerroakIzan = true;

				kopurua = Integer.valueOf(lerroa.getKopurua());
				salneurria = Double.valueOf(lerroa.getSalneurria().replace(',', '.'));
			
				guztira = guztira + kopurua * salneurria;
			}
		}

		if (lerroakIzan == false) {
			Kontsola.inprimatu("\tEskari honek ez dauka lerrorik.");

			return;
		}
		guztira = (long) (guztira * 100 + 0.5) / 100.0;
		guztiraBeza = (long) (guztira * 1.16 * 100 + 0.5) / 100.0;
	}

	private void inprimatuLerroak(String IdEskari) {
		List<EskariLerroa> lerroak = eskariLerroIrakurri();
		boolean lerroakIzan = false;

		for (EskariLerroa lerroa : lerroak) {
			if (lerroa.getIdEskari().equals(bilatuIdEskaria)) {
				lerroakIzan = true;
				Kontsola.inprimatu("\tEskaria ID: " + lerroa.getIdEskari() + "\tProduktua ID: " + lerroa.getIdProduktu()
						+ "\tKopurua: " + lerroa.getKopurua() + "\tSalneurria: " + lerroa.getSalneurria() + " €\n");
			}
		}

		if (!lerroakIzan) {
			Kontsola.inprimatu("\tEskari honek ez dauka lerrorik.\n");
		}
	}

	private void gordeFaktura(Bezeroak bezeroak) {
		try (FileWriter fitxategiakIdatzi = new FileWriter(FITXATEGIA_FAKTURAK, true);
				BufferedWriter zatiHandikoFitxategiak = new BufferedWriter(fitxategiakIdatzi);
				PrintWriter idatziFitxategia = new PrintWriter(zatiHandikoFitxategiak)) {

			idatziFitxategia.println("__________________________________________________");
			idatziFitxategia.println("FAKTURA  ");
			idatziFitxategia.println(
					"Bezeroa: " + bezeroak.getId().trim() + " | " + bezeroak.getIzena() + " " + bezeroak.getAbizena());
			idatziFitxategia.println("Emaila: " + bezeroak.getEmaila() + " | Helbidea: " + bezeroak.getHelbidea());
			idatziFitxategia.println("Eskaria ID: " + bilatuIdEskaria);
			idatziFitxategia.println("__________________________________________________");

			for (EskariLerroa lerroa : eskariLerroIrakurri()) {
				if (lerroa.getIdEskari().equals(bilatuIdEskaria)) {
					idatziFitxategia.println("Produktua: " + lerroa.getIdProduktu() + "\tKopurua: "
							+ lerroa.getKopurua() + "\tSalneurria: " + lerroa.getSalneurria() + " €");
				}
			}

			idatziFitxategia.println("__________________________________________________");
			idatziFitxategia.println("Guztira: " + guztira + " €");
			idatziFitxategia.println("Guztira BEZ-a aplikatuta (%16): " + guztiraBeza + " €");
			idatziFitxategia.println();

			Kontsola.inprimatu("\tFaktura gorde da: " + FITXATEGIA_FAKTURAK);

		} catch (IOException akatza) {
			System.err.println("Errorea faktura gordetzean: " + akatza.getMessage());
		}
	}
}