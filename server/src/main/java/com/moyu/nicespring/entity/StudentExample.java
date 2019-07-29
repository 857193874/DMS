package com.moyu.nicespring.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andStudentUsernameIsNull() {
            addCriterion("student_username is null");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameIsNotNull() {
            addCriterion("student_username is not null");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameEqualTo(String value) {
            addCriterion("student_username =", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameNotEqualTo(String value) {
            addCriterion("student_username <>", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameGreaterThan(String value) {
            addCriterion("student_username >", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("student_username >=", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameLessThan(String value) {
            addCriterion("student_username <", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameLessThanOrEqualTo(String value) {
            addCriterion("student_username <=", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameLike(String value) {
            addCriterion("student_username like", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameNotLike(String value) {
            addCriterion("student_username not like", value, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameIn(List<String> values) {
            addCriterion("student_username in", values, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameNotIn(List<String> values) {
            addCriterion("student_username not in", values, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameBetween(String value1, String value2) {
            addCriterion("student_username between", value1, value2, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentUsernameNotBetween(String value1, String value2) {
            addCriterion("student_username not between", value1, value2, "studentUsername");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidIsNull() {
            addCriterion("student_domitoryid is null");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidIsNotNull() {
            addCriterion("student_domitoryid is not null");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidEqualTo(Integer value) {
            addCriterion("student_domitoryid =", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidNotEqualTo(Integer value) {
            addCriterion("student_domitoryid <>", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidGreaterThan(Integer value) {
            addCriterion("student_domitoryid >", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidGreaterThanOrEqualTo(Integer value) {
            addCriterion("student_domitoryid >=", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidLessThan(Integer value) {
            addCriterion("student_domitoryid <", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidLessThanOrEqualTo(Integer value) {
            addCriterion("student_domitoryid <=", value, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidIn(List<Integer> values) {
            addCriterion("student_domitoryid in", values, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidNotIn(List<Integer> values) {
            addCriterion("student_domitoryid not in", values, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidBetween(Integer value1, Integer value2) {
            addCriterion("student_domitoryid between", value1, value2, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentDomitoryidNotBetween(Integer value1, Integer value2) {
            addCriterion("student_domitoryid not between", value1, value2, "studentDomitoryid");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordIsNull() {
            addCriterion("student_password is null");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordIsNotNull() {
            addCriterion("student_password is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordEqualTo(String value) {
            addCriterion("student_password =", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordNotEqualTo(String value) {
            addCriterion("student_password <>", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordGreaterThan(String value) {
            addCriterion("student_password >", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("student_password >=", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordLessThan(String value) {
            addCriterion("student_password <", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordLessThanOrEqualTo(String value) {
            addCriterion("student_password <=", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordLike(String value) {
            addCriterion("student_password like", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordNotLike(String value) {
            addCriterion("student_password not like", value, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordIn(List<String> values) {
            addCriterion("student_password in", values, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordNotIn(List<String> values) {
            addCriterion("student_password not in", values, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordBetween(String value1, String value2) {
            addCriterion("student_password between", value1, value2, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentPasswordNotBetween(String value1, String value2) {
            addCriterion("student_password not between", value1, value2, "studentPassword");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNull() {
            addCriterion("student_name is null");
            return (Criteria) this;
        }

        public Criteria andStudentNameIsNotNull() {
            addCriterion("student_name is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNameEqualTo(String value) {
            addCriterion("student_name =", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotEqualTo(String value) {
            addCriterion("student_name <>", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThan(String value) {
            addCriterion("student_name >", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameGreaterThanOrEqualTo(String value) {
            addCriterion("student_name >=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThan(String value) {
            addCriterion("student_name <", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLessThanOrEqualTo(String value) {
            addCriterion("student_name <=", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameLike(String value) {
            addCriterion("student_name like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotLike(String value) {
            addCriterion("student_name not like", value, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameIn(List<String> values) {
            addCriterion("student_name in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotIn(List<String> values) {
            addCriterion("student_name not in", values, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameBetween(String value1, String value2) {
            addCriterion("student_name between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentNameNotBetween(String value1, String value2) {
            addCriterion("student_name not between", value1, value2, "studentName");
            return (Criteria) this;
        }

        public Criteria andStudentSexIsNull() {
            addCriterion("student_sex is null");
            return (Criteria) this;
        }

        public Criteria andStudentSexIsNotNull() {
            addCriterion("student_sex is not null");
            return (Criteria) this;
        }

        public Criteria andStudentSexEqualTo(String value) {
            addCriterion("student_sex =", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotEqualTo(String value) {
            addCriterion("student_sex <>", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexGreaterThan(String value) {
            addCriterion("student_sex >", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexGreaterThanOrEqualTo(String value) {
            addCriterion("student_sex >=", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLessThan(String value) {
            addCriterion("student_sex <", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLessThanOrEqualTo(String value) {
            addCriterion("student_sex <=", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexLike(String value) {
            addCriterion("student_sex like", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotLike(String value) {
            addCriterion("student_sex not like", value, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexIn(List<String> values) {
            addCriterion("student_sex in", values, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotIn(List<String> values) {
            addCriterion("student_sex not in", values, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexBetween(String value1, String value2) {
            addCriterion("student_sex between", value1, value2, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentSexNotBetween(String value1, String value2) {
            addCriterion("student_sex not between", value1, value2, "studentSex");
            return (Criteria) this;
        }

        public Criteria andStudentClassIsNull() {
            addCriterion("student_class is null");
            return (Criteria) this;
        }

        public Criteria andStudentClassIsNotNull() {
            addCriterion("student_class is not null");
            return (Criteria) this;
        }

        public Criteria andStudentClassEqualTo(String value) {
            addCriterion("student_class =", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassNotEqualTo(String value) {
            addCriterion("student_class <>", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassGreaterThan(String value) {
            addCriterion("student_class >", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassGreaterThanOrEqualTo(String value) {
            addCriterion("student_class >=", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassLessThan(String value) {
            addCriterion("student_class <", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassLessThanOrEqualTo(String value) {
            addCriterion("student_class <=", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassLike(String value) {
            addCriterion("student_class like", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassNotLike(String value) {
            addCriterion("student_class not like", value, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassIn(List<String> values) {
            addCriterion("student_class in", values, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassNotIn(List<String> values) {
            addCriterion("student_class not in", values, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassBetween(String value1, String value2) {
            addCriterion("student_class between", value1, value2, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentClassNotBetween(String value1, String value2) {
            addCriterion("student_class not between", value1, value2, "studentClass");
            return (Criteria) this;
        }

        public Criteria andStudentStateIsNull() {
            addCriterion("student_state is null");
            return (Criteria) this;
        }

        public Criteria andStudentStateIsNotNull() {
            addCriterion("student_state is not null");
            return (Criteria) this;
        }

        public Criteria andStudentStateEqualTo(String value) {
            addCriterion("student_state =", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateNotEqualTo(String value) {
            addCriterion("student_state <>", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateGreaterThan(String value) {
            addCriterion("student_state >", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateGreaterThanOrEqualTo(String value) {
            addCriterion("student_state >=", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateLessThan(String value) {
            addCriterion("student_state <", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateLessThanOrEqualTo(String value) {
            addCriterion("student_state <=", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateLike(String value) {
            addCriterion("student_state like", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateNotLike(String value) {
            addCriterion("student_state not like", value, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateIn(List<String> values) {
            addCriterion("student_state in", values, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateNotIn(List<String> values) {
            addCriterion("student_state not in", values, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateBetween(String value1, String value2) {
            addCriterion("student_state between", value1, value2, "studentState");
            return (Criteria) this;
        }

        public Criteria andStudentStateNotBetween(String value1, String value2) {
            addCriterion("student_state not between", value1, value2, "studentState");
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