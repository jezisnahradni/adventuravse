package logika;
import java.util.*;

public class PrikazOchutnat implements IPrikaz
{
    private Hra hra;
    public PrikazOchutnat(Hra hra)
    {
        this.hra = hra;
    }
    public String getNazev()
    {
        return "ochutnat";
    }
    public String proved(String[] parametryPrikazu)
    {
        if (parametryPrikazu.length < 1) {
            return "Nevím co mám ochutnat.";
        }
        if (parametryPrikazu.length > 1) {
            return "Nedokážu ochutnávat více věcí najednou.";
        }
        String nazevOchutnavky = parametryPrikazu[0];
        HerniSvet herniSvet = hra.getHerniSvet();
        Lokace aktualniLokace = herniSvet.getAktualniLokace();

        if (nazevOchutnavky.equals("lahudka"))
        {
            if (aktualniLokace.maItem("lahudka"))
            {
                List<Lokace> lokaci = Arrays.asList(herniSvet.uhliri, herniSvet.kostel, herniSvet.rozcestnik, herniSvet.staj);
                Random r = new Random();
                Lokace nahodnaLokace = lokaci.get(r.nextInt(lokaci.size()));

                herniSvet.setAktualniLokace(nahodnaLokace);
                String v = "To byla síla, dávej si pozor co strkáš do pusy! Budeš se muset porozhlédnout abys vůbec zjistil kde jsi.";
                if (nahodnaLokace.equals(herniSvet.uhliri))
                {
                    return v + "\nProbudil tě hlasitý smích uhlířů, Zrzek radší dělá, že tě nezná.";
                }
                else if(nahodnaLokace.equals(herniSvet.kostel))
                {
                    return v + "\nProbudila tě farářova prosba o spasení tvé důše. Farár si tě radší nevšímá. Nevěří svím očím.";
                }
                else if(nahodnaLokace.equals(herniSvet.rozcestnik))
                {
                    return v + "\nProbudil tě venkosvký vítr. Nastěstí zde není kdo by se ti smál, probudil ses kousek od značky. Nejspíš si o ni zakopl.";
                }
                else if(nahodnaLokace.equals(herniSvet.staj))
                {
                    return v + "\nProbudil tě koňský smích. Panský kůn se na tebe celkem divně dívá. Možná by ses měl začít ovládát.";
                }
            }
        }
        else if (nazevOchutnavky == "oroseny")
        {
            Inventar inv = herniSvet.getInventar();
            if (inv.maItem("oroseny"))
            {
                return "Mám ze včerejšká dost, víc nechci. Někomu udělá větší radost.";
            }
            else
            {
                return "Tohle zrovná nemám u sebe.";
            }
        }
        else if (nazevOchutnavky == "houba")
        {
            Inventar inv = herniSvet.getInventar();
            if (inv.maItem("oroseny"))
            {
                return "Na tohle je expert místní lovec.";
            }
            else
            {
                return "Tohle zrovná nemám u sebe.";
            }
        }
        return "Přece tohle nebudu ochutnávat!";

    }
}

