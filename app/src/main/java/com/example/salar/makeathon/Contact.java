package com.example.salar.makeathon;

public class Contact {
    private int image;
    private String name;
    private String phone;

    public Contact(int image, String name, String phone) {
        this.image = image;
        this.name = name;
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
