package br.edu.infnet.appMarcoMontes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMarcoMontes.model.domain.BilheteUnico;

@Repository
public interface BilheteUnicoRepository extends CrudRepository<BilheteUnico, Integer> {

}
