package com.meeting.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HoteltypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HoteltypeExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andHtnumIsNull() {
            addCriterion("htnum is null");
            return (Criteria) this;
        }

        public Criteria andHtnumIsNotNull() {
            addCriterion("htnum is not null");
            return (Criteria) this;
        }

        public Criteria andHtnumEqualTo(Integer value) {
            addCriterion("htnum =", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumNotEqualTo(Integer value) {
            addCriterion("htnum <>", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumGreaterThan(Integer value) {
            addCriterion("htnum >", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("htnum >=", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumLessThan(Integer value) {
            addCriterion("htnum <", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumLessThanOrEqualTo(Integer value) {
            addCriterion("htnum <=", value, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumIn(List<Integer> values) {
            addCriterion("htnum in", values, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumNotIn(List<Integer> values) {
            addCriterion("htnum not in", values, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumBetween(Integer value1, Integer value2) {
            addCriterion("htnum between", value1, value2, "htnum");
            return (Criteria) this;
        }

        public Criteria andHtnumNotBetween(Integer value1, Integer value2) {
            addCriterion("htnum not between", value1, value2, "htnum");
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

        public Criteria andHotelplaceIsNull() {
            addCriterion("hotelplace is null");
            return (Criteria) this;
        }

        public Criteria andHotelplaceIsNotNull() {
            addCriterion("hotelplace is not null");
            return (Criteria) this;
        }

        public Criteria andHotelplaceEqualTo(String value) {
            addCriterion("hotelplace =", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceNotEqualTo(String value) {
            addCriterion("hotelplace <>", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceGreaterThan(String value) {
            addCriterion("hotelplace >", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceGreaterThanOrEqualTo(String value) {
            addCriterion("hotelplace >=", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceLessThan(String value) {
            addCriterion("hotelplace <", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceLessThanOrEqualTo(String value) {
            addCriterion("hotelplace <=", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceLike(String value) {
            addCriterion("hotelplace like", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceNotLike(String value) {
            addCriterion("hotelplace not like", value, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceIn(List<String> values) {
            addCriterion("hotelplace in", values, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceNotIn(List<String> values) {
            addCriterion("hotelplace not in", values, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceBetween(String value1, String value2) {
            addCriterion("hotelplace between", value1, value2, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHotelplaceNotBetween(String value1, String value2) {
            addCriterion("hotelplace not between", value1, value2, "hotelplace");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNull() {
            addCriterion("hoteltype is null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIsNotNull() {
            addCriterion("hoteltype is not null");
            return (Criteria) this;
        }

        public Criteria andHoteltypeEqualTo(String value) {
            addCriterion("hoteltype =", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotEqualTo(String value) {
            addCriterion("hoteltype <>", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThan(String value) {
            addCriterion("hoteltype >", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeGreaterThanOrEqualTo(String value) {
            addCriterion("hoteltype >=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThan(String value) {
            addCriterion("hoteltype <", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLessThanOrEqualTo(String value) {
            addCriterion("hoteltype <=", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeLike(String value) {
            addCriterion("hoteltype like", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotLike(String value) {
            addCriterion("hoteltype not like", value, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeIn(List<String> values) {
            addCriterion("hoteltype in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotIn(List<String> values) {
            addCriterion("hoteltype not in", values, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeBetween(String value1, String value2) {
            addCriterion("hoteltype between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andHoteltypeNotBetween(String value1, String value2) {
            addCriterion("hoteltype not between", value1, value2, "hoteltype");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterionForJDBCDate("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterionForJDBCDate("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterionForJDBCDate("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterionForJDBCDate("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterionForJDBCDate("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterionForJDBCDate("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterionForJDBCDate("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endtime not between", value1, value2, "endtime");
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