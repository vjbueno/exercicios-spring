package com.farmacia.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farmacia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
	
}
