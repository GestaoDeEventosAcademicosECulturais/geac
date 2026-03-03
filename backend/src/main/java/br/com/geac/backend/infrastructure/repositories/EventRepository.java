package br.com.geac.backend.infrastructure.repositories;

import br.com.geac.backend.domain.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
    List<Event> findAllByStartTimeBetween(LocalDateTime startTimeAfter, LocalDateTime startTimeBefore);
}
