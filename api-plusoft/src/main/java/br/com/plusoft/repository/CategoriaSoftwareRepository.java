package br.com.plusoft.repository;

import br.com.plusoft.entity.CategoriaSoftwareEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaSoftwareRepository extends JpaRepository<CategoriaSoftwareEntity, Long> {

    Page<CategoriaSoftwareEntity> findAllByAtivoTrue(Pageable paginacao);
}
