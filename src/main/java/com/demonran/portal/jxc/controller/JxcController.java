package com.demonran.portal.jxc.controller;

import com.alibaba.excel.metadata.Sheet;
import com.demonran.portal.jxc.common.Pagination;
import com.demonran.portal.jxc.model.Bom;
import com.demonran.portal.jxc.repository.BomRepository;
import com.demonran.portal.jxc.utils.ExcelUitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("bom")
public class JxcController {

    @Autowired
    private BomRepository repository;

    @GetMapping
    public Pagination<Bom> list(int page , int size){
        return Pagination.of(repository.findAll(PageRequest.of(page-1, size)));
    }

    @PostMapping
    public Bom save(@RequestBody Bom bom){
        return repository.save(bom);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
         repository.deleteById(id);
    }


    @PostMapping("/upload")
    public List<Bom> upload(@RequestParam("file") MultipartFile file) throws IOException {
        List<Bom> boms = ExcelUitls.read(file.getInputStream(), new Sheet(1, 1, Bom.class))
                .stream().map(lt -> (Bom) lt).collect(Collectors.toList());

        repository.saveAll(boms);
        return boms;
    }


}
