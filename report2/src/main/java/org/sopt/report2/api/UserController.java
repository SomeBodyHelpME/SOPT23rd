package org.sopt.report2.api;

import org.sopt.report2.model.User;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UserController {
    private final static List<User> userList = new LinkedList<>();

    /**
     * GET /
     * @return : current time
     */
    @GetMapping("")
    public String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        return today;
    }

    /**
     * GET /users || /users?name="name" || /users?part="part"
     * @param name : name
     * @param part : part
     * @return : user info
     */
    @GetMapping("/users")
    public String getSingleUser(
            @RequestParam(value = "name", defaultValue = "") final String name,
            @RequestParam(value = "part", defaultValue = "") final String part
            ) {
        if (!name.equals("") && part.equals("")) {              // users?name="name"
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getName().equals(name)) {
                    return user.toString();
                }
            }
            return "No Name in List";
        } else if (name.equals("") && !part.equals("")) {       // users?part="part"
            Iterator<User> iterator = userList.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                if (user.getPart().equals(part)) {
                    return user.toString();
                }
            }
            return "No Part in List";
        } else {                                                // users
            Iterator<User> iterator = userList.iterator();
            StringBuilder result = new StringBuilder();
            while (iterator.hasNext()) {
                User user = iterator.next();

                result.append(user.toString() + "\n");
            }
            return result.toString();
        }
    }

    /**
     * GET /users/{user_idx}
     * @param user_idx : user_idx
     * @return : user info
     */
    @GetMapping("/users/{user_idx}")
    public String getName(@PathVariable(value = "user_idx") final int user_idx) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_idx() == user_idx) {
                return user.toString();
            }
        }
        return "No User in List";
    }

    /**
     * POST /users
     * @param user : User JSON
     * @return : Msg
     */
    @PostMapping("/users")
    public String postUsers(@RequestBody final User user) {
        if(userList.add(user)) {
            return "Success to Register";
        } else {
            return "Fail to Register";
        }

    }

    /**
     * PUT /users/{user_idx}
     * @param user_idx : user_idx
     * @return : user info
     */
    @PutMapping("/users/{user_idx}")
    public User putUsers(@PathVariable(value = "user_idx") final int user_idx) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_idx() == user_idx) {
                return user;
            }
        }
        return null;
    }

    /**
     * DELETE /users/{user_idx}
     * @param user_idx : user_idx
     * @return : Msg
     */
    @DeleteMapping("/users/{user_idx}")
    public String DeleteUsers(@PathVariable(value = "user_idx") final int user_idx) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser_idx() == user_idx) {
                userList.remove(user);
                return "Success to Delete";
            }
        }
        return "Fail to Delete";
    }
}
