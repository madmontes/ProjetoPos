package br.edu.infnet.appMarcoMontes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnicoEstudante;

@Repository
public interface BilheteUnicoEstudanteRepository extends CrudRepository<BilheteUnicoEstudante, Integer> {

}
