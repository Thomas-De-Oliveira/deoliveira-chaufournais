package com.projet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "party_user_stats")
public class PartyUserStats {

    @Id
    private Long partyId;

    private String partyName;
    private Integer currentUserCount;
    private Integer maxUserCount;
    private String organiserName;
}
