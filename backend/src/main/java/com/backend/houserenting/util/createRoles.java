package com.backend.houserenting.util;

import com.backend.houserenting.security.entity.Rol;
import com.backend.houserenting.security.enumjwt.RolName;
import com.backend.houserenting.security.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
/*public class createRoles implements CommandLineRunner {

    @Autowired
    RolService rolService;

    @Override
    public void run(String... args) throws Exception {
        Rol rolAdmin = new Rol(RolName.ROLE_ADMIN);
        Rol rolUser = new Rol(RolName.ROLE_USER);
        rolService.save(rolAdmin);
        rolService.save(rolUser);
    }
}*/
public class createRoles {

}
