package com.example.mapper;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface MapperInterface<T,R>{
    R modelToEntity(T t);
    T entityToModel(R r);
    Collection<R> modelLstToEntityLst(Collection<T> t);
    List<T> entityLstToModelLst(Collection<R> r);
//    Page<T> entit
    Page<T> entityToModel(Page<R> r);
//    Set<T> entitySetToModelSet(Set<R> r);
//    Set<R> modelSetToEntitySet(Set<T> r);
}
