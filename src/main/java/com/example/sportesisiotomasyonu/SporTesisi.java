package com.example.sportesisiotomasyonu;


public class SporTesisi {
	
	private int tesisId;
	private String tesisAdi;
	private String adres;
	private String telefon;
	
	private SporAlani[] alanlar;
	private int alanSayisi;
	
	public SporTesisi(int tesisId, String tesisAdi, String adres, String telefon) {
		this.tesisId = tesisId;
		this.tesisAdi = tesisAdi;
		this.adres = adres;
		this.telefon = telefon;
		this.alanlar = new SporAlani[10];
		this.alanSayisi = 0;
	}
	
	public void alanEkle(SporAlani alan) {
		if (alan == null) {
			return;
		}
		if (alanSayisi == alanlar.length) {
			SporAlani[] yeniDizi = 
				new SporAlani[alanlar.length * 2];
			for (int i = 0; i < alanSayisi; i++) {
				yeniDizi[i] = alanlar[i];
			}
			alanlar = yeniDizi;
		}
		alanlar[alanSayisi] = alan;
		alanSayisi++;
	}
	
	public void alanCikar(int alanId) {
		for (int i = 0; i < alanSayisi; i++) {
			if (alanlar[i].getAlanId() == alanId) {
				for (int j = i; j < alanSayisi - 1; j++) {
					alanlar[j] = alanlar[j + 1];
				}
				alanlar[alanSayisi - 1] = null;
				alanSayisi--;
				return;
			}
		}
	}
	
	public SporAlani[] alanlariListele() {
		SporAlani[] liste = new SporAlani[alanSayisi];
		for (int i = 0; i < alanSayisi; i++) {
			liste[i] = alanlar[i];
		}
		return liste;
	}
	
	public String bilgiGetir() {
		return "Tesis ID: " + tesisId
				+ "\nTesis Adı: " + tesisAdi
				+ "\nAdres: " + adres
				+ "\nTelefon: " + telefon
				+ "\nSpor Alanı Sayısı: " + alanSayisi;
	}
}