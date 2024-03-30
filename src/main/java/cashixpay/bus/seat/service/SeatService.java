package cashixpay.bus.seat.service;

import cashixpay.bus.seat.dto.SeatDTO;
import cashixpay.bus.seat.entities.Seat;
import cashixpay.bus.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;


    public Seat createSeat(SeatDTO seatDTO){

        Seat seat = Seat.builder()
                .busId(seatDTO.getBusId())
                .busReference(seatDTO.getBusReference())
                .busName(seatDTO.getBusName())
                .seatNumber(seatDTO.getSeatNumber()).build();

        seatRepository.save(seat);

        return seat;

    }

    public List<Seat> createSeats(List<SeatDTO> seatDTOList){

        List<Seat> seatList = new ArrayList<>();
        for(SeatDTO seatDTO : seatDTOList){
            Seat seat = Seat.builder()
                    .busId(seatDTO.getBusId())
                    .busReference(seatDTO.getBusReference())
                    .busName(seatDTO.getBusName())
                    .seatNumber(seatDTO.getSeatNumber()).build();

            seatList.add(seat);


        }

        seatRepository.saveAll(seatList);
        return seatList;

    }

    public List<Seat> getSeatList(){

        return seatRepository.findAll();
    }

    public List<Seat> getSeatList(String busId){

        return seatRepository.findSeatsByBusId(busId);
    }
}
