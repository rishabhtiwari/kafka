/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:45 AM
*/

package org.rishabh.t.models;

import java.math.BigInteger;

public class Employee {

    private String employeeName;
    private String employeeAddress;
    private BigInteger employeeNumber;
    private Double employeeSalary;
    private String employeeDesk;

    public Employee(String employeeName, String employeeAddress, BigInteger employeeNumber, Double employeeSalary, String employeeDesk) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeNumber = employeeNumber;
        this.employeeSalary = employeeSalary;
        this.employeeDesk = employeeDesk;
    }
}
