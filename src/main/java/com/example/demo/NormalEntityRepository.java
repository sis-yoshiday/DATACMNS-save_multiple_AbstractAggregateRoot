package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yukiyoshida
 */
@Repository
public interface NormalEntityRepository extends JpaRepository<NormalEntity, Integer> {
}
