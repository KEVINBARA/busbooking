package cashixpay.bus.owner.service;

import cashixpay.bus.owner.dto.OwnerDTO;
import cashixpay.bus.owner.entities.Owner;
import cashixpay.bus.owner.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;



    public Owner createOwner(OwnerDTO ownerDTO){

        Owner owner = Owner.builder()
                .name(ownerDTO.getName())
                .address(ownerDTO.getAddress())
                .phoneNumber(ownerDTO.getPhoneNumber()).build();

      return   ownerRepository.save(owner);

    }

    public List<Owner> getOwnerList(){

        return ownerRepository.findAll();
    }


}
