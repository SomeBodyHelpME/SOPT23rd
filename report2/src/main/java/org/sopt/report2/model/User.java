package org.sopt.report2.model;

public class User {
    // user index
    private int user_idx;
    // user name
    private String name;
    // user part
    private String part;

    public User() {
    }

    public User(int user_idx, String name, String part) {
        this.user_idx = user_idx;
        this.name = name;
        this.part = part;
    }

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @Override
    public String toString() {
        return "User {" +
                "user_idx=" + user_idx +
                ", name='" + name + '\'' +
                ", part='" + part + '\'' +
                '}';
    }
}
