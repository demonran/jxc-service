package com.demonran.portal.jxc.repository;

import com.demonran.portal.jxc.model.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomRepository extends JpaRepository<Bom,Integer> {
}
