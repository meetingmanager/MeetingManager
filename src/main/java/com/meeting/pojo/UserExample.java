package com.meeting.pojo;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserpwIsNull() {
            addCriterion("userpw is null");
            return (Criteria) this;
        }

        public Criteria andUserpwIsNotNull() {
            addCriterion("userpw is not null");
            return (Criteria) this;
        }

        public Criteria andUserpwEqualTo(String value) {
            addCriterion("userpw =", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwNotEqualTo(String value) {
            addCriterion("userpw <>", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwGreaterThan(String value) {
            addCriterion("userpw >", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwGreaterThanOrEqualTo(String value) {
            addCriterion("userpw >=", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwLessThan(String value) {
            addCriterion("userpw <", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwLessThanOrEqualTo(String value) {
            addCriterion("userpw <=", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwLike(String value) {
            addCriterion("userpw like", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwNotLike(String value) {
            addCriterion("userpw not like", value, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwIn(List<String> values) {
            addCriterion("userpw in", values, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwNotIn(List<String> values) {
            addCriterion("userpw not in", values, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwBetween(String value1, String value2) {
            addCriterion("userpw between", value1, value2, "userpw");
            return (Criteria) this;
        }

        public Criteria andUserpwNotBetween(String value1, String value2) {
            addCriterion("userpw not between", value1, value2, "userpw");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserseatIsNull() {
            addCriterion("userseat is null");
            return (Criteria) this;
        }

        public Criteria andUserseatIsNotNull() {
            addCriterion("userseat is not null");
            return (Criteria) this;
        }

        public Criteria andUserseatEqualTo(String value) {
            addCriterion("userseat =", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatNotEqualTo(String value) {
            addCriterion("userseat <>", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatGreaterThan(String value) {
            addCriterion("userseat >", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatGreaterThanOrEqualTo(String value) {
            addCriterion("userseat >=", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatLessThan(String value) {
            addCriterion("userseat <", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatLessThanOrEqualTo(String value) {
            addCriterion("userseat <=", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatLike(String value) {
            addCriterion("userseat like", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatNotLike(String value) {
            addCriterion("userseat not like", value, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatIn(List<String> values) {
            addCriterion("userseat in", values, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatNotIn(List<String> values) {
            addCriterion("userseat not in", values, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatBetween(String value1, String value2) {
            addCriterion("userseat between", value1, value2, "userseat");
            return (Criteria) this;
        }

        public Criteria andUserseatNotBetween(String value1, String value2) {
            addCriterion("userseat not between", value1, value2, "userseat");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNull() {
            addCriterion("usersex is null");
            return (Criteria) this;
        }

        public Criteria andUsersexIsNotNull() {
            addCriterion("usersex is not null");
            return (Criteria) this;
        }

        public Criteria andUsersexEqualTo(String value) {
            addCriterion("usersex =", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotEqualTo(String value) {
            addCriterion("usersex <>", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThan(String value) {
            addCriterion("usersex >", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexGreaterThanOrEqualTo(String value) {
            addCriterion("usersex >=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThan(String value) {
            addCriterion("usersex <", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLessThanOrEqualTo(String value) {
            addCriterion("usersex <=", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexLike(String value) {
            addCriterion("usersex like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotLike(String value) {
            addCriterion("usersex not like", value, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexIn(List<String> values) {
            addCriterion("usersex in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotIn(List<String> values) {
            addCriterion("usersex not in", values, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexBetween(String value1, String value2) {
            addCriterion("usersex between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andUsersexNotBetween(String value1, String value2) {
            addCriterion("usersex not between", value1, value2, "usersex");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIsNull() {
            addCriterion("headphoto is null");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIsNotNull() {
            addCriterion("headphoto is not null");
            return (Criteria) this;
        }

        public Criteria andHeadphotoEqualTo(String value) {
            addCriterion("headphoto =", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotEqualTo(String value) {
            addCriterion("headphoto <>", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoGreaterThan(String value) {
            addCriterion("headphoto >", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoGreaterThanOrEqualTo(String value) {
            addCriterion("headphoto >=", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLessThan(String value) {
            addCriterion("headphoto <", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLessThanOrEqualTo(String value) {
            addCriterion("headphoto <=", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoLike(String value) {
            addCriterion("headphoto like", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotLike(String value) {
            addCriterion("headphoto not like", value, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoIn(List<String> values) {
            addCriterion("headphoto in", values, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotIn(List<String> values) {
            addCriterion("headphoto not in", values, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoBetween(String value1, String value2) {
            addCriterion("headphoto between", value1, value2, "headphoto");
            return (Criteria) this;
        }

        public Criteria andHeadphotoNotBetween(String value1, String value2) {
            addCriterion("headphoto not between", value1, value2, "headphoto");
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