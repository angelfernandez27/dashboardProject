package com.moby.dashboard.persistence.repository;

import com.moby.dashboard.persistence.models.entity.TypeDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeRepository extends JpaRepository<TypeDocument,Long> {


}
