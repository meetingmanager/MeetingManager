package com.meeting.pojo;

import java.util.ArrayList;
import java.util.List;

public class ParticipantsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParticipantsExample() {
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

        public Criteria andPnumIsNull() {
            addCriterion("pnum is null");
            return (Criteria) this;
        }

        public Criteria andPnumIsNotNull() {
            addCriterion("pnum is not null");
            return (Criteria) this;
        }

        public Criteria andPnumEqualTo(Integer value) {
            addCriterion("pnum =", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotEqualTo(Integer value) {
            addCriterion("pnum <>", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumGreaterThan(Integer value) {
            addCriterion("pnum >", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pnum >=", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumLessThan(Integer value) {
            addCriterion("pnum <", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumLessThanOrEqualTo(Integer value) {
            addCriterion("pnum <=", value, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumIn(List<Integer> values) {
            addCriterion("pnum in", values, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotIn(List<Integer> values) {
            addCriterion("pnum not in", values, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumBetween(Integer value1, Integer value2) {
            addCriterion("pnum between", value1, value2, "pnum");
            return (Criteria) this;
        }

        public Criteria andPnumNotBetween(Integer value1, Integer value2) {
            addCriterion("pnum not between", value1, value2, "pnum");
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

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPsexIsNull() {
            addCriterion("psex is null");
            return (Criteria) this;
        }

        public Criteria andPsexIsNotNull() {
            addCriterion("psex is not null");
            return (Criteria) this;
        }

        public Criteria andPsexEqualTo(String value) {
            addCriterion("psex =", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotEqualTo(String value) {
            addCriterion("psex <>", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexGreaterThan(String value) {
            addCriterion("psex >", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexGreaterThanOrEqualTo(String value) {
            addCriterion("psex >=", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLessThan(String value) {
            addCriterion("psex <", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLessThanOrEqualTo(String value) {
            addCriterion("psex <=", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexLike(String value) {
            addCriterion("psex like", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotLike(String value) {
            addCriterion("psex not like", value, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexIn(List<String> values) {
            addCriterion("psex in", values, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotIn(List<String> values) {
            addCriterion("psex not in", values, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexBetween(String value1, String value2) {
            addCriterion("psex between", value1, value2, "psex");
            return (Criteria) this;
        }

        public Criteria andPsexNotBetween(String value1, String value2) {
            addCriterion("psex not between", value1, value2, "psex");
            return (Criteria) this;
        }

        public Criteria andPunitIsNull() {
            addCriterion("punit is null");
            return (Criteria) this;
        }

        public Criteria andPunitIsNotNull() {
            addCriterion("punit is not null");
            return (Criteria) this;
        }

        public Criteria andPunitEqualTo(String value) {
            addCriterion("punit =", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitNotEqualTo(String value) {
            addCriterion("punit <>", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitGreaterThan(String value) {
            addCriterion("punit >", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitGreaterThanOrEqualTo(String value) {
            addCriterion("punit >=", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitLessThan(String value) {
            addCriterion("punit <", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitLessThanOrEqualTo(String value) {
            addCriterion("punit <=", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitLike(String value) {
            addCriterion("punit like", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitNotLike(String value) {
            addCriterion("punit not like", value, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitIn(List<String> values) {
            addCriterion("punit in", values, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitNotIn(List<String> values) {
            addCriterion("punit not in", values, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitBetween(String value1, String value2) {
            addCriterion("punit between", value1, value2, "punit");
            return (Criteria) this;
        }

        public Criteria andPunitNotBetween(String value1, String value2) {
            addCriterion("punit not between", value1, value2, "punit");
            return (Criteria) this;
        }

        public Criteria andPtitleIsNull() {
            addCriterion("ptitle is null");
            return (Criteria) this;
        }

        public Criteria andPtitleIsNotNull() {
            addCriterion("ptitle is not null");
            return (Criteria) this;
        }

        public Criteria andPtitleEqualTo(String value) {
            addCriterion("ptitle =", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleNotEqualTo(String value) {
            addCriterion("ptitle <>", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleGreaterThan(String value) {
            addCriterion("ptitle >", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleGreaterThanOrEqualTo(String value) {
            addCriterion("ptitle >=", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleLessThan(String value) {
            addCriterion("ptitle <", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleLessThanOrEqualTo(String value) {
            addCriterion("ptitle <=", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleLike(String value) {
            addCriterion("ptitle like", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleNotLike(String value) {
            addCriterion("ptitle not like", value, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleIn(List<String> values) {
            addCriterion("ptitle in", values, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleNotIn(List<String> values) {
            addCriterion("ptitle not in", values, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleBetween(String value1, String value2) {
            addCriterion("ptitle between", value1, value2, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPtitleNotBetween(String value1, String value2) {
            addCriterion("ptitle not between", value1, value2, "ptitle");
            return (Criteria) this;
        }

        public Criteria andPphoneIsNull() {
            addCriterion("pphone is null");
            return (Criteria) this;
        }

        public Criteria andPphoneIsNotNull() {
            addCriterion("pphone is not null");
            return (Criteria) this;
        }

        public Criteria andPphoneEqualTo(String value) {
            addCriterion("pphone =", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneNotEqualTo(String value) {
            addCriterion("pphone <>", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneGreaterThan(String value) {
            addCriterion("pphone >", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneGreaterThanOrEqualTo(String value) {
            addCriterion("pphone >=", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneLessThan(String value) {
            addCriterion("pphone <", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneLessThanOrEqualTo(String value) {
            addCriterion("pphone <=", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneLike(String value) {
            addCriterion("pphone like", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneNotLike(String value) {
            addCriterion("pphone not like", value, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneIn(List<String> values) {
            addCriterion("pphone in", values, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneNotIn(List<String> values) {
            addCriterion("pphone not in", values, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneBetween(String value1, String value2) {
            addCriterion("pphone between", value1, value2, "pphone");
            return (Criteria) this;
        }

        public Criteria andPphoneNotBetween(String value1, String value2) {
            addCriterion("pphone not between", value1, value2, "pphone");
            return (Criteria) this;
        }

        public Criteria andPchoiceIsNull() {
            addCriterion("pchoice is null");
            return (Criteria) this;
        }

        public Criteria andPchoiceIsNotNull() {
            addCriterion("pchoice is not null");
            return (Criteria) this;
        }

        public Criteria andPchoiceEqualTo(String value) {
            addCriterion("pchoice =", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceNotEqualTo(String value) {
            addCriterion("pchoice <>", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceGreaterThan(String value) {
            addCriterion("pchoice >", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceGreaterThanOrEqualTo(String value) {
            addCriterion("pchoice >=", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceLessThan(String value) {
            addCriterion("pchoice <", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceLessThanOrEqualTo(String value) {
            addCriterion("pchoice <=", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceLike(String value) {
            addCriterion("pchoice like", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceNotLike(String value) {
            addCriterion("pchoice not like", value, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceIn(List<String> values) {
            addCriterion("pchoice in", values, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceNotIn(List<String> values) {
            addCriterion("pchoice not in", values, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceBetween(String value1, String value2) {
            addCriterion("pchoice between", value1, value2, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPchoiceNotBetween(String value1, String value2) {
            addCriterion("pchoice not between", value1, value2, "pchoice");
            return (Criteria) this;
        }

        public Criteria andPcodeIsNull() {
            addCriterion("pcode is null");
            return (Criteria) this;
        }

        public Criteria andPcodeIsNotNull() {
            addCriterion("pcode is not null");
            return (Criteria) this;
        }

        public Criteria andPcodeEqualTo(String value) {
            addCriterion("pcode =", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotEqualTo(String value) {
            addCriterion("pcode <>", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeGreaterThan(String value) {
            addCriterion("pcode >", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeGreaterThanOrEqualTo(String value) {
            addCriterion("pcode >=", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLessThan(String value) {
            addCriterion("pcode <", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLessThanOrEqualTo(String value) {
            addCriterion("pcode <=", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeLike(String value) {
            addCriterion("pcode like", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotLike(String value) {
            addCriterion("pcode not like", value, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeIn(List<String> values) {
            addCriterion("pcode in", values, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotIn(List<String> values) {
            addCriterion("pcode not in", values, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeBetween(String value1, String value2) {
            addCriterion("pcode between", value1, value2, "pcode");
            return (Criteria) this;
        }

        public Criteria andPcodeNotBetween(String value1, String value2) {
            addCriterion("pcode not between", value1, value2, "pcode");
            return (Criteria) this;
        }

        public Criteria andPflagIsNull() {
            addCriterion("pflag is null");
            return (Criteria) this;
        }

        public Criteria andPflagIsNotNull() {
            addCriterion("pflag is not null");
            return (Criteria) this;
        }

        public Criteria andPflagEqualTo(Integer value) {
            addCriterion("pflag =", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotEqualTo(Integer value) {
            addCriterion("pflag <>", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagGreaterThan(Integer value) {
            addCriterion("pflag >", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("pflag >=", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagLessThan(Integer value) {
            addCriterion("pflag <", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagLessThanOrEqualTo(Integer value) {
            addCriterion("pflag <=", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagIn(List<Integer> values) {
            addCriterion("pflag in", values, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotIn(List<Integer> values) {
            addCriterion("pflag not in", values, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagBetween(Integer value1, Integer value2) {
            addCriterion("pflag between", value1, value2, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotBetween(Integer value1, Integer value2) {
            addCriterion("pflag not between", value1, value2, "pflag");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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