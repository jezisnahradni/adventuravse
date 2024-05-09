package logika;

public class PrikazBatuzek implements IPrikaz{

    private Hra hra;
    public PrikazBatuzek(Hra hra)
    {
        this.hra = hra;
    }
    public String getNazev()
    {
        return "batuzek";
    }
    public String proved(String[] parametryPrikazu)
    {
        HerniSvet herniSvet = hra.getHerniSvet();
        Inventar inv = herniSvet.getInventar();
        int zbyvajiciMisto = inv.getMaxVelikost() - inv.getVelikost();
        if (inv.batuzekEmpty())
        {
            return "Tvůj batůžek o velikosti " + zbyvajiciMisto + " míst je prázdný";
        }
        return inv.getInventar() + "\n" + "V batůžku máš ještě místo na "+ zbyvajiciMisto + " itemů";
    }
}
