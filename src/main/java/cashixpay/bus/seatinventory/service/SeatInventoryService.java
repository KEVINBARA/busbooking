package cashixpay.bus.seatinventory.service;

import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import cashixpay.bus.seatinventory.pojo.AvailableSeats;
import cashixpay.bus.seatinventory.pojo.SeatBookRequest;
import cashixpay.bus.seatinventory.repositories.SeatInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeatInventoryService {

    @Autowired
    private SeatInventoryRepository seatInventoryRepo;

    public void createSeatInventory(SeatInventory seatInventory){

        seatInventoryRepo.save(seatInventory);

    }

    public List<SeatInventory> getSeatInventory(){

        return seatInventoryRepo.findAll();
    }

    public List<AvailableSeats> searchSeats(String startStop, String endStop, String seatStatus, String travelDate){


        return seatInventoryRepo.getAvailableSeats(startStop,endStop,SeatStatus.valueOf(seatStatus),LocalDate.parse(travelDate));
    }

    public List<SeatInventory>  bookSeat(SeatBookRequest seatBookRequest){

        List<SeatInventory> seatInventories =  seatInventoryRepo.getSeatInventoriesBySeatNumberAndSeatStatusAndRouteIdAndBusIdAndTravelDateTimeAndSegmentSequenceBetween(
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
