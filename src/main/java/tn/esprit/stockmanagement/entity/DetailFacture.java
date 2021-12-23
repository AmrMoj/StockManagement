package tn.esprit.stockmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author AMR MOUJBANI-PC ON 07/11/2021
 * @project IntelliJ IDEA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailFacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDetailFacture;

    private int qte, pourcentageRemise;
    private float prixTotal, montantRemise;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Facture facture;

}
