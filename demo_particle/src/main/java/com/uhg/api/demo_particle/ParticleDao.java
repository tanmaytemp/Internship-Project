package com.uhg.api.demo_particle;

import com.uhg.api.demo_particle.Wrappers.GetWrapper;
import com.uhg.api.demo_particle.Wrappers.TotalWrapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface ParticleDao extends CrudRepository<Particle, Integer> {
    @Query(value = "SELECT p FROM Particle p WHERE p.tid = :#{#obj}")
    ArrayList<Particle> getFromTid(@Param("obj") int obj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity + :#{#qobj} WHERE p.tid = :#{#tobj} AND p.price = :#{#pobj}")
    void update(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.price = :#{#pobj} WHERE p.tid = :#{#tobj} AND p.quantity = :#{#qobj}")
    void putPrice(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Particle p SET p.quantity = p.quantity - :#{#qobj} WHERE p.tid = :#{#tobj} AND p.price = :#{#pobj}")
    void updateWRTsale(@Param("tobj") int tobj, @Param("pobj") double pobj, @Param("qobj") long qobj);

    @Query(value = "SELECT new com.uhg.api.demo_particle.Wrappers.GetWrapper(p.tid, p.type, p.quantity, p.price) FROM Particle p")
    ArrayList<GetWrapper> getOnlyNecessary();

    @Query(value = "SELECT new com.uhg.api.demo_particle.Wrappers.TotalWrapper(p.tid, SUM(p.quantity), SUM(p.price), AVG(p.price)) FROM Particle p GROUP BY(p.tid)")
    ArrayList<TotalWrapper> getTotal();

}
