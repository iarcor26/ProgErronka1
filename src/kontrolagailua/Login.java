package kontrolagailua;

import ikuspegia.*;

public class Login {
	// Deklaratu
	private Boolean saioa = false;
	private final String erabiltzaile = "Admin";
	private final String pasahitza = "123";
	private String saiatuerabiltzaile;
	private String saiatupasahitza;
	private Integer saiakerak = 3;

	public Login() {
		run();
	}

	public void run() {
		sartuDatuak();
		ongiEtorria();
	}

	private void sartuDatuak() {
		do {
			// Eskatu erabiltzaile eta pasahitza
			Kontsola.inprimatu("\nSartu zure erabiltzailea: ");
			saiatuerabiltzaile = Teklatua.irakurri();
			Kontsola.inprimatu("Sartu zure pasahitza: ");
			saiatupasahitza = Teklatua.irakurri();

			// Konprobatu erabiltzailea eta pasahitza
			if (saiatuerabiltzaile.trim().equals(erabiltzaile)) {
				if (saiatupasahitza.trim().equals(pasahitza)) {
					// Ondo badago
					saioa = true;
				} else {
					// Pasahitsa txarto badago kendi saiakera bat
					saiakerak--;
					Kontsola.inprimatu("Geratzen zaizu " + saiakerak + " saiakera");
					// Konprobatu saiakera kopurua 0 bada, eta bada progrma itxi
					if (saiakerak == 0) {
						Kontsola.inprimatu("Geratu zara saiakerarik gabe");
						System.exit(0);
					}
				}
			} else {
				// Erabiltzailea txarto badago kendu saiakera bat
				saiakerak--;
				Kontsola.inprimatu("Geratzen zaizu " + saiakerak + " saiakera");
				// Konprobatu saiakera kopurua 0 bada, eta bada progrma itxi
				if (saiakerak == 0) {
					Kontsola.inprimatu("Geratu zara saiakerarik gabe");
					System.exit(0);
				}
			}
		} while (saioa == false);
	}

	private void ongiEtorria() {
		// Deitu Logoari imprimatzeko
		Logoa log = new Logoa();
		log.inprimatuLogo();
	}
}
