/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:50 AM
*/

package org.rishabh.t.models;

import java.math.BigInteger;

public class Teacher {

    private String teacherName;
    private String teacherAddress;
    private BigInteger teacherNumber;
    private Integer teacherId;

    public Teacher() {

    }

    public Teacher(String teacherName, String teacherAddress, BigInteger teacherNumber, Integer teacherId) {
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
        this.teacherNumber = teacherNumber;
        this.teacherId = teacherId;
    }
}
