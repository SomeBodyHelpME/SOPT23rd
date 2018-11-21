package org.sopt.report3.api;

import lombok.extern.slf4j.Slf4j;
import org.sopt.report3.model.User;
import org.sopt.report3.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.sopt.report3.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
public class UserController {
    private final static List<User> userList = new LinkedList<>();

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }


    /**
     * GET /
     * @return : current time
     */
    @GetMapping("")
    public ResponseEntity getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        return new ResponseEntity<>(today, HttpStatus.OK);
    }

    /**
     * GET /users || /users?name="name" || /users?part="part"
     * @param name : name
     * @param part : part
     * @return : user info
     */
    @GetMapping("/users")
    public ResponseEntity getUser(
            @RequestParam(value = "name") final Optional<String> name,
            @RequestParam(value = "part") final Optional<String> part
    ) {
        try {
            if (name.isPresent()) return new ResponseEntity<>(userService.findByName(name.get()), HttpStatus.OK);

            if (part.isPresent()) return new ResponseEntity<>(userService.findByPart(part.get()), HttpStatus.OK);

            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    /**
     * GET /users/{user_idx}
     * @param user_idx : user_idx
     * @return : user info
     */
    @GetMapping("/users/{user_idx}")
    public ResponseEntity getUserIdx(@PathVariable(value = "user_idx") final int user_idx) {
        try {
            return new ResponseEntity<>(userService.findByUserIdx(user_idx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * POST /users
     * @param user : User JSON
     * @return : Msg
     */
    @PostMapping("/users")
    public ResponseEntity postUsers(@RequestBody final User user) {

        try {
            return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * PUT /users/{user_idx}
     * @param user_idx : user_idx
     * @return : user info
     */
    @PutMapping("/users/{user_idx}")
    public ResponseEntity putUsers(
            @PathVariable(value = "user_idx") final int user_idx,
            @RequestBody final User user
    ) {
        try {
            return new ResponseEntity<>(userService.update(user_idx, user), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * DELETE /users/{user_idx}
     * @param user_idx : user_idx
     * @return : Msg
     */
    @DeleteMapping("/users/{user_idx}")
    public ResponseEntity DeleteUsers(@PathVariable(value = "user_idx") final int user_idx) {
        try {
            return new ResponseEntity<>(userService.deleteByUserIdx(user_idx), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
