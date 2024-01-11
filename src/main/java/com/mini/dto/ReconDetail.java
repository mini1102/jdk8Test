package com.mini.dto;

import java.math.BigDecimal;

/**
 * 对账明细
 */
public class ReconDetail {
    /**
     * ID
     */
    private Long id;

    /**
     * 本方数量
     */
    private Long srcQty;

    /**
     * 本方金额
     */
    private BigDecimal srcAmt;

    /**
     * 对手方数量
     */
    private Long oppQty;

    /**
     * 对手方金额
     */
    private BigDecimal oppAmt;

    public ReconDetail() {

    }

    public ReconDetail(Long srcQty, BigDecimal srcAmt, Long oppQty, BigDecimal oppAmt) {
        this.srcQty = srcQty;
        this.srcAmt = srcAmt;
        this.oppQty = oppQty;
        this.oppAmt = oppAmt;
    }

    public ReconDetail(Long id, Long srcQty, BigDecimal srcAmt, Long oppQty, BigDecimal oppAmt) {
        this.id = id;
        this.srcQty = srcQty;
        this.srcAmt = srcAmt;
        this.oppQty = oppQty;
        this.oppAmt = oppAmt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSrcQty() {
        return srcQty;
    }

    public void setSrcQty(Long srcQty) {
        this.srcQty = srcQty;
    }

    public BigDecimal getSrcAmt() {
        return srcAmt;
    }

    public void setSrcAmt(BigDecimal srcAmt) {
        this.srcAmt = srcAmt;
    }

    public Long getOppQty() {
        return oppQty;
    }

    public void setOppQty(Long oppQty) {
        this.oppQty = oppQty;
    }

    public BigDecimal getOppAmt() {
        return oppAmt;
    }

    public void setOppAmt(BigDecimal oppAmt) {
        this.oppAmt = oppAmt;
    }
}