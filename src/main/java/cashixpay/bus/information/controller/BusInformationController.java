package cashixpay.bus.information.controller;


import cashixpay.bus.information.dto.BusInformationDTO;
import cashixpay.bus.information.entities.BusInformation;
import cashixpay.bus.information.model.BusDetails;
import cashixpay.bus.information.service.BusInformationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/bus")
public class BusInformationController {

    private final BusInformationService busInformationService;

    public BusInformationController(BusInformationService busInformationService) {
        this.busInformationService = busInformationService;
    }

    @GetMapping
    public List<BusInformation> getBusList(){

        return busInformationService.getBusList();
    }

    @PostMapping
    public BusDetails addBus(@RequestBody BusInformationDTO busInformationDTO){

        return busInformationService.addBus(busInformationDTO);
    }
}
