package appli_bancaire;

public class compteCourant extends compteBancaire {

    private double decouvert;

    public compteCourant(double decouvert){
        super();
        this.decouvert = decouvert;
    }

    void retirer(double montant){
        var soldeTotal = solde + decouvert;
        if (soldeTotal <= 0){
            System.err.println("Votre autorisation de découvert est épuisée");
        } else if (soldeTotal < montant){
            System.err.println("Votre solde est insuffisant pour effectuer cette opération");
        } else {
            retrait retrait = new retrait(montant);
            solde -= montant;
            listeOperations.add(retrait);
        }
    }

    void virement(double montant, compteBancaire compte) {
        var soldeTotal = solde + decouvert;
        if (soldeTotal <= 0){
            System.err.println("Votre autorisation de découvert est épuisée");
        } else if (soldeTotal < montant){
            System.err.println("Votre solde est insuffisant pour effectuer cette opération");
        } else {
            retrait retrait = new retrait(montant);
            solde -= montant;
            compte.verser(montant);
            listeOperations.add(retrait);
        }        
    }

    @Override
    void updateSolde(){
        System.err.println("Opération impossible sur un compte courant");
    }

    public String toString(){
        return "Compte courant n° " + code + ", solde de " + solde + ", découvert de " + decouvert;
    }
    
}
