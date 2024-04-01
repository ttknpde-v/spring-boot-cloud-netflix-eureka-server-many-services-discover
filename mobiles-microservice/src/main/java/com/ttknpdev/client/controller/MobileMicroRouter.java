package com.ttknpdev.client.controller;

import com.ttknpdev.client.entity.Mobile;
import com.ttknpdev.client.logging.LogBack;
import com.ttknpdev.client.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// Done crud concept
@RestController
@RequestMapping(value = MobileMicroRouter.DEFAULT_PATH)
public class MobileMicroRouter {
    protected static final String DEFAULT_PATH = "/api/mobile";
    private LogBack logBack;
    private MobileRepository mobileRepository;

    @Autowired
    public MobileMicroRouter(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
        logBack = new LogBack(MobileMicroRouter.class);
    }
    @GetMapping(value = "/reads")
    private List<Mobile> retrieveMobiles() {
        logBack.log.info("************ POSTGRESQL DATABASE ************** You called http://MOBILES-MICROSERVICE{} api",DEFAULT_PATH+"/reads");
        return mobileRepository.reads();
    }

    @GetMapping(value = "/read")
    private Mobile retrieveMobile(@RequestParam(required = false) Long id) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** You called http://MOBILES-MICROSERVICE{} api",DEFAULT_PATH+"/read?id="+id);
        return (Mobile) mobileRepository.read(id);
    }

    @PostMapping(value = "/create")
    private Boolean addMobile(@RequestBody Mobile mobile) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** You called http://MOBILES-MICROSERVICE{} api",DEFAULT_PATH+"/create");
        return mobileRepository.create(mobile);
    }

    @PutMapping(value = "/update")
    private Boolean editMobile(@RequestBody Mobile mobile,@RequestParam(required = false) Long id) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** You called http://MOBILES-MICROSERVICE{} api",DEFAULT_PATH+"/update?id="+id);
        return mobileRepository.update(mobile,id);
    }

    @DeleteMapping(value = "/delete")
    private Boolean removeMobile(@RequestParam(required = false) Long id) {
        logBack.log.info("************ POSTGRESQL DATABASE ************** You called http://MOBILES-MICROSERVICE{} api",DEFAULT_PATH+"/delete?id="+id);
        return mobileRepository.delete(id);
    }

}
