package cashixpay.bus.owner.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="owner")
public class Owner {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String address;

    private String phoneNumber;
}
