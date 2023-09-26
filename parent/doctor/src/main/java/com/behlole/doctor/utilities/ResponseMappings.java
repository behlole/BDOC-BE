package com.behlole.doctor.utilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
@Setter
public class ResponseMappings {

    public ResponseEntity<Object> getSuccessMessage(Object data) {
        Map<String, Object> mappedData = new HashMap<>();
        mappedData.put("body", data);
        mappedData.put("status", 200);
        return new ResponseEntity<Object>(mappedData, HttpStatus.OK);
    }
}