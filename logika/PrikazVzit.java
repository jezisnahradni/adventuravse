package logika;

import java.util.*;

public class PrikazVzit implements IPrikaz
{
    public String getNazev()
    {
        return "vzit";
    }

    private Hra hra;
    public PrikazVzit(Hra hra)
    {
        this.hra = hra;
    }


    public String proved(String[] parametryPrikazu)
    {
        if (parametryPrikazu.length < 1)
        {
            return "Musíš mi říct, co mám vzít";
        }
        if (parametryPrikazu.length > 1)
        {
            return "Tomu nerozumím, nevim co mám vzít";
        }

        String nazevItemu = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        Inventar inv = herniSvet.getInventar();
        Item item = aktualniLokace.vratItem(nazevItemu);

        if (item == null)
        {
            return "Item " + nazevItemu + " tady není.";
        }
        if (inv.getVelikost() < inv.getMaxVelikost())
        {
            if (item.isPrenositelny())
            {
                inv.pridatItem(item);
                aktualniLokace.odeberItem(item);
                return "Item " + item.getNazev() + " sis vložil do tvého batůžku.";
            }
            else if (!item.isPrenositelny())
            {
                if (item == herniSvet.medvedihlava)
                {
                    Inventar inv1 = herniSvet.getInventar();
                    if (inv1.maItem("mec"))
                    {
                        inv1.pridatItem(item);
                        aktualniLokace.odeberItem(item);
                        return "Item " + item.getNazev() + " sis vložil do tvého batůžku.";
                    }
                    else if (!inv1.maItem("mec"))
                    {
                        return "Potřebuješ nějaký pořádný meč střáže, aby usekl hlavu a vzal ji";
                    }
                }
                else
                {
                    return "Nemůžeš sebrat item " + nazevItemu + " " + item.getProcNejdeVzit();
                }
            }

        }
        else if (inv.getVelikost() >= inv.getMaxVelikost())
        {
            return "Do batůžku už nic dát nemůžeš";
        }
        return null;
    }

}
