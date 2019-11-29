package com.example.lv1.Model;

public class Student {
    private String ime;
    private String prezime;
    private String datumRodenja;
    private String predmet;
    private String profesor;
    private String godina;
    private String predavanja;
    private String vjezbe;

    public Student(String Ime, String Prezime, String DatumRodenja, String Predmet, String Profesor, String Godina, String Predavanja, String Vjezbe) {
        ime = Ime;
        prezime= Prezime;
        datumRodenja = DatumRodenja;
        predmet = Predmet;
        profesor = Profesor;
        godina = Godina;
        predavanja = Predavanja;
        vjezbe = Vjezbe;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getDatumRodenja() {
        return datumRodenja;
    }

    public String getPredmet() {
        return predmet;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getGodina() {
        return godina;
    }

    public String getPredavanja() {
        return predavanja;
    }

    public String getVjezbe() {
        return vjezbe;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setDatumRodenja(String datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setGodina(String godina) {
        this.godina = godina;
    }

    public void setPredavanja(String predavanja) {
        this.predavanja = predavanja;
    }

    public void setVjezbe(String vjezbe) {
        this.vjezbe = vjezbe;
    }
}
