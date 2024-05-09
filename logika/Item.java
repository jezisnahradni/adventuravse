package logika;

public class Item
{
    private String nazev;
    private String popis;

    private boolean prenositelnost;
    private String procNejdeVzit;


    public Item(String nazev, String popis, boolean prenositelnost, String procNejdeVzit){
        this.nazev=nazev;
        this.popis=popis;

        this.prenositelnost = prenositelnost;
        this.procNejdeVzit = procNejdeVzit;
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
    public boolean isPrenositelny() {
        return prenositelnost;
    }
    public void setPrenositelnost(boolean prenositelnost) {
        this.prenositelnost = prenositelnost;
    }
    public String getProcNejdeVzit() {
        return procNejdeVzit;
    }
}