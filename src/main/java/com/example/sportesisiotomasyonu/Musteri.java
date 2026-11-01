package com.example.sportesisiotomasyonu;

public class Musteri {
    private int musteriId;
    private String adSoyad;
    private String telefon;
    private String eposta;

 public Musteri(int musteriId,String adSoyad,String telefon,String eposta){
    this.musteriId=musteriId;
    this.adSoyad=adSoyad;
    this.telefon=telefon;
    this.eposta=eposta;
 }
  public int getMusteriId(){
    return musteriId;
  }
  public void setMusteriId(int musteriId){
    this.musteriId=musteriId;
  }
  public String getAdSoyad(){
    return adSoyad;
  }
  public void setAdSoyad(String adSoyad){
    this.adSoyad=adSoyad;
  }
  public String getTelefon(){
    return telefon;
  }
  public void setTelefon(String telefon){
    this.telefon=telefon;
  }
  public String getEposta(){
    return eposta;
  }
  public void setEposta(String eposta){
    this.eposta=eposta;
  }


  public void musteriEkle(int musteriId,String adSoyad,String telefon,String eposta){
    this.musteriId=musteriId;
    this.adSoyad=adSoyad;
    this.telefon=telefon;
    this.eposta=eposta;
  }
  public void musteriGuncelle(String adSoyad,String telefon,String eposta){
    this.adSoyad=adSoyad;
    this.telefon=telefon;
    this.eposta=eposta;
  }
  public void musteriSil(){
    this.adSoyad=null;
    this.telefon=null;
    this.eposta=null;
  }
  public void bilgiGetir(){
    System.out.println("Müşteri Id: "+ musteriId);
    System.out.println("AdSoyad: "+adSoyad);
    System.out.println("Telefon: "+telefon);
    System.out.println("E-posta: "+eposta);
  }
}
    
   
     
