package app.repositories;

import app.domain.Measurement;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MeasurementRepository extends CassandraRepository <Measurement, UUID> {
}
