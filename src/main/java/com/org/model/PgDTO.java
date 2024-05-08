package com.org.model;

public class PgDTO {
    private Integer id;
    private String name;
    private String address;
    private Integer rent;
    private String review;

    private AddressDTO addressDetails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public AddressDTO getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDTO addressDetails) {
        this.addressDetails = addressDetails;
    }
}
