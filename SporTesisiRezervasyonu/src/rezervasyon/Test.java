package rezervasyon;

public class Test {

	public static void main(String[] args) { 
		RezervasyonZamani r =new RezervasyonZamani("07.07.2027",17,23);
		System.out.println(r.getTarih());
		System.out.println(r.getBaslangicSaati());
		System.out.println(r.getBitisSaati());
		System.out.println("Süre: " + r.sureHesapla() + " saat");
		RezervasyonZamani r2 =new RezervasyonZamani("07.07.2027",20,22);
		System.out.println("r ile r2 çakışıyor mu?" +r .cakisiyorMu(r2));
		RezervasyonZamani r3 =new RezervasyonZamani("07.07.2027",23,24);
		System.out.println("r ile r3 çakışıyor mu?" +r .cakisiyorMu(r3));
		RezervasyonZamani r4 =new RezervasyonZamani("06.06.2027",23,24);
		System.out.println("r ile r4 çakışıyor mu?" + r.cakisiyorMu(r4));
		
	
	}

}
