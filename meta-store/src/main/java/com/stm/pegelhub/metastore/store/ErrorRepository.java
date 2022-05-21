package com.stm.pegelhub.metastore.store;

import com.stm.pegelhub.metastore.entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorRepository extends JpaRepository<Error, Long> {
}
