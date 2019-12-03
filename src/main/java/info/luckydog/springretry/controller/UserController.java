package info.luckydog.springretry.controller;

import info.luckydog.springretry.model.User;
import info.luckydog.springretry.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author eric
 * @since 2019/12/2
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("user")
    public User getUser(@RequestParam("token") String token) {
        return userService.getUser(token);
    }
}
