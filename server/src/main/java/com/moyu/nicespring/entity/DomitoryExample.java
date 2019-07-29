package com.moyu.nicespring.entity;

import java.util.ArrayList;
import java.util.List;

public class DomitoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DomitoryExample() {
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

        public Criteria andDomitoryIdIsNull() {
            addCriterion("domitory_id is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdIsNotNull() {
            addCriterion("domitory_id is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdEqualTo(Integer value) {
            addCriterion("domitory_id =", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdNotEqualTo(Integer value) {
            addCriterion("domitory_id <>", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdGreaterThan(Integer value) {
            addCriterion("domitory_id >", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("domitory_id >=", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdLessThan(Integer value) {
            addCriterion("domitory_id <", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("domitory_id <=", value, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdIn(List<Integer> values) {
            addCriterion("domitory_id in", values, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdNotIn(List<Integer> values) {
            addCriterion("domitory_id not in", values, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdBetween(Integer value1, Integer value2) {
            addCriterion("domitory_id between", value1, value2, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("domitory_id not between", value1, value2, "domitoryId");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidIsNull() {
            addCriterion("domitory_buildingid is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidIsNotNull() {
            addCriterion("domitory_buildingid is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidEqualTo(Integer value) {
            addCriterion("domitory_buildingid =", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidNotEqualTo(Integer value) {
            addCriterion("domitory_buildingid <>", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidGreaterThan(Integer value) {
            addCriterion("domitory_buildingid >", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidGreaterThanOrEqualTo(Integer value) {
            addCriterion("domitory_buildingid >=", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidLessThan(Integer value) {
            addCriterion("domitory_buildingid <", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidLessThanOrEqualTo(Integer value) {
            addCriterion("domitory_buildingid <=", value, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidIn(List<Integer> values) {
            addCriterion("domitory_buildingid in", values, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidNotIn(List<Integer> values) {
            addCriterion("domitory_buildingid not in", values, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidBetween(Integer value1, Integer value2) {
            addCriterion("domitory_buildingid between", value1, value2, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryBuildingidNotBetween(Integer value1, Integer value2) {
            addCriterion("domitory_buildingid not between", value1, value2, "domitoryBuildingid");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameIsNull() {
            addCriterion("domitory_name is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameIsNotNull() {
            addCriterion("domitory_name is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameEqualTo(String value) {
            addCriterion("domitory_name =", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameNotEqualTo(String value) {
            addCriterion("domitory_name <>", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameGreaterThan(String value) {
            addCriterion("domitory_name >", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("domitory_name >=", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameLessThan(String value) {
            addCriterion("domitory_name <", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameLessThanOrEqualTo(String value) {
            addCriterion("domitory_name <=", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameLike(String value) {
            addCriterion("domitory_name like", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameNotLike(String value) {
            addCriterion("domitory_name not like", value, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameIn(List<String> values) {
            addCriterion("domitory_name in", values, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameNotIn(List<String> values) {
            addCriterion("domitory_name not in", values, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameBetween(String value1, String value2) {
            addCriterion("domitory_name between", value1, value2, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryNameNotBetween(String value1, String value2) {
            addCriterion("domitory_name not between", value1, value2, "domitoryName");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeIsNull() {
            addCriterion("domitory_type is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeIsNotNull() {
            addCriterion("domitory_type is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeEqualTo(String value) {
            addCriterion("domitory_type =", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeNotEqualTo(String value) {
            addCriterion("domitory_type <>", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeGreaterThan(String value) {
            addCriterion("domitory_type >", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("domitory_type >=", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeLessThan(String value) {
            addCriterion("domitory_type <", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeLessThanOrEqualTo(String value) {
            addCriterion("domitory_type <=", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeLike(String value) {
            addCriterion("domitory_type like", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeNotLike(String value) {
            addCriterion("domitory_type not like", value, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeIn(List<String> values) {
            addCriterion("domitory_type in", values, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeNotIn(List<String> values) {
            addCriterion("domitory_type not in", values, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeBetween(String value1, String value2) {
            addCriterion("domitory_type between", value1, value2, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryTypeNotBetween(String value1, String value2) {
            addCriterion("domitory_type not between", value1, value2, "domitoryType");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberIsNull() {
            addCriterion("domitory_number is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberIsNotNull() {
            addCriterion("domitory_number is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberEqualTo(String value) {
            addCriterion("domitory_number =", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberNotEqualTo(String value) {
            addCriterion("domitory_number <>", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberGreaterThan(String value) {
            addCriterion("domitory_number >", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberGreaterThanOrEqualTo(String value) {
            addCriterion("domitory_number >=", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberLessThan(String value) {
            addCriterion("domitory_number <", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberLessThanOrEqualTo(String value) {
            addCriterion("domitory_number <=", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberLike(String value) {
            addCriterion("domitory_number like", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberNotLike(String value) {
            addCriterion("domitory_number not like", value, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberIn(List<String> values) {
            addCriterion("domitory_number in", values, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberNotIn(List<String> values) {
            addCriterion("domitory_number not in", values, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberBetween(String value1, String value2) {
            addCriterion("domitory_number between", value1, value2, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryNumberNotBetween(String value1, String value2) {
            addCriterion("domitory_number not between", value1, value2, "domitoryNumber");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelIsNull() {
            addCriterion("domitory_tel is null");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelIsNotNull() {
            addCriterion("domitory_tel is not null");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelEqualTo(String value) {
            addCriterion("domitory_tel =", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelNotEqualTo(String value) {
            addCriterion("domitory_tel <>", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelGreaterThan(String value) {
            addCriterion("domitory_tel >", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelGreaterThanOrEqualTo(String value) {
            addCriterion("domitory_tel >=", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelLessThan(String value) {
            addCriterion("domitory_tel <", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelLessThanOrEqualTo(String value) {
            addCriterion("domitory_tel <=", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelLike(String value) {
            addCriterion("domitory_tel like", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelNotLike(String value) {
            addCriterion("domitory_tel not like", value, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelIn(List<String> values) {
            addCriterion("domitory_tel in", values, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelNotIn(List<String> values) {
            addCriterion("domitory_tel not in", values, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelBetween(String value1, String value2) {
            addCriterion("domitory_tel between", value1, value2, "domitoryTel");
            return (Criteria) this;
        }

        public Criteria andDomitoryTelNotBetween(String value1, String value2) {
            addCriterion("domitory_tel not between", value1, value2, "domitoryTel");
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