package com.moby.dashboard.persistence.repository;

import com.moby.dashboard.persistence.models.entity.CandidateTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICandidateTechnologyRepository extends JpaRepository<CandidateTechnology,Long> {
}
