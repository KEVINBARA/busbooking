package cashixpay.bus.owner.repository;

import cashixpay.bus.owner.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerRepository extends JpaRepository<Owner, UUID> {


    Owner findBusOwnerByName(String name);

}
