package com.example.ProjetJEE;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Panier {
    private HashMap<Long,Article> listArticlePanier = new HashMap<>();
    private HashMap<Long,Double> listPrixUnitaireTTC = new HashMap<>();
    private Double totalTTC;
    private HashMap<Long,Double> listMontantTauxTVA = new HashMap<>();
    private final DecimalFormat df = new DecimalFormat("0.00");

    public Panier(HashMap<Long, Article> listArticlePanier) {
        this.listArticlePanier = listArticlePanier;
    }

    public Panier() {
    }

    public HashMap<Long, Article> getlistArticlePanier() {
        return listArticlePanier;
    }

    public void setlistArticlePanier(HashMap<Long, Article> listArticlePanier) {
        this.listArticlePanier = listArticlePanier;
    }

    public HashMap<Long, Double> getListPrixUnitaireTTC() {
        return listPrixUnitaireTTC;
    }

    public void setListPrixUnitaireTTC(HashMap<Long, Double> listPrixUnitaireTTC) {
        this.listPrixUnitaireTTC = listPrixUnitaireTTC;
    }

    public Double getTotalTTC() {
        return totalTTC;
    }

    public void setTotalTTC(Double totalTTC) {
        this.totalTTC = totalTTC;
    }

    public HashMap<Long, Double> getListMontantTauxTVA() {
        return listMontantTauxTVA;
    }

    public void setListMontantTauxTVA(HashMap<Long, Double> listMontantTauxTVA) {
        this.listMontantTauxTVA = listMontantTauxTVA;
    }


    public void CalculAutomatiquePrixUnitaireTTC(HashMap<Long,Article> listArticlePanier){
        for (Map.Entry<Long,Article> article: listArticlePanier.entrySet()) {
            double prixUnitaireTTC;

            if(article.getValue().getTauxTVA()==550){
                prixUnitaireTTC = Double.parseDouble(df.format(article.getValue().getPrixHT()*1.055));
            }else{
                prixUnitaireTTC = Double.parseDouble(df.format(article.getValue().getPrixHT()*1.2));
            }
            listPrixUnitaireTTC.put(article.getKey(), prixUnitaireTTC);
        }
    }

    public void CalculAutomatiqueTTC(HashMap<Long,Double> listPrixUnitaireTTC){
        Double prixUnitaireTTC =0.0;

        for (Map.Entry<Long,Double> prixTTC: listPrixUnitaireTTC.entrySet()) {
            prixUnitaireTTC += prixTTC.getValue();
        }
        totalTTC = Double.parseDouble(df.format(prixUnitaireTTC));
    }


    public void CalculAutomatiqueMontantUnitaireTVA(HashMap<Long,Article> listArticlePanier){
        for (Map.Entry<Long,Article> article: listArticlePanier.entrySet()) {
            double prixUnitaireTTC;

            if(article.getValue().getTauxTVA()==550){
                prixUnitaireTTC = Double.parseDouble(df.format(article.getValue().getPrixHT()*0.055));
            }else{
                prixUnitaireTTC = Double.parseDouble(df.format(article.getValue().getPrixHT()*0.2));
            }
            listMontantTauxTVA.put(article.getKey(), prixUnitaireTTC);
        }
    }
    public void execute(){
        CalculAutomatiquePrixUnitaireTTC(listArticlePanier);
        CalculAutomatiqueTTC(listPrixUnitaireTTC);
        CalculAutomatiqueMontantUnitaireTVA(listArticlePanier);
    }
}
