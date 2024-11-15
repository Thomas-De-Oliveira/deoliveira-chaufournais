package com.projet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "type_provision")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeProvision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_provision_id")
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "need_for_party", joinColumns = @JoinColumn(name = "type_provision_id"), inverseJoinColumns = @JoinColumn(name = "party_id"))
    private Set<Party> parties;
}