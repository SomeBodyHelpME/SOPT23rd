package org.sopt.report5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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

    private MultipartFile profile;
    // user photo
    private String profileUrl;
}
