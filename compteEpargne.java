package appli_bancaire;

public class compteEpargne extends compteBancaire {

    private double taux;

    public compteEpargne(double taux){
        super();
        this.taux = taux;
    }
    
    void retirer(double montant){
        if (solde <= 0){
            System.err.println("Votre autorisation de découvert est épuisée");
        } else if (solde < montant){
            System.err.println("Votre solde est insuffisant pour effectuer cette opération");
        } else {
            retrait retrait = new retrait(montant);
            solde -= montant;
            listeOperations.add(retrait);
        }
    }

    void virement(double montant, compteBancaire compte) {
        if (solde <= 0){
            System.err.println("Votre autorisation de découvert est épuisée");
        } else if (solde < montant){
            System.err.println("Votre solde est insuffisant pour effectuer cette opération");
        } else {
            retrait retrait = new retrait(montant);
            solde -= montant;
            compte.verser(montant);
            listeOperations.add(retrait);
        }        
    }

    void updateSolde(){
        solde += (solde/100) * taux;
    }

    public String toString(){
        return "Compte epargne n° " + code + ", solde de " + solde + ", taux d'intérêt de " + taux + " %";
    }
}
