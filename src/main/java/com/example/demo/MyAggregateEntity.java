package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.util.Assert;

/**
 * @author yukiyoshida
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(staticName = "of")
@Getter
@Entity
@Table(name = "my_aggregate_entities")
public class MyAggregateEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name")
  private String name;

  @Getter(onMethod = @__(@DomainEvents)) //
  private transient final List<Object> domainEvents = new ArrayList<Object>();

  public static MyAggregateEntity create(String name) {
    MyAggregateEntity aggregateEntity = new MyAggregateEntity();
    aggregateEntity.name = name;
    return aggregateEntity;
  }

  protected <T> T registerEvent(T event) {

    Assert.notNull(event, "Domain event must not be null!");

    this.domainEvents.add(event);
    return event;
  }

  @AfterDomainEventPublication
  public void clearDomainEvents() {
    this.domainEvents.clear();
  }
}
