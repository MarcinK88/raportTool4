package pl.marcin.raportTool4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.marcin.raportTool4.Models.UserRoles;
import pl.marcin.raportTool4.Models.Users;
import pl.marcin.raportTool4.Repositories.UsersRepository;

import java.util.Set;
@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);
        User.UserBuilder builder = null;

        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            Set<UserRoles> userRoles = user.getUserRoles();
            builder.authorities(String.valueOf(userRoles));
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
