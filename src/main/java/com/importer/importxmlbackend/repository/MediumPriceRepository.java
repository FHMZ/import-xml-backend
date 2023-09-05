package com.importer.importxmlbackend.repository;

import com.importer.importxmlbackend.model.MediumPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumPriceRepository extends JpaRepository<MediumPrice, Long> {
}
