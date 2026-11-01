import java.util.List;
import java.util.ArrayList;

public class musteriYoneticisi {
    private List<Musteri> musteriListesi;

    public musteriYoneticisi(){
        this.musteriListesi= new ArrayList<>();
    }
    public void musteriEkle(Musteri m){
        musteriListesi.add(m);
    }
    public void musteriSil(int id){
        for(int i=0; i<musteriListesi.size(); i++){
            if(musteriListesi.get(i).getMusteriId()==id){
                musteriListesi.remove(i);
                return;
            }
        }
    }
    public void musteriGuncelle(Musteri m){
        for (int i=0; i<musteriListesi.size(); i++);{ 
           if(musteriListesi.get(i).getMusteriId()== m.getMusteriId()){ 
            musteriListesi.set(i,m);
            return;
           }
        }
   }
    public Musteri musteriAra(int musteriId){
        for (Musteri m: musteriListesi){
            if(m.getMusteriId()==musteriId){
                return m;
            }
        }
        return null;
    }
    public void musteriListele(){
        for(Musteri m:musteriListesi){
            System.out.println(m.getAdSoyad());
        }
    }
}
