package com.qa.main.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.main.persistence.domain.ListName;

public interface ListRepo extends JpaRepository<ListName, Long>{
	
}
