package br.ucsal.domain.vehicle;

import br.ucsal.domain.BaseEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "gps_tracking")
public class GPSTracking extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    private LocalDateTime timestamp;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal speed;
}
