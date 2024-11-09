package com.security.services;
import java.util.List;

import com.security.entities.AppRole;
import com.security.entities.AppUser;

public interface AccountService {

    List<AppUser> listUsers();

    AppUser loadUserByUsername(String username);

    void addRoleToUser(String username, String rolename);

    AppRole addNewRole(AppRole role);

    AppUser addNewUser(AppUser appUser);

}
