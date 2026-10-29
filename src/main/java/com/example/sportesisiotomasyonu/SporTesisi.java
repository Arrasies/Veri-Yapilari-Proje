package com.example.sportesisiotomasyonu;

import java.util.ArrayList;
import java.util.List;

public class SporTesisi {
	
	private int tesisId;
	private String tesisAdi;
	private String adres;
	private String telefon;
	
	private List<SporAlani> alanlar;
	
	public SporTesisi(int tesisId, String tesisAdi, String adres, String telefon) {
		this.tesisId = tesisId;
		this.tesisAdi = tesisAdi;
		this.adres = adres;
		this.telefon = telefon;
		this.alanlar = new ArrayList<>();
	}
	
	public void alanEkle(SporAlani alan) {
		if (alan != null) {
			alanlar.add(alan);
		}
	}
	
	public void alanCikar(int alanId) {
		alanlar.removeIf(alan -> alan.getAlanId() == alanId);
	}
	
	public List<SporAlani> alanlariListele() {
		return new ArrayList<>(alanlar);
	}
	
	public String bilgiGetir() {
		return "Tesis ID: " + tesisId
				+ "\nTesis Adı: " + tesisAdi
				+ "\nAdres: " + adres
				+ "\nTelefon: " + telefon
				+ "\nSpor ALanı Sayısı: " + alanlar.size();
	}
}
