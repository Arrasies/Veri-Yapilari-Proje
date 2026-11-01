package com.example.sportesisiotomasyonu;

public class RezervasyonDugumu {
    private Rezervasyon veri;
    private RezervasyonDugumu sonraki;

    public RezervasyonDugumu(Rezervasyon veri){
        this.veri = veri;
        this.sonraki = null;
    }

    public Rezervasyon getVeri(){
        return veri;
    }

    public void setVeri(Rezervasyon veri){
        this.veri = veri;
    }

    public RezervasyonDugumu getSonraki(){
        return sonraki;
    }

    public void setSonraki(RezervasyonDugumu sonraki){
        this.sonraki = sonraki;
    }
}
