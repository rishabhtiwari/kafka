/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:47 AM
*/

package org.rishabh.t.models;

import java.math.BigInteger;

public class Company {

    private String companyName;
    private String companyAddress;
    private BigInteger companyContactNumber;
    private Double companyFund;
    private Integer companyRank;
    private Double companyWorth;

    public Company() {

    }

    public Company(String companyName, String companyAddress, BigInteger companyContactNumber, Double companyFund, Integer companyRank, Double companyWorth) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyContactNumber = companyContactNumber;
        this.companyFund = companyFund;
        this.companyRank = companyRank;
        this.companyWorth = companyWorth;
    }
}
