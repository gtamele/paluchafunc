package com.bassissa.edmfipag.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface  FuncionarioDAO extends JpaRepository<FuncionarioVO, Long>{
	
	
	
	@Query("SELECT f FROM FuncionarioVO f  WHERE id = ?1 AND nomeEntidade = ?2")
	    FuncionarioVO findFuncioanrioByIdAndEntidade(Long id, String nomeEntidade);

}
