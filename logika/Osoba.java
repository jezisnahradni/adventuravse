package logika;

public class Osoba {

    private String nazev;
    private String popis;
    private String dialogVitej;
    private String dialogNepros;
    private String dialogVitejZnameSe;
    private String dialogProseniNeuskutecneno;
    private String dialogProseniHotovo;

    private boolean promluveno;


    public Osoba(String nazev, String popis, String dialogVitej, String dialogNepros,String dialogVitejZnameSe,String dialogProseniNeuskutecneno,String dialogProseniHotovo, boolean promluveno)
    {
        this.nazev = nazev;
        this.popis = popis;
        this.dialogVitej = dialogVitej;
        this.dialogNepros = dialogNepros;
        this.dialogVitejZnameSe = dialogVitejZnameSe;
        this.dialogProseniNeuskutecneno = dialogProseniNeuskutecneno;
        this.dialogProseniHotovo = dialogProseniHotovo;
        this.promluveno = promluveno;
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
    public void setDialog(String dialog)
    {
        this.dialogVitejZnameSe = dialog;
    }
    public void setDialogProseniNeuskutecneno(String dialog)
    {
        this.dialogProseniNeuskutecneno = dialog;
    }
    public void setDialogProseniHotovo(String dialog)
    {
        this.dialogProseniHotovo = dialog;
    }
    public String getDialogVitej()
    {
        return dialogVitej;
    }
    public String getDialogNepros()
    {
        return dialogNepros;
    }
    public String getDialogVitejZnameSe()
    {
        return dialogVitejZnameSe;
    }
    public String getDialogProseniNeuskutecneno()
    {
        return dialogProseniNeuskutecneno;
    }
    public String getDialogProseniHotovo()
    {
        return dialogProseniHotovo;
    }
    public boolean stavZnamosti()
    {
        return promluveno;
    }
    public void seznameno()
    {
        promluveno = true;
    }



}
