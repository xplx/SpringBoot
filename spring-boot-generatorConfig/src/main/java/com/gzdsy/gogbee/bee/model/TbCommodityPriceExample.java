package com.gzdsy.gogbee.bee.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TbCommodityPriceExample {
    /**
     * tb_commodity_price
     */
    protected String orderByClause;

    /**
     * tb_commodity_price
     */
    protected boolean distinct;

    /**
     * tb_commodity_price
     */
    protected List<Criteria> oredCriteria;

    public TbCommodityPriceExample() {
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

    /**
     * tb_commodity_price 2019-04-04
     */
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

        public Criteria andCommodityIdIsNull() {
            addCriterion("commodity_id is null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIsNotNull() {
            addCriterion("commodity_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommodityIdEqualTo(Integer value) {
            addCriterion("commodity_id =", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotEqualTo(Integer value) {
            addCriterion("commodity_id <>", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThan(Integer value) {
            addCriterion("commodity_id >", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commodity_id >=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThan(Integer value) {
            addCriterion("commodity_id <", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdLessThanOrEqualTo(Integer value) {
            addCriterion("commodity_id <=", value, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdIn(List<Integer> values) {
            addCriterion("commodity_id in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotIn(List<Integer> values) {
            addCriterion("commodity_id not in", values, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andCommodityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commodity_id not between", value1, value2, "commodityId");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleIsNull() {
            addCriterion("receivable_style is null");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleIsNotNull() {
            addCriterion("receivable_style is not null");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleEqualTo(Integer value) {
            addCriterion("receivable_style =", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleNotEqualTo(Integer value) {
            addCriterion("receivable_style <>", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleGreaterThan(Integer value) {
            addCriterion("receivable_style >", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleGreaterThanOrEqualTo(Integer value) {
            addCriterion("receivable_style >=", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleLessThan(Integer value) {
            addCriterion("receivable_style <", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleLessThanOrEqualTo(Integer value) {
            addCriterion("receivable_style <=", value, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleIn(List<Integer> values) {
            addCriterion("receivable_style in", values, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleNotIn(List<Integer> values) {
            addCriterion("receivable_style not in", values, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleBetween(Integer value1, Integer value2) {
            addCriterion("receivable_style between", value1, value2, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivableStyleNotBetween(Integer value1, Integer value2) {
            addCriterion("receivable_style not between", value1, value2, "receivableStyle");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceIsNull() {
            addCriterion("receivable_price is null");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceIsNotNull() {
            addCriterion("receivable_price is not null");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceEqualTo(BigDecimal value) {
            addCriterion("receivable_price =", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceNotEqualTo(BigDecimal value) {
            addCriterion("receivable_price <>", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceGreaterThan(BigDecimal value) {
            addCriterion("receivable_price >", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_price >=", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceLessThan(BigDecimal value) {
            addCriterion("receivable_price <", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("receivable_price <=", value, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceIn(List<BigDecimal> values) {
            addCriterion("receivable_price in", values, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceNotIn(List<BigDecimal> values) {
            addCriterion("receivable_price not in", values, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_price between", value1, value2, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andReceivablePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("receivable_price not between", value1, value2, "receivablePrice");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(String value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(String value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(String value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(String value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(String value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(String value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLike(String value) {
            addCriterion("is_delete like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotLike(String value) {
            addCriterion("is_delete not like", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<String> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<String> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(String value1, String value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(String value1, String value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    /**
     * tb_commodity_price
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * tb_commodity_price 2019-04-04
     */
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