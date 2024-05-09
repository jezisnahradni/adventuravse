package logika;

import java.util.*;

public class Hra
{
    private boolean hraSkoncila;
    private HerniSvet herniSvet;
    
    private Set<IPrikaz> prikazy;
    
    public Hra()
    {
        hraSkoncila = false;
        herniSvet = new HerniSvet();
        
        prikazy = new HashSet<>();
        
        prikazy.add(new PrikazJdi(this));
        prikazy.add(new PrikazKonec(this));
        prikazy.add(new PrikazNapoveda());
        prikazy.add(new PrikazRozhlednout(this));
        prikazy.add(new PrikazBatuzek(this));
        prikazy.add(new PrikazVzit(this));
        prikazy.add(new PrikazPoloz(this));
        prikazy.add(new PrikazPromluvit(this));
        prikazy.add(new PrikazPoprosit(this));
        prikazy.add(new PrikazZjistit(this));
        prikazy.add(new PrikazOchutnat(this));
    }
    
    public boolean isHraSkoncila()
    {
        return hraSkoncila;
    }
    
    public void setHraSkoncila(boolean hraSkoncila)
    {
        this.hraSkoncila = hraSkoncila;
    }
    
    public HerniSvet getHerniSvet()
    {
        return herniSvet;
    }


    public String zpracujPrikaz(String prikaz)
    {
        String[] casti = prikaz.split(" ");
        
        String[] parametryPrikazu = new String[casti.length - 1];
        for (int i = 1; i < casti.length; i++) {
            parametryPrikazu[i - 1] = casti[i];
        }
        
        for (IPrikaz p : prikazy) {
            if (p.getNazev().equals(casti[0])) {
                return p.proved(parametryPrikazu);
            }
        }
        
        return "Tento příkaz neznám.";
    }
}
