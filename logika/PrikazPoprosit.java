package logika;

public class PrikazPoprosit implements IPrikaz
{


    private Hra hra;
    public PrikazPoprosit(Hra hra)
    {
        this.hra = hra;
    }

    public String getNazev()
    {
        return "poprosit";
    }

    public String proved(String[] parametryPrikazu)
    {

        if (parametryPrikazu.length < 1) {
            return "Nevím u koho mám žadonit";
        }
        if (parametryPrikazu.length > 1) {
            return "Můžu žadonit pouze u jedné osoby najednou";
        }
        String nazevOsoby = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();
        Lokace inv = herniSvet.getInventarOsob();
        Osoba o = aktualniLokace.vratOsobu(nazevOsoby);

        if (o == null)
        {
            return "To není osoba!";
        }
        if (!(o.stavZnamosti()))
        {
            if (o.equals(herniSvet.getHospodsky()))
            {
                herniSvet.setAktualniLokace(herniSvet.namesti);
                Lokace kamVyhodil = herniSvet.getAktualniLokace();
                return o.getDialogNepros() + "\n*hospodký Karel, tě za tvou drzost vyhodil z hospody* \nNacházíš se teď v lokaci: " + kamVyhodil.getNazev();
            }
            else return o.getDialogNepros();
        }
        else if (o.equals(herniSvet.getFarar()))
        {
            if (!aktualniLokace.maItem("svicka"))
            {
                return "Vidím synu, že svíčku sis již vzal, nechť dobře slouží.";
            }
            else
            {
                Item svicka = herniSvet.svicka;
                svicka.setPrenositelnost(true);
                return o.getDialogProseniHotovo();
            }
        }
        else if (o.equals(herniSvet.getHospodsky()))
        {
            if (!inv.maItem("oroseny"))
            {
                return "Pivo už jsem ti dal, žádné nemám mladej!";
            }

            Item i = herniSvet.oroseny;
            aktualniLokace.pridejItem(i);
            inv.odeberItem(i);
            o.setDialog("Rád tě vidím, orosený, už ale nemám.");
            return o.getDialogProseniHotovo();
        }
        else if (o.equals(herniSvet.zrzek))
        {
            if (!aktualniLokace.maItem("oroseny"))
            {
                return o.getDialogProseniNeuskutecneno();
            }
            else if (aktualniLokace.maItem("cepice"))
            {
                return o.getDialogProseniHotovo();
            }
            else
            {
                Item i = herniSvet.cepice;
                aktualniLokace.pridejItem(i);
                inv.odeberItem(i);
                aktualniLokace.odeberItem(herniSvet.oroseny);
                o.setDialog("Ať ti slouží čepka!");
                o.setDialogProseniNeuskutecneno("Ať ti slouží čepka!");
                return o.getDialogProseniHotovo();
            }
        }
        else if (o.equals(herniSvet.lovec))
        {
            if (!aktualniLokace.maItem("houba"))
            {
                return o.getDialogProseniNeuskutecneno();
            }
            else if (inv.maItem("houba"))
            {
                return o.getDialogProseniHotovo();
            }
            else if (aktualniLokace.maItem("houba"))
            {
                Item i = herniSvet.lektvar;
                aktualniLokace.pridejItem(i);
                inv.odeberItem(i);
                aktualniLokace.odeberItem(herniSvet.houba);
                inv.pridejItem(herniSvet.houba);
                o.setDialog("Nevypíj to najednou!");
                return o.getDialogProseniHotovo();
            }
            return null;
        }
        else if (o.equals(herniSvet.straz))
        {
            if (!aktualniLokace.maItem("kumanskeucho"))
            {
                return o.getDialogProseniNeuskutecneno();
            }
            else if (inv.maItem("kumanskeucho"))
            {
                return o.getDialogProseniHotovo();
            }
            else if (aktualniLokace.maItem("kumanskeucho"))
            {
                Item i = herniSvet.mec;
                aktualniLokace.pridejItem(i);
                inv.odeberItem(i);
                aktualniLokace.odeberItem(herniSvet.kumanskeucho);
                inv.pridejItem(herniSvet.kumanskeucho);
                o.setDialog("Neřízni se!");
                return o.getDialogProseniHotovo();
            }
            return null;
        }
        return o.getDialogProseniHotovo();
    }
}