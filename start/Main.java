package start;

import logika.Hra;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {


        Hra hra = new Hra();
        Scanner sc = new Scanner(System.in);

        System.out.println("Tohle je hra o Samuelovi z Vestce, jsi běžný sedlák a chceš se vydat do Brodu z kterého se potom vydáš do světa,\n" +
                "před tím než utečeš do Brodu, musíš nasbírat potřebné věci, budeš potřebovat meč, lektvar a čepici\nProbudil si se v hospodě, naštěstí už je vše zaplaceno.\n\n"
                +"Můžeš používat příkazy \n"+
                "jdi , vzit, poloz, ochutnat, promluvit, poprostit, rozhlednout, zjistit, batuzek, napoveda, konec \n");

        while (!hra.isHraSkoncila())
        {
            String s = sc.nextLine();
            String v = hra.zpracujPrikaz(s);
            System.out.println(v);
        }
    }
}