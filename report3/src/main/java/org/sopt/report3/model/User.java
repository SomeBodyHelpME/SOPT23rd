package org.sopt.report3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    // user index
    private int user_idx;
    // user name
    private String name;
    // user part
    private String part;
}
