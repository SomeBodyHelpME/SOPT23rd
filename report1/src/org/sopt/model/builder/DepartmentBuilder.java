package org.sopt.model.builder;

import org.sopt.model.Department;

public class DepartmentBuilder {
    private int idx;
    private String name;
    private String phone;
    private int type;

    public DepartmentBuilder setIdx(int idx) {
        this.idx = idx;
        return this;
    }

    public DepartmentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DepartmentBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public DepartmentBuilder setType(int type) {
        this.type = type;
        return this;
    }

    public Department build() {
        return new Department(this.idx, this.name, this.phone, this.type);
    }
}
