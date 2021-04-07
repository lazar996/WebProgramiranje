package model;

public class Rezervacije {

	private int id;
	private Let polazniLet;
	private Let povratniLet;
	private int sedistePolazni;
	private int sedisteDolazni;
	private String datumRezervacije;
	private String datumProdajeKarte;
	private User user;
	private String imePutnika;
	private String prezimePutnika;
	
	
	
	public Rezervacije() {
		super();
	}
	public Rezervacije(int id, Let polazniLet, Let povratniLet, int sedistePolazni, int sedisteDolazni,
			String datumRezervacije, String datumProdajeKarte, User user, String imePutnika, String prezimePutnika) {
		super();
		this.id = id;
		this.polazniLet = polazniLet;
		this.povratniLet = povratniLet;
		this.sedistePolazni = sedistePolazni;
		this.sedisteDolazni = sedisteDolazni;
		this.datumRezervacije = datumRezervacije;
		this.datumProdajeKarte = datumProdajeKarte;
		this.user = user;
		this.imePutnika = imePutnika;
		this.prezimePutnika = prezimePutnika;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Let getPolazniLet() {
		return polazniLet;
	}
	public void setPolazniLet(Let polazniLet) {
		this.polazniLet = polazniLet;
	}
	public Let getPovratniLet() {
		return povratniLet;
	}
	public void setPovratniLet(Let povratniLet) {
		this.povratniLet = povratniLet;
	}
	public int getSedistePolazni() {
		return sedistePolazni;
	}
	public void setSedistePolazni(int sedistePolazni) {
		this.sedistePolazni = sedistePolazni;
	}
	public int getSedisteDolazni() {
		return sedisteDolazni;
	}
	public void setSedisteDolazni(int sedisteDolazni) {
		this.sedisteDolazni = sedisteDolazni;
	}
	public String getDatumRezervacije() {
		return datumRezervacije;
	}
	public void setDatumRezervacije(String datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}
	public String getDatumProdajeKarte() {
		return datumProdajeKarte;
	}
	public void setDatumProdajeKarte(String datumProdajeKarte) {
		this.datumProdajeKarte = datumProdajeKarte;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImePutnika() {
		return imePutnika;
	}
	public void setImePutnika(String imePutnika) {
		this.imePutnika = imePutnika;
	}
	public String getPrezimePutnika() {
		return prezimePutnika;
	}
	public void setPrezimePutnika(String prezimePutnika) {
		this.prezimePutnika = prezimePutnika;
	}
	@Override
	public String toString() {
		return "Rezervacije [id=" + id + ", polazniLet=" + polazniLet + ", povratniLet=" + povratniLet
				+ ", sedistePolazni=" + sedistePolazni + ", sedisteDolazni=" + sedisteDolazni + ", datumRezervacije="
				+ datumRezervacije + ", datumProdajeKarte=" + datumProdajeKarte + ", user=" + user + ", imePutnika="
				+ imePutnika + ", prezimePutnika=" + prezimePutnika + "]";
	}
	
	
	
}
