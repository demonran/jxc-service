package com.demonran.portal.jxc.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Bom  extends BaseRowModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ExcelProperty( index = 0)
    private String serialNumber;
    @ExcelProperty( index = 1)
    private String name;
    @ExcelProperty( index = 2)
    private String specification;
    @ExcelProperty( index = 3)
    private String vendor;
    @ExcelProperty( index = 4)
    private String wholesaler;
    @ExcelProperty( index = 5)
    private double price;
    @ExcelProperty( index = 6)
    private String vendorModel;
    @ExcelProperty( index = 7)
    private int minQuantity;
    @ExcelProperty( index = 8)
    private String deliveryDay;
    @ExcelProperty( index = 9)
    private String backupVendor;
}
