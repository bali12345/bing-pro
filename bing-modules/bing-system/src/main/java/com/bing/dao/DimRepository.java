package com.bing.dao;

import com.bing.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DimRepository extends JpaRepository<Info, Integer>, JpaSpecificationExecutor<Info>, CrudRepository<Info,Integer> {



}
