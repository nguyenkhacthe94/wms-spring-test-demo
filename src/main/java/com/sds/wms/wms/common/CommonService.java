package com.sds.wms.wms.common;

import java.util.List;

public interface CommonService<T> {
    List<T> findAll();

    T findByCode(String cd);

    boolean insert(T t);

    boolean updateByCd(String cd, T t);

    boolean delete(T t);

    boolean deleteByCd(String cd);
}
