package com.example.sportesisiotomasyonu;

public class UcretHesaplayici {
	public boolean sureGecerliMi(SporAlani alan, int sure) {
		if (alan == null || !alan.isAktif()) {
			return false;
		}
		return sure > 0
			&& sure >= alan.getMinRezervasyonSuresi()
			&& sure <= alan.getMaxRezervasyonSuresi();
	}
	public double ucretHesapla(SporAlani alan, int sure) {
		if (!sureGecerliMi(alan, sure)) {
			return -1;
		}
		double saatlikUcret = alan.getSaatlikUcret();
		double saat = sure / 60.0;
		double toplamUcret = saatlikUcret * saat;
		return toplamUcret;
	}
	public double indirimliUcretHesapla(SporAlani alan, int sure, double indirimOrani) {
		double toplamUcret = ucretHesapla(alan, sure);
		if (toplamUcret < 0) {
			return -1;
		}
		if (indirimOrani < 0 || indirimOrani > 100) {
			return -1;
		}
		double indirimTutari = toplamUcret * indirimOrani / 100.0 ;
		return toplamUcret - indirimTutari;
	}

}
