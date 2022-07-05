package com.sds.wms.wms.units;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        // TODO Auto-generated method stub
        return unitRepository.findAll();
    }

    @Override
    public Unit findByCode(String cd) {
        return unitRepository.findById(cd).orElse(null);
    }

    @Override
    public boolean insert(Unit t) {
        unitRepository.save(t);
        return false;
    }

    @Override
    public boolean updateByCd(String cd, Unit t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Unit t) {
        unitRepository.delete(t);
        return false;
    }

    @Override
    public boolean deleteByCd(String cd) {
        // TODO Auto-generated method stub
        return false;
    }

}
