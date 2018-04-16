package app.repositories;

import app.domain.EndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<EndUser, Long> {
}
