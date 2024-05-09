package logika;

public class PrikazZjistit implements IPrikaz
{


    private Hra hra;
    public PrikazZjistit(Hra hra)
    {
        this.hra = hra;
    }

    public String getNazev()
    {
        return "zjistit";
    }

    public String proved(String[] parametryPrikazu)
    {

        if (parametryPrikazu.length < 1)
        {
            return "Nevím, co mám zjišťovat.";
        }
        if (parametryPrikazu.length > 1)
        {
            return "Můžu zjišťovat pouze jednu věc najednou.";
        }
        String nazevZjistovak = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();


        Osoba o = aktualniLokace.vratOsobu(nazevZjistovak);
        if (!(o == null))
        {
            if (o.stavZnamosti())
            {
                return o.getPopis() + "\nS postavou si se již správně uvítal";
            } else return "Nevím, co mám zjišťovat.";
        }
        Item p = aktualniLokace.vratItem(nazevZjistovak);
        if (!(p == null))
        {
            return p.getPopis();
        }
        Inventar inv = herniSvet.getInventar();
        Item b = inv.vratItem(nazevZjistovak);
        if (!(b == null))
        {
            return b.getPopis();
        }
        return "Nevím, co mám zjišťovat.";
    }
}

