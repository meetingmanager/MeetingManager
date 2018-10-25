package com.meeting.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubprojiectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubprojiectExample() {
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

        public Criteria andSnumIsNull() {
            addCriterion("snum is null");
            return (Criteria) this;
        }

        public Criteria andSnumIsNotNull() {
            addCriterion("snum is not null");
            return (Criteria) this;
        }

        public Criteria andSnumEqualTo(Integer value) {
            addCriterion("snum =", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotEqualTo(Integer value) {
            addCriterion("snum <>", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThan(Integer value) {
            addCriterion("snum >", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("snum >=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThan(Integer value) {
            addCriterion("snum <", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumLessThanOrEqualTo(Integer value) {
            addCriterion("snum <=", value, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumIn(List<Integer> values) {
            addCriterion("snum in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotIn(List<Integer> values) {
            addCriterion("snum not in", values, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumBetween(Integer value1, Integer value2) {
            addCriterion("snum between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andSnumNotBetween(Integer value1, Integer value2) {
            addCriterion("snum not between", value1, value2, "snum");
            return (Criteria) this;
        }

        public Criteria andMnumIsNull() {
            addCriterion("mnum is null");
            return (Criteria) this;
        }

        public Criteria andMnumIsNotNull() {
            addCriterion("mnum is not null");
            return (Criteria) this;
        }

        public Criteria andMnumEqualTo(Long value) {
            addCriterion("mnum =", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotEqualTo(Long value) {
            addCriterion("mnum <>", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumGreaterThan(Long value) {
            addCriterion("mnum >", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumGreaterThanOrEqualTo(Long value) {
            addCriterion("mnum >=", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumLessThan(Long value) {
            addCriterion("mnum <", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumLessThanOrEqualTo(Long value) {
            addCriterion("mnum <=", value, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumIn(List<Long> values) {
            addCriterion("mnum in", values, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotIn(List<Long> values) {
            addCriterion("mnum not in", values, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumBetween(Long value1, Long value2) {
            addCriterion("mnum between", value1, value2, "mnum");
            return (Criteria) this;
        }

        public Criteria andMnumNotBetween(Long value1, Long value2) {
            addCriterion("mnum not between", value1, value2, "mnum");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSplaceIsNull() {
            addCriterion("splace is null");
            return (Criteria) this;
        }

        public Criteria andSplaceIsNotNull() {
            addCriterion("splace is not null");
            return (Criteria) this;
        }

        public Criteria andSplaceEqualTo(String value) {
            addCriterion("splace =", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceNotEqualTo(String value) {
            addCriterion("splace <>", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceGreaterThan(String value) {
            addCriterion("splace >", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceGreaterThanOrEqualTo(String value) {
            addCriterion("splace >=", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceLessThan(String value) {
            addCriterion("splace <", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceLessThanOrEqualTo(String value) {
            addCriterion("splace <=", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceLike(String value) {
            addCriterion("splace like", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceNotLike(String value) {
            addCriterion("splace not like", value, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceIn(List<String> values) {
            addCriterion("splace in", values, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceNotIn(List<String> values) {
            addCriterion("splace not in", values, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceBetween(String value1, String value2) {
            addCriterion("splace between", value1, value2, "splace");
            return (Criteria) this;
        }

        public Criteria andSplaceNotBetween(String value1, String value2) {
            addCriterion("splace not between", value1, value2, "splace");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("stime is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("stime is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(Date value) {
            addCriterion("stime =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(Date value) {
            addCriterion("stime <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(Date value) {
            addCriterion("stime >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(Date value) {
            addCriterion("stime >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(Date value) {
            addCriterion("stime <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(Date value) {
            addCriterion("stime <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<Date> values) {
            addCriterion("stime in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<Date> values) {
            addCriterion("stime not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(Date value1, Date value2) {
            addCriterion("stime between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(Date value1, Date value2) {
            addCriterion("stime not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andSconmentIsNull() {
            addCriterion("sconment is null");
            return (Criteria) this;
        }

        public Criteria andSconmentIsNotNull() {
            addCriterion("sconment is not null");
            return (Criteria) this;
        }

        public Criteria andSconmentEqualTo(String value) {
            addCriterion("sconment =", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentNotEqualTo(String value) {
            addCriterion("sconment <>", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentGreaterThan(String value) {
            addCriterion("sconment >", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentGreaterThanOrEqualTo(String value) {
            addCriterion("sconment >=", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentLessThan(String value) {
            addCriterion("sconment <", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentLessThanOrEqualTo(String value) {
            addCriterion("sconment <=", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentLike(String value) {
            addCriterion("sconment like", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentNotLike(String value) {
            addCriterion("sconment not like", value, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentIn(List<String> values) {
            addCriterion("sconment in", values, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentNotIn(List<String> values) {
            addCriterion("sconment not in", values, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentBetween(String value1, String value2) {
            addCriterion("sconment between", value1, value2, "sconment");
            return (Criteria) this;
        }

        public Criteria andSconmentNotBetween(String value1, String value2) {
            addCriterion("sconment not between", value1, value2, "sconment");
            return (Criteria) this;
        }

        public Criteria andSflowIsNull() {
            addCriterion("sflow is null");
            return (Criteria) this;
        }

        public Criteria andSflowIsNotNull() {
            addCriterion("sflow is not null");
            return (Criteria) this;
        }

        public Criteria andSflowEqualTo(String value) {
            addCriterion("sflow =", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowNotEqualTo(String value) {
            addCriterion("sflow <>", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowGreaterThan(String value) {
            addCriterion("sflow >", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowGreaterThanOrEqualTo(String value) {
            addCriterion("sflow >=", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowLessThan(String value) {
            addCriterion("sflow <", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowLessThanOrEqualTo(String value) {
            addCriterion("sflow <=", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowLike(String value) {
            addCriterion("sflow like", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowNotLike(String value) {
            addCriterion("sflow not like", value, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowIn(List<String> values) {
            addCriterion("sflow in", values, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowNotIn(List<String> values) {
            addCriterion("sflow not in", values, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowBetween(String value1, String value2) {
            addCriterion("sflow between", value1, value2, "sflow");
            return (Criteria) this;
        }

        public Criteria andSflowNotBetween(String value1, String value2) {
            addCriterion("sflow not between", value1, value2, "sflow");
            return (Criteria) this;
        }

        public Criteria andSguideIsNull() {
            addCriterion("sguide is null");
            return (Criteria) this;
        }

        public Criteria andSguideIsNotNull() {
            addCriterion("sguide is not null");
            return (Criteria) this;
        }

        public Criteria andSguideEqualTo(String value) {
            addCriterion("sguide =", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideNotEqualTo(String value) {
            addCriterion("sguide <>", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideGreaterThan(String value) {
            addCriterion("sguide >", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideGreaterThanOrEqualTo(String value) {
            addCriterion("sguide >=", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideLessThan(String value) {
            addCriterion("sguide <", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideLessThanOrEqualTo(String value) {
            addCriterion("sguide <=", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideLike(String value) {
            addCriterion("sguide like", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideNotLike(String value) {
            addCriterion("sguide not like", value, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideIn(List<String> values) {
            addCriterion("sguide in", values, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideNotIn(List<String> values) {
            addCriterion("sguide not in", values, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideBetween(String value1, String value2) {
            addCriterion("sguide between", value1, value2, "sguide");
            return (Criteria) this;
        }

        public Criteria andSguideNotBetween(String value1, String value2) {
            addCriterion("sguide not between", value1, value2, "sguide");
            return (Criteria) this;
        }

        public Criteria andMflagIsNull() {
            addCriterion("mflag is null");
            return (Criteria) this;
        }

        public Criteria andMflagIsNotNull() {
            addCriterion("mflag is not null");
            return (Criteria) this;
        }

        public Criteria andMflagEqualTo(String value) {
            addCriterion("mflag =", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotEqualTo(String value) {
            addCriterion("mflag <>", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagGreaterThan(String value) {
            addCriterion("mflag >", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagGreaterThanOrEqualTo(String value) {
            addCriterion("mflag >=", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagLessThan(String value) {
            addCriterion("mflag <", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagLessThanOrEqualTo(String value) {
            addCriterion("mflag <=", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagLike(String value) {
            addCriterion("mflag like", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotLike(String value) {
            addCriterion("mflag not like", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagIn(List<String> values) {
            addCriterion("mflag in", values, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotIn(List<String> values) {
            addCriterion("mflag not in", values, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagBetween(String value1, String value2) {
            addCriterion("mflag between", value1, value2, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotBetween(String value1, String value2) {
            addCriterion("mflag not between", value1, value2, "mflag");
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