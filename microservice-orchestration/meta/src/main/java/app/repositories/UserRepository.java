package app.repositories;

import app.domain.IotUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<IotUser, Long> {
}
