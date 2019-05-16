package com.demonran.portal.jxc.controller;

import com.demonran.portal.jxc.model.Bom;
import com.demonran.portal.jxc.repository.BomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("bom")
public class JxcController {

    @Autowired
    private BomRepository repository;

    @GetMapping
    public List<Bom> list(){
        return repository.findAll();
    }


}
