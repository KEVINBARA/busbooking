package cashixpay.bus.travelschedule.service;

import cashixpay.bus.busdetails.entities.BusInformation;
import cashixpay.bus.busdetails.service.BusInformationService;
import cashixpay.bus.seat.entities.Seat;
import cashixpay.bus.seat.repository.SeatRepository;
import cashixpay.bus.seatinventory.entities.SeatInventory;
import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import cashixpay.bus.seatinventory.service.SeatInventoryService;
import cashixpay.bus.travelroutesegment.entities.TravelRouteSegment;
import cashixpay.bus.travelroutesegment.service.TravelRouteSegmentService;
import cashixpay.bus.travelschedule.dto.TravelScheduleDTO;
import cashixpay.bus.travelschedule.entities.TravelSchedule;
import cashixpay.bus.travelschedule.repository.TravelScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TravelScheduleService {

    @Autowired
    private TravelScheduleRepository travelScheduleRepository;

    @Autowired
    private BusInformationService busInformationService;

    @Autowired
    private TravelRouteSegmentService travelRouteSegmentService;

    @Autowired
    private SeatInventoryService seatInventoryService;

    @Autowired
    private SeatRepository seatRepository;



    @Transactional
    public List<TravelSchedule> createSchedule(TravelScheduleDTO travelScheduleDTO){


        List<TravelSchedule> travelScheduleList = new ArrayList<>();

        BusInformation busInfo = busInformationService
                .getBusInformationByPlateNumber(travelScheduleDTO.getBusPlateNumber());

        List<TravelRouteSegment> travelRouteSegmentList = travelRouteSegmentService
                .getRouteSegments(travelScheduleDTO.getRouteId());

        //temp create three days for test

        String routeId = travelScheduleDTO.getRouteId();
        String routeName = travelScheduleDTO.getRouteName();
        for(int i = 0; i <=3 ;i++){


            LocalDateTime startDateTime = travelScheduleDTO.getStartDateTime().plusDays(i);
            TravelSchedule travelSchedule = TravelSchedule.builder()
                    .busId(busInfo.getId().toString())
                    .busName(busInfo.getName())
                    .routeId(routeId)
                    .routeName(routeName)
                    .startDateTime(startDateTime)
                    .arrivalDateTime(travelScheduleDTO.getArrivalDateTime()).build();

            travelScheduleList.add(travelSchedule);

            travelScheduleRepository.save(travelSchedule);

            List<Seat> seatList = seatRepository.findSeatsByBusId(busInfo.getId().toString());

            createSeatInventory(busInfo,routeId,routeName,travelRouteSegmentList,seatList,
                    travelSchedule.getId().toString(),startDateTime);

        }

        return travelScheduleList;
    }

    public void createSeatInventory(BusInformation busInfo, String routeId, String routeName,
                                    List<TravelRouteSegment>travelRouteSegmentList, List<Seat> seatList,String travelScheduleId,LocalDateTime travelDateTime){

        for(TravelRouteSegment travelRouteSegment : travelRouteSegmentList){

            String segmentId = travelRouteSegment.getId().toString();
            int segmentSequence = travelRouteSegment.getSegmentSequence();
            String startStop = travelRouteSegment.getStartStop();
            String endStop = travelRouteSegment.getEndStop();


            for(Seat seat : seatList){

                String seatId = seat.getId().toString();
                int seatNumber = seat.getSeatNumber();

                SeatInventory seatInventory = SeatInventory.builder()
                        .busId(busInfo.getId().toString())
                        .busName(busInfo.getName())
                        .routeId(routeId)
                        .routeName(routeName)
                        .segmentId(segmentId)
                        .segmentSequence(segmentSequence)
                        .startStop(startStop)
                        .endStop(endStop)
                        .seatId(seatId)
                        .seatNumber(seatNumber)
                        .travelScheduleId(travelScheduleId)
                        .travelDateTime(travelDateTime)
                        .seatStatus(SeatStatus.AVAILABLE).build();

                seatInventoryService.createSeatInventory(seatInventory);




            }
        }

    }
}
