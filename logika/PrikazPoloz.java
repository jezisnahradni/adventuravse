package logika;





public class PrikazPoloz implements IPrikaz {

    private Hra hra;
    public PrikazPoloz(Hra hra)
    {
        this.hra = hra;
    }

    public String getNazev()
    {
        return "poloz";
    }

    public String proved(String[] parametryPrikazu) {

        if (parametryPrikazu.length < 1) {
            return "Musíš mi říct, co mám položit";
        }
        if (parametryPrikazu.length > 1) {
            return "Tomu nerozumím, nevím co mám položit";
        }

        String nazevItemu = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        Inventar inv = herniSvet.getInventar();
        Item item = inv.vratItem(nazevItemu);

        if (item == null) {
            return "Item " + nazevItemu + " v batůžku nemáš.";
        }
        else{
            inv.vyuzitItem(item);
            aktualniLokace.pridejItem(item);
            return nazevItemu + " jsi položil do lokace " + aktualniLokace.getNazev();
        }
    }
}
