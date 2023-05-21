package br.com.plusoft.repository;

import br.com.plusoft.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {


    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);
    UsuarioEntity findByEmail(String email);
}
