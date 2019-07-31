package pl.marcin.raportTool4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.raportTool4.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLoginAndPassword(String login, String password);

}
