package cashixpay.bus.owner.controller;


import cashixpay.bus.owner.dto.OwnerDTO;
import cashixpay.bus.owner.entities.Owner;
import cashixpay.bus.owner.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/cashixpay/v1/owner")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping
    public List<Owner> getOwnerList(){

        return ownerService.getOwnerList();
    }
    @PostMapping
    public Owner createOwner(@RequestBody OwnerDTO ownerDTO){

       return ownerService.createOwner(ownerDTO);
    }
}
