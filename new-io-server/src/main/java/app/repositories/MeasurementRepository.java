package app.repositories;

import app.domain.Measurement;
import com.datastax.driver.core.ConsistencyLevel;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Consistency;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends CassandraRepository <Measurement, UUID> {
    // just for testing
    @AllowFiltering
    @Consistency(ConsistencyLevel.ONE)
    List<Measurement> findAllByDevEui(String devEui);
}
