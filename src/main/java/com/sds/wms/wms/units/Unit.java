package com.sds.wms.wms.units;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MA_UNIT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Unit {
    @Id
    private String unitCd;
    private String unitName;
}
