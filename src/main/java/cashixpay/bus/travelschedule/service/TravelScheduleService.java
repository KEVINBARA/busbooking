package cashixpay.bus.travelschedule.service;

import cashixpay.bus.information.entities.BusInformation;
import cashixpay.bus.information.service.BusInformationService;
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
                .getRouteSegments(travelScheduleDTO.getRouteReference());

        //temp create three days for test

        String routeReference = travelScheduleDTO.getRouteReference();
        String routeName = travelScheduleDTO.getRouteName();
        for(int i = 0; i <=3 ;i++){


            LocalDateTime startDateTime = travelScheduleDTO.getStartDateTime().plusDays(i);
            TravelSchedule travelSchedule = TravelSchedule.builder()
                    .busReference(busInfo.getReference())
                    .busName(busInfo.getName())
                    .routeReference(routeReference)
                    .routeName(routeName)
                    .startDateTime(startDateTime)
                    .price(20000.0)
                    .arrivalDateTime(travelScheduleDTO.getArrivalDateTime().plusDays(i)).build();

            travelScheduleList.add(travelSchedule);

            travelScheduleRepository.save(travelSchedule);

            List<Seat> seatList = seatRepository.findSeatsByBusId(busInfo.getId().toString());

            createSeatInventory(busInfo,travelSchedule,travelRouteSegmentList,seatList);

        }

        return travelScheduleList;
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

                seatInventoryService.createSeatInventory(seatInventory);




            }
        }

    }
}
