package pl.marcin.raportTool4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.raportTool4.Models.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUsername(String username);
}
