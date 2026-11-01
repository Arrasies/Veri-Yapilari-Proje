package com.example.sportesisiotomasyonu;
import java.util.ArrayList;
import java.util.List;

public class RezervasyonListesi {
    private RezervasyonDugumu bas;
    private int boyut;

    public RezervasyonListesi(){
        this.bas = null;
        this.boyut = 0;
    }

    public void ekle (Rezervasyon yeniRezervasyon){
        if(yeniRezervasyon == null){
            throw new IllegalArgumentException("Eklenecek rezervasyon boş olamaz!");
        }
        RezervasyonDugumu yeniDugum = new RezervasyonDugumu(yeniRezervasyon);
        if(bas == null){
            bas = yeniDugum;
        } else{
            RezervasyonDugumu gecici = bas;
            while(gecici.getSonraki() !=null) {
                gecici = gecici.getSonraki();
            }
            gecici.setSonraki(yeniDugum);
        }
        boyut++;
    }
    public boolean sil(int id){
        if(bas == null) return false;

        if(bas.getVeri().getId() == id){
            bas = bas.getSonraki();
            boyut--;
            return true;
        }
        RezervasyonDugumu gecici = bas;
        while(gecici.getSonraki() != null) {
            if(gecici.getSonraki().getVeri().getId() == id){
                gecici.setSonraki(gecici.getSonraki().getSonraki());
                boyut--;
                return true;
            }
            gecici = gecici.getSonraki();
        }
        return false;
    }

    public boolean guncelle(Rezervasyon guncelRezervasyon){
        if(guncelRezervasyon == null) return false;
        RezervasyonDugumu gecici = bas;
        while(gecici != null){
            if(gecici.getVeri().getId() == guncelRezervasyon.getId()){
                gecici.setVeri(guncelRezervasyon);
                return true;
            }
            gecici = gecici.getSonraki();
        }
        return false;
    }

    public Rezervasyon getir(int id){
        RezervasyonDugumu gecici = bas;
        while(gecici != null){
            if(gecici.getVeri().getId() == id){
                return gecici.getVeri();
            }
            gecici = gecici.getSonraki();
        }
        return null;
    }

    public List<Rezervasyon> tumunuListele(){
        List<Rezervasyon> liste = new ArrayList<> ();
        RezervasyonDugumu gecici = bas;
        while(gecici != null){
            liste.add(gecici.getVeri());
            gecici = gecici.getSonraki();
        }
        return liste;
    }

    public void temizle(){
        bas = null;
        boyut = 0;
    }

    public RezervasyonDugumu getBas(){
        return bas;
    }

    public void setBas(RezervasyonDugumu bas){
        this.bas = bas;
    }

    public int getBoyut(){
        return boyut;
    }
}
