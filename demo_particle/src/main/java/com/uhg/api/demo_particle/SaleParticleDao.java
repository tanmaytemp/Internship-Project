package com.uhg.api.demo_particle;

import com.uhg.api.demo_particle.Wrappers.*;
import java.util.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface SaleParticleDao extends CrudRepository<SParticle, Integer> {
    @Query(value = "SELECT new com.uhg.api.demo_particle.Wrappers.Wrapper(s.tid, s.price, s.quantity) FROM SParticle s" )
    ArrayList<Wrapper> getOnlySales();

    @Transactional
    @Modifying
    @Query(value = "Update SParticle s set s.quantity = s.quantity - :#{#qobj} WHERE s.tid = :#{#tobj}")
    void update(@Param("tobj") int tobj  ,@Param("qobj") long quantity);
}
