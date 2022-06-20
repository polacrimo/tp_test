package appli_bancaire;

public class retrait extends operation {
    
    public retrait(double montant){
        super(montant);
    }

    public String toString(){
        return dateOperation + " - Retrait de " + montant + " €";
    }
}
