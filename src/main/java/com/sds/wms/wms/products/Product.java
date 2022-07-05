package com.sds.wms.wms.products;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sds.wms.wms.units.Unit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MA_PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    private String productCode;
    private String productName;
    @ManyToOne
    private Unit unitCode;
    private double weight;
    private double x;
    private double y;
    private double z;
    private LocalDateTime createDt;

}
