package com.jmango360.server.core.components.repositories.mongo;

import java.util.List;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jmango360.server.core.components.entities.TaxiLocation;

public interface TaxiLocationRepository extends
		MongoRepository<TaxiLocation, String> {

	List<TaxiLocation> findByPositionWithin(Box b);

	List<TaxiLocation> findByPositionWithin(Circle c);
}
