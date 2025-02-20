package br.ucsal.infrastructure;

import br.ucsal.domain.locations.Location;
import br.ucsal.domain.locations.LocationType;
import br.ucsal.domain.logs.ApprovalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IApprovalLogRepository extends JpaRepository<ApprovalLog, Long>  {

}
