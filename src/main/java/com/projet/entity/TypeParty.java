package com.projet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "type_party")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_party_id")
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "interests", joinColumns = @JoinColumn(name = "type_party_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<Users> users;
}
