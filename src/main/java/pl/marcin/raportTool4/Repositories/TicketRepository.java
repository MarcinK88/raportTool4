package pl.marcin.raportTool4.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marcin.raportTool4.Models.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStatusLike(String status);
}
