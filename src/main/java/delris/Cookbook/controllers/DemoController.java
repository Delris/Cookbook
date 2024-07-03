package delris.Cookbook.controllers;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/test")
public class DemoController {

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/user")
    public String userDemo(){
        return ("<h1> Spring security is working as intended, this is USER content</h1>");
    }
    @PreAuthorize("hasRole('MODERATOR')")
    @GetMapping("/moderator")
    public String moderatorDemo(){
        return ("<h1> Spring security is working as intended, this is MODERATOR content</h1>");
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public String adminDemo(){
        return ("<h1> Spring security is working as intended, this is ADMIN content</h1>");
    }

}
