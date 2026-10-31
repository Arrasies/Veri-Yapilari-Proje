package rezervasyon;

public class Rezervasyon {
	private int id;
	private Musteri musteri ;
	private SporAlani alani ;
	private RezervasyonZamani zamani;
	
	public Rezervasyon(int id,Musteri musteri,SporAlani alani ,RezervasyonZamani zamani){
		if (id<=0) {
			throw new IllegalArgumentException("Id numarası 0 veya negatif olamaz");
		}
		if (musteri == null) {
			throw new IllegalArgumentException("Müşteri bilgisi boş olamaz");
		}
		if (alani == null){
			throw new IllegalArgumentException("Spor alanı boş olamaz");
		}
		if (zamani==null) {
			throw new IllegalArgumentException("rezervasyon zamanı boş olamaz");
		}
		
	
	this.id=id;
	this.musteri=musteri;
	this.alani=alani;
	this.zamani=zamani;
	}

	public int getId() {
		return id ;
	}
	public Musteri getMusteri() {
		return musteri;
		
	}
	public SporAlani getAlani() {
		return alani;
	}
	public RezervasyonZamani getZamani() {
		return zamani ;
	}
	
	public double ucretHesapla() {
		int sure = zamani.sureHesapla();
		double saatlikUcret=alani.getSaatlikUcret();
		return sure*saatlikUcret;
	}
	public String bilgiGetir() {
		return "Rezervasyon ID: " + id 
				+ ", Alan: " + alani.getAlanAdi() 
				+ ", Tarih: " + zamani.getTarih() 
				+ ", Saat: " + zamani.getBaslangicSaati() + "-" + zamani.getBitisSaati() 
				+ ", Toplam Ücret: " + ucretHesapla() + " TL";
	}

}