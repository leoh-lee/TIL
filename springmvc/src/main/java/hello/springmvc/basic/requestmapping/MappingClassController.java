package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

import java.util.StringTokenizer;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String users() {
        return "get users";
    }

    @PostMapping
    public String addUser() {
        return "post users";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "get userId= " + userId;
     }

    @PatchMapping("/{userId}")
    public String update(@PathVariable String userId) {
        return "update userId= " + userId;
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable String userId) {
        return "delete userId= " + userId;
    }
}
