
package lk.coop.controller.authentication;


import io.dekorate.deps.javax.validation.Valid;
import lk.coop.configuration.TokenProvider;

import lk.coop.dto.authentication.request.LoginUserRequest;
import lk.coop.dto.authentication.request.UserRequest;
import lk.coop.dto.authentication.request.UserUpdateRequest;
import lk.coop.dto.authentication.response.AuthTokenResponse;
import lk.coop.dto.authentication.response.LoginResponse;
import lk.coop.dto.authentication.response.UserResponse;
import lk.coop.entity.authentication.User;
import lk.coop.service.authentication.LoginLoggerService;
import lk.coop.service.authentication.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "*", maxAge = 3600)
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLoggerService loggerService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUserRequest loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        LoginResponse save = this.loggerService.save(loginUser.getLoginSaveRequest());
        return ResponseEntity.ok(new AuthTokenResponse(userService.findOne(user.getUsername()),token));
    }

    @PutMapping()
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserUpdateRequest userUpdate) {
        UserResponse update = userService.update(userUpdate);
        return ResponseEntity.ok(update);
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest user){
        return ResponseEntity.ok(userService.save(user));
    }

    @RequestMapping(value="/me", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User) auth.getPrincipal();

        return ResponseEntity.ok(userService.findOne(user.getUsername()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

    @RequestMapping(value="/hellouser", method = RequestMethod.GET)
    public String testPing(){
        return "Only Test Can Read This";
    }



}

