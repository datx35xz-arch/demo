package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User newUser) {
        if (userRepository.findByUsername(newUser.getUsername()).isPresent()) {
            return Map.of("status", "error", "message", "Tài khoản đã tồn tại!");
        }
        userRepository.save(newUser);
        return Map.of("status", "success", "message", "Đăng ký thành công!");
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginUser) {
        Optional<User> userOpt = userRepository.findByUsername(loginUser.getUsername());
        
        if (userOpt.isPresent() && userOpt.get().getPassword().equals(loginUser.getPassword())) {
            return Map.of("status", "success", "message", "Đăng nhập thành công!");
        } else {
            return Map.of("status", "error", "message", "Sai tài khoản hoặc mật khẩu!");
        }
    }
}
