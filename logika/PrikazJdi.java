package logika;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PrikazJdi implements IPrikaz
{
    private Hra hra;
    
    public PrikazJdi(Hra hra)
    {
        this.hra = hra;
    }
    
    public String getNazev()
    {
        return "jdi";
    }
    
    public String proved(String[] parametryPrikazu)
    {
        if (parametryPrikazu.length < 1) {
            return "Nevím, kam mám jít.";
        }
        
        if (parametryPrikazu.length > 1) {
            return "Nedokážu jít na více míst současně.";
        }
        String nazevLokace = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();

        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        if (!aktualniLokace.maVychod(nazevLokace)) {
            return "Do lokace '" + nazevLokace + "' se odsud nedostanu.";
        }

        List<Lokace> lokaci = Arrays.asList(herniSvet.namesti, herniSvet.rozcestnik, herniSvet.staj);
        Random r = new Random();
        Lokace nahodnaLokace = lokaci.get(r.nextInt(lokaci.size()));
        herniSvet.rozcestnik.odendejOsobu(herniSvet.kocka);
        herniSvet.namesti.odendejOsobu(herniSvet.kocka);
        herniSvet.staj.odendejOsobu(herniSvet.kocka);
        nahodnaLokace.pridejOsobu(herniSvet.kocka);

        if (nazevLokace.equals("jeskyne"))
        {
            Inventar inv = herniSvet.getInventar();
            if (inv.maItem("svicka"))
            {
                Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
                herniSvet.setAktualniLokace(novaLokace);

                return novaLokace.getDetailniPopis();
            }
            else if (herniSvet.jeskyne.maItem("svicka"))
            {
                Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
                herniSvet.setAktualniLokace(novaLokace);

                return "Nechal si svíčku v jeskyni, světlo boží bude navěky přítomno v tomto místě. \n" +novaLokace.getDetailniPopis();
            }
            else
            {
                return "Jeskyně je velmi temná, potřebuješ nějakou svíčku. Farář má dost oltářních svícnů.";
            }
        }
        if (nazevLokace.equals("les"))
        {
            Inventar inv = herniSvet.getInventar();
            if (inv.maItem("medvedihlava"))
            {
                Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
                herniSvet.setAktualniLokace(novaLokace);

                return novaLokace.getDetailniPopis();
            }
            else if (herniSvet.les.maItem("medvedihlava"))
            {
                Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
                herniSvet.setAktualniLokace(novaLokace);

                return "Nechal si hlavu v lese, zajíc proto utekl.\n" + novaLokace.getDetailniPopis();
            }
            else
            {
                return "V lese je zabijácký ježek, kdybych měl v batůžku hlavu nějakého zvířete mohl bych tam jít, třeba by se mě bál.";
            }
        }
        if (nazevLokace.equals("brod"))
        {
            Inventar inv = herniSvet.getInventar();
            if (inv.maItem("mec") && inv.maItem("cepice") && inv.maItem("lektvar"))
            {
                hra.setHraSkoncila(true);
                return "Gratuluji! Vyhrál jsi! Jsi na cestě do světa, doufej, že tě cestou nepolapí lapkové.";
            }
            else return "Nejsi připraven odcestovat do světa";
        }
        Lokace novaLokace = aktualniLokace.vratVychod(nazevLokace);
        herniSvet.setAktualniLokace(novaLokace);
        return novaLokace.getDetailniPopis();
    }
}
