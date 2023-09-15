package cashixpay.bus.seatinventory.repositories;

import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import cashixpay.bus.seatinventory.pojo.AvailableSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SeatInventoryRepository extends JpaRepository<SeatInventory, UUID> {



    @Query("SELECT DISTINCT new cashixpay.bus.seatinventory.pojo.AvailableSeats " +
            "(s.busId AS busId,s.busName AS busName,s.routeId AS routeId,s.routeName AS routeName,s.startStop AS startStop,d.endStop AS endStop,s.segmentSequence AS startSegmentSequence,d.segmentSequence AS endSegmentSequence,s.seatNumber AS seatNumber,s.travelDateTime AS travelDateTime ) FROM SeatInventory AS s INNER JOIN SeatInventory  AS d ON s.travelScheduleId = d.travelScheduleId " +
            "WHERE s.startStop= :startStop AND d.endStop = :endStop AND FUNCTION('DATE', s.travelDateTime) = :travelDate  AND s.seatStatus = :seatStatus AND d.seatStatus = :seatStatus ")
    List<AvailableSeats> getAvailableSeats(String startStop, String endStop, SeatStatus seatStatus, LocalDate travelDate );




    List<SeatInventory> getSeatInventoriesBySeatNumberAndSeatStatusAndRouteIdAndBusIdAndTravelDateTimeAndSegmentSequenceBetween(int seatNumber,
                                                                                                                         SeatStatus seatStatus,
                                                                                                                         String routeId,
                                                                                                                         String busId,
                                                                                                                         LocalDateTime travelDateTime,
                                                                                                                         int startSegmentSequence,
                                                                                                                         int endSegmentSequence);
}
