package businesslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ikuspegia.Kontsola;

public class MenuFitxategiaFaktura {

	private final String FITXATEGIAKO_BIDEA = "./src/businesslogic/FAKTURAK.txt";

	public void bilatuTeklatuz() {
		inprimatu();
	}

	private void inprimatu() {
		try (FileReader fr = new FileReader(FITXATEGIAKO_BIDEA);
				BufferedReader br = new BufferedReader(fr)) {

			String lerroa;
			boolean daturikDago = false;

			while ((lerroa = br.readLine()) != null) {
				daturikDago = true;
				Kontsola.inprimatu("\t" + lerroa);
			}

			if (!daturikDago) {
				Kontsola.inprimatu("\tEz dago fakturarik gordeta.");
			}

		} catch (IOException akatza) {
			Kontsola.inprimatu("\tEz dago fakturarik gordeta oraindik.");
		}
	}
}