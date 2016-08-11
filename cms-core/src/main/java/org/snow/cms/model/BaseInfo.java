package org.snow.cms.model;

public class BaseInfo {
    private String name;
    private String address;
    private String zipCode;
    private String recordCode;
    private String phone;
    private String email;
    private String domainName;
    private int indexPicWidth;
    private int indexPicHeight;
    private int indexPicNumber;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRecordCode() {
        return this.recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public int getIndexPicWidth() {
        return this.indexPicWidth;
    }

    public void setIndexPicWidth(int indexPicWidth) {
        this.indexPicWidth = indexPicWidth;
    }

    public int getIndexPicHeight() {
        return this.indexPicHeight;
    }

    public void setIndexPicHeight(int indexPicHeight) {
        this.indexPicHeight = indexPicHeight;
    }

    public int getIndexPicNumber() {
        return this.indexPicNumber;
    }

    public void setIndexPicNumber(int indexPicNumber) {
        this.indexPicNumber = indexPicNumber;
    }

    public String toString() {
        return "BaseInfo [name=" + this.name + ", address=" + this.address + ", zipCode=" + this.zipCode + ", recordCode=" + this.recordCode + ", phone=" + this.phone + ", email=" + this.email + ", domainName=" + this.domainName + ", indexPicWidth=" + this.indexPicWidth + ", indexPicHeight=" + this.indexPicHeight + ", indexPicNumber=" + this.indexPicNumber + "]";
    }
}
