package br.ucsal.infrastructure;

import br.ucsal.domain.logs.ActionLog;
import br.ucsal.domain.logs.ApprovalLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActionLogRepository extends JpaRepository<ActionLog, Long>  {

}
