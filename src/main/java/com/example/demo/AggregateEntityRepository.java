package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yukiyoshida
 */
@Repository
public interface AggregateEntityRepository extends JpaRepository<AggregateEntity, Integer> {
}
