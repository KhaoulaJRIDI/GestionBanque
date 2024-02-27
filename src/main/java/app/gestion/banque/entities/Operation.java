package app.gestion.banque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Operation {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numOperation;
    private Date dateOperation;
    private double montant;

}
