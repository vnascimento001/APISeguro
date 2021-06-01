package com.apiseguro.api.models;

public class ErrorMessage{

    private int status;
    private int code;
    private String message;

    public ErrorMessage(int status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorResponse{" +
                "status=" + status +
                ", Código=" + code +
                ", Erro=" + message +
                '}';
    }
}