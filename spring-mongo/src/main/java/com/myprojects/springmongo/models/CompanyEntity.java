package com.myprojects.springmongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "company")
public class CompanyEntity {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String address;
    @Field
    private String principalName;

    public CompanyEntity() {}

    public CompanyEntity(String name, String address, String principalName) {
        this.name = name;
        this.address = address;
        this.principalName = principalName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    @Override
    public String toString() {
        return String.format("Company[id='%s', name='%s', address='%s', principalName='%s']", id, name, address, principalName);
    }
}
