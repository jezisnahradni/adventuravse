package logika;

import java.util.HashSet;
import java.util.Set;

public class HerniSvet
{
    private Lokace aktualniLokace;
    private Lokace inv;
    private Inventar inventar;
    private Osoba hospodsky;
    private Osoba farar;
    public Osoba straz;
    public Osoba zrzek;
    public Item svicka;
    public Item oroseny;
    public Item medvedihlava;
    public Item mec;
    public Item cepice;
    public Osoba lovec;
    public Item lektvar;
    public Item houba;
    public Item kumanskeucho;
    public Lokace jeskyne;
    public Lokace les;
    public Lokace rozcestnik;
    public Lokace kostel;
    public Lokace uhliri;
    public Lokace staj;
    public Osoba kocka;
    public Lokace namesti;


    public HerniSvet()
    {
        Lokace brod = new Lokace ("brod","Výhrál jsi! Jsi na cestě do světa!" );
        Lokace inventarOsob = new Lokace ("inv", "zde nemas co delat, ani se to nemas jak dostat");
            Item oroseny = new Item ("oroseny","Mistrovské pivečko s perfektní mírou", true, "");
            Item mec = new Item ("mec","Ostrý jako břitva, usekl by hlavu i medvědovi! - Potřebný předmět k dokončení hry.", true, "");
            Item lektvar = new Item ("lektvar","Snad v něm nejsou žádné houby. - Potřebný předmět k dokončení hry.",true,"");
            Item cepice = new Item ("cepice","Sebevrahova čepice, nebude mi s ní svítit do oči na cestách - Potřebný předmět k dokončení hry.",true,"");
            inventarOsob.pridejItem(cepice);
            inventarOsob.pridejItem(oroseny);
            inventarOsob.pridejItem(mec);
            inventarOsob.pridejItem(lektvar);

        Lokace hrad = new Lokace("hrad","Stojíš před hlavní branou do hradu Vestce, bránů stráží hradní stráž.");
            Osoba straz = new Osoba("straz","Má pořádný meč, taky bych chtěl takový mít. Třeba mi ho dá.",
                    "Nazdar! Ztratil jsem moje šťastné ucho, dones mi ho a dám ti meč. Naposledy jsem byl ve stáji.",
                    "Že já tě propíchnu. Pozdrav!",
                    "Zdarec, Samueli!",
                    "Už si našel to ucho ve stáji? Jestli jo, polož mi ho tady.",
                    "Tady ho máš, mám doma dalších dvacet, znamý mi je dováží z Ústí.",false);
            hrad.pridejOsobu(straz);

        Lokace kostel = new Lokace("kostel","Honosně postavý kostel, cítíš zde jakousi divnou sílu, kostel hlídá místní farář.");
            Osoba farar = new Osoba("farar","Farář Žid, dobrák od kosti, pro ostatní by se roztrhal, určitě mi dá co budu chtít.",
                    "Pochválen buď Ježíš Kristus.",
                    "No co by na to řekl všemocný pán! Aspoň pozdrav!",
                    "Pochválen buď Ježíš Kristus, Samueli.",
                    "Stačí poprosit",
                    "Chtěl by si svíčku všemocného? Vezmi si ji támhle z oltáře, jen ať tě světlo dovede k našemu osvoboditeli Ježíši Kristovi.",false);
            kostel.pridejOsobu(farar);
            Item svicka = new Item("svicka","Hodně svítí, dokázala by osvítit i velkou jeskyni.",false,"přece nebudeš krást na svaté půdě, popros faráře.");
            kostel.pridejItem(svicka);

        Lokace rozcestnik = new Lokace("rozcestnik","Rozcestník čtyř cest, které vedou k uhlířům, na námestí, do kostela a do Brodu.");
            Item znacka = new Item("znacka","Má na sobě značky, Východní cesta - k uhlířům, Západní cesta - k Brodu, Jihovýchodní cesta - na faru a hradu, Jižní cesta - na námestí.",false,"jak chceš sám zvednout metrovou kládu?");
            rozcestnik.pridejItem(znacka);
            Osoba kocka = new Osoba("kocka","Roztomilá toulavá černá kočička",
                    "vrr",
                    "mrrr",
                    "mňau",
                    "vrrrrr",
                    "*škrábe si drápky*",
                    false);
                    rozcestnik.pridejOsobu(kocka);
        Lokace uhliri = new Lokace("uhliri","Uhlíři u lesa, máš zde kamaráda zrzka, třeba ti pomůže sehnat jeden ze tří hlavních itemů.");
            Osoba zrzek = new Osoba("zrzek","Můj nejlepší kamarád Tomáš, řikám mu ale Zrzek, co by ale neudělal pro jedno orosený.",
                    "Nazdar Samueli! Podívej na tuhle super čepici, vzal jsem ji tomu cápkovi na mostě.",
                    "No tak dlouho jsme se neviděli. Snad pozdravíš ne?",
                    "Nazdar Samueli, co řikáš na tu čepku?",
                    "Tu čepku ti dám, ale polož mi tady jedno orosený",
                    "No to byl obchod panečku!",false);
        uhliri.pridejOsobu(zrzek);

        Lokace namesti = new Lokace("namesti","Malé naměstíčko Vestce, nikde nikdo, asi všichni ještě spí.");
        Lokace hospoda = new Lokace("hospoda","Taková klasická hospůdka co každé město má, při pohledu na ní si dostal chuť na jedno orosený, ale to možná až příště.");
            Osoba hospodsky = new Osoba("hospodsky", "Starý dobrý hospodský, ještě že má neomezeně piv.",
                    "Zdarec mladej!",
                    "Ani se nepředstavíš a hned žadoníš! Mazej mladej, příště aspon pozdrav!",
                    "Rád tě zase vidím!",
                    "Stačí poprosit",
                    "Tady máme jedno orosený pro mladého pána!",false);
            hospoda.pridejOsobu(hospodsky);
            Item lahudka = new Item("lahudka","Nevíš co v ní je. Možná to ani vědět nechceš.", false,"dívá se na tebe hospodský, přece za to nechceš platit! Možná bys ale mohl trochu ochutnat.");
                hospoda.pridejItem(lahudka);


        Lokace lazne = new Lokace("lazne","Lázně vedle rybníčku, pěkné místo k odpočinku");
            Osoba lazebnice = new Osoba("lazebnice", "To je Johanka, je to pěkná holka.",
                    "Pochválen buď Ježíš Kristus, Samueli!",
                    "Přece se nejdříve pozdravíme ne?",
                    "Jestli si zapomněl v téhle lokaci si můžeš schovat itemy, které si myslíš, že už nepotřebuješ. Ten batůžek co jsem ti dávno dala je celkem malý, je hezké, že ho stále používáš.",
                    "Stačí poprosit",
                    "Už ti nemám co nabídnout Samueli.",false);
            lazne.pridejOsobu(lazebnice);

        Lokace chata = new Lokace("chata","V chatce u lesa bydlí lovec, možná by ti pomohl sehnat nějakou tu zbraň");
            Osoba lovec = new Osoba("lovec", "Místní lovec, stará se zvěř, která by mohla ohrožovat místních. Bojí se ale ježků",
                    "Ahoj, jsem místní lovec, ale to už určitě víš, žiješ tady jak dlouho.",
                    "Nejdřív si promluvíme, potom to vyřešíme.",
                    "Do lesa by nikdo neměl chodit, jsou tam sice houby, ale žije tam něco strašného!",
                    "Pokud by jsi chtěl ten lektvar, polož mi na stůl houbu z lesa",
                    "Nikomu o tom neříkej.",false);
            chata.pridejOsobu(lovec);

        Lokace most = new Lokace("most","Malý dřevený můstek přes potůček Kvaj, jak tiše stojíš, slyšíš klidný tok malého potůčku");
            Osoba sebevrah = new Osoba("sebevrah","Vypadá smutně, ten mi s ničím nepomůže.",
                    "Nemluv na mě nebo skočím!",
                    "To už jsem na tom tak špatně, že ani nepozdravíš?!",
                    "Já opravdu skočím!",
                    "Stačí poprosit",
                    "Bude se mnou konec, jestli mě nenecháš!",false);
            most.pridejOsobu(sebevrah);

        Lokace staj = new Lokace("staj","Až příliš velká stáj pro malé město, vidíš panské koně a spoustu dalších.");
            Item kumanskeucho = new Item("kumanskeucho","Krvavé ucho, co dělá ve stáji?!, třeba patří nějakému vojákovi.",true,"");
            staj.pridejItem(kumanskeucho);


        Lokace les = new Lokace("les","Temný a hustý les, nevídíš nic jiného než stromy, neztratil si se?");
            Osoba jezek = new Osoba("jezek","Je to zabijácký ježek, ještě že si myslí, že jsi mědvěd.",
                    "ks Zdar medvěde ks",
                    "ks hleď si svého méďo ks",
                    "ks jdi zas hybernovat nebo co to vy medvědi děláte brumlo ks!",
                    "ks stačí poprosit ks",
                    "ks dej mi pokoj medvěde ks",false);
            les.pridejOsobu(jezek);
            Item houba = new Item("houba","Ta má pěknou barvu, lovec si s ní pořádně užije.",true,"");
            les.pridejItem(houba);

        Lokace jeskyne = new Lokace("jeskyne","V jeskyni je tma, nic nevidíš jen slyšíš jak se tvé kroky toulají do hlubyn skály.");
            Item medvedihlava = new Item("medvedihlava","Mrtvé tělo medvěda, možná bych jeho hlavu mohl použít, aby si mě ježek nevšímal.",false,"Musím mít u sebe meč, abych jí odsekl od zbytku těla.");
            jeskyne.pridejItem(medvedihlava);

        hrad.pridejVychod(kostel);
        kostel.pridejVychod(hrad);
        rozcestnik.pridejVychod(kostel);
        kostel.pridejVychod(rozcestnik);
            uhliri.pridejVychod(rozcestnik);
            rozcestnik.pridejVychod(uhliri);
                rozcestnik.pridejVychod(brod);
        rozcestnik.pridejVychod(namesti);
        namesti.pridejVychod(rozcestnik);
            namesti.pridejVychod(lazne);
            namesti.pridejVychod(hospoda);
            namesti.pridejVychod(chata);
            chata.pridejVychod(namesti);
            hospoda.pridejVychod(namesti);
            lazne.pridejVychod(namesti);
        most.pridejVychod(namesti);
        namesti.pridejVychod(most);
            most.pridejVychod(staj);
            most.pridejVychod(les);
            most.pridejVychod(jeskyne);
            staj.pridejVychod(most);
            les.pridejVychod(most);
            jeskyne.pridejVychod(most);

        inventarOsob.pridejVychod(hospoda);
        hospoda.pridejVychod(inventarOsob);


        inventar = new Inventar();
        aktualniLokace = hospoda;
        inv = inventarOsob;
        this.hospodsky = hospodsky;
        this.farar = farar;
        this.svicka = svicka;
        this.oroseny = oroseny;
        this.medvedihlava = medvedihlava;
        this.mec = mec;
        this.zrzek = zrzek;
        this.cepice = cepice;
        this.lovec = lovec;
        this.lektvar = lektvar;
        this.houba = houba;
        this.straz = straz;
        this.kumanskeucho = kumanskeucho;
        this.jeskyne = jeskyne;
        this.les = les;
        this.rozcestnik = rozcestnik;
        this.kostel = kostel;
        this.uhliri = uhliri;
        this.staj = staj;
        this.kocka = kocka;
        this.namesti = namesti;
    }
    
    public Lokace getAktualniLokace()
    {
        return aktualniLokace;
    }
    public Inventar getInventar(){
        return inventar;
    }
    public Lokace getInventarOsob(){
        return inv;
    }
    public void setAktualniLokace(Lokace aktualniLokace)
    {
        this.aktualniLokace = aktualniLokace;
    }

    public Osoba getHospodsky(){
        return hospodsky;
    }
    public Osoba getFarar(){
        return farar;
    }
}
