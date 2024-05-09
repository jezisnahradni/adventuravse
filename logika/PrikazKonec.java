package logika;



public class PrikazKonec implements IPrikaz
{
    private Hra hra;
    
    public PrikazKonec(Hra hra)
    {
        this.hra = hra;
    }
    
    public String getNazev()
    {
        return "konec";
    }
    
    public String proved(String[] parametryPrikazu)
    {
        hra.setHraSkoncila(true);
            
        return "Hra byla ukončena příkazem KONEC.";
    }
}
