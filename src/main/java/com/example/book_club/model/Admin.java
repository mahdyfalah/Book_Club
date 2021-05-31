package com.example.book_club.model;


public class Admin extends User{

    private String phone_NR;
    private String address;

    public Admin() {
        super();
    }

    public Admin(String user_name, String password, String email,String date, String phone_NR, String address) {
        super(user_name, password, email,date);
        this.phone_NR = phone_NR;
        this.address = address;
    }

    public String getPhone_NR() {
        return phone_NR;
    }

    public void setPhone_NR(String phone_NR) {
        this.phone_NR = phone_NR;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "phone_NR='" + phone_NR + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
