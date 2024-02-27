package app.gestion.banque.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEmploye;
    private String nomEmploye;
    @ManyToMany
    @JoinTable(name="EMP_GPR",
            joinColumns = @JoinColumn(name="CODEEMP"),
            inverseJoinColumns= @JoinColumn(name="CODEGPR"))
    private Collection<Groupe> groupes;

}
