package com.moby.dashboard.persistence.repository;

import com.moby.dashboard.persistence.models.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnologyRepository extends JpaRepository<Technology,Long> {
}
