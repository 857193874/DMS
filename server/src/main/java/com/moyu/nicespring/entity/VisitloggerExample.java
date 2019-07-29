package com.moyu.nicespring.entity;

import java.util.ArrayList;
import java.util.List;

public class VisitloggerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VisitloggerExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPageurlIsNull() {
            addCriterion("pageurl is null");
            return (Criteria) this;
        }

        public Criteria andPageurlIsNotNull() {
            addCriterion("pageurl is not null");
            return (Criteria) this;
        }

        public Criteria andPageurlEqualTo(String value) {
            addCriterion("pageurl =", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlNotEqualTo(String value) {
            addCriterion("pageurl <>", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlGreaterThan(String value) {
            addCriterion("pageurl >", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlGreaterThanOrEqualTo(String value) {
            addCriterion("pageurl >=", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlLessThan(String value) {
            addCriterion("pageurl <", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlLessThanOrEqualTo(String value) {
            addCriterion("pageurl <=", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlLike(String value) {
            addCriterion("pageurl like", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlNotLike(String value) {
            addCriterion("pageurl not like", value, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlIn(List<String> values) {
            addCriterion("pageurl in", values, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlNotIn(List<String> values) {
            addCriterion("pageurl not in", values, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlBetween(String value1, String value2) {
            addCriterion("pageurl between", value1, value2, "pageurl");
            return (Criteria) this;
        }

        public Criteria andPageurlNotBetween(String value1, String value2) {
            addCriterion("pageurl not between", value1, value2, "pageurl");
            return (Criteria) this;
        }

        public Criteria andApiurlIsNull() {
            addCriterion("apiurl is null");
            return (Criteria) this;
        }

        public Criteria andApiurlIsNotNull() {
            addCriterion("apiurl is not null");
            return (Criteria) this;
        }

        public Criteria andApiurlEqualTo(String value) {
            addCriterion("apiurl =", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotEqualTo(String value) {
            addCriterion("apiurl <>", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlGreaterThan(String value) {
            addCriterion("apiurl >", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlGreaterThanOrEqualTo(String value) {
            addCriterion("apiurl >=", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLessThan(String value) {
            addCriterion("apiurl <", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLessThanOrEqualTo(String value) {
            addCriterion("apiurl <=", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlLike(String value) {
            addCriterion("apiurl like", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotLike(String value) {
            addCriterion("apiurl not like", value, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlIn(List<String> values) {
            addCriterion("apiurl in", values, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotIn(List<String> values) {
            addCriterion("apiurl not in", values, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlBetween(String value1, String value2) {
            addCriterion("apiurl between", value1, value2, "apiurl");
            return (Criteria) this;
        }

        public Criteria andApiurlNotBetween(String value1, String value2) {
            addCriterion("apiurl not between", value1, value2, "apiurl");
            return (Criteria) this;
        }

        public Criteria andVisitnumIsNull() {
            addCriterion("visitnum is null");
            return (Criteria) this;
        }

        public Criteria andVisitnumIsNotNull() {
            addCriterion("visitnum is not null");
            return (Criteria) this;
        }

        public Criteria andVisitnumEqualTo(Long value) {
            addCriterion("visitnum =", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumNotEqualTo(Long value) {
            addCriterion("visitnum <>", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumGreaterThan(Long value) {
            addCriterion("visitnum >", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumGreaterThanOrEqualTo(Long value) {
            addCriterion("visitnum >=", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumLessThan(Long value) {
            addCriterion("visitnum <", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumLessThanOrEqualTo(Long value) {
            addCriterion("visitnum <=", value, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumIn(List<Long> values) {
            addCriterion("visitnum in", values, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumNotIn(List<Long> values) {
            addCriterion("visitnum not in", values, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumBetween(Long value1, Long value2) {
            addCriterion("visitnum between", value1, value2, "visitnum");
            return (Criteria) this;
        }

        public Criteria andVisitnumNotBetween(Long value1, Long value2) {
            addCriterion("visitnum not between", value1, value2, "visitnum");
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