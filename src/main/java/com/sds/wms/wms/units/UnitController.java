package com.sds.wms.wms.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/u")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping
    public ResponseEntity<List<Unit>> getAll() {
        List<Unit> unitList = unitService.findAll();
        if (unitList.size() > 0) {
            return new ResponseEntity<List<Unit>>(unitList, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Unit> insertNewUnit(@RequestBody Unit entity) {
        Unit foundUnit = unitService.findByCode(entity.getUnitCd());
        if (foundUnit != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        unitService.insert(entity);
        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }
}
