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

		List<EntityType> entityCollection;
		List<DataType> dataCollection;
		DataType data;

		entityCollection = dao.retrieveAll();
		dataCollection = new ArrayList<DataType>();

        for(EntityType entity : entityCollection) {
            data = entityToData(entity);
            dataCollection.add(data);
        }

		return dataCollection;
	}

	protected abstract DataType entityToData(EntityType entity);
	protected abstract EntityType dataToEntity(DataType data);
}
