package org.sopt.service.impl;

import org.sopt.model.Department;
import org.sopt.model.builder.DepartmentBuilder;
import org.sopt.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public Department getByDepartmentName(String DepartmentName) {
        final DepartmentBuilder departmentBuilder = new DepartmentBuilder();
        final Department department = departmentBuilder
                .setIdx(3)
                .setName("이상은")
                .setPhone("010-1234-5678")
                .setType(1)
                .build();
        return department;
    }
}
