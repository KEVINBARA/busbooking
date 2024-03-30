package cashixpay.bus.information.repository;

import cashixpay.bus.information.entities.BusInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusInformationRepository extends JpaRepository<BusInformation, UUID> {


    BusInformation findBusByPlateNumber(String plateNumber);
}