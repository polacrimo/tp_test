package appli_bancaire;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class compteBancaire {

    private static final AtomicInteger ID_COMPTE = new AtomicInteger(1);
    protected final int code;
    protected double solde;
    protected ArrayList<operation> listeOperations;

    public compteBancaire(){
        code = ID_COMPTE.getAndIncrement();
        solde = 0;
        listeOperations = new ArrayList<operation>();
    }

    public void verser(double montant){
        versement versement = new versement(montant);
        solde += montant;
        listeOperations.add(versement);
    }

    abstract void retirer(double montant);

    abstract void virement(double montant, compteBancaire compte);
    
    public double consulterSolde(){
        return solde;
    }

    abstract void updateSolde();

    public ArrayList<operation> listerOperations(){
        return listeOperations;

    }

    public double totalVersements(){
        double totalVersements = 0;
        for (operation o: listeOperations){
            if (o.getClass() == versement.class){
                totalVersements += o.getMontant();
            }
        }
        return totalVersements;
    }

    public double totalRetraits(){
        double totalRetraits = 0;
        for (operation o: listeOperations){
            if (o.getClass() == retrait.class){
                totalRetraits += o.getMontant();
            }
        }
        return totalRetraits;
    }

    public String toString(){
        return "Compte n° " + code + ", solde : " + solde;
    }

}