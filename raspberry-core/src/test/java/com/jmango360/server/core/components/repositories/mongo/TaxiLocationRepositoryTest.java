package com.jmango360.server.core.components.repositories.mongo;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jmango360.server.core.components.entities.TaxiLocation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "spring/mongo-context.xml" })
public class TaxiLocationRepositoryTest {

	@Autowired
	private TaxiLocationRepository taxiLocationRepository;

	@Autowired
	MongoTemplate template;

	private Random random = new Random();

	private static final int SAMPLE_SIZE = 10;

	@Before
	public void setUp() {
		// ensure geospatial index
		template.indexOps(TaxiLocation.class).ensureIndex(
				new GeospatialIndex("position"));

		// get some sample data
		for (int index = 0; index < SAMPLE_SIZE; index++) {
			template.save(generateTaxiLocation());
		}

	}

	@Test
	public void shouldFindAroundOrigin() {
		// when
		List<TaxiLocation> locations = taxiLocationRepository
				.findByPositionWithin(new Circle(0, 0, 0.75));

	}

	@Test
	public void shouldFindWithinBox() {
		// when
		List<TaxiLocation> locations = taxiLocationRepository
				.findByPositionWithin(new Box(new Point(0.25, 0.25), new Point(
						1, 1)));

	}

	private TaxiLocation generateTaxiLocation() {

		random.setSeed(RandomUtils.nextLong());

		TaxiLocation taxiLocation = new TaxiLocation();
		taxiLocation.setDriverId(String.format("%d", random.nextInt()));
		taxiLocation
				.setDriverName(String.format("Mr No. %d", random.nextInt()));

		if (random.nextInt() % 2 == 0)
			taxiLocation.setJobRef(UUID.randomUUID().toString());

		double[] position = { random.nextDouble(), random.nextDouble() };
		taxiLocation.setPosition(position);

		taxiLocation.setTaxiId(UUID.randomUUID().toString());
		taxiLocation.setTaxiNumber(String.format("%d", random.nextInt()));
		taxiLocation.setTimestamp(new Date());

		return taxiLocation;
	}

}
