package appli_bancaire;

public class appliBancaire {
    
    public static void main(String[] Args){        

        compteCourant courant = new compteCourant(200);

        compteEpargne epargne = new compteEpargne(1);

        courant.verser(150);

        epargne.retirer(50);

        courant.retirer(50);

        courant.virement(100, epargne);

        epargne.retirer(50);

        System.out.println(courant.consulterSolde());

        System.out.println(epargne.consulterSolde());

        courant.updateSolde();

        epargne.updateSolde();

        System.out.println(courant.listerOperations());

        System.out.println(epargne.listerOperations());

        System.out.println(courant.totalVersements());

        System.out.println(epargne.totalRetraits());

        System.out.println(courant);

        System.out.println(epargne);





    }
}
