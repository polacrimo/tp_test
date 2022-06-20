package appli_bancaire;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class operation {

    private static final AtomicInteger ID_OPERATION = new AtomicInteger(1);
    private final int numero;
    protected static Date dateOperation;
    protected double montant;

    public operation(double montant){
        numero = ID_OPERATION.getAndIncrement();
        dateOperation = new Date();
        this.montant = montant;
    }

    public double getMontant(){
        return montant;
    }

    public String toString(){
        return dateOperation + " - " + montant;
    }
    
}
