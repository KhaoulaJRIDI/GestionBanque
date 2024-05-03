package app.gestion.banque.exceptions;

public class FournisseurNotFoundException extends RuntimeException{
    public FournisseurNotFoundException(Long id) {
        super("Could not find fournisseur " + id);
    }

}
