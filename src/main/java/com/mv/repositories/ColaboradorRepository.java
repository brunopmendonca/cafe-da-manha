package com.mv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mv.entities.Colaborador;

@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE from colaboradores as c WHERE c.cpf = :cpf ", nativeQuery = true)
	void deleteByCpf(@Param("cpf") String cpf);

	@Query(value = "SELECT * FROM colaboradores c WHERE c.cpf =:cpf", nativeQuery = true)
	Colaborador findByCpf(@Param("cpf") String cpf);

	@Query(value = "SELECT * FROM colaboradores", nativeQuery = true)
	List<Colaborador> findAll();
}
