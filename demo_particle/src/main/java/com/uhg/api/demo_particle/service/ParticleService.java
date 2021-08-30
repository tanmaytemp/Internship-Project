package com.uhg.api.demo_particle.service;

import com.uhg.api.demo_particle.Particle;
import com.uhg.api.demo_particle.Wrappers.GetWrapper;
import com.uhg.api.demo_particle.Wrappers.TotalWrapper;
import com.uhg.api.demo_particle.Wrappers.Wrapper;

import java.util.ArrayList;

public interface ParticleService {
    ArrayList<Particle> putParticles(Wrapper wrap) ;
    ArrayList<Particle> getsParticles();
    boolean getByTid(int tid);
    ArrayList<Particle> getAllByTid(int tid);
    void update(int tid, double price, long quantity);
    ArrayList<GetWrapper> getsNecessaryParticles();
    void putsPrice(Wrapper wrap);
    ArrayList<TotalWrapper> getTotals();
}
