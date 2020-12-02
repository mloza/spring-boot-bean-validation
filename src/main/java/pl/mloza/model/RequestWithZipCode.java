package pl.mloza.model;

import pl.mloza.validators.ZipCode;

public class RequestWithZipCode {

    @ZipCode
    private String zipCode;

    public RequestWithZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public RequestWithZipCode() {
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
