package pe.com.semanadigital.keycloakclient.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.semanadigital.keycloakclient.util.ApplicationConstants;

@RestController
@RequestMapping
public class ClientController {


    @GetMapping("/authenticated-resource")
    public ResponseEntity<String> login(@AuthenticationPrincipal OAuth2User user) {

        if (user != null) {
            return ResponseEntity.ok("Welcome " + user.getAttribute("name"));
        }
        return ResponseEntity.ok(ApplicationConstants.UNAUTHORIZED);
    }


    @GetMapping("/public-resource")
    public ResponseEntity<String> permitAll() {
        return ResponseEntity.ok("Public Resource");
    }


}
