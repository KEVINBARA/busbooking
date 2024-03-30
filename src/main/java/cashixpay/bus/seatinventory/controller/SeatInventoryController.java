package cashixpay.bus.seatinventory.controller;

import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.pojo.AvailableSeats;
import cashixpay.bus.seatinventory.pojo.AvailableTravelSchedule;
import cashixpay.bus.seatinventory.pojo.SeatBookRequest;
import cashixpay.bus.seatinventory.service.SeatInventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/seatinventory")
public class SeatInventoryController {

    private final SeatInventoryService seatInventoryService;


    public SeatInventoryController(SeatInventoryService seatInventoryService) {
        this.seatInventoryService = seatInventoryService;
    }

    @GetMapping
    public List<SeatInventory> getSeatInventory(){

        return seatInventoryService.getSeatInventory();
    }

    @GetMapping("/search")
    public List<AvailableTravelSchedule> searchSeats(
            @RequestParam(name= "startStop") String startStop,
            @RequestParam(name = "endStop") String endStop,
            @RequestParam(name = "travelDate") String travelDate,
            @RequestParam(name = "seatStatus") String seatStatus
    ){

        return seatInventoryService.getAvailableSchedules(startStop,endStop,seatStatus);
    }

    @PostMapping("/book")
    public List<SeatInventory>  bookSeats(

            @RequestBody SeatBookRequest seatBookRequest
            ){

        return seatInventoryService.bookSeat(seatBookRequest);
    }


}
