package com.akichou.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class AkiResponseEntity<T> implements Serializable {

    // Fields
    private Integer httpCode ;
    private String message ;
    private T data ;

    // Constructors
    public AkiResponseEntity() {}

    // Fields Builders
    public AkiResponseEntity<T> ok(Integer httpCode, String message, T data) {

        this.httpCode = httpCode ;
        this.message = message ;
        this.data = data ;

        return this ;
    }

    public AkiResponseEntity<T> error(Integer httpCode, String message, T data) {

        this.httpCode = httpCode ;
        this.message = message ;
        this.data = data ;

        return this ;
    }

    // Result Entities
    public AkiResponseEntity<T> okEntity() {

        return ok(AkiHttpCodeEnum.SUCCESS.getCode(),
                  AkiHttpCodeEnum.SUCCESS.getMsg(),
                  null) ;
    }

    public AkiResponseEntity<T> okEntity(Integer httpCode, String message) {

        return ok(httpCode, message, null) ;
    }

    public AkiResponseEntity<T> okEntity(Integer httpCode, String message, T data) {

        return ok(httpCode, message, data) ;
    }

    public AkiResponseEntity<T> errorEntity() {

        return error(AkiHttpCodeEnum.INTERNAL_ERROR.getCode(),
                     AkiHttpCodeEnum.INTERNAL_ERROR.getMsg(),
                null) ;
    }

    public AkiResponseEntity<T> errorEntity(Integer httpCode, String message) {

        return error(httpCode, message, null) ;
    }

    public AkiResponseEntity<T> errorEntity(Integer httpCode, String message, T data) {

        return error(httpCode, message, data) ;
    }
}
