package org.sopt.model;

public class University {
    private int idx;
    private String name;
    private String phone;
    private String address;

    public University() {
    }

    public University(int idx, String name, String phone, String address) {
        this.idx = idx;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "University{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
