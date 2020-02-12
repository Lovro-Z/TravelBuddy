package zubcic.travel.travelapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zubcic.travel.travelapplication.dto.CreateUserDto;
import zubcic.travel.travelapplication.dto.LoginDto;
import zubcic.travel.travelapplication.model.User;
import zubcic.travel.travelapplication.services.UserService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String token = userService.login(loginDto.getUsername(), loginDto.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody CreateUserDto userDto) throws URISyntaxException {
        User user = userService.register(userDto);
        return ResponseEntity.created(new URI(user.getId().toString())).body(user);
    }
}
