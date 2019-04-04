package com.example.bee.mode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbSellOrderExample {
    /**
     * tb_sell_order
     */
    protected String orderByClause;

    /**
     * tb_sell_order
     */
    protected boolean distinct;

    /**
     * tb_sell_order
     */
    protected List<Criteria> oredCriteria;

    public TbSellOrderExample() {
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
     * tb_sell_order 2019-04-04
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSellorderNoIsNull() {
            addCriterion("sellOrder_no is null");
            return (Criteria) this;
        }

        public Criteria andSellorderNoIsNotNull() {
            addCriterion("sellOrder_no is not null");
            return (Criteria) this;
        }

        public Criteria andSellorderNoEqualTo(String value) {
            addCriterion("sellOrder_no =", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoNotEqualTo(String value) {
            addCriterion("sellOrder_no <>", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoGreaterThan(String value) {
            addCriterion("sellOrder_no >", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoGreaterThanOrEqualTo(String value) {
            addCriterion("sellOrder_no >=", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoLessThan(String value) {
            addCriterion("sellOrder_no <", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoLessThanOrEqualTo(String value) {
            addCriterion("sellOrder_no <=", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoLike(String value) {
            addCriterion("sellOrder_no like", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoNotLike(String value) {
            addCriterion("sellOrder_no not like", value, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoIn(List<String> values) {
            addCriterion("sellOrder_no in", values, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoNotIn(List<String> values) {
            addCriterion("sellOrder_no not in", values, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoBetween(String value1, String value2) {
            addCriterion("sellOrder_no between", value1, value2, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andSellorderNoNotBetween(String value1, String value2) {
            addCriterion("sellOrder_no not between", value1, value2, "sellorderNo");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(BigDecimal value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(BigDecimal value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<BigDecimal> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIsNull() {
            addCriterion("integral_amount is null");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIsNotNull() {
            addCriterion("integral_amount is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountEqualTo(BigDecimal value) {
            addCriterion("integral_amount =", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotEqualTo(BigDecimal value) {
            addCriterion("integral_amount <>", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountGreaterThan(BigDecimal value) {
            addCriterion("integral_amount >", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("integral_amount >=", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountLessThan(BigDecimal value) {
            addCriterion("integral_amount <", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("integral_amount <=", value, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountIn(List<BigDecimal> values) {
            addCriterion("integral_amount in", values, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotIn(List<BigDecimal> values) {
            addCriterion("integral_amount not in", values, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integral_amount between", value1, value2, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andIntegralAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("integral_amount not between", value1, value2, "integralAmount");
            return (Criteria) this;
        }

        public Criteria andPaidAmounIsNull() {
            addCriterion("paid_amoun is null");
            return (Criteria) this;
        }

        public Criteria andPaidAmounIsNotNull() {
            addCriterion("paid_amoun is not null");
            return (Criteria) this;
        }

        public Criteria andPaidAmounEqualTo(BigDecimal value) {
            addCriterion("paid_amoun =", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounNotEqualTo(BigDecimal value) {
            addCriterion("paid_amoun <>", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounGreaterThan(BigDecimal value) {
            addCriterion("paid_amoun >", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amoun >=", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounLessThan(BigDecimal value) {
            addCriterion("paid_amoun <", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paid_amoun <=", value, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounIn(List<BigDecimal> values) {
            addCriterion("paid_amoun in", values, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounNotIn(List<BigDecimal> values) {
            addCriterion("paid_amoun not in", values, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amoun between", value1, value2, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andPaidAmounNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paid_amoun not between", value1, value2, "paidAmoun");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNull() {
            addCriterion("collection is null");
            return (Criteria) this;
        }

        public Criteria andCollectionIsNotNull() {
            addCriterion("collection is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionEqualTo(BigDecimal value) {
            addCriterion("collection =", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotEqualTo(BigDecimal value) {
            addCriterion("collection <>", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThan(BigDecimal value) {
            addCriterion("collection >", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("collection >=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThan(BigDecimal value) {
            addCriterion("collection <", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("collection <=", value, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionIn(List<BigDecimal> values) {
            addCriterion("collection in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotIn(List<BigDecimal> values) {
            addCriterion("collection not in", values, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection between", value1, value2, "collection");
            return (Criteria) this;
        }

        public Criteria andCollectionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("collection not between", value1, value2, "collection");
            return (Criteria) this;
        }

        public Criteria andChangeIsNull() {
            addCriterion("change is null");
            return (Criteria) this;
        }

        public Criteria andChangeIsNotNull() {
            addCriterion("change is not null");
            return (Criteria) this;
        }

        public Criteria andChangeEqualTo(BigDecimal value) {
            addCriterion("change =", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotEqualTo(BigDecimal value) {
            addCriterion("change <>", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThan(BigDecimal value) {
            addCriterion("change >", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("change >=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThan(BigDecimal value) {
            addCriterion("change <", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("change <=", value, "change");
            return (Criteria) this;
        }

        public Criteria andChangeIn(List<BigDecimal> values) {
            addCriterion("change in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotIn(List<BigDecimal> values) {
            addCriterion("change not in", values, "change");
            return (Criteria) this;
        }

        public Criteria andChangeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andChangeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("change not between", value1, value2, "change");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNull() {
            addCriterion("pay_way is null");
            return (Criteria) this;
        }

        public Criteria andPayWayIsNotNull() {
            addCriterion("pay_way is not null");
            return (Criteria) this;
        }

        public Criteria andPayWayEqualTo(Integer value) {
            addCriterion("pay_way =", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotEqualTo(Integer value) {
            addCriterion("pay_way <>", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThan(Integer value) {
            addCriterion("pay_way >", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_way >=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThan(Integer value) {
            addCriterion("pay_way <", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayLessThanOrEqualTo(Integer value) {
            addCriterion("pay_way <=", value, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayIn(List<Integer> values) {
            addCriterion("pay_way in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotIn(List<Integer> values) {
            addCriterion("pay_way not in", values, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayBetween(Integer value1, Integer value2) {
            addCriterion("pay_way between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andPayWayNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_way not between", value1, value2, "payWay");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeIsNull() {
            addCriterion("sellOrder_type is null");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeIsNotNull() {
            addCriterion("sellOrder_type is not null");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeEqualTo(Integer value) {
            addCriterion("sellOrder_type =", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeNotEqualTo(Integer value) {
            addCriterion("sellOrder_type <>", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeGreaterThan(Integer value) {
            addCriterion("sellOrder_type >", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellOrder_type >=", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeLessThan(Integer value) {
            addCriterion("sellOrder_type <", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sellOrder_type <=", value, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeIn(List<Integer> values) {
            addCriterion("sellOrder_type in", values, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeNotIn(List<Integer> values) {
            addCriterion("sellOrder_type not in", values, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeBetween(Integer value1, Integer value2) {
            addCriterion("sellOrder_type between", value1, value2, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andSellorderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sellOrder_type not between", value1, value2, "sellorderType");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(Integer value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(Integer value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(Integer value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(Integer value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<Integer> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<Integer> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(Integer value1, Integer value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusIsNull() {
            addCriterion("sellOrder_status is null");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusIsNotNull() {
            addCriterion("sellOrder_status is not null");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusEqualTo(Integer value) {
            addCriterion("sellOrder_status =", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusNotEqualTo(Integer value) {
            addCriterion("sellOrder_status <>", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusGreaterThan(Integer value) {
            addCriterion("sellOrder_status >", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellOrder_status >=", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusLessThan(Integer value) {
            addCriterion("sellOrder_status <", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sellOrder_status <=", value, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusIn(List<Integer> values) {
            addCriterion("sellOrder_status in", values, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusNotIn(List<Integer> values) {
            addCriterion("sellOrder_status not in", values, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusBetween(Integer value1, Integer value2) {
            addCriterion("sellOrder_status between", value1, value2, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andSellorderStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sellOrder_status not between", value1, value2, "sellorderStatus");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNull() {
            addCriterion("buy_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyIdIsNotNull() {
            addCriterion("buy_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyIdEqualTo(Long value) {
            addCriterion("buy_id =", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotEqualTo(Long value) {
            addCriterion("buy_id <>", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThan(Long value) {
            addCriterion("buy_id >", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("buy_id >=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThan(Long value) {
            addCriterion("buy_id <", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdLessThanOrEqualTo(Long value) {
            addCriterion("buy_id <=", value, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdIn(List<Long> values) {
            addCriterion("buy_id in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotIn(List<Long> values) {
            addCriterion("buy_id not in", values, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdBetween(Long value1, Long value2) {
            addCriterion("buy_id between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andBuyIdNotBetween(Long value1, Long value2) {
            addCriterion("buy_id not between", value1, value2, "buyId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShophqIdIsNull() {
            addCriterion("shopHq_id is null");
            return (Criteria) this;
        }

        public Criteria andShophqIdIsNotNull() {
            addCriterion("shopHq_id is not null");
            return (Criteria) this;
        }

        public Criteria andShophqIdEqualTo(Long value) {
            addCriterion("shopHq_id =", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdNotEqualTo(Long value) {
            addCriterion("shopHq_id <>", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdGreaterThan(Long value) {
            addCriterion("shopHq_id >", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shopHq_id >=", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdLessThan(Long value) {
            addCriterion("shopHq_id <", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdLessThanOrEqualTo(Long value) {
            addCriterion("shopHq_id <=", value, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdIn(List<Long> values) {
            addCriterion("shopHq_id in", values, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdNotIn(List<Long> values) {
            addCriterion("shopHq_id not in", values, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdBetween(Long value1, Long value2) {
            addCriterion("shopHq_id between", value1, value2, "shophqId");
            return (Criteria) this;
        }

        public Criteria andShophqIdNotBetween(Long value1, Long value2) {
            addCriterion("shopHq_id not between", value1, value2, "shophqId");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNull() {
            addCriterion("cashier_id is null");
            return (Criteria) this;
        }

        public Criteria andCashierIdIsNotNull() {
            addCriterion("cashier_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashierIdEqualTo(Long value) {
            addCriterion("cashier_id =", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotEqualTo(Long value) {
            addCriterion("cashier_id <>", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThan(Long value) {
            addCriterion("cashier_id >", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cashier_id >=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThan(Long value) {
            addCriterion("cashier_id <", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdLessThanOrEqualTo(Long value) {
            addCriterion("cashier_id <=", value, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdIn(List<Long> values) {
            addCriterion("cashier_id in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotIn(List<Long> values) {
            addCriterion("cashier_id not in", values, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdBetween(Long value1, Long value2) {
            addCriterion("cashier_id between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCashierIdNotBetween(Long value1, Long value2) {
            addCriterion("cashier_id not between", value1, value2, "cashierId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEmptyIsNull() {
            addCriterion("empty is null");
            return (Criteria) this;
        }

        public Criteria andEmptyIsNotNull() {
            addCriterion("empty is not null");
            return (Criteria) this;
        }

        public Criteria andEmptyEqualTo(BigDecimal value) {
            addCriterion("empty =", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotEqualTo(BigDecimal value) {
            addCriterion("empty <>", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyGreaterThan(BigDecimal value) {
            addCriterion("empty >", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("empty >=", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyLessThan(BigDecimal value) {
            addCriterion("empty <", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("empty <=", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyIn(List<BigDecimal> values) {
            addCriterion("empty in", values, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotIn(List<BigDecimal> values) {
            addCriterion("empty not in", values, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("empty between", value1, value2, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("empty not between", value1, value2, "empty");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialIsNull() {
            addCriterion("order_preferential is null");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialIsNotNull() {
            addCriterion("order_preferential is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialEqualTo(BigDecimal value) {
            addCriterion("order_preferential =", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialNotEqualTo(BigDecimal value) {
            addCriterion("order_preferential <>", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialGreaterThan(BigDecimal value) {
            addCriterion("order_preferential >", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_preferential >=", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialLessThan(BigDecimal value) {
            addCriterion("order_preferential <", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_preferential <=", value, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialIn(List<BigDecimal> values) {
            addCriterion("order_preferential in", values, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialNotIn(List<BigDecimal> values) {
            addCriterion("order_preferential not in", values, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_preferential between", value1, value2, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andOrderPreferentialNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_preferential not between", value1, value2, "orderPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialIsNull() {
            addCriterion("member_preferential is null");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialIsNotNull() {
            addCriterion("member_preferential is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialEqualTo(BigDecimal value) {
            addCriterion("member_preferential =", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialNotEqualTo(BigDecimal value) {
            addCriterion("member_preferential <>", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialGreaterThan(BigDecimal value) {
            addCriterion("member_preferential >", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("member_preferential >=", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialLessThan(BigDecimal value) {
            addCriterion("member_preferential <", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialLessThanOrEqualTo(BigDecimal value) {
            addCriterion("member_preferential <=", value, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialIn(List<BigDecimal> values) {
            addCriterion("member_preferential in", values, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialNotIn(List<BigDecimal> values) {
            addCriterion("member_preferential not in", values, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_preferential between", value1, value2, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberPreferentialNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_preferential not between", value1, value2, "memberPreferential");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeIsNull() {
            addCriterion("member_order_type is null");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeIsNotNull() {
            addCriterion("member_order_type is not null");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeEqualTo(Integer value) {
            addCriterion("member_order_type =", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeNotEqualTo(Integer value) {
            addCriterion("member_order_type <>", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeGreaterThan(Integer value) {
            addCriterion("member_order_type >", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_order_type >=", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeLessThan(Integer value) {
            addCriterion("member_order_type <", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeLessThanOrEqualTo(Integer value) {
            addCriterion("member_order_type <=", value, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeIn(List<Integer> values) {
            addCriterion("member_order_type in", values, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeNotIn(List<Integer> values) {
            addCriterion("member_order_type not in", values, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeBetween(Integer value1, Integer value2) {
            addCriterion("member_order_type between", value1, value2, "memberOrderType");
            return (Criteria) this;
        }

        public Criteria andMemberOrderTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("member_order_type not between", value1, value2, "memberOrderType");
            return (Criteria) this;
        }
    }

    /**
     * tb_sell_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * tb_sell_order 2019-04-04
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