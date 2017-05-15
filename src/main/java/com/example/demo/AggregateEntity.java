package com.example.demo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

/**
 * @author yukiyoshida
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@Getter
@Entity
@Table(name = "aggregate_entities")
public class AggregateEntity extends AbstractAggregateRoot implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  public static AggregateEntity create(String name) {
    AggregateEntity aggregateEntity = new AggregateEntity();
    aggregateEntity.name = name;
    return aggregateEntity;
  }
}
