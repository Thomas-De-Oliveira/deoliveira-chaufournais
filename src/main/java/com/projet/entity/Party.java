package com.projet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "party", indexes = {
        @Index(name = "idx_party_type_party_id", columnList = "type_party_id"),
        @Index(name = "idx_party_address_id", columnList = "address_id"),
        @Index(name = "idx_need_for_party_party_id", columnList = "party_id")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "party_id")
    private Long id;
    private String name;
    private String street;
    private Boolean publish;
    private Float price;
    private Integer numberMaxParticipate;
    private LocalDateTime date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "need_for_party", joinColumns = @JoinColumn(name = "party_id"), inverseJoinColumns = @JoinColumn(name = "type_provision_id"))
    private Set<TypeProvision> typeProvisions;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_party_id")
    private TypeParty typeParty;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
}
