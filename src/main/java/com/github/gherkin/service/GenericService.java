package com.github.gherkin.service;

import java.util.ArrayList;
import java.util.List;

import com.github.gherkin.api.data.Data;
import com.github.gherkin.persistence.DAO;

abstract class GenericService<EntityType, DataType extends Data> {

    DAO<EntityType> dao;

    public DataType retrieve(Long id) {

        EntityType entity;
        DataType data;

        entity = dao.retrieve(id);
        data = entityToData(entity);

        return data;
    }

    public void add(DataType data) {

        EntityType entity;
        entity = dataToEntity(data);

        dao.add(entity);
    }

    public void delete(DataType data) throws Exception {

        dao.remove(data.getId());
    }

    public List<DataType> retrieveAll() {

        return entityToData(dao.retrieveAll());
    }

    @Deprecated
    List<DataType> search(Object field) {

        return entityToData(dao.find(field));
    }

    protected List<DataType> entityToData(List<EntityType> entityList) {

        List<DataType> dataList = new ArrayList<DataType>();
        DataType data;

        for(EntityType entity : entityList) {
            data = entityToData(entity);
            dataList.add(data);
        }

        return dataList;
    }

    protected List<EntityType> dataToEntity(List<DataType> dataList) {

        List<EntityType> entityList = new ArrayList<EntityType>();
        EntityType entity;

        for(DataType data : dataList) {
            entity = dataToEntity(data);
            entityList.add(entity);
        }

        return entityList;
    }

    protected abstract DataType entityToData(EntityType entity);
    protected abstract EntityType dataToEntity(DataType data);
}
