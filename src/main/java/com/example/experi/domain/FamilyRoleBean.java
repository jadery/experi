package com.example.experi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FamilyRoleBean implements Comparable<FamilyRoleBean>{

    private String relaName;

    private int userTypeNum;

    @Override
    public int compareTo(FamilyRoleBean o) {
        return (this.userTypeNum < o.getUserTypeNum()) ? -1 : ((this.userTypeNum == o.getUserTypeNum()) ? 0 : 1);
    }
}
