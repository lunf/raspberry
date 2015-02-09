package com.jmango360.server.core.components.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jmango360.server.core.components.entities.TaxiLocation;

public interface TaxiLocationRespository extends MongoRepository<TaxiLocation, String>{

}
