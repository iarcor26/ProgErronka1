package eredua;

public class EskariLerroa {
	public String IdEskari;
	public String IdLerro;
	public String IdProduktu;
	public String Kopurua;
	public String Salneurria;

	public EskariLerroa() {
	}

	public EskariLerroa(String IdEskari, String IdLerro, String IdProduktu, String Kopurua, String Salneurria) {
		this.setIdEskari(IdEskari);
		this.setIdLerro(IdLerro);
		this.setIdProduktu(IdProduktu);
		this.setKopurua(Kopurua);
		this.setSalneurria(Salneurria);

	}



	public String getIdEskari() {
		return IdEskari;
	}

	public void setIdEskari(String idEskari) {
		IdEskari = idEskari;
	}

	public String getIdLerro() {
		return IdLerro;
	}

	public void setIdLerro(String idLerro) {
		IdLerro = idLerro;
	}

	public String getIdProduktu() {
		return IdProduktu;
	}

	public void setIdProduktu(String idProduktu) {
		IdProduktu = idProduktu;
	}

	public String getKopurua() {
		return Kopurua;
	}

	public void setKopurua(String kopurua) {
		Kopurua = kopurua;
	}

	public String getSalneurria() {
		return Salneurria;
	}

	public void setSalneurria(String salneurria) {
		Salneurria = salneurria;
	}

}
