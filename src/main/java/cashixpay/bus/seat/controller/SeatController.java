package cashixpay.bus.seat.controller;


import cashixpay.bus.seat.dto.SeatDTO;
import cashixpay.bus.seat.entities.Seat;
import cashixpay.bus.seat.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/seat")
public class SeatController {


    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping
    public List<Seat> getSeatList(){

        return seatService.getSeatList();
    }

    @PostMapping
    public Seat createSeat(@RequestBody SeatDTO seatDTO){

        return seatService.createSeat(seatDTO);
    }


}
