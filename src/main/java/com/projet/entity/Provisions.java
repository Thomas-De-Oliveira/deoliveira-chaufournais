package com.projet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "provisions", indexes = {
        @Index(name = "idx_provisions_party_id", columnList = "party_id"),
        @Index(name = "idx_provisions_user_id", columnList = "user_id"),
        @Index(name = "idx_provisions_type_provision_id", columnList = "type_provision_id")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Provisions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provision_id")
    private Long id;
    private String provision;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_provision_id")
    private TypeProvision typeProvision;
}
