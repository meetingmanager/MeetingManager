package com.meeting.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MeetingExample() {
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

        public Criteria andMnameIsNull() {
            addCriterion("mname is null");
            return (Criteria) this;
        }

        public Criteria andMnameIsNotNull() {
            addCriterion("mname is not null");
            return (Criteria) this;
        }

        public Criteria andMnameEqualTo(String value) {
            addCriterion("mname =", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotEqualTo(String value) {
            addCriterion("mname <>", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThan(String value) {
            addCriterion("mname >", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameGreaterThanOrEqualTo(String value) {
            addCriterion("mname >=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThan(String value) {
            addCriterion("mname <", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLessThanOrEqualTo(String value) {
            addCriterion("mname <=", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameLike(String value) {
            addCriterion("mname like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotLike(String value) {
            addCriterion("mname not like", value, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameIn(List<String> values) {
            addCriterion("mname in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotIn(List<String> values) {
            addCriterion("mname not in", values, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameBetween(String value1, String value2) {
            addCriterion("mname between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMnameNotBetween(String value1, String value2) {
            addCriterion("mname not between", value1, value2, "mname");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNull() {
            addCriterion("mtime is null");
            return (Criteria) this;
        }

        public Criteria andMtimeIsNotNull() {
            addCriterion("mtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtimeEqualTo(Date value) {
            addCriterion("mtime =", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotEqualTo(Date value) {
            addCriterion("mtime <>", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThan(Date value) {
            addCriterion("mtime >", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("mtime >=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThan(Date value) {
            addCriterion("mtime <", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeLessThanOrEqualTo(Date value) {
            addCriterion("mtime <=", value, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeIn(List<Date> values) {
            addCriterion("mtime in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotIn(List<Date> values) {
            addCriterion("mtime not in", values, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeBetween(Date value1, Date value2) {
            addCriterion("mtime between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMtimeNotBetween(Date value1, Date value2) {
            addCriterion("mtime not between", value1, value2, "mtime");
            return (Criteria) this;
        }

        public Criteria andMplaceIsNull() {
            addCriterion("mplace is null");
            return (Criteria) this;
        }

        public Criteria andMplaceIsNotNull() {
            addCriterion("mplace is not null");
            return (Criteria) this;
        }

        public Criteria andMplaceEqualTo(String value) {
            addCriterion("mplace =", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceNotEqualTo(String value) {
            addCriterion("mplace <>", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceGreaterThan(String value) {
            addCriterion("mplace >", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceGreaterThanOrEqualTo(String value) {
            addCriterion("mplace >=", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceLessThan(String value) {
            addCriterion("mplace <", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceLessThanOrEqualTo(String value) {
            addCriterion("mplace <=", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceLike(String value) {
            addCriterion("mplace like", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceNotLike(String value) {
            addCriterion("mplace not like", value, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceIn(List<String> values) {
            addCriterion("mplace in", values, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceNotIn(List<String> values) {
            addCriterion("mplace not in", values, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceBetween(String value1, String value2) {
            addCriterion("mplace between", value1, value2, "mplace");
            return (Criteria) this;
        }

        public Criteria andMplaceNotBetween(String value1, String value2) {
            addCriterion("mplace not between", value1, value2, "mplace");
            return (Criteria) this;
        }

        public Criteria andMcontentIsNull() {
            addCriterion("mcontent is null");
            return (Criteria) this;
        }

        public Criteria andMcontentIsNotNull() {
            addCriterion("mcontent is not null");
            return (Criteria) this;
        }

        public Criteria andMcontentEqualTo(String value) {
            addCriterion("mcontent =", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentNotEqualTo(String value) {
            addCriterion("mcontent <>", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentGreaterThan(String value) {
            addCriterion("mcontent >", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentGreaterThanOrEqualTo(String value) {
            addCriterion("mcontent >=", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentLessThan(String value) {
            addCriterion("mcontent <", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentLessThanOrEqualTo(String value) {
            addCriterion("mcontent <=", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentLike(String value) {
            addCriterion("mcontent like", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentNotLike(String value) {
            addCriterion("mcontent not like", value, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentIn(List<String> values) {
            addCriterion("mcontent in", values, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentNotIn(List<String> values) {
            addCriterion("mcontent not in", values, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentBetween(String value1, String value2) {
            addCriterion("mcontent between", value1, value2, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMcontentNotBetween(String value1, String value2) {
            addCriterion("mcontent not between", value1, value2, "mcontent");
            return (Criteria) this;
        }

        public Criteria andMflowIsNull() {
            addCriterion("mflow is null");
            return (Criteria) this;
        }

        public Criteria andMflowIsNotNull() {
            addCriterion("mflow is not null");
            return (Criteria) this;
        }

        public Criteria andMflowEqualTo(String value) {
            addCriterion("mflow =", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowNotEqualTo(String value) {
            addCriterion("mflow <>", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowGreaterThan(String value) {
            addCriterion("mflow >", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowGreaterThanOrEqualTo(String value) {
            addCriterion("mflow >=", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowLessThan(String value) {
            addCriterion("mflow <", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowLessThanOrEqualTo(String value) {
            addCriterion("mflow <=", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowLike(String value) {
            addCriterion("mflow like", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowNotLike(String value) {
            addCriterion("mflow not like", value, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowIn(List<String> values) {
            addCriterion("mflow in", values, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowNotIn(List<String> values) {
            addCriterion("mflow not in", values, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowBetween(String value1, String value2) {
            addCriterion("mflow between", value1, value2, "mflow");
            return (Criteria) this;
        }

        public Criteria andMflowNotBetween(String value1, String value2) {
            addCriterion("mflow not between", value1, value2, "mflow");
            return (Criteria) this;
        }

        public Criteria andMguideIsNull() {
            addCriterion("mguide is null");
            return (Criteria) this;
        }

        public Criteria andMguideIsNotNull() {
            addCriterion("mguide is not null");
            return (Criteria) this;
        }

        public Criteria andMguideEqualTo(String value) {
            addCriterion("mguide =", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideNotEqualTo(String value) {
            addCriterion("mguide <>", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideGreaterThan(String value) {
            addCriterion("mguide >", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideGreaterThanOrEqualTo(String value) {
            addCriterion("mguide >=", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideLessThan(String value) {
            addCriterion("mguide <", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideLessThanOrEqualTo(String value) {
            addCriterion("mguide <=", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideLike(String value) {
            addCriterion("mguide like", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideNotLike(String value) {
            addCriterion("mguide not like", value, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideIn(List<String> values) {
            addCriterion("mguide in", values, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideNotIn(List<String> values) {
            addCriterion("mguide not in", values, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideBetween(String value1, String value2) {
            addCriterion("mguide between", value1, value2, "mguide");
            return (Criteria) this;
        }

        public Criteria andMguideNotBetween(String value1, String value2) {
            addCriterion("mguide not between", value1, value2, "mguide");
            return (Criteria) this;
        }

        public Criteria andMcreateIsNull() {
            addCriterion("mcreate is null");
            return (Criteria) this;
        }

        public Criteria andMcreateIsNotNull() {
            addCriterion("mcreate is not null");
            return (Criteria) this;
        }

        public Criteria andMcreateEqualTo(Date value) {
            addCriterion("mcreate =", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateNotEqualTo(Date value) {
            addCriterion("mcreate <>", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateGreaterThan(Date value) {
            addCriterion("mcreate >", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateGreaterThanOrEqualTo(Date value) {
            addCriterion("mcreate >=", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateLessThan(Date value) {
            addCriterion("mcreate <", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateLessThanOrEqualTo(Date value) {
            addCriterion("mcreate <=", value, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateIn(List<Date> values) {
            addCriterion("mcreate in", values, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateNotIn(List<Date> values) {
            addCriterion("mcreate not in", values, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateBetween(Date value1, Date value2) {
            addCriterion("mcreate between", value1, value2, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMcreateNotBetween(Date value1, Date value2) {
            addCriterion("mcreate not between", value1, value2, "mcreate");
            return (Criteria) this;
        }

        public Criteria andMendIsNull() {
            addCriterion("mend is null");
            return (Criteria) this;
        }

        public Criteria andMendIsNotNull() {
            addCriterion("mend is not null");
            return (Criteria) this;
        }

        public Criteria andMendEqualTo(Date value) {
            addCriterion("mend =", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendNotEqualTo(Date value) {
            addCriterion("mend <>", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendGreaterThan(Date value) {
            addCriterion("mend >", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendGreaterThanOrEqualTo(Date value) {
            addCriterion("mend >=", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendLessThan(Date value) {
            addCriterion("mend <", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendLessThanOrEqualTo(Date value) {
            addCriterion("mend <=", value, "mend");
            return (Criteria) this;
        }

        public Criteria andMendIn(List<Date> values) {
            addCriterion("mend in", values, "mend");
            return (Criteria) this;
        }

        public Criteria andMendNotIn(List<Date> values) {
            addCriterion("mend not in", values, "mend");
            return (Criteria) this;
        }

        public Criteria andMendBetween(Date value1, Date value2) {
            addCriterion("mend between", value1, value2, "mend");
            return (Criteria) this;
        }

        public Criteria andMendNotBetween(Date value1, Date value2) {
            addCriterion("mend not between", value1, value2, "mend");
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

        public Criteria andMflagEqualTo(Integer value) {
            addCriterion("mflag =", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotEqualTo(Integer value) {
            addCriterion("mflag <>", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagGreaterThan(Integer value) {
            addCriterion("mflag >", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("mflag >=", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagLessThan(Integer value) {
            addCriterion("mflag <", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagLessThanOrEqualTo(Integer value) {
            addCriterion("mflag <=", value, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagIn(List<Integer> values) {
            addCriterion("mflag in", values, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotIn(List<Integer> values) {
            addCriterion("mflag not in", values, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagBetween(Integer value1, Integer value2) {
            addCriterion("mflag between", value1, value2, "mflag");
            return (Criteria) this;
        }

        public Criteria andMflagNotBetween(Integer value1, Integer value2) {
            addCriterion("mflag not between", value1, value2, "mflag");
            return (Criteria) this;
        }

        public Criteria andMeatIsNull() {
            addCriterion("meat is null");
            return (Criteria) this;
        }

        public Criteria andMeatIsNotNull() {
            addCriterion("meat is not null");
            return (Criteria) this;
        }

        public Criteria andMeatEqualTo(Integer value) {
            addCriterion("meat =", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatNotEqualTo(Integer value) {
            addCriterion("meat <>", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatGreaterThan(Integer value) {
            addCriterion("meat >", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatGreaterThanOrEqualTo(Integer value) {
            addCriterion("meat >=", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatLessThan(Integer value) {
            addCriterion("meat <", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatLessThanOrEqualTo(Integer value) {
            addCriterion("meat <=", value, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatIn(List<Integer> values) {
            addCriterion("meat in", values, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatNotIn(List<Integer> values) {
            addCriterion("meat not in", values, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatBetween(Integer value1, Integer value2) {
            addCriterion("meat between", value1, value2, "meat");
            return (Criteria) this;
        }

        public Criteria andMeatNotBetween(Integer value1, Integer value2) {
            addCriterion("meat not between", value1, value2, "meat");
            return (Criteria) this;
        }

        public Criteria andMhotelIsNull() {
            addCriterion("mhotel is null");
            return (Criteria) this;
        }

        public Criteria andMhotelIsNotNull() {
            addCriterion("mhotel is not null");
            return (Criteria) this;
        }

        public Criteria andMhotelEqualTo(Integer value) {
            addCriterion("mhotel =", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelNotEqualTo(Integer value) {
            addCriterion("mhotel <>", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelGreaterThan(Integer value) {
            addCriterion("mhotel >", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelGreaterThanOrEqualTo(Integer value) {
            addCriterion("mhotel >=", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelLessThan(Integer value) {
            addCriterion("mhotel <", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelLessThanOrEqualTo(Integer value) {
            addCriterion("mhotel <=", value, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelIn(List<Integer> values) {
            addCriterion("mhotel in", values, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelNotIn(List<Integer> values) {
            addCriterion("mhotel not in", values, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelBetween(Integer value1, Integer value2) {
            addCriterion("mhotel between", value1, value2, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMhotelNotBetween(Integer value1, Integer value2) {
            addCriterion("mhotel not between", value1, value2, "mhotel");
            return (Criteria) this;
        }

        public Criteria andMtypeIsNull() {
            addCriterion("mtype is null");
            return (Criteria) this;
        }

        public Criteria andMtypeIsNotNull() {
            addCriterion("mtype is not null");
            return (Criteria) this;
        }

        public Criteria andMtypeEqualTo(Integer value) {
            addCriterion("mtype =", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeNotEqualTo(Integer value) {
            addCriterion("mtype <>", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeGreaterThan(Integer value) {
            addCriterion("mtype >", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mtype >=", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeLessThan(Integer value) {
            addCriterion("mtype <", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeLessThanOrEqualTo(Integer value) {
            addCriterion("mtype <=", value, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeIn(List<Integer> values) {
            addCriterion("mtype in", values, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeNotIn(List<Integer> values) {
            addCriterion("mtype not in", values, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeBetween(Integer value1, Integer value2) {
            addCriterion("mtype between", value1, value2, "mtype");
            return (Criteria) this;
        }

        public Criteria andMtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mtype not between", value1, value2, "mtype");
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

        public Criteria andMimageIsNull() {
            addCriterion("mimage is null");
            return (Criteria) this;
        }

        public Criteria andMimageIsNotNull() {
            addCriterion("mimage is not null");
            return (Criteria) this;
        }

        public Criteria andMimageEqualTo(String value) {
            addCriterion("mimage =", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageNotEqualTo(String value) {
            addCriterion("mimage <>", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageGreaterThan(String value) {
            addCriterion("mimage >", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageGreaterThanOrEqualTo(String value) {
            addCriterion("mimage >=", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageLessThan(String value) {
            addCriterion("mimage <", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageLessThanOrEqualTo(String value) {
            addCriterion("mimage <=", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageLike(String value) {
            addCriterion("mimage like", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageNotLike(String value) {
            addCriterion("mimage not like", value, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageIn(List<String> values) {
            addCriterion("mimage in", values, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageNotIn(List<String> values) {
            addCriterion("mimage not in", values, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageBetween(String value1, String value2) {
            addCriterion("mimage between", value1, value2, "mimage");
            return (Criteria) this;
        }

        public Criteria andMimageNotBetween(String value1, String value2) {
            addCriterion("mimage not between", value1, value2, "mimage");
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