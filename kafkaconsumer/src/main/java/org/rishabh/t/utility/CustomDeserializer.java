/*
  Created by IntelliJ IDEA.
  User: rishabh.t
  Date: 20/04/19
  Time: 8:59 PM
*/

package org.rishabh.t.utility;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.rishabh.t.models.*;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class CustomDeserializer <T> implements Deserializer <T> {

    public ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public void configure(Map<String, ?> map, boolean b) {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    @Override
    public T deserialize(String topic, byte[] bytes) {
        if(bytes == null) return null;
        T data = null;
        try {
            switch (topic) {
                case Constants.Topics.COMPANY_TOPIC: data = (T) objectMapper.readValue(bytes, Company.class); break;
                case Constants.Topics.COUNTRY_TOPIC: data = (T) objectMapper.readValue(bytes, Country.class); break;
                case Constants.Topics.EMPLOYEE_TOPIC: data = (T) objectMapper.readValue(bytes, Employee.class); break;
                case Constants.Topics.STUDENT_TOPIC: data = (T) objectMapper.readValue(bytes, Student.class); break;
                case Constants.Topics.TEACHER_TOPIC: data = (T) objectMapper.readValue(bytes, Teacher.class); break;
                default: return null;
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void close() {

    }
}
