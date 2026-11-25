package com.example.sportesisiotomasyonu;

public class SporAlaniHashMap {
	private Dugum[] tablo;
	private int kapasite;
	private int elemanSayisi;
	
	private static class Dugum {
		int anahtar;
		SporAlani deger;
		Dugum sonraki;
		
		public Dugum(int anahtar, SporAlani deger) {
			this.anahtar = anahtar;
			this.deger = deger;
			this.sonraki = null;
		}
	}
	
	public SporAlaniHashMap() {
		this.kapasite = 10;
		this.tablo = new Dugum[kapasite];
		this.elemanSayisi = 0;
	}
	
	private int hash(int anahtar) {
		int indeks = anahtar % kapasite;
		
		if (indeks < 0 ) {
			indeks += kapasite;
		}
		return indeks;
	}
	
	public void alanEkle(SporAlani alan) {
		if (alan == null) {
			return;
		}
		
		int anahtar = alan.getAlanId();
		int indeks = hash(anahtar);
		
		Dugum mevcut = tablo[indeks];
		
		while (mevcut != null) {
			if (mevcut.anahtar == anahtar) {
				mevcut.deger = alan;
				return;
			}
			mevcut = mevcut.sonraki;
		}
		Dugum yeniDugum = new Dugum(anahtar,alan);
		yeniDugum.sonraki = tablo[indeks];
		tablo[indeks] = yeniDugum;
		elemanSayisi++;
	}
	public SporAlani alanAra(int alanId) {
		int indeks = hash(alanId);
		Dugum mevcut = tablo[indeks];
		while (mevcut != null) {
			if (mevcut.anahtar == alanId) {
				return mevcut.deger;
			}
			mevcut = mevcut.sonraki;
		}
		return null;
	}
	public void alanSil(int alanId) {
		int indeks = hash(alanId);
		Dugum mevcut = tablo[indeks];
		Dugum onceki = null;
		while (mevcut != null) {
			if (mevcut.anahtar == alanId) {
				if (onceki == null) {
					tablo[indeks] = mevcut.sonraki;
				} else {
					onceki.sonraki = mevcut.sonraki;
				}
				elemanSayisi--;
				return;
			}
			onceki = mevcut;
			mevcut = mevcut.sonraki;
		}
	}
	public SporAlani[] alanlariListele() {
		SporAlani[] liste = new SporAlani[elemanSayisi];
		int sayac = 0;
		for (int i = 0; i < kapasite; i++) {
			Dugum mevcut = tablo[i];
			while (mevcut != null) {
				liste[sayac] = mevcut.deger;
				sayac++;
				mevcut = mevcut.sonraki;
			}
		}
		return liste;
	}
	public int getElemanSayisi() {
		return elemanSayisi;
	}
}
