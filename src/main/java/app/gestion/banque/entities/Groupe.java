package app.gestion.banque.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numGroupe;
    private String nomGroupe;
    @ManyToMany(mappedBy = "groupes")
    private Collection<Employe> employes;
}
