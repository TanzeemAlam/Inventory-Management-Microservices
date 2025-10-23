package com.tanzeem.livestock_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tanzeem.livestock_service.entity.Livestock;

@Repository
public interface LivestockRepository extends JpaRepository<Livestock, Long>{

}
