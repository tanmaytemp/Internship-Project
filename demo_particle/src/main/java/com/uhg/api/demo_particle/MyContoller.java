package com.uhg.api.demo_particle;

import com.uhg.api.demo_particle.Wrappers.GetWrapper;
import com.uhg.api.demo_particle.Wrappers.TotalWrapper;
import com.uhg.api.demo_particle.Wrappers.Wrapper;
import com.uhg.api.demo_particle.service.ParticleService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Random;

@RestController
public class MyContoller {

    @Autowired
    ParticleService service;

    @Autowired
    SaleParticleService ss;

    @RequestMapping(method = RequestMethod.GET, value = "/ui")
    public RedirectView redirects(){

        return new RedirectView("/swagger-ui/index.html");
    }

    String newLine = System.getProperty("line.separator");

    @RequestMapping(method = RequestMethod.GET, value = " ")
    public String redirectsToHome(){
        return "Welcome to the particle stock exchange" + newLine + "We will help you out here" +
                newLine + "" + newLine + "1. You can access swagger ui by adding /ui to the local host" +
                newLine + "2. To access documentation use /doc" +
                newLine + "3. To access info on current available particles use /particle" +
                newLine + "2. To access complete particle details use /particle/details" +
                newLine + "2. To access documentation use /doc";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doc")
    public RedirectView redirectsToDocs(){

        return new RedirectView("/v3/api-docs");
    }


    @RequestMapping( method = RequestMethod.POST ,value = "/particle")
    String puts(@RequestBody ArrayList<Wrapper> list){
        for(Wrapper wrap : list){
            if (service.getByTid(wrap.getTid())){
                ArrayList<Particle> plist = service.getAllByTid(wrap.getTid());
                for(Particle p : plist){
                    if (p.getPrice() == wrap.getPrice()){
                        service.update(wrap.getTid(), wrap.getPrice(), wrap.getQuantity());
                    }
                }
            }

            else{
                service.putParticles(wrap);
            }
        }
        return "Save Successful";
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle")
    ArrayList<GetWrapper> gets(){
        return service.getsNecessaryParticles();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/details")
    ArrayList<Particle> getsAll(){
        return service.getsParticles();
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/total")
    ArrayList<TotalWrapper> total(){
        return service.getTotals();
    }

    @RequestMapping( method = RequestMethod.PUT ,value = "/particle/price")
    String Puts(@RequestBody ArrayList<Wrapper> wraps){
        for(Wrapper wrap : wraps){
            service.putsPrice(wrap);
        }
        return "SUCCESSFUL";
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/sales")
    ArrayList<Wrapper> getsSales(){
        return ss.onlySales();
    }

    @RequestMapping(method = RequestMethod.POST ,value = "/particle/sales")
    String postSales(@RequestBody ArrayList<Wrapper> wraps) {
        for (Wrapper wrap : wraps){
            ArrayList<Particle> tmp = service.getAllByTid(wrap.getTid());
            if(tmp.size() == 0){
                return "No stock of available";
            }
            for(Particle p : tmp){
                if (p.getQuantity() <= 0){
                    return "Out of stock";
                }
            }
            ArrayList<Wrapper> tmpp = ss.onlySales();
            int flag = 0;
            for(Wrapper w : tmpp){
                if (w.getTid() == wrap.getTid()){
                    ss.updateSale(wrap.getTid(), wrap.getQuantity());
                    flag = 1;
                    break; }
            }
            if (flag == 0){
                ss.postParticle(wrap);
            }
        }
        return "SUCCESSFUL";
    }

    @RequestMapping( method = RequestMethod.GET ,value = "/particle/sales/details")
    ArrayList<SParticle> getsFullSales(){
        return ss.getFullSales();
    }
}
