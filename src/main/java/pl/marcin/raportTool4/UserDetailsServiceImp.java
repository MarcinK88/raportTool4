package pl.marcin.raportTool4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.marcin.raportTool4.Models.UserRoles;
import pl.marcin.raportTool4.Models.Users;
import pl.marcin.raportTool4.Repositories.UsersRepository;

import java.util.Set;

import static org.springframework.security.core.userdetails.User.*;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        //TODO: handle multiple roles case

        return withUsername(username)
                .disabled(!user.isEnabled())
                .password(user.getPassword())
                .authorities(user.getUserRoles().getRole())
                .build();
    }
}
