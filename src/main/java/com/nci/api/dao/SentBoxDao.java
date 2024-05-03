package com.nci.api.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nci.api.model.SentBoxModel;

public interface SentBoxDao extends CrudRepository<SentBoxModel, Integer> {

	List<SentBoxModel> findBySender(String sender);
	SentBoxModel findById(int id);

}
