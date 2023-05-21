package br.com.plusoft.repository;

import br.com.plusoft.entity.SoftwareGestaoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftwareGestaoRepository extends JpaRepository<SoftwareGestaoEntity, Long> {
    Page<SoftwareGestaoEntity> findAllByAtivoTrue(Pageable paginacao);
}
