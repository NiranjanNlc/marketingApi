package com.pareva.marketing_api.CustomResponse;



public class CustomResponse<T> {
    private Integer status;
    private T body;
    private String message;
    private String error;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CustomResponse{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", body=" + body +
                ", message='" + message + '\'' +
                '}';
    }
}