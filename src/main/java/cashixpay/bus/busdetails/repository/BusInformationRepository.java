package cashixpay.bus.busdetails.repository;

import cashixpay.bus.busdetails.entities.BusInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusInformationRepository extends JpaRepository<BusInformation, UUID> {


    BusInformation findBusByPlateNumber(String plateNumber);
}