package com.findmore.serverapp.pipeline;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExceptionResponse {

    @JsonProperty(value="status") private int status;
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    @JsonProperty(value="message") private String message;
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @JsonProperty(value="type") private String type;
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public ExceptionResponse() {}
    public ExceptionResponse(int status, String message, String type) { this.status = status; this.message = message; this.type = type; }
}
