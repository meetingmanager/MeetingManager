package com.meeting.pojo;

import java.util.ArrayList;
import java.util.List;

public class GuestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GuestExample() {
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

        public Criteria andGnumIsNull() {
            addCriterion("gnum is null");
            return (Criteria) this;
        }

        public Criteria andGnumIsNotNull() {
            addCriterion("gnum is not null");
            return (Criteria) this;
        }

        public Criteria andGnumEqualTo(Integer value) {
            addCriterion("gnum =", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumNotEqualTo(Integer value) {
            addCriterion("gnum <>", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumGreaterThan(Integer value) {
            addCriterion("gnum >", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("gnum >=", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumLessThan(Integer value) {
            addCriterion("gnum <", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumLessThanOrEqualTo(Integer value) {
            addCriterion("gnum <=", value, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumIn(List<Integer> values) {
            addCriterion("gnum in", values, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumNotIn(List<Integer> values) {
            addCriterion("gnum not in", values, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumBetween(Integer value1, Integer value2) {
            addCriterion("gnum between", value1, value2, "gnum");
            return (Criteria) this;
        }

        public Criteria andGnumNotBetween(Integer value1, Integer value2) {
            addCriterion("gnum not between", value1, value2, "gnum");
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

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGphoneIsNull() {
            addCriterion("gphone is null");
            return (Criteria) this;
        }

        public Criteria andGphoneIsNotNull() {
            addCriterion("gphone is not null");
            return (Criteria) this;
        }

        public Criteria andGphoneEqualTo(String value) {
            addCriterion("gphone =", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotEqualTo(String value) {
            addCriterion("gphone <>", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneGreaterThan(String value) {
            addCriterion("gphone >", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneGreaterThanOrEqualTo(String value) {
            addCriterion("gphone >=", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLessThan(String value) {
            addCriterion("gphone <", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLessThanOrEqualTo(String value) {
            addCriterion("gphone <=", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneLike(String value) {
            addCriterion("gphone like", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotLike(String value) {
            addCriterion("gphone not like", value, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneIn(List<String> values) {
            addCriterion("gphone in", values, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotIn(List<String> values) {
            addCriterion("gphone not in", values, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneBetween(String value1, String value2) {
            addCriterion("gphone between", value1, value2, "gphone");
            return (Criteria) this;
        }

        public Criteria andGphoneNotBetween(String value1, String value2) {
            addCriterion("gphone not between", value1, value2, "gphone");
            return (Criteria) this;
        }

        public Criteria andGtitleIsNull() {
            addCriterion("gtitle is null");
            return (Criteria) this;
        }

        public Criteria andGtitleIsNotNull() {
            addCriterion("gtitle is not null");
            return (Criteria) this;
        }

        public Criteria andGtitleEqualTo(String value) {
            addCriterion("gtitle =", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotEqualTo(String value) {
            addCriterion("gtitle <>", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleGreaterThan(String value) {
            addCriterion("gtitle >", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleGreaterThanOrEqualTo(String value) {
            addCriterion("gtitle >=", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLessThan(String value) {
            addCriterion("gtitle <", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLessThanOrEqualTo(String value) {
            addCriterion("gtitle <=", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleLike(String value) {
            addCriterion("gtitle like", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotLike(String value) {
            addCriterion("gtitle not like", value, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleIn(List<String> values) {
            addCriterion("gtitle in", values, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotIn(List<String> values) {
            addCriterion("gtitle not in", values, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleBetween(String value1, String value2) {
            addCriterion("gtitle between", value1, value2, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGtitleNotBetween(String value1, String value2) {
            addCriterion("gtitle not between", value1, value2, "gtitle");
            return (Criteria) this;
        }

        public Criteria andGintroductionIsNull() {
            addCriterion("gintroduction is null");
            return (Criteria) this;
        }

        public Criteria andGintroductionIsNotNull() {
            addCriterion("gintroduction is not null");
            return (Criteria) this;
        }

        public Criteria andGintroductionEqualTo(String value) {
            addCriterion("gintroduction =", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionNotEqualTo(String value) {
            addCriterion("gintroduction <>", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionGreaterThan(String value) {
            addCriterion("gintroduction >", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionGreaterThanOrEqualTo(String value) {
            addCriterion("gintroduction >=", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionLessThan(String value) {
            addCriterion("gintroduction <", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionLessThanOrEqualTo(String value) {
            addCriterion("gintroduction <=", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionLike(String value) {
            addCriterion("gintroduction like", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionNotLike(String value) {
            addCriterion("gintroduction not like", value, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionIn(List<String> values) {
            addCriterion("gintroduction in", values, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionNotIn(List<String> values) {
            addCriterion("gintroduction not in", values, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionBetween(String value1, String value2) {
            addCriterion("gintroduction between", value1, value2, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGintroductionNotBetween(String value1, String value2) {
            addCriterion("gintroduction not between", value1, value2, "gintroduction");
            return (Criteria) this;
        }

        public Criteria andGstateIsNull() {
            addCriterion("gstate is null");
            return (Criteria) this;
        }

        public Criteria andGstateIsNotNull() {
            addCriterion("gstate is not null");
            return (Criteria) this;
        }

        public Criteria andGstateEqualTo(String value) {
            addCriterion("gstate =", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateNotEqualTo(String value) {
            addCriterion("gstate <>", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateGreaterThan(String value) {
            addCriterion("gstate >", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateGreaterThanOrEqualTo(String value) {
            addCriterion("gstate >=", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateLessThan(String value) {
            addCriterion("gstate <", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateLessThanOrEqualTo(String value) {
            addCriterion("gstate <=", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateLike(String value) {
            addCriterion("gstate like", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateNotLike(String value) {
            addCriterion("gstate not like", value, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateIn(List<String> values) {
            addCriterion("gstate in", values, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateNotIn(List<String> values) {
            addCriterion("gstate not in", values, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateBetween(String value1, String value2) {
            addCriterion("gstate between", value1, value2, "gstate");
            return (Criteria) this;
        }

        public Criteria andGstateNotBetween(String value1, String value2) {
            addCriterion("gstate not between", value1, value2, "gstate");
            return (Criteria) this;
        }

        public Criteria andGreasonIsNull() {
            addCriterion("greason is null");
            return (Criteria) this;
        }

        public Criteria andGreasonIsNotNull() {
            addCriterion("greason is not null");
            return (Criteria) this;
        }

        public Criteria andGreasonEqualTo(String value) {
            addCriterion("greason =", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonNotEqualTo(String value) {
            addCriterion("greason <>", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonGreaterThan(String value) {
            addCriterion("greason >", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonGreaterThanOrEqualTo(String value) {
            addCriterion("greason >=", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonLessThan(String value) {
            addCriterion("greason <", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonLessThanOrEqualTo(String value) {
            addCriterion("greason <=", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonLike(String value) {
            addCriterion("greason like", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonNotLike(String value) {
            addCriterion("greason not like", value, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonIn(List<String> values) {
            addCriterion("greason in", values, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonNotIn(List<String> values) {
            addCriterion("greason not in", values, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonBetween(String value1, String value2) {
            addCriterion("greason between", value1, value2, "greason");
            return (Criteria) this;
        }

        public Criteria andGreasonNotBetween(String value1, String value2) {
            addCriterion("greason not between", value1, value2, "greason");
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