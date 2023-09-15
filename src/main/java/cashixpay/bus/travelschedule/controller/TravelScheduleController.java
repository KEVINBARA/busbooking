package cashixpay.bus.travelschedule.controller;

import cashixpay.bus.travelschedule.dto.TravelScheduleDTO;
import cashixpay.bus.travelschedule.entities.TravelSchedule;
import cashixpay.bus.travelschedule.service.TravelScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/travelschedule")
public class TravelScheduleController {

    private final TravelScheduleService travelScheduleService;


    public TravelScheduleController(TravelScheduleService travelScheduleService) {
        this.travelScheduleService = travelScheduleService;
    }

    @PostMapping
    public List<TravelSchedule> addSchedule(@RequestBody TravelScheduleDTO travelScheduleDTO){

        return travelScheduleService.createSchedule(travelScheduleDTO);
    }
}
