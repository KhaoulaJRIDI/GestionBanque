package app.gestion.banque.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CPTE",discriminatorType=DiscriminatorType.STRING,length=2)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compte {

     @Id
    private String codeCompte;
    private Date dateCreation;
    private double solde;
    @ManyToOne
    @JoinColumn(name = "CODECLI")
    private Client client;
    @OneToMany
    Collection <Operation> operations;
    @ManyToOne
    @JoinColumn(name="CODEEMP")
    private Employe emp;
}
