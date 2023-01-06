package com.myprojects.springmongo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "user")
public class UserEntity {
    @Id
    private String id = ObjectId.get().toHexString();
    @Field
    private String name;
    @Field
    private String passportId;
    @Field
    private String phoneNumber;
    @Field
    private List<String> companies;

    public UserEntity() {}

    public UserEntity(String name, String passportId, String phoneNumber, List<String> companies) {
        this.name = name;
        this.passportId = passportId;
        this.phoneNumber = phoneNumber;
        this.companies = companies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return String.format("User[id='%s', name='%s', passportId='%s', companies='%s']", id, name, passportId, companies);
    }
}
