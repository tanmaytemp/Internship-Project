package com.uhg.api.demo_particle;

import com.uhg.api.demo_particle.Wrappers.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Primary
public class ConcSaleParticleService implements SaleParticleService{

    @Autowired
    SaleParticleDao dao ;

    @Override
    public void postParticle(Wrapper wrap) {
        SParticle sp = SaleBuilder.builder(wrap);
        dao.save(sp);
    }

    @Override
    public ArrayList<Wrapper> onlySales() {
        return dao.getOnlySales();
    }

    @Override
    public ArrayList<SParticle> getFullSales() {
        ArrayList<SParticle> list = new ArrayList<>();
        dao.findAll().forEach(list::add);
        return list;
    }

    @Override
    public void updateSale(int tid, long quantity) {
        dao.update(tid, quantity);
    }
}
