
/**
 * Autogenerated by Jack
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package com.rapleaf.jack.test_project.database_1.mock_impl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Timestamp;

import com.rapleaf.jack.AbstractMockDatabaseModel;
import com.rapleaf.jack.queries.ModelQuery;
import com.rapleaf.jack.ModelWithId;
import com.rapleaf.jack.queries.WhereConstraint;
import com.rapleaf.jack.queries.QueryOrder;
import com.rapleaf.jack.queries.LimitCriterion;
import com.rapleaf.jack.queries.OrderCriterion;

import com.rapleaf.jack.test_project.database_1.models.Image;
import com.rapleaf.jack.test_project.database_1.models.Image.Id;
import com.rapleaf.jack.test_project.database_1.iface.IImagePersistence;
import com.rapleaf.jack.test_project.database_1.query.ImageQueryBuilder;

import com.rapleaf.jack.test_project.IDatabases;

public class BaseMockImagePersistenceImpl extends AbstractMockDatabaseModel<Image, IDatabases> implements IImagePersistence {
  private final IDatabases databases;

  private static AtomicInteger curId = new AtomicInteger(1);

  public BaseMockImagePersistenceImpl(IDatabases databases) {
    super(databases);
    this.databases = databases;
  }

  @Override
  public Image create(Map<Enum, Object> fieldsMap) throws IOException {
    Integer user_id = (Integer) fieldsMap.get(Image._Fields.user_id);
    return create(user_id);
  }


  public Image create(final Integer user_id) throws IOException {
    long __id = curId.getAndIncrement();
    Image newInst = new Image(__id, user_id, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }



  public Image create() throws IOException {
    long __id = curId.getAndIncrement();
    Image newInst = new Image(__id, null, databases);
    records.put(__id, newInst);
    clearForeignKeyCache();
    return newInst.getCopy();
  }


  public Image createDefaultInstance() throws IOException {
    return create();
  }

  public Set<Image> find(Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(fieldsMap);
  }

  public Set<Image> find(Set<Long> ids, Map<Enum, Object> fieldsMap) throws IOException {
    return super.realFind(ids, fieldsMap);
  }

  public Set<Image> find(ModelQuery query) throws IOException {
    Set<Image> allResults = super.realFind(query);
    return truncateResults(allResults, query.getLimitCriterion());
  }
  
  public List<Image> findWithOrder(ModelQuery query) throws IOException {
    List<Image> allResults = sortUnorderedMockQuery(super.realFind(query), query);
    return truncateResults(allResults, query.getLimitCriterion());
  }

  private List<Image> sortUnorderedMockQuery(Set<Image> unorderedResult, ModelQuery query) {
    final List<OrderCriterion> orderCriteria = query.getOrderCriteria();
    List<Image> result = new ArrayList<Image>(unorderedResult);

    Collections.sort(result, new Comparator<Image>() {
      public int compare(Image t1, Image t2) {
        for (OrderCriterion orderCriterion : orderCriteria) {
          int compareResult;
          Enum field = orderCriterion.getField();
          String fieldName = field != null ? field.toString() : "id";

          Object o1 = field != null ? t1.getField(fieldName) : t1.getId();
          Object o2 = field != null ? t2.getField(fieldName) : t2.getId();
          if (o1 instanceof java.lang.Comparable) {
            compareResult = ((Comparable) o1).compareTo(o2);
          } else {
            compareResult = Integer.valueOf(o1.hashCode()).compareTo(o2.hashCode());
          }

          int orderDirection = (orderCriterion.getOrder() == QueryOrder.ASC) ? 1 : -1;
          compareResult = compareResult * orderDirection;
          if (compareResult != 0) {
            if (compareResult < 0) {
              return -1;
            } else {
              return 1;
            }
          }
        }
        return 0;
      }
    });

    return result;    
  }

  public Set<Image> findByUserId(final Integer value) throws IOException {
    return find(new HashMap<Enum, Object>(){{put(Image._Fields.user_id, value);}});
  }

  public ImageQueryBuilder query() {
    return new ImageQueryBuilder(this);
  }
}
