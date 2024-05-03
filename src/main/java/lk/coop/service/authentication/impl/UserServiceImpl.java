
package lk.coop.service.authentication.impl;


import lk.coop.converters.DateFormatConverter;
import lk.coop.dto.authentication.request.RoleSaveRequest;
import lk.coop.dto.authentication.request.UserRequest;
import lk.coop.dto.authentication.request.UserUpdateRequest;
import lk.coop.dto.authentication.response.LocationResponse;
import lk.coop.dto.authentication.response.RoleResponse;
import lk.coop.dto.authentication.response.UserResponse;

import lk.coop.entity.authentication.Location;
import lk.coop.entity.authentication.Role;
import lk.coop.entity.authentication.User;
import lk.coop.repository.authentication.UserRepository;
import lk.coop.service.authentication.RoleService;
import lk.coop.service.authentication.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service(value = "userService")
@Slf4j
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUserName(String userName) {
        return null;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        try {
            User user = userRepository.findByUsername(userRequest.getUserName());
            if (user == null) {
                User save = userRepository.save(convert(userRequest));
                return convert(save);
            }
            return null;
        } catch (Exception e) {
            log.error("Error Save User {} ", userRequest.getName());
            e.printStackTrace();
            return null;
        }


//        Role role = roleService.findByName("USER");
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);

//        if (userRequest.getEmail().split("@")[1].equals("admin.edu")) {
//            role = roleService.findByName("ADMIN");
//            roleSet.add(role);
//        }
//
//        userRequest.setRoles(roleSet);
//        userDao.save(nUser);
    }

    @Transactional
    @Override
    public UserResponse update(UserUpdateRequest userUpdate) {

        try {
            User user = userRepository.findByUsername(userUpdate.getUserName());

            String changePassword = bcryptEncoder.encode(userUpdate.getPassword());
            userRepository.updateUser(changePassword, userUpdate.getId());

            return convert(user);

        } catch (Exception e) {
            log.error("Error Update User {} ", userUpdate.getName());
            e.printStackTrace();
            return null;
        }
    }


    private User convert(UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setUsername(userRequest.getUserName());
        user.setPassword(bcryptEncoder.encode(userRequest.getPassword()));
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setBusinessTitle(userRequest.getBusinessTitle());
        user.setEpfNo(userRequest.getEpfNo());
        user.setRoles(convertRole(userRequest.getRoles()));

        return user;
    }


    private static UserResponse convert(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getName(), user.getBusinessTitle(), user.getEpfNo(), convertRoleResponse(user.getRoles()), convertLocation(user.getLocation()));
    }

    private static List<RoleResponse> convertRoleResponse(List<Role> roles) {
        if (roles == null) {
            return null;
        }
        List<RoleResponse> roleResponseList = new ArrayList<>();
        for (Role role : roles) {
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(role.getId());
            roleResponse.setName(role.getName());
            roleResponse.setDescription(role.getDescription());
            roleResponseList.add(roleResponse);
        }

        return roleResponseList;
    }

    private static List<Role> convertRole(Set<RoleSaveRequest> roles) {
        if (roles == null) {
            return null;
        }
        List<Role> roleList = new ArrayList<>();
        for (RoleSaveRequest roleSaveRequest : roles) {
            Role role = new Role();
            role.setId(roleSaveRequest.getId());
            role.setName(roleSaveRequest.getName());
            role.setDescription(roleSaveRequest.getDescription());
            roleList.add(role);
        }

        return roleList;
    }

    //LOCATION RESPONSE CONVERT
    private static LocationResponse convertLocation(Location location) {
        DateFormatConverter df = new DateFormatConverter();
        if (location == null) {
            return null;
        }

        return new LocationResponse(location.getId(), location.getInitialName(), location.getCode(), location.getEmail(), df.patternDate(location.getStartDate()), df.patternDate(location.getEndDate()));
    }
}

