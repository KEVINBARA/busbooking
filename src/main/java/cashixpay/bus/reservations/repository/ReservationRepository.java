package cashixpay.bus.reservations.repository;

import cashixpay.bus.reservations.entities.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservations, UUID> {


}
