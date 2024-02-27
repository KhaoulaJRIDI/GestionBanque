package app.gestion.banque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CE")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CompteEpargne extends Compte{
    private double taux_interet;
}
