package eredua;

public class Eskaria {
	public String Id;
	public String IdBezero;
	public String IdEgoera;
	public String EskaeraData;

	public Eskaria() {
	}

	public Eskaria(String Id, String IdBezero, String IdEgoera, String EskaeraData) {
		this.setId(Id);
		this.setIdBezero(IdBezero);
		this.setIdEgoera(IdEgoera);
		this.setEskaeraData(EskaeraData);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getIdBezero() {
		return IdBezero;
	}

	public void setIdBezero(String idBezero) {
		this.IdBezero = idBezero;
	}

	public String getIdEgoera() {
		return IdEgoera;
	}

	public void setIdEgoera(String idEgoera) {
		this.IdEgoera = idEgoera;
	}

	public String getEskaeraData() {
		return EskaeraData;
	}

	public void setEskaeraData(String eskaeraData) {
		this.EskaeraData = eskaeraData;
	}

}
