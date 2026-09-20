package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @PostMapping
    public Map<String, Object> createProject(@RequestBody Map<String, String> request) {
        String projectName = request.get("projectName");
        String description = request.get("description");

        // Ở đây bạn có thể lưu vào Database sau, hiện tại ta trả về thông báo thành công
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Đã tạo dự án thành công: " + projectName);
        return response;
    }
}
@DeleteMapping("/{id}")
public Map<String, Object> deleteProject(@PathVariable Long id) {
    Map<String, Object> response = new HashMap<>();
    // Ở đây bạn có thể thêm logic xóa dự án trong Database theo ID
    response.put("status", "success");
    response.put("message", "Đã xóa dự án thành công có ID: " + id);
    return response;
}