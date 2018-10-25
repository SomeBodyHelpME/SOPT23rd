package org.sopt.model;

public class Department extends University {
    private int idx;
    private String name;
    private String phone;
    private int type;

    public Department() {
    }

    public Department(int idx, String name, String phone, int type) {
        this.idx = idx;
        this.name = name;
        this.phone = phone;
        this.type = type;
    }

//    public Department(int UniversityIdx, String UniversityName, String UniversityPhone, String UniversityAddress, int DepartmentIdx, String DepartmentName, String DepartmentPhone, int DepartmentType) {
//        super(UniversityIdx, UniversityName, UniversityPhone, UniversityAddress);
//        this.idx = DepartmentIdx;
//        this.name = DepartmentName;
//        this.phone = DepartmentPhone;
//        this.type = DepartmentType;
//    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }
}
