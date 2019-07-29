package com.moyu.nicespring.entity;

import java.util.ArrayList;
import java.util.List;

public class OutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OutExample() {
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

        public Criteria andOutIdIsNull() {
            addCriterion("out_id is null");
            return (Criteria) this;
        }

        public Criteria andOutIdIsNotNull() {
            addCriterion("out_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutIdEqualTo(Integer value) {
            addCriterion("out_id =", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotEqualTo(Integer value) {
            addCriterion("out_id <>", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThan(Integer value) {
            addCriterion("out_id >", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("out_id >=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThan(Integer value) {
            addCriterion("out_id <", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdLessThanOrEqualTo(Integer value) {
            addCriterion("out_id <=", value, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdIn(List<Integer> values) {
            addCriterion("out_id in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotIn(List<Integer> values) {
            addCriterion("out_id not in", values, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdBetween(Integer value1, Integer value2) {
            addCriterion("out_id between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andOutIdNotBetween(Integer value1, Integer value2) {
            addCriterion("out_id not between", value1, value2, "outId");
            return (Criteria) this;
        }

        public Criteria andOutStudentidIsNull() {
            addCriterion("out_studentid is null");
            return (Criteria) this;
        }

        public Criteria andOutStudentidIsNotNull() {
            addCriterion("out_studentid is not null");
            return (Criteria) this;
        }

        public Criteria andOutStudentidEqualTo(String value) {
            addCriterion("out_studentid =", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidNotEqualTo(String value) {
            addCriterion("out_studentid <>", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidGreaterThan(String value) {
            addCriterion("out_studentid >", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidGreaterThanOrEqualTo(String value) {
            addCriterion("out_studentid >=", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidLessThan(String value) {
            addCriterion("out_studentid <", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidLessThanOrEqualTo(String value) {
            addCriterion("out_studentid <=", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidLike(String value) {
            addCriterion("out_studentid like", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidNotLike(String value) {
            addCriterion("out_studentid not like", value, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidIn(List<String> values) {
            addCriterion("out_studentid in", values, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidNotIn(List<String> values) {
            addCriterion("out_studentid not in", values, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidBetween(String value1, String value2) {
            addCriterion("out_studentid between", value1, value2, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutStudentidNotBetween(String value1, String value2) {
            addCriterion("out_studentid not between", value1, value2, "outStudentid");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNull() {
            addCriterion("out_date is null");
            return (Criteria) this;
        }

        public Criteria andOutDateIsNotNull() {
            addCriterion("out_date is not null");
            return (Criteria) this;
        }

        public Criteria andOutDateEqualTo(String value) {
            addCriterion("out_date =", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotEqualTo(String value) {
            addCriterion("out_date <>", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThan(String value) {
            addCriterion("out_date >", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateGreaterThanOrEqualTo(String value) {
            addCriterion("out_date >=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThan(String value) {
            addCriterion("out_date <", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLessThanOrEqualTo(String value) {
            addCriterion("out_date <=", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateLike(String value) {
            addCriterion("out_date like", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotLike(String value) {
            addCriterion("out_date not like", value, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateIn(List<String> values) {
            addCriterion("out_date in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotIn(List<String> values) {
            addCriterion("out_date not in", values, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateBetween(String value1, String value2) {
            addCriterion("out_date between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutDateNotBetween(String value1, String value2) {
            addCriterion("out_date not between", value1, value2, "outDate");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIsNull() {
            addCriterion("out_remark is null");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIsNotNull() {
            addCriterion("out_remark is not null");
            return (Criteria) this;
        }

        public Criteria andOutRemarkEqualTo(String value) {
            addCriterion("out_remark =", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotEqualTo(String value) {
            addCriterion("out_remark <>", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkGreaterThan(String value) {
            addCriterion("out_remark >", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("out_remark >=", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLessThan(String value) {
            addCriterion("out_remark <", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLessThanOrEqualTo(String value) {
            addCriterion("out_remark <=", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkLike(String value) {
            addCriterion("out_remark like", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotLike(String value) {
            addCriterion("out_remark not like", value, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkIn(List<String> values) {
            addCriterion("out_remark in", values, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotIn(List<String> values) {
            addCriterion("out_remark not in", values, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkBetween(String value1, String value2) {
            addCriterion("out_remark between", value1, value2, "outRemark");
            return (Criteria) this;
        }

        public Criteria andOutRemarkNotBetween(String value1, String value2) {
            addCriterion("out_remark not between", value1, value2, "outRemark");
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