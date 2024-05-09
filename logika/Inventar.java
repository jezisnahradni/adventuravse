package logika;

import java.util.*;

public class Inventar
{
    private Set<Item> inventar;
    private int inventarMaxVelikost;

    public Inventar(){
        inventar = new HashSet<>();
        this.inventarMaxVelikost = 4;

    }
    public String getInventar()
    {
        String nazvyItemu = "V batůžku máš: ";
        for (Item item : inventar)
        {
            nazvyItemu += " " + item.getNazev();
        }
        return nazvyItemu;

    }
    public boolean batuzekEmpty()
    {
        return inventar.isEmpty();
    }
    public boolean pridatItem(Item item)
    {
        return inventar.add(item);
    }
    public int getMaxVelikost()
    {
        return inventarMaxVelikost;
    }
    public int getVelikost()
    {
        return inventar.size();
    }
    public Item vratItem(String nazevItemu)
    {
        for (Item p : inventar)
        {
            if (p.getNazev().equals(nazevItemu))
            {
                return p;
            }
        }
        return null;
    }
    public boolean maItem(String nazevItemu)
    {
        for (Item p : inventar)
        {
            if (p.getNazev().equals(nazevItemu))
            {
                return true;
            }
        }
        return false;
    }
    public boolean vyuzitItem(Item item)
    {
        return inventar.remove(item);
    }
}
