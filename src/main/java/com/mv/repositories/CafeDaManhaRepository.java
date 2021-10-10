package com.mv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mv.entities.CafeDaManha;

public interface CafeDaManhaRepository extends JpaRepository<CafeDaManha, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE from cafe_da_manha as c WHERE c.nome = :nome ", nativeQuery = true)
	void deleteByNome(@Param("nome") String nome);

	@Query(value = "SELECT * FROM cafe_da_manha c WHERE c.nome =:nome", nativeQuery = true)
	CafeDaManha findByNome(@Param("nome") String nome);

	@Query(value = "SELECT * FROM cafe_da_manha", nativeQuery = true)
	List<CafeDaManha> findAll();

}
