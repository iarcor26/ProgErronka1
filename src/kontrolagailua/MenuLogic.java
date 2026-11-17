package kontrolagailua;

import businesslogic.BezeroFitxategia;
import businesslogic.EskariLerroakFitxategia;
import businesslogic.EskariakFitxategia;
import businesslogic.Faktura;
import businesslogic.MenuFitxategiLangileak;
import businesslogic.MenuFitxategiaBezeroak;
import businesslogic.MenuFitxategiaFaktura;
import businesslogic.LangileakFitxategia;
import businesslogic.MenuFitxategiaNagusi;
import businesslogic.TelefonoakFitxategia;

public class MenuLogic {

	String FitxategiAukera;
	String LangileAukera;
	String BezeroAukera;
	String IrteeraAukera;
	String AkatzaAukera;

	Menua menuaNag = new Menua();
	Menua menuIrteera = new Menua();
	Menua menuaLangilea = new Menua();
	Menua menuaBezeroa = new Menua();
	Menua menuaFitxategi = new Menua();
	Menua menuaAkatza = new Menua();


	MenuFitxategiaFaktura fitxFakturakIrakurri = new MenuFitxategiaFaktura();
	LangileakFitxategia fitxLangile = new LangileakFitxategia();
	MenuFitxategiaBezeroak fitxBezero = new MenuFitxategiaBezeroak();
	MenuFitxategiaNagusi fitxNagusi = new MenuFitxategiaNagusi();
	BezeroFitxategia fitxBezeroakIrakurri = new BezeroFitxategia();
	MenuFitxategiLangileak fitxlangileakIrakurri = new MenuFitxategiLangileak();
	TelefonoakFitxategia fitxTelefonoakIrakurri = new TelefonoakFitxategia();
	EskariakFitxategia fitxEskariakIrakurri = new EskariakFitxategia();
	EskariLerroakFitxategia fitxEskariLerroakIrakurri= new EskariLerroakFitxategia();
	Faktura fakturasortu=new Faktura();
	
	boolean MenuaAmaitu = false;
	boolean ItxiSaioa = false;

	public MenuLogic() {

		menuNagusia();
		menuLangile();
		menuBezero();
		menuFitxategi();
		menuIrteera();
		menuAkatza();
		menuAkatza2();
		menuAkatza3();

	}

	private void menuNagusia() {
		// Menu nagusiaren logika
		String aukera = "";
		do {

			menuaNag.inprimatu();
			aukera = menuaNag.getAukera();
			IO.println();

			if (aukera.equals("1")) {
				menuLangile();
				IO.println();
			} else if (aukera.equals("2")) {
				menuBezero();
				IO.println();
			} else if (aukera.equals("3")) {
				menuFitxategi();
				IO.println();
			} else if (aukera.equals("4")) {
				menuIrteera();
			} else {
				menuAkatza();
			}
		} while (MenuaAmaitu == false);

	}

	private void menuIrteera() {
		// Irteeraren logika

		menuIrteera.inprimatuIrteera();
		do {
			IrteeraAukera = menuIrteera.getAukera();
			if (IrteeraAukera.equals("Bai")) {
				saioaItxi();
				MenuaAmaitu = true;
				ItxiSaioa = true;
				System.exit(0);
			} else if (IrteeraAukera.equals("bai")) {
				saioaItxi();
				MenuaAmaitu = true;
				ItxiSaioa = true;
				System.exit(0);
			} else if (IrteeraAukera.equals("BAI")) {
				saioaItxi();
				MenuaAmaitu = true;
				ItxiSaioa = true;
				System.exit(0);
			} else if (IrteeraAukera.equals("b")) {
				saioaItxi();
				MenuaAmaitu = true;
				ItxiSaioa = true;
				System.exit(0);
			} else if (IrteeraAukera.equals("Ez")) {
				ItxiSaioa = true;
			} else if (IrteeraAukera.equals("ez")) {
				ItxiSaioa = true;
			} else if (IrteeraAukera.equals("EZ")) {
				ItxiSaioa = true;
			} else if (IrteeraAukera.equals("e")) {
				ItxiSaioa = true;
			} else {
				akatzaItxiSaioa();
			}
		} while (ItxiSaioa == false);

	}

	private void menuLangile() {
		// Langile menuaren logika
		String aukera = "";
		do {

			menuaLangilea.inprimatuLangileak();
			aukera = menuaLangilea.getAukera();
			IO.println();

			if (aukera.equals("1")) {
				fitxLangile.bilatuTeklatuz();
				IO.println();
			}

			else if (aukera.equals("2")) {
				fitxNagusi.bilatuTeklatuz();
				IO.println();
			}

			else if (aukera.equals("3")) {
				menuNagusia();
			} else {
				menuAkatza2();
			}
		} while (MenuaAmaitu == false);
	}

	private void menuBezero() {
		// bezeroen menuaren logika
		String aukera = "";
		do {

			menuaBezeroa.inprimatuBezeroak();
			aukera = menuaBezeroa.getAukera();
			IO.println();
			if (aukera.equals("1")) {
				fitxBezero.bilatuTeklatuz();
				IO.println();
			} else if (aukera.equals("2")) {
				fakturasortu.bilatuTeklatuz();
				IO.println();
			} else if (aukera.equals("3")) {
				menuNagusia();
			}

			else {
				menuAkatza2();

			}
		} while (MenuaAmaitu == false);

	}

	private void menuFitxategi() {
		// Fitxategien menuaren logika
		String aukera = "";
		do {

			menuaFitxategi.inprimatuFitxategiak();
			aukera = menuaFitxategi.getAukera();
			IO.println();

			if (aukera.equals("1")) {
				fitxFakturakIrakurri.bilatuTeklatuz();
				IO.println();
			} else if (aukera.equals("2")) {
				fitxBezeroakIrakurri.bilatuTeklatuz();
				IO.println();

			} else if (aukera.equals("3")) {
				fitxlangileakIrakurri.bilatuTeklatuz();
				IO.println();

			} else if (aukera.equals("4")) {
				fitxTelefonoakIrakurri.bilatuTeklatuz();
				IO.println();

			} else if (aukera.equals("5")) {
				fitxEskariakIrakurri.bilatuTeklatuz();
				IO.println();

			} else if (aukera.equals("6")) {
				fitxEskariLerroakIrakurri.bilatuTeklatuz();
				IO.println();

			}

			else if (aukera.equals("7")) {
				menuNagusia();

			}

			else {
				menuAkatza3();

			}

		} while (MenuaAmaitu == false);
	}

	private void menuAkatza() {
		// akatza bat egiterakoan sortutako mezua

		menuaAkatza.inprimatuAkatasa();
		IO.println();
	}

	private void menuAkatza2() {

		menuaAkatza.inprimatuAkatasa2();
		IO.println();
	}

	private void menuAkatza3() {

		menuaAkatza.inprimatuAkatasa3();
		IO.println();
	}

	private void saioaItxi() {
		menuaAkatza.agurtu();
	}

	private void akatzaItxiSaioa() {
		menuaAkatza.akatzaItxiSaioa();
	}
}
