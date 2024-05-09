package logika;



public class PrikazNapoveda implements IPrikaz
{
    public String getNazev()
    {
        return "napoveda";
    }
    
    public String proved(String[] parametryPrikazu)
    {
        return "Tohle je hra o Samuelovi z Vestce, jsi běžný sedlák a chceš se vydat do Brodu z kterého se potom vydáš do světa, \n"+
                "před tím než utečeš do Brodu, musíš nasbírat potřebné věci, budeš potřebovat meč, lektvar a čepici \n"
                + "Můžeš používat příkazy \n"
                + "jdi , vzit, poloz, ochutnat, promluvit, poprosit, rozhlednout, zjistit, batuzek, napoveda, konec \n";
    }
}
