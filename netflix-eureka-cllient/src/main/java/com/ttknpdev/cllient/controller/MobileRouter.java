package com.ttknpdev.cllient.controller;

import com.ttknpdev.cllient.entities.Mobile;
import com.ttknpdev.cllient.services.MobileResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = MobileRouter.ROUTER)
public class MobileRouter {
    private MobileResponseService mobileResponseService;
    protected final static String ROUTER = "/api/mobile";
    private final static String NEW_DOMAIN = "http://MOBILES-MICROSERVICE"+ROUTER;
    @Autowired
    public MobileRouter(MobileResponseService mobileResponseService) {
        this.mobileResponseService = mobileResponseService;
    }

    @GetMapping(value = "/reads")
    private ResponseEntity<List<Mobile>> retrieveMobilesFromMobilesMicroservice(){
        String url = NEW_DOMAIN+"/reads";
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mobileResponseService.reads(url));
    }

    @GetMapping(value = "/read")
    private ResponseEntity<Mobile> retrieveMobileFromMobilesMicroservice(@RequestParam(required = false) Long id){
        // request params url look like below
        String url = NEW_DOMAIN+"/read?id="+id;
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mobileResponseService.read(url));
    }

    @PostMapping(value = "/create")
    private ResponseEntity<Boolean> addMobileFromMobilesMicroservice(@RequestBody Mobile mobile){
        // request params url look like below
        String url = NEW_DOMAIN+"/create";
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(mobileResponseService.create(url,mobile));
    }

    @PutMapping(value = "/update")
    private ResponseEntity<Boolean> editMobileFromMobilesMicroservice(@RequestParam(required = false) Long id,@RequestBody Mobile mobile){
        // request params url look like below
        String url = NEW_DOMAIN+"/update?id="+id;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(mobileResponseService.update(url,mobile));
    }

    @DeleteMapping(value = "/delete")
    private ResponseEntity<Boolean> removeMobileFromMobilesMicroservice(@RequestParam(required = false) Long id){
        // request params url look like below
        String url = NEW_DOMAIN+"/delete?id="+id;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(mobileResponseService.delete(url));
    }
}
