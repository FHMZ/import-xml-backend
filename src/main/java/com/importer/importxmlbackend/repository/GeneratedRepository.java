package com.importer.importxmlbackend.repository;

import com.importer.importxmlbackend.model.Generated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedRepository extends JpaRepository<Generated, Long> {
}
