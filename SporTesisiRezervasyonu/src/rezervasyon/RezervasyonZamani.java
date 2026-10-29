package rezervasyon;

public class RezervasyonZamani {
	private String tarih;
	private int baslangicSaati;
	private int bitisSaati;

	
	public RezervasyonZamani(String tarih, int baslangicSaati, int bitisSaati) {
		if(tarih == null){
			throw new IllegalArgumentException("tarih boş olamaz");	
		}
		if(tarih .isBlank()){
			throw new IllegalArgumentException("tarih boş olamaz");	
		}
		if (baslangicSaati<0 || baslangicSaati>23) {
			throw new IllegalArgumentException("başlangıç saati 0 ve 23 arasında olmalıdır ");
			}
		if (bitisSaati<1 || bitisSaati>24) {
			throw new IllegalArgumentException("bitiş saati 1 ve 24 arasında olmalıdır ");
		}
		if (bitisSaati <= baslangicSaati) {
			throw new IllegalArgumentException("bitiş saati başlangış saatinden büyük olmalı  ");
		}
		
		
		this.tarih = tarih;
		this.baslangicSaati = baslangicSaati;
		this.bitisSaati = bitisSaati;
	}

	public String getTarih() {
		return tarih;
	}

	public int getBaslangicSaati() {
		return baslangicSaati;
	}

	public int getBitisSaati() {
		return bitisSaati;
	}
	
	public int sureHesapla() {
		return (bitisSaati-baslangicSaati);
	}
	public boolean cakisiyorMu(RezervasyonZamani diger){
		boolean ayniTarih = tarih.equals(diger.getTarih());
		boolean saatlerCAkisiyor = this.baslangicSaati < diger.getBitisSaati() 
		&&  
		diger.getBaslangicSaati()<this.bitisSaati;
		return ayniTarih && saatlerCAkisiyor;
	
	
	
	
	}
}
