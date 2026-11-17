package eredua;

public class Langileak {

	private String id;

	private String izena;

	private String telefonoa;

	private String emaila;

	private String abizena;

	private String altaeguna;

	public Langileak(String id, String izena, String abizena, String telefonoa, String emaila, String altaeguna) {
		this.setId(id);
		this.setIzena(izena);
		this.setAbizena(abizena);
		this.setTelefonoa(telefonoa);
		this.setEmaila(emaila);
		this.setAltaeguna(altaeguna);
	}

	public Langileak() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String getEmaila() {
		return emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getAltaeguna() {
		return altaeguna;
	}

	public void setAltaeguna(String altaeguna) {
		this.altaeguna = altaeguna;
	}

}
