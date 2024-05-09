package logika;

public class PrikazPromluvit implements IPrikaz {


    private Hra hra;
    public PrikazPromluvit(Hra hra)
    {
        this.hra = hra;
    }

    public String getNazev()
    {
        return "promluvit";
    }

    public String proved(String[] parametryPrikazu) {

        if (parametryPrikazu.length < 1) {
            return "Nevím na koho mám mluvit";
        }
        if (parametryPrikazu.length > 1) {
            return "Můžu vést konverzaci pouze s jednou osobou";
        }
        String nazevOsoby = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();

        Osoba o = aktualniLokace.vratOsobu(nazevOsoby);
        if (!(o == null)) {
            if (!o.stavZnamosti()) {
                o.seznameno();
                return o.getDialogVitej();
            } else return o.getDialogVitejZnameSe();
        } else return "Přece nebudu mluvit k věci!";
    }
}
