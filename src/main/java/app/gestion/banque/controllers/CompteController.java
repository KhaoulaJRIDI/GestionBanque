package app.gestion.banque.controllers;

import app.gestion.banque.entities.Compte;
import app.gestion.banque.entities.CompteCourant;
import app.gestion.banque.entities.CompteEpargne;
import app.gestion.banque.entities.Operation;
import app.gestion.banque.exceptions.FournisseurNotFoundException;
import app.gestion.banque.repositories.CompteCourantRepository;
import app.gestion.banque.repositories.CompteEpargneRepository;
import app.gestion.banque.repositories.CompteRepository;
import app.gestion.banque.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@RestController
public class CompteController {
    @Autowired
    CompteCourantRepository compteCourantRepository;
    @Autowired
    CompteEpargneRepository compteEpargneRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    OperationRepository operationRepository;

    @GetMapping("/comptes")
    public Collection<Compte> allAccounts() {
        Collection<Compte> accounts = new ArrayList<Compte>();
        for (CompteCourant cc : compteCourantRepository.findAll()) {
            accounts.add(cc);
        }
        for (CompteEpargne ce : compteEpargneRepository.findAll()) {
            accounts.add(ce);
        }


        return accounts;
    }

    @PostMapping("/comptes")
    public void addAccount(@RequestBody Compte compte) {
        /*Identifier le type du compte*/
        if (compte.getCodeCompte().contains("CC")) {
            CompteCourant cc = (CompteCourant) compte;
            cc.setCodeCompte(compte.getCodeCompte());
            cc.setSolde(compte.getSolde());
            cc.setDateCreation(compte.getDateCreation());
            cc.setDecouvert(((CompteCourant) compte).getDecouvert());
            compteCourantRepository.save(cc);
        }

        if (compte.getCodeCompte().contains("CE")) {
            CompteEpargne ce = new CompteEpargne();
            ce.setCodeCompte(compte.getCodeCompte());
            ce.setSolde(compte.getSolde());
            ce.setDateCreation(compte.getDateCreation());
            ce.setTaux_interet(((CompteEpargne) compte).getTaux_interet());
            compteEpargneRepository.save(ce);
        }

    }

    @GetMapping("/comptes/{codeCompte}")
    public Collection<Operation> GetAccountOperations(@PathVariable String codeCompte) {


            return operationRepository.getAccountOperations(codeCompte);


    }
}