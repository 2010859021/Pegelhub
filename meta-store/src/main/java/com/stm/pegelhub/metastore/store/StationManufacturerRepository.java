package com.stm.pegelhub.metastore.store;

import com.stm.pegelhub.metastore.entity.StationManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StationManufacturerRepository extends JpaRepository<StationManufacturer, UUID> {
}
