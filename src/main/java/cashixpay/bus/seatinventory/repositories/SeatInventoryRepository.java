package cashixpay.bus.seatinventory.repositories;

import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import cashixpay.bus.seatinventory.pojo.AvailableSeats;
import cashixpay.bus.seatinventory.pojo.AvailableTravelSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface SeatInventoryRepository extends JpaRepository<SeatInventory, UUID> {



    @Query("SELECT DISTINCT new cashixpay.bus.seatinventory.pojo.AvailableSeats " +
            "(s.busReference AS busId,s.busName AS busName,s.routeReference AS routeId,s.routeName AS routeName,s.startStop AS startStop,d.endStop AS endStop,s.segmentSequence AS startSegmentSequence,d.segmentSequence AS endSegmentSequence,s.seatNumber AS seatNumber,s.travelDateTime AS travelDateTime ) FROM SeatInventory AS s INNER JOIN SeatInventory  AS d ON s.travelScheduleId = d.travelScheduleId " +
            "WHERE s.startStop= :startStop AND d.endStop = :endStop AND FUNCTION('DATE', s.travelDateTime) = :travelDate  AND s.seatStatus = :seatStatus AND d.seatStatus = :seatStatus ")
    List<AvailableSeats> getAvailableSeats(String startStop, String endStop, SeatStatus seatStatus, LocalDate travelDate );



    @Query("SELECT new cashixpay.bus.seatinventory.pojo.AvailableTravelSchedule " +
            "(COUNT(DISTINCT s.seatNumber) as seatLeft,s.busOwnerReference AS ownerRef ,s.travelScheduleId AS travelScheduleId,s.startStop AS startStop,d.endStop AS endStop,s.travelDateTime AS travelDateTime,d.arrivalDateTime as arrivalDateTime,d.segmentSequence as routeSegment)  FROM SeatInventory AS s INNER JOIN SeatInventory  AS d ON s.travelScheduleId = d.travelScheduleId " +
            "WHERE s.startStop= :startStop AND d.endStop = :endStop   AND s.seatStatus = :seatStatus AND d.seatStatus = :seatStatus GROUP BY s.busOwnerReference,s.travelScheduleId,s.startStop,d.endStop,s.travelDateTime,d.arrivalDateTime,routeSegment order by s.travelDateTime  ASC ")
    List<AvailableTravelSchedule> getAvailableSchedules(String startStop, String endStop, SeatStatus seatStatus);




    List<SeatInventory> getSeatInventoriesBySeatNumberAndSeatStatusAndRouteReferenceAndBusReferenceAndTravelDateTimeAndSegmentSequenceBetween(int seatNumber,
                                                                                                                         SeatStatus seatStatus,
                                                                                                                         String routeId,
                                                                                                                         String busId,
                                                                                                                         LocalDateTime travelDateTime,
                                                                                                                         int startSegmentSequence,
                                                                                                                         int endSegmentSequence);
}
