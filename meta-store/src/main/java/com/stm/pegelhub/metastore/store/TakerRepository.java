package com.stm.pegelhub.metastore.store;

import com.stm.pegelhub.data.Taker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TakerRepository extends JpaRepository<Taker, UUID> {
}
