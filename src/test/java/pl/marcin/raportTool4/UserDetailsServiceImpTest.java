package pl.marcin.raportTool4;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class UserDetailsServiceImpTest {

    @Ignore
    @Test
    public void generatePassword(){
        System.out.println(new BCryptPasswordEncoder().encode(""));
    }

}