/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:48 AM
*/

package org.rishabh.t.models;

import java.math.BigInteger;

public class Student {

    private String studentName;
    private String studentAddress;
    private BigInteger studentNumber;
    private Integer studentRollNumber;

    public Student() {

    }
    public Student(String studentName, String studentAddress, BigInteger studentNumber, Integer studentRollNumber) {
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentNumber = studentNumber;
        this.studentRollNumber = studentRollNumber;
    }
}
