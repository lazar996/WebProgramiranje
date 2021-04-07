package model;

import java.util.Date;

public class Let {

	
	
	private int id;
	private int broj;
	private Date datumPolaska;
	private Date datumDolaska;
	private Aerodrom polazniAerodrom;
	private Aerodrom dolazniAerodrom;
	private int brojSedista;
	private int cenaKarte;
	private boolean izbrisan;
	
	
	
	
	
	public Let() {
		super();
	}
	public Let(int id, int broj, Date datumPolaska, Date datumDolaska, Aerodrom polazniAerodrom,
			Aerodrom dolazniAerodrom, int brojSedista, int cenaKarte, boolean izbrisan) {
		super();
		this.id = id;
		this.broj = broj;
		this.datumPolaska = datumPolaska;
		this.datumDolaska = datumDolaska;
		this.polazniAerodrom = polazniAerodrom;
		this.dolazniAerodrom = dolazniAerodrom;
		this.brojSedista = brojSedista;
		this.cenaKarte = cenaKarte;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBroj() {
		return broj;
	}
	public void setBroj(int broj) {
		this.broj = broj;
	}
	
	public Date getDatumPolaska() {
		return datumPolaska;
	}
	public void setDatumPolaska(Date datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public Date getDatumDolaska() {
		return datumDolaska;
	}
	public void setDatumDolaska(Date datumDolaska) {
		this.datumDolaska = datumDolaska;
	}
	public Aerodrom getPolazniAerodrom() {
		return polazniAerodrom;
	}
	public void setPolazniAerodrom(Aerodrom polazniAerodrom) {
		this.polazniAerodrom = polazniAerodrom;
	}
	public Aerodrom getDolazniAerodrom() {
		return dolazniAerodrom;
	}
	public void setDolazniAerodrom(Aerodrom dolazniAerodrom) {
		this.dolazniAerodrom = dolazniAerodrom;
	}
	public int getBrojSedista() {
		return brojSedista;
	}
	public void setBrojSedista(int brojSedista) {
		this.brojSedista = brojSedista;
	}
	public int getCenaKarte() {
		return cenaKarte;
	}
	public void setCenaKarte(int cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	
	
	public boolean isIzbrisan() {
		return izbrisan;
	}
	public void setIzbrisan(boolean izbrisan) {
		this.izbrisan = izbrisan;
	}
	@Override
	public String toString() {
		return "Let [id=" + id + ", broj=" + broj + ", datumPolaska=" + datumPolaska + ", datumDolaska=" + datumDolaska
				+ ", polazniAerodrom=" + polazniAerodrom + ", dolazniAerodrom=" + dolazniAerodrom + ", brojSedista="
				+ brojSedista + ", cenaKarte=" + cenaKarte + ", izbrisan=" + izbrisan + "]";
	}

	
	
}
