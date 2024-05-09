package logika;

import java.util.*;

public class Lokace
{
    private String nazev;
    private String popis;
    
    private Set<Lokace> vychody;
    private Set<Item> itemy;
    private Set<Osoba> osoby;

    public Lokace(String nazev, String popis)
    {
        this.nazev = nazev;
        this.popis = popis;
        
        vychody = new HashSet<Lokace>();
        itemy = new HashSet<Item>();
        osoby = new HashSet<Osoba>();
    }

    public String getNazev()
    {
        return nazev;
    }
    public String getPopis()
    {
        return popis;
    }
    public void setPopis(String popis)
    {
        this.popis = popis;
    }
    public boolean obsahujeItem(String item)
    {
        return itemy.contains(item);
    }

    public boolean odeberItem(Item item)
    {
        return itemy.remove(item);
    }
    public String getDetailniPopis()
    {
        String nazvyVychodu = "Východy:";
        for (Lokace vychod : vychody)
        {
            nazvyVychodu += " " + vychod.getNazev();
        }
            String p;
            if (itemy.isEmpty())
            {
                p = "V lokaci nevidíš žádné itemy";
            }
            else if (itemy.size() == 1)
            {
                    p = "V lokaci vidíš item:";
            }
            else
            {
                p = "V lokaci vidíš itemy:";
            }


        String o;
        if (osoby.isEmpty())
        {
            o = "V lokaci nevidíš žádné osoby";
        }
        else if (osoby.size() == 1)
        {
            o = "V lokaci je osoba:";
        }
        else
        {
            o = "V lokaci jsou osoby:";
        }
        String nazvyOsob = o;
        for (Osoba osoba : osoby)
        {
            nazvyOsob += " " + osoba.getNazev();
        }
            String nazvyItemu = p;
            for (Item item : itemy)
            {
                nazvyItemu += " " + item.getNazev();
            }
        return "Jsi v lokaci -" + nazev + "-.\n"
                + popis + "\n\n"
                + nazvyVychodu + "\n"
                + nazvyItemu + "\n"
                + nazvyOsob;
    }
    public boolean pridejVychod(Lokace cilovaLokace)
    {
        return vychody.add(cilovaLokace);
    }
    public boolean pridejItem(Item item)
    {
        return itemy.add(item);
    }

    public boolean maVychod(String nazevLokace)
    {
        for (Lokace l : vychody)
        {
            if (l.getNazev().equals(nazevLokace))
            {
                return true;
            }
        }
        return false;
    }
    public Lokace vratVychod(String nazevLokace)
    {
        for (Lokace l : vychody)
        {
            if (l.getNazev().equals(nazevLokace))
            {
                return l;
            }
        }
        return null;
    }

    public boolean maItem(String nazevItemu)
    {
        for (Item p : itemy)
        {
            if (p.getNazev().equals(nazevItemu))
            {
                return true;
            }
        }
        return false;
    }

    public Item vratItem(String nazevItemu)
    {
        for (Item p : itemy)
        {
            if (p.getNazev().equals(nazevItemu))
            {
                return p;
            }
        }
        return null;
    }

    public boolean pridejOsobu(Osoba osoba)
    {
        return osoby.add(osoba);
    }
    public boolean odendejOsobu(Osoba osoba)
    {
        return osoby.remove(osoba);
    }
    public Osoba vratOsobu(String nazevOsoby)
    {
        for (Osoba o : osoby)
        {
            if (o.getNazev().equals(nazevOsoby))
            {
                return o;
            }
        }
        return null;
    }
}
