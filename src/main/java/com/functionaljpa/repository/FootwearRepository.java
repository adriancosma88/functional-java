package com.functionaljpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.functionaljpa.domain.Footwear;

public interface FootwearRepository extends JpaRepository<Footwear, Integer>{

}
