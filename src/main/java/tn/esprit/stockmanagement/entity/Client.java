package tn.esprit.stockmanagement.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idClient;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Facture> factures;

    private String nom, prenom, email, password;

    @Enumerated(EnumType.STRING)
    private CategorieClient categorieClient;

    @Enumerated(EnumType.STRING)
    private Profession profession;

    private Date dateNaissance;

}
