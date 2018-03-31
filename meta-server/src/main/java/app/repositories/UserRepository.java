package app.repositories;

import app.domain.IotUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<IotUser, Long> {
}
