package com.greenhi.hongBao.controller;

import com.greenhi.hongBao.domian.PartyBranch;
import com.greenhi.hongBao.domian.YouthLeagueBranch;
import com.greenhi.hongBao.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService service;

    @RequestMapping(value = "/party", method = RequestMethod.GET)
    public List<PartyBranch> getAll1() {
        return service.findAllPBranches();
    }

    @RequestMapping(value = "/league", method = RequestMethod.GET)
    public List<YouthLeagueBranch> getAll2() {
        return service.findAllYBranches();
    }

    @RequestMapping(value = "/party", method = RequestMethod.POST)
    public ResponseEntity<Void> insert1(@RequestBody PartyBranch obj) {
        System.out.println("insertOne----->" + obj);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/league", method = RequestMethod.POST)
    public ResponseEntity<Void> insert2(@RequestBody YouthLeagueBranch obj) {
        System.out.println("insertOne----->" + obj);
        obj = service.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/party", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody PartyBranch obj) {
        obj = service.save(obj);
        System.out.println("success update--> " + obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/league", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody YouthLeagueBranch obj) {
        obj = service.save(obj);
        System.out.println("success update--> " + obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
