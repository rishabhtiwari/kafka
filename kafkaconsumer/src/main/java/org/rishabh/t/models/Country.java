/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:41 AM
*/

package org.rishabh.t.models;

public class Country {
    private String countryName;
    private String countryPm;
    private Integer countryCode;
    private String countryCapital;
    private Double countryEconomy;
    private Integer countryRank;

    public Country() {

    }

    public Country(String countryName, String countryPm, Integer countryCode, String countryCapital, Double countryEconomy, Integer countryRank) {
        this.countryName = countryName;
        this.countryPm = countryPm;
        this.countryCode = countryCode;
        this.countryCapital = countryCapital;
        this.countryEconomy = countryEconomy;
        this.countryRank = countryRank;
    }

}
