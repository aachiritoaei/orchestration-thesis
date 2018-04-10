package app.controllers;

import app.domain.IotUser;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> newUser(@RequestBody Map<String, Object> userMap) {
        IotUser user = new IotUser(
                userMap.get("username").toString(),
                userMap.get("password").toString(),
                userMap.get("firstname").toString(),
                userMap.get("lastname").toString());

        userRepository.save(user);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "User created successfully");
        response.put("user", user);

        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAll")
    public Map<String, Object> deleteAllUsers() {
        userRepository.deleteAll();

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "All users deleted successfully");

        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<IotUser> getAllUsers() {

        return userRepository.findAll();
    }
}
