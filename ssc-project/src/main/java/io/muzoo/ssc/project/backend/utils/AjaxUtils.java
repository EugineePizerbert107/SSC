package io.muzoo.ssc.project.backend.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class AjaxUtils {

    public static String convertToString(Object objectValue){
        StringWriter writer = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(writer, objectValue);
            return writer.toString();
        } catch (IOException e) {
            return "bad object";
        }
    }

}
