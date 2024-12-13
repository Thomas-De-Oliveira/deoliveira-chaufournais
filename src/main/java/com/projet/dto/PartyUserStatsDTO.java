package com.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyUserStatsDTO {
    private Long partyId;
    private String partyName;
    private Integer currentUserCount;
    private Integer maxUserCount;
    private String organiserName;
}
