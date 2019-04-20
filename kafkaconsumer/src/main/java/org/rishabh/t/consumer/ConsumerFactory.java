/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 7:34 PM
*/

package org.rishabh.t.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.rishabh.t.utility.Constants;

@Configuration
public class ConsumerFactory {

    private StudentConsumer studentConsumer;
    private CountryConsumer countryConsumer;
    private CompanyConsumer companyConsumer;
    private TeacherConsumer teacherConsumer;
    private EmployeeConsumer employeeConsumer;

    @Autowired
    public ConsumerFactory(StudentConsumer studentConsumer, CountryConsumer countryConsumer, CompanyConsumer companyConsumer, TeacherConsumer teacherConsumer, EmployeeConsumer employeeConsumer){
        this.studentConsumer = studentConsumer;
        this.countryConsumer = countryConsumer;
        this.companyConsumer = companyConsumer;
        this.teacherConsumer = teacherConsumer;
        this.employeeConsumer = employeeConsumer;
    }

    public Consumer getConsumer(String consumerType) {
        switch (consumerType){
            case Constants.ConsumerType.COMPANY_CONSUMER: return this.companyConsumer;
            case Constants.ConsumerType.COUNTRY_CONSUMER: return this.countryConsumer;
            case Constants.ConsumerType.EMPLOYEE_CONSUMER: return this.employeeConsumer;
            case Constants.ConsumerType.STUDENT_CONSUMER: return this.studentConsumer;
            case Constants.ConsumerType.TEACHER_CONSUMER: return this.teacherConsumer;
            default:return null;
        }
    }
}
