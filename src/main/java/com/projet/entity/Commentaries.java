package com.projet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "commentaries")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Commentaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_id")
    private Long id;
    private Integer note;
    private String commentary;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Users author;

    // Relation vers l'utilisateur qui est commenté
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users target;


}
