package org.mehedi.ordermanagementsystem.utils;

import org.mehedi.ordermanagementsystem.model.GenericResponse;

import java.util.Map;

public class ResponseUtil {
    public static GenericResponse setSuccessResponse(int status, Object data) {
        return GenericResponse.builder()
                .status(status)
                .data(data)
                .build();
    }
    public static GenericResponse setErrorResponse(int status,Exception ex) {
        return GenericResponse.builder()
                .status(status)
                .message(ex.getMessage())
                .error(ex.getClass().getName())
                .build();
    }
}
