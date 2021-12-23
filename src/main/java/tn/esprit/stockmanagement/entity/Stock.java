package tn.esprit.stockmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idStock;
    private int qte, qteMin;
    private String libelleStock;

    @OneToMany(mappedBy = "stock")
    private List<Produit> produits;

    @JsonIgnore
    public List<Produit> getProduits() {
        return produits;
    }

    public void addProduits(Produit produit) {
        produits.add(produit);
    }

}
