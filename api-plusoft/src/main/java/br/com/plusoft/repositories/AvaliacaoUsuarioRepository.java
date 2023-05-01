package br.com.plusoft.repositories;

import br.com.plusoft.entities.AvaliacaoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoUsuarioRepository extends JpaRepository<AvaliacaoUsuarioEntity, Long> {

}
