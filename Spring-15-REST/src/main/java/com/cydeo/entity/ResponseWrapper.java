package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {

    /**
     * This class is for serialization and deserialization flow
     */

    private boolean success;
    private String message;
    private Integer code;
    private Object data;

    public ResponseWrapper( String message, Object data) {
        this.success = true;
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.data = data;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code = HttpStatus.OK.value();
        this.success = true;
    }

}
