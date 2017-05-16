package com.example.demo;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Autowired
  NormalEntityRepository normalEntityRepository;

  @Autowired
  AggregateEntityRepository aggregateEntityRepository;

  @Autowired
  MyAggregateEntityRepository myAggregateEntityRepository;

  @Test
  public void normal_save_one() {

    NormalEntity actual = normalEntityRepository.save(NormalEntity.create("n1"));

    assertThat(actual.getId(), is(notNullValue()));
    assertThat(actual.getName(), is("n1"));
  }

  @Test
  public void normal_save_multiple() {

    List<NormalEntity> actual = normalEntityRepository.save(
        Arrays.asList(NormalEntity.create("n1"), NormalEntity.create("n2"))
    );

    assertThat(actual, iterableWithSize(2));
    assertThat(actual.get(0).getId(), is(notNullValue()));
    assertThat(actual.get(1).getId(), is(notNullValue()));
  }

  @Test
  public void aggregate_save_one() {

    AggregateEntity actual = aggregateEntityRepository.save(AggregateEntity.create("a1"));

    assertThat(actual.getId(), is(notNullValue()));
    assertThat(actual.getName(), is("a1"));
  }

  @Test
  public void aggregate_save_multiple() {

    List<AggregateEntity> actual = aggregateEntityRepository.save(
        Arrays.asList(AggregateEntity.create("a1"), AggregateEntity.create("a2"))
    );

    assertThat(actual, iterableWithSize(2));
    assertThat(actual.get(0).getId(), is(notNullValue()));
    assertThat(actual.get(1).getId(), is(notNullValue()));
  }

  @Test
  public void aggregate_save_multiple_each() {

    Arrays.asList(AggregateEntity.create("a1"), AggregateEntity.create("a2"))
        .forEach(aggregateEntityRepository::save);

    List<AggregateEntity> actual = aggregateEntityRepository.findAll();

    assertThat(actual, iterableWithSize(2));
    assertThat(actual.get(0).getId(), is(notNullValue()));
    assertThat(actual.get(1).getId(), is(notNullValue()));
  }

  @Test
  public void my_aggregate_save_one() {

    MyAggregateEntity actual = myAggregateEntityRepository.save(MyAggregateEntity.create("ma1"));

    assertThat(actual.getId(), is(notNullValue()));
    assertThat(actual.getName(), is("ma1"));
  }

  @Test
  public void my_aggregate_save_multiple() {

    List<MyAggregateEntity> actual = myAggregateEntityRepository.save(
        Arrays.asList(
            MyAggregateEntity.create("ma1"),
            MyAggregateEntity.create("ma2")
        )
    );

    assertThat(actual, iterableWithSize(2));
    assertThat(actual.get(0).getId(), is(notNullValue()));
    assertThat(actual.get(1).getId(), is(notNullValue()));
  }

  @Test
  public void my_aggregate_save_multiple_each() {

    Arrays.asList(MyAggregateEntity.create("ma1"), MyAggregateEntity.create("ma2"))
        .forEach(myAggregateEntityRepository::save);

    List<MyAggregateEntity> actual = myAggregateEntityRepository.findAll();

    assertThat(actual, iterableWithSize(2));
    assertThat(actual.get(0).getId(), is(notNullValue()));
    assertThat(actual.get(1).getId(), is(notNullValue()));
  }
}
