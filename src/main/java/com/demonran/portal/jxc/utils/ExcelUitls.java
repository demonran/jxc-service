package com.demonran.portal.jxc.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import java.io.InputStream;
import java.util.List;

public class ExcelUitls {

    public static List<?> read(InputStream is, Sheet sheet){
        return EasyExcelFactory.read(is, sheet);
    }
}
