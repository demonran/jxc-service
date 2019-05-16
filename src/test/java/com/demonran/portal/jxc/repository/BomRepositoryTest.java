package com.demonran.portal.jxc.repository;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.demonran.portal.jxc.model.Bom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BomRepositoryTest {

    @Autowired
    private BomRepository repository;

    @Test
    public void upload() throws FileNotFoundException {
        String file = "/Users/liuran/tmp/BoM_0508.xlsx";

        List<Object> read = EasyExcelFactory.read(new FileInputStream(file), new Sheet(1, 1, Bom.class));

        List<Bom> list = read.stream().map(lt -> (Bom) lt).collect(Collectors.toList());
        List<Bom> boms = repository.saveAll(list);
        System.out.println(boms);
    }

}