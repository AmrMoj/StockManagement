package tn.esprit.stockmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduit;
    private String code,libelle;
    private float prixUnitaire;

    @OneToOne(cascade = CascadeType.PERSIST)
    private DetailProduit detailProduit;

    @ManyToOne
    private Rayon rayon;

    @ManyToMany
    private List<Fournisseur> fournisseurs;

    @OneToMany(mappedBy = "produit")
    private List<DetailFacture> detailFactures;

    @ManyToOne
    private Stock stock;

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void addFournisseur(Fournisseur fournisseur){
        fournisseurs.add(fournisseur);
    }

}
