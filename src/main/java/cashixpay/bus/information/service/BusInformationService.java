package cashixpay.bus.information.service;


import cashixpay.bus.information.dto.BusInformationDTO;
import cashixpay.bus.information.entities.BusInformation;
import cashixpay.bus.information.model.BusDetails;
import cashixpay.bus.information.repository.BusInformationRepository;
import cashixpay.bus.seat.dto.SeatDTO;
import cashixpay.bus.seat.entities.Seat;
import cashixpay.bus.seat.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusInformationService {


    @Autowired
    private BusInformationRepository busInformationRepository;

    @Autowired
    private SeatService seatService;

    @Transactional
    public BusDetails addBus(BusInformationDTO busInformationDTO){

        String busReference = getBusReference(busInformationDTO.getBusOwnerReference(),busInformationDTO.getPlateNumber(),busInformationDTO.getName());

        BusInformation busInformation = BusInformation.builder()
                .busOwnerReference(busInformationDTO.getBusOwnerReference())
                .name(busInformationDTO.getName())
                .reference(busReference)
                .numberOfSeats(busInformationDTO.getNumberOfSeats())
                .plateNumber(busInformationDTO.getPlateNumber()).build();



        busInformationRepository.save(busInformation);

        int numberOfSeats = busInformationDTO.getNumberOfSeats();
        List<SeatDTO> seatDTOList = getSeatList(numberOfSeats,busInformation.getId().toString(),busReference,busInformation.getName());

      List<Seat> seatList =   seatService.createSeats(seatDTOList);

        return BusDetails.builder()
              .busInformation(busInformation)
              .seatList(seatList).build();

    }

    public List<BusInformation> getBusList(){

        return busInformationRepository.findAll();
    }


    private String getBusReference(String busOwnerReference,String plateNumber,String busName){

        return busOwnerReference+"-"+busName+"-"+plateNumber;
    }

    public BusInformation getBusInformationByPlateNumber(String plateNumber){

        return busInformationRepository.findBusByPlateNumber(plateNumber);
    }

    private List<SeatDTO> getSeatList(int numberOfSeats,String busId,String busReference,String busName){

        List<SeatDTO> seatDTOList = new ArrayList<>();

        for(int i = 1 ; i <= numberOfSeats ;i++){

            SeatDTO seatDTO = SeatDTO.builder()
                    .seatNumber(i)
                    .busId(busId)
                    .busReference(busReference)
                    .busName(busName).build();

            seatDTOList.add(seatDTO);
        }

        return seatDTOList;
    }


}
