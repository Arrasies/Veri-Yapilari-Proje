package com.example.sportesisiotomasyonu;

import java.util.ArrayList;
import java.util.List;

public class MusaitlikKontrol {
	private RezervasyonListesi rezervasyonListesi;

	public MusaitlikKontrol() {
		this.rezervasyonListesi = new RezervasyonListesi();
	}

	public MusaitlikKontrol(RezervasyonListesi rezervasyonListesi) {
		if (rezervasyonListesi == null) {
			this.rezervasyonListesi = new RezervasyonListesi();
		} else {
			this.rezervasyonListesi = rezervasyonListesi;
		}
	}

	public boolean rezervasyonAraliginiKontrolEt(int bas, int sure, SporAlani alan) {
		if (alan == null)
			throw new IllegalArgumentException("Spor alanı boş olamaz ");

		if (!alan.isAktif())
			return false;

		if (bas < 0 || bas > 23 || sure <= 0)
			return false;

		int bit = bas + sure;
		if (bit > 24)
			return false;

		if (sure < alan.getMinRezervasyonSuresi() || sure > alan.getMaxRezervasyonSuresi())
			return false;

		return true;

	}

	public boolean cakismaKontrol(Rezervasyon rez, RezervasyonZamani zaman) {
		if (rez == null || zaman == null)
			throw new IllegalArgumentException();
		return rez.getZamani().cakisiyorMu(zaman);
	}

	public boolean uygunMu(SporAlani alan, RezervasyonZamani zaman) {
		if (alan == null || zaman == null) {
			throw new IllegalArgumentException();
		}
		if (!rezervasyonAraliginiKontrolEt(zaman.getBaslangicSaati(), zaman.sureHesapla(), alan)) {
			return false;
		}
		RezervasyonDugumu gecici = rezervasyonListesi.getBas();
		while (gecici != null) {
			Rezervasyon mevcut = gecici.getVeri();
			if (mevcut != null && mevcut.getAlani().getAlanId() == alan.getAlanId() && cakismaKontrol(mevcut, zaman)) {
				return false;
			}
			gecici = gecici.getSonraki();
		}
		return true;
	}

	public List<RezervasyonZamani> uygunZamanlariBul(SporAlani alan, String tarih) {
		if (alan == null || tarih == null || tarih.isBlank())
			throw new IllegalArgumentException("Spor alanı ve tarih boş olamaz");
		List<RezervasyonZamani> uygunZamanlar = new ArrayList<>();
		if (!alan.isAktif()) {
			return uygunZamanlar;
		}
		int sure = Math.max(1, alan.getMinRezervasyonSuresi());
		for (int saat = 0; saat <= 24 - sure; saat++) {
			RezervasyonZamani aday = new RezervasyonZamani(tarih, saat, saat + sure);
			if (uygunMu(alan, aday))
				uygunZamanlar.add(aday);
		}
		return uygunZamanlar;
	}
}
