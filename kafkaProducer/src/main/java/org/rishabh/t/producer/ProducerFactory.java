/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 2:08 AM
*/

package org.rishabh.t.producer;


import org.rishabh.t.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerFactory {

    private final CompanyProducer companyProducer;
    private final CountryProducer countryProducer;
    private final EmployeeProducer employeeProducer;
    private final StudentProducer studentProducer;
    private final TeacherProducer teacherProducer;

    @Autowired
    public ProducerFactory(CompanyProducer companyProducer, CountryProducer countryProducer, EmployeeProducer employeeProducer, StudentProducer studentProducer, TeacherProducer teacherProducer) {
        this.companyProducer = companyProducer;
        this.countryProducer = countryProducer;
        this.employeeProducer = employeeProducer;
        this.studentProducer = studentProducer;
        this.teacherProducer = teacherProducer;
    }

    public Producer getProducer(String producerType) {
        switch (producerType){

            case Constants.ProducerType.COMPANY_PRODUCER: return companyProducer;
            case Constants.ProducerType.COUNTRY_PRODUCER: return countryProducer;
            case Constants.ProducerType.EMPLOYEE_PRODUCER: return employeeProducer;
            case Constants.ProducerType.STUDENT_PRODUCER: return studentProducer;
            case Constants.ProducerType.TEACHER_PRODUCER: return teacherProducer;
            default:return countryProducer;
        }
    }
}
