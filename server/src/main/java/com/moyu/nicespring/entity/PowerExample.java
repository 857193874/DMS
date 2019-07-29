package com.moyu.nicespring.entity;

import java.util.ArrayList;
import java.util.List;

public class PowerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PowerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPowerIdIsNull() {
            addCriterion("power_id is null");
            return (Criteria) this;
        }

        public Criteria andPowerIdIsNotNull() {
            addCriterion("power_id is not null");
            return (Criteria) this;
        }

        public Criteria andPowerIdEqualTo(Integer value) {
            addCriterion("power_id =", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotEqualTo(Integer value) {
            addCriterion("power_id <>", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdGreaterThan(Integer value) {
            addCriterion("power_id >", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_id >=", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdLessThan(Integer value) {
            addCriterion("power_id <", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdLessThanOrEqualTo(Integer value) {
            addCriterion("power_id <=", value, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdIn(List<Integer> values) {
            addCriterion("power_id in", values, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotIn(List<Integer> values) {
            addCriterion("power_id not in", values, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdBetween(Integer value1, Integer value2) {
            addCriterion("power_id between", value1, value2, "powerId");
            return (Criteria) this;
        }

        public Criteria andPowerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("power_id not between", value1, value2, "powerId");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionIsNull() {
            addCriterion("totalconsumption is null");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionIsNotNull() {
            addCriterion("totalconsumption is not null");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionEqualTo(Double value) {
            addCriterion("totalconsumption =", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionNotEqualTo(Double value) {
            addCriterion("totalconsumption <>", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionGreaterThan(Double value) {
            addCriterion("totalconsumption >", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionGreaterThanOrEqualTo(Double value) {
            addCriterion("totalconsumption >=", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionLessThan(Double value) {
            addCriterion("totalconsumption <", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionLessThanOrEqualTo(Double value) {
            addCriterion("totalconsumption <=", value, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionIn(List<Double> values) {
            addCriterion("totalconsumption in", values, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionNotIn(List<Double> values) {
            addCriterion("totalconsumption not in", values, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionBetween(Double value1, Double value2) {
            addCriterion("totalconsumption between", value1, value2, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andTotalconsumptionNotBetween(Double value1, Double value2) {
            addCriterion("totalconsumption not between", value1, value2, "totalconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionIsNull() {
            addCriterion("subsidyconsumption is null");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionIsNotNull() {
            addCriterion("subsidyconsumption is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionEqualTo(Double value) {
            addCriterion("subsidyconsumption =", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionNotEqualTo(Double value) {
            addCriterion("subsidyconsumption <>", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionGreaterThan(Double value) {
            addCriterion("subsidyconsumption >", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionGreaterThanOrEqualTo(Double value) {
            addCriterion("subsidyconsumption >=", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionLessThan(Double value) {
            addCriterion("subsidyconsumption <", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionLessThanOrEqualTo(Double value) {
            addCriterion("subsidyconsumption <=", value, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionIn(List<Double> values) {
            addCriterion("subsidyconsumption in", values, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionNotIn(List<Double> values) {
            addCriterion("subsidyconsumption not in", values, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionBetween(Double value1, Double value2) {
            addCriterion("subsidyconsumption between", value1, value2, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andSubsidyconsumptionNotBetween(Double value1, Double value2) {
            addCriterion("subsidyconsumption not between", value1, value2, "subsidyconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionIsNull() {
            addCriterion("payconsumption is null");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionIsNotNull() {
            addCriterion("payconsumption is not null");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionEqualTo(Double value) {
            addCriterion("payconsumption =", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionNotEqualTo(Double value) {
            addCriterion("payconsumption <>", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionGreaterThan(Double value) {
            addCriterion("payconsumption >", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionGreaterThanOrEqualTo(Double value) {
            addCriterion("payconsumption >=", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionLessThan(Double value) {
            addCriterion("payconsumption <", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionLessThanOrEqualTo(Double value) {
            addCriterion("payconsumption <=", value, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionIn(List<Double> values) {
            addCriterion("payconsumption in", values, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionNotIn(List<Double> values) {
            addCriterion("payconsumption not in", values, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionBetween(Double value1, Double value2) {
            addCriterion("payconsumption between", value1, value2, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andPayconsumptionNotBetween(Double value1, Double value2) {
            addCriterion("payconsumption not between", value1, value2, "payconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionIsNull() {
            addCriterion("freeconsumption is null");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionIsNotNull() {
            addCriterion("freeconsumption is not null");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionEqualTo(Double value) {
            addCriterion("freeconsumption =", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionNotEqualTo(Double value) {
            addCriterion("freeconsumption <>", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionGreaterThan(Double value) {
            addCriterion("freeconsumption >", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionGreaterThanOrEqualTo(Double value) {
            addCriterion("freeconsumption >=", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionLessThan(Double value) {
            addCriterion("freeconsumption <", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionLessThanOrEqualTo(Double value) {
            addCriterion("freeconsumption <=", value, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionIn(List<Double> values) {
            addCriterion("freeconsumption in", values, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionNotIn(List<Double> values) {
            addCriterion("freeconsumption not in", values, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionBetween(Double value1, Double value2) {
            addCriterion("freeconsumption between", value1, value2, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andFreeconsumptionNotBetween(Double value1, Double value2) {
            addCriterion("freeconsumption not between", value1, value2, "freeconsumption");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdIsNull() {
            addCriterion("power_building_id is null");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdIsNotNull() {
            addCriterion("power_building_id is not null");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdEqualTo(Integer value) {
            addCriterion("power_building_id =", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdNotEqualTo(Integer value) {
            addCriterion("power_building_id <>", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdGreaterThan(Integer value) {
            addCriterion("power_building_id >", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("power_building_id >=", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdLessThan(Integer value) {
            addCriterion("power_building_id <", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdLessThanOrEqualTo(Integer value) {
            addCriterion("power_building_id <=", value, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdIn(List<Integer> values) {
            addCriterion("power_building_id in", values, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdNotIn(List<Integer> values) {
            addCriterion("power_building_id not in", values, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdBetween(Integer value1, Integer value2) {
            addCriterion("power_building_id between", value1, value2, "powerBuildingId");
            return (Criteria) this;
        }

        public Criteria andPowerBuildingIdNotBetween(Integer value1, Integer value2) {
            addCriterion("power_building_id not between", value1, value2, "powerBuildingId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}