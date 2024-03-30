package cashixpay.bus.travelroutesegment.service;


import cashixpay.bus.travelroutesegment.dto.TravelRouteSegmentDTO;
import cashixpay.bus.travelroutesegment.entities.TravelRouteSegment;
import cashixpay.bus.travelroutesegment.repositories.TravelRouteSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelRouteSegmentService {

    @Autowired
    private TravelRouteSegmentRepository travelRouteSegmentRepo;


    public TravelRouteSegment addSegment(TravelRouteSegmentDTO segmentDTO){

        TravelRouteSegment travelRouteSegment = TravelRouteSegment.builder()
                .routeReference(segmentDTO.getRouteReference())
                .segmentSequence(segmentDTO.getSegmentSequence())
                .startStop(segmentDTO.getStartStop())
                .endStop(segmentDTO.getEndStop()).build();

        return travelRouteSegmentRepo.save(travelRouteSegment);

    }

    public List<TravelRouteSegment> getRouteSegments(){

        return travelRouteSegmentRepo.findAll();
    }

    public List<TravelRouteSegment> getRouteSegments(String routeReference){

        return travelRouteSegmentRepo.findTravelRouteSegmentByRouteReference(routeReference);
    }
}
