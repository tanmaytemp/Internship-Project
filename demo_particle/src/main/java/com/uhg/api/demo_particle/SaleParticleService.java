package com.uhg.api.demo_particle;

import com.uhg.api.demo_particle.Wrappers.Wrapper;

import java.util.ArrayList;

public interface SaleParticleService {
    void postParticle(Wrapper wrap);
    ArrayList<Wrapper> onlySales();
    ArrayList<SParticle> getFullSales();
    void updateSale(int tid, long quantity);
}
