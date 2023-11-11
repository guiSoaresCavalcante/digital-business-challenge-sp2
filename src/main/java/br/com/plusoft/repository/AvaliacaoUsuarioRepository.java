package br.com.plusoft.repository;

import br.com.plusoft.entity.AvaliacaoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoUsuarioRepository extends JpaRepository<AvaliacaoUsuarioEntity, Long> {

}
