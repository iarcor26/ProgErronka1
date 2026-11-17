package kontrolagailua;

import ikuspegia.Kontsola;

public class Menua {
	public void inprimatu() {
		Kontsola.inprimatu("█   █ █████ █   █ █   █    █   █  ███   ███  █   █  ████ ███  ███      ");
		Kontsola.inprimatu("██ ██ █     ██  █ █   █    ██  █ █   █ █     █   █ █      █  █   █    ");
		Kontsola.inprimatu("█ █ █ ████  █ █ █ █   █    █ █ █ █████ █  ██ █   █  ███   █  █████   ");
		Kontsola.inprimatu("█   █ █     █  ██ █   █    █  ██ █   █ █   █ █   █     █  █  █   █  ");
		Kontsola.inprimatu("█   █ █████ █   █  ███     █   █ █   █  ███   ███  ████  ███ █   █ ");
		Kontsola.inprimatu("1.Langileak");
		Kontsola.inprimatu("2.Bezeroak");
		Kontsola.inprimatu("3.Fitxategiak kontsultatu");
		Kontsola.inprimatu("4.Irten");
	}

	public void inprimatuLangileak() {
		Kontsola.inprimatu("█      ███  █   █  ███  ███ █     █████  ███  █   █     ");
		Kontsola.inprimatu("█     █   █ ██  █ █      █  █     █     █   █ █  █     ");
		Kontsola.inprimatu("█     █████ █ █ █ █  ██  █  █     ████  █████ ███     ");
		Kontsola.inprimatu("█     █   █ █  ██ █   █  █  █     █     █   █ █  █   ");
		Kontsola.inprimatu("█████ █   █ █   █  ███  ███ █████ █████ █   █ █   █ ");
		Kontsola.inprimatu("1.Langile kontsulta");
		Kontsola.inprimatu("2.Nagusi kontsulta");
		Kontsola.inprimatu("3.Atzera joan");

	}

	public void inprimatuBezeroak() {
		Kontsola.inprimatu("████  █████ █████ █████ ████   ███      █   █ █████ █   █ █   █  ███       ");
		Kontsola.inprimatu("█   █ █        █  █     █   █ █   █     ██ ██ █     ██  █ █   █ █   █      ");
		Kontsola.inprimatu("████  ████    █   ████  ████  █   █     █ █ █ ████  █ █ █ █   █ █████      ");
		Kontsola.inprimatu("█   █ █      █    █     █  █  █   █     █   █ █     █  ██ █   █ █   █   ");
		Kontsola.inprimatu("████  █████ █████ █████ █   █  ███      █   █ █████ █   █  ███  █   █ ");
		Kontsola.inprimatu("1.Kontaktuak");
		Kontsola.inprimatu("2.Faktura sortu");
		Kontsola.inprimatu("3.Atzera joan");

	}

	public void inprimatuFitxategiak() {
		Kontsola.inprimatu("█████ ███ █████ █   █  ███  █████ █████  ███  ███    █   █ █████ █   █ █   █  ███       ");
		Kontsola.inprimatu("█      █    █    █ █  █   █   █   █     █      █     ██ ██ █     ██  █ █   █ █   █     ");
		Kontsola.inprimatu("████   █    █     █   █████   █   ████  █  ██  █     █ █ █ ████  █ █ █ █   █ █████      ");
		Kontsola.inprimatu("█      █    █    █ █  █   █   █   █     █   █  █     █   █ █     █  ██ █   █ █   █  ");
		Kontsola.inprimatu("█     ███   █   █   █ █   █   █   █████  ███  ███    █   █ █████ █   █  ███  █   █ ");
		Kontsola.inprimatu("1.Fakturak");
		Kontsola.inprimatu("2.Bezero");
		Kontsola.inprimatu("3.Langile");
		Kontsola.inprimatu("4.Bezero telefonoa");
		Kontsola.inprimatu("5.Eskariak");		
		Kontsola.inprimatu("6.Eskari zerrenda");
		Kontsola.inprimatu("7.Atzera joan");
	}

	public void inprimatuIrteera() {
		Kontsola.inprimatu("Saioa itxi nahi duzu? (Bai/Ez)");

	}

	public void inprimatuAkatasa() {
		Kontsola.inprimatu("aukeratu 1-4 arteko zenbakia mesedez");
	}

	public void inprimatuAkatasa2() {
		Kontsola.inprimatu("aukeratu 1-3arteko zenbakia mesedez");
	}

	public void inprimatuAkatasa3() {
		Kontsola.inprimatu("aukeratu 1-7 zenbakia mesedez");
	}
	public void agurtu() {
		Kontsola.inprimatu("Saioa itxi da. Agur!");
	}
	public void akatzaItxiSaioa() {
		Kontsola.inprimatu("aukeratu Bai edo Ez soilik!");
		IO.println();
	}

	public String getAukera() {

		String aukera = Teklatua.irakurri();
		return aukera;
	}
}
