package cashixpay.bus.seat.repository;

import cashixpay.bus.seat.entities.Seat;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SeatRepository extends JpaRepository<Seat, UUID> {


    Seat findSeatBySeatNumberAndBusName(int seatNumber,String busName);

    List<Seat> findSeatsByBusId(String busId);
}
