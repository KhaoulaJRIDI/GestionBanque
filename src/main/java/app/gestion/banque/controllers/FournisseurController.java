package app.gestion.banque.controllers;

import app.gestion.banque.entities.Fournisseur;
import app.gestion.banque.exceptions.FournisseurNotFoundException;
import app.gestion.banque.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin("*")
@RestController
public class FournisseurController {
    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }
    @GetMapping("/fournisseurs")
    Collection<Fournisseur> all()
    {

        return fournisseurRepository.findAll();
    }
    @PostMapping("/fournisseurs")
    Fournisseur newFournisseur(@RequestBody Fournisseur newFournisseur) {
        return fournisseurRepository.save(newFournisseur);
    }

    @GetMapping("/fournisseurs/{id}")
    Fournisseur one(@PathVariable Long id) {

        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new FournisseurNotFoundException(id));
    }
    @PutMapping("/fournisseurs/{id}")
    Fournisseur replaceFournisseur(@RequestBody Fournisseur fournisseur, @PathVariable Long id) {

        return fournisseurRepository.findById(id)
                .map(newfournisseur -> {
                    newfournisseur.setName(fournisseur.getName());
                    newfournisseur.setEmail(fournisseur.getEmail());
                    newfournisseur.setAddress(fournisseur.getAddress());
                    return fournisseurRepository.save(newfournisseur);
                })
                .orElseGet(() -> {
                    fournisseur.setId(id);
                    return fournisseurRepository.save(fournisseur);
                });
    }

    @DeleteMapping("/fournisseurs/{id}")
    void deleteFournisseur(@PathVariable Long id) {
        fournisseurRepository.deleteById(id);
    }

}
