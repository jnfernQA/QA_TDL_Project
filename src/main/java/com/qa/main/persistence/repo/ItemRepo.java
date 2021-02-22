package com.qa.main.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.main.persistence.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Long>{

}
