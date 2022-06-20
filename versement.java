package appli_bancaire;

public class versement extends operation {
    
    public versement(double montant){
        super(montant);
    }

    public String toString(){
        return dateOperation + " - Versement de " + montant + " €";
    }
}
