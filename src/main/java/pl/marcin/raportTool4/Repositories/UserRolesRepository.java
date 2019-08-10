package pl.marcin.raportTool4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.raportTool4.Models.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles,Integer> {
}
