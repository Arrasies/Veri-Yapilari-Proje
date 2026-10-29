package com.example.sportesisiotomasyonu;

import java.util.Date;
import java.sql.Time;

public class SporAlani {
	private int alanId;
	private String alanAdi;
	private String alanTuru;
	private double saatlikUcret;
	private int minRezervasyonSuresi;
	private int maxRezervasyonSuresi;
	private boolean aktif;
	
	public SporAlani (int alanId, String alanAdi, String alanTuru, double saatlikUcret, int minRezervasyonSuresi, int maxRezervasyonSuresi, boolean aktif)
	{
		this.alanId = alanId;
		this.alanAdi = alanAdi;
		this.alanTuru = alanTuru;
		this.saatlikUcret = saatlikUcret;
		this.minRezervasyonSuresi = minRezervasyonSuresi;
		this.maxRezervasyonSuresi = maxRezervasyonSuresi;
		this.aktif = aktif;
	}
	
	public void alanEkle() {
		// Spor alanını ekleme işlemi
	}
	
	public void alanGuncelle() {
		 // Spor alanını güncelleme işlemi
	}
	
	public void alanSil() {
		// Spor alanını silme işlemi
	}
	
	public boolean uygunMu(Date tarih, Time bas, Time bit) {
		// uygunluk kontrolü sonra eklenecek
		return false;
	}
	
	public void rezevasyonSuresiGuncelle(int min, int max) {
		if (min > 0 && max >= min) {
			this.minRezervasyonSuresi = min;
			this.maxRezervasyonSuresi = max;
		}
	}
	
	public int getAlanId() {
		return alanId;
	}
	
	public String getAlanAdi() {
		return alanAdi;
	}
	
	public String getAlanTuru() {
		return alanTuru;
	}
	
	public double getSaatlikUcret() {
		return saatlikUcret;
	}
	
	public int getMinRezervasyonSuresi() {
		return minRezervasyonSuresi;
	}
	
	public int getMaxRezervasyonSuresi( ) {
		return maxRezervasyonSuresi;
	}
	
	public boolean isAktif( ) {
		return aktif;
	}
}
