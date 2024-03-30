package cashixpay.bus.seatinventory.service;

import cashixpay.bus.information.entities.BusInformation;
import cashixpay.bus.seat.entities.Seat;
import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import cashixpay.bus.seatinventory.pojo.AvailableSeats;
import cashixpay.bus.seatinventory.pojo.AvailableTravelSchedule;
import cashixpay.bus.seatinventory.pojo.SeatBookRequest;
import cashixpay.bus.seatinventory.repositories.SeatInventoryRepository;
import cashixpay.bus.travelroutesegment.entities.TravelRouteSegment;
import cashixpay.bus.travelschedule.entities.TravelSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatInventoryService {

    @Autowired
    private SeatInventoryRepository seatInventoryRepo;



    public List<SeatInventory> getSeatInventory(){

        return seatInventoryRepo.findAll();
    }


    public void createSeatInventory(BusInformation busInfo, TravelSchedule ts,
                                    List<TravelRouteSegment>travelRouteSegmentList, List<Seat> seatList){

        for(TravelRouteSegment travelRouteSegment : travelRouteSegmentList){

            String segmentId = travelRouteSegment.getId().toString();
            int segmentSequence = travelRouteSegment.getSegmentSequence();
            String startStop = travelRouteSegment.getStartStop();
            String endStop = travelRouteSegment.getEndStop();


            for(Seat seat : seatList){

                String seatId = seat.getId().toString();
                int seatNumber = seat.getSeatNumber();

                SeatInventory seatInventory = SeatInventory.builder()
                        .busOwnerReference(busInfo.getBusOwnerReference())
                        .busReference(busInfo.getReference())
                        .busName(busInfo.getName())
                        .routeReference(ts.getRouteReference())
                        .routeName(ts.getRouteName())
                        .segmentId(segmentId)
                        .segmentSequence(segmentSequence)
                        .startStop(startStop)
                        .endStop(endStop)
                        .seatId(seatId)
                        .seatNumber(seatNumber)
                        .travelScheduleId(ts.getId().toString())
                        .travelDateTime(ts.getStartDateTime())
                        .arrivalDateTime(ts.getArrivalDateTime())
                        .seatStatus(SeatStatus.AVAILABLE).build();

                seatInventoryRepo.save(seatInventory);


            }
        }

    }


    public List<AvailableTravelSchedule> getAvailableSchedules(String startStop, String endStop, String seatStatus){

        return seatInventoryRepo.getAvailableSchedules(startStop,endStop,SeatStatus.valueOf(seatStatus));

    }

    public List<SeatInventory>  bookSeat(SeatBookRequest seatBookRequest){

        List<SeatInventory> seatInventories =  seatInventoryRepo.getSeatInventoriesBySeatNumberAndSeatStatusAndRouteReferenceAndBusReferenceAndTravelDateTimeAndSegmentSequenceBetween(
                seatBookRequest.getSeatNumber(),
                SeatStatus.AVAILABLE,
                seatBookRequest.getRouteId(),
                seatBookRequest.getBusId(),
                LocalDateTime.parse(seatBookRequest.getTravelDateTime()),
                seatBookRequest.getStartSegmentSequence(),
                seatBookRequest.getEndSegmentSequence());

        updateSeatStatus(seatInventories);

        return seatInventories;

    }



    private void updateSeatStatus(List<SeatInventory> seatInventories){


        for(SeatInventory seatInventory : seatInventories){

            seatInventory.setSeatStatus(SeatStatus.BOOKED);

            seatInventoryRepo.save(seatInventory);
        }
    }
}
