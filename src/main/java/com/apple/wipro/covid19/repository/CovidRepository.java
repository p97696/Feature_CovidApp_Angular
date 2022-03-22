package com.apple.wipro.covid19.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apple.wipro.covid19.entity.CovidTotalEntity;


@Repository
public interface CovidRepository extends JpaRepository<CovidTotalEntity,Long>{

}
