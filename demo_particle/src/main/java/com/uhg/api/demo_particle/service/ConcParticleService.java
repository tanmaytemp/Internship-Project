package com.uhg.api.demo_particle.service;

import com.uhg.api.demo_particle.Particle;
import com.uhg.api.demo_particle.ParticleBuilder;
import com.uhg.api.demo_particle.ParticleDao;
import com.uhg.api.demo_particle.Wrappers.GetWrapper;
import com.uhg.api.demo_particle.Wrappers.TotalWrapper;
import com.uhg.api.demo_particle.Wrappers.Wrapper;
import com.uhg.api.demo_particle.service.ParticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ConcParticleService implements ParticleService {
    @Autowired
    ParticleDao dao;

    @Override
    public ArrayList<Particle> putParticles(Wrapper wrap) {
        Particle p = ParticleBuilder.builder(wrap);
        dao.save(p);
        ArrayList<Particle> particles = new ArrayList<>();
        dao.findAll().forEach(particles::add);
        return particles;

    }

    @Override
    public ArrayList<Particle> getsParticles() {
        ArrayList<Particle> particles= new ArrayList<>();
        dao.findAll().forEach(particles::add);
        return particles;
    }

    public boolean getByTid(int tid){
        ArrayList<Particle> list= new ArrayList<>();
        dao.findAll().forEach(list::add);
        for(Particle p : list){
            if (p.getTid() == tid){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Particle> getAllByTid(int tid){
        return dao.getFromTid(tid);
    }

    @Override
    public void update(int tid, double price, long quantity) {
        dao.update(tid, price, quantity);
    }

    @Override
    public ArrayList<GetWrapper> getsNecessaryParticles() {
        return dao.getOnlyNecessary();
    }

    @Override
    public void putsPrice(Wrapper wrap) {
        dao.putPrice(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
    }

    @Override
    public ArrayList<TotalWrapper> getTotals() {
        return dao.getTotal();
    }
}
