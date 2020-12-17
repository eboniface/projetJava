package com.example.ProjetJEE;

public class Article {

    private long codeBarre;
    private String reference;
    private String libelle;
    private int prixHT;
    private int tauxTVA;
    private final static int[] ValeurTauxTVA ={550,2000};

    public Article(long codeBarre, String reference, String libelle, int prixHT, int tauxTVA) {
        this.codeBarre = codeBarre;
        this.reference = reference;
        this.libelle = libelle;
        this.prixHT = prixHT;
        this.tauxTVA = tauxTVA;
    }

    public Article() {

    }

    public long getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(long codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(int prixHT) {
        this.prixHT = prixHT;
    }

    public int getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(int tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public static int[] getValeurTauxTVA() {
        return ValeurTauxTVA;
    }
}
