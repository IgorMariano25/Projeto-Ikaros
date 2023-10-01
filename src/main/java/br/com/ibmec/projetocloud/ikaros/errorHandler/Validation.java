package br.com.ibmec.projetocloud.ikaros.errorHandler;

public class Validation {
    private String field;
    
    public String message;
    
    public Validation(String field, String message) {
        super();
        this.field = field;
        this.message = message;
    }
    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}