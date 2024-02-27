package app.gestion.banque.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("CC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompteCourant extends Compte {
    private double decouvert;
}
