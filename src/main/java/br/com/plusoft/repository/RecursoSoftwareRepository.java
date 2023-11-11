package br.com.plusoft.repository;

import br.com.plusoft.entity.RecursoSoftwareEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoSoftwareRepository extends JpaRepository<RecursoSoftwareEntity, Long> {
    Page<RecursoSoftwareEntity> findAllByAtivoTrue(Pageable paginacao);

}
