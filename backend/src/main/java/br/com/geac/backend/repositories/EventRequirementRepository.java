package br.com.geac.backend.repositories;

import br.com.geac.backend.domain.Entities.EventRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRequirementRepository extends JpaRepository<EventRequirement, Integer> {
}