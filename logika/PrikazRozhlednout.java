package logika;

public class PrikazRozhlednout implements IPrikaz
{
    private Hra gamesa;
    public PrikazRozhlednout(Hra hra)
    {
        gamesa = hra;
    }

    public String getNazev()
    {
        return "rozhlednout";
    }

    public String proved(String[] parametryPrikazu)
    {
        if (parametryPrikazu.length != 0)
        {
            return "Neočekávám žádný parametr";
        }

        HerniSvet svet = gamesa.getHerniSvet();
        Lokace akt = svet.getAktualniLokace();

        return akt.getDetailniPopis();

    }
}
