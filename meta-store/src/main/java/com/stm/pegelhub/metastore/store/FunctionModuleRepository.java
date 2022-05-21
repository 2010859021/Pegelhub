package com.stm.pegelhub.metastore.store;

import com.stm.pegelhub.data.FunctionModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FunctionModuleRepository extends JpaRepository<FunctionModule, UUID> {
}
