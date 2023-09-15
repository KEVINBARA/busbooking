package cashixpay.bus.travelroutesegment.controller;

import cashixpay.bus.travelroutesegment.dto.TravelRouteSegmentDTO;
import cashixpay.bus.travelroutesegment.entities.TravelRouteSegment;
import cashixpay.bus.travelroutesegment.service.TravelRouteSegmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/cashixpay/v1/travelroutesegment")
public class TravelRouteSegmentController {

    private final TravelRouteSegmentService travelRouteSegmentService;

    public TravelRouteSegmentController(TravelRouteSegmentService travelRouteSegmentService) {
        this.travelRouteSegmentService = travelRouteSegmentService;
    }

    @PostMapping
    public TravelRouteSegment addSegment(@RequestBody TravelRouteSegmentDTO travelRouteSegmentDTO){

        return travelRouteSegmentService.addSegment(travelRouteSegmentDTO);
    }
}
