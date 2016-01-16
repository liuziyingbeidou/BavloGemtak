package com.bavlo.counter.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class SafeCompute {
	
	  /**
     * Rounding mode to round away from zero.  Always increments the
     * digit prior to a nonzero discarded fraction.  Note that this rounding
     * mode never decreases the magnitude of the calculated value.
     */
    public final static int ROUND_UP =           0;

    /**
     * Rounding mode to round towards zero.  Never increments the digit
     * prior to a discarded fraction (i.e., truncates).  Note that this
     * rounding mode never increases the magnitude of the calculated value.
     */
    public final static int ROUND_DOWN =         1;

    /**
     * Rounding mode to round towards positive infinity.  If the
     * {@code BigDecimal} is positive, behaves as for
     * {@code ROUND_UP}; if negative, behaves as for
     * {@code ROUND_DOWN}.  Note that this rounding mode never
     * decreases the calculated value.
     */
    public final static int ROUND_CEILING =      2;

    /**
     * Rounding mode to round towards negative infinity.  If the
     * {@code BigDecimal} is positive, behave as for
     * {@code ROUND_DOWN}; if negative, behave as for
     * {@code ROUND_UP}.  Note that this rounding mode never
     * increases the calculated value.
     */
    public final static int ROUND_FLOOR =        3;

    /**
     * Rounding mode to round towards {@literal "nearest neighbor"}
     * unless both neighbors are equidistant, in which case round up.
     * Behaves as for {@code ROUND_UP} if the discarded fraction is
     * &ge; 0.5; otherwise, behaves as for {@code ROUND_DOWN}.  Note
     * that this is the rounding mode that most of us were taught in
     * grade school.
     */
    public final static int ROUND_HALF_UP =      4;

    /**
     * Rounding mode to round towards {@literal "nearest neighbor"}
     * unless both neighbors are equidistant, in which case round
     * down.  Behaves as for {@code ROUND_UP} if the discarded
     * fraction is {@literal >} 0.5; otherwise, behaves as for
     * {@code ROUND_DOWN}.
     */
    public final static int ROUND_HALF_DOWN =    5;

    /**
     * Rounding mode to round towards the {@literal "nearest neighbor"}
     * unless both neighbors are equidistant, in which case, round
     * towards the even neighbor.  Behaves as for
     * {@code ROUND_HALF_UP} if the digit to the left of the
     * discarded fraction is odd; behaves as for
     * {@code ROUND_HALF_DOWN} if it's even.  Note that this is the
     * rounding mode that minimizes cumulative error when applied
     * repeatedly over a sequence of calculations.
     */
    public final static int ROUND_HALF_EVEN =    6;

    /**
     * Rounding mode to assert that the requested operation has an exact
     * result, hence no rounding is necessary.  If this rounding mode is
     * specified on an operation that yields an inexact result, an
     * {@code ArithmeticException} is thrown.
     */
    public final static int ROUND_UNNECESSARY =  7;


	public SafeCompute() {
		super();
	}

	/**
	 * 取绝对值
	 * 
	 * @param n1
	 * @return
	 */
	public static Double abs(Double n1) {
		if (n1 == null)
			return new Double(0);
		else
			return n1.intValue() > 0 ? n1 : n1 * (-1);
	}

	/**
	 * 比较
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int compare(Double n1, Double n2) {
		if (n1 == null)
			n1 = new Double(0);
		if (n2 == null)
			n2 = new Double(0);
		return n1.compareTo(n2);
	}

	/**
	 * 判断相等
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static boolean isEqual(Double n1, Double n2) {
		if (n1 == null)
			n1 = new Double(0);
		if (n2 == null)
			n2 = new Double(0);
		if (n1.compareTo(n2) != 0)
			return false;
		else
			return true;
	}

	/**
	 * 取较大数
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static Double max(Double n1, Double n2) {
		if (n1 == null)
			n1 = new Double(0);
		if (n2 == null)
			n2 = new Double(0);

		if (n1.doubleValue() >= n2.doubleValue())
			return n1;
		else
			return n2;
	}

	/**
	 * 取较小数
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static Double min(Double n1, Double n2) {

		if (n1 == null)
			n1 = new Double(0);
		if (n2 == null)
			n2 = new Double(0);
		if (n1.doubleValue() > n2.doubleValue())
			return n2;
		else
			return n1;
	}

	/**
	 * 取反
	 * 
	 * @param n1
	 * @return
	 */
	public static Double minus(Double n1) {
		if (n1 == null)
			return new Double(0);
		else
			return n1 * (-1);
	}

	public static Double add(Double d1, Double d2) {
		d1 = d1 != null ? d1 : new Double(0);
		d2 = d2 != null ? d2 : new Double(0);
		return d1 + d2;
	}

	public static Double div(Double d1, Double d2) {
		d1 = d1 != null ? d1 : new Double(0);
		d2 = d2 != null ? d2 : new Double(0);
		if (isEqual(0d, d2)) {
			return null;
		}
		return d1 / d2;
	}

	public static Double multiply(Double d1, Double d2) {
		d1 = d1 != null ? d1 : new Double(0);
		d2 = d2 != null ? d2 : new Double(0);
		return d1 * d2;
	}

	public static Double sub(Double d1, Double d2) {
		d1 = d1 != null ? d1 : new Double(0);
		d2 = d2 != null ? d2 : new Double(0);
		return d1 - d2;
	}

	/**
	 * 设置精度、舍入方式
	 * 
	 * @param value
	 * @param scale
	 * @param roundingMode 如：四舍五入：BigDecimal.ROUND_HALF_UP <br/>
	 *            ROUND_UP =0;ROUND_DOWN =1;ROUND_CEILING 2;
	 *            ROUND_FLOOR=3;ROUND_HALF_UP =4;
	 * @return
	 */
	public static Double setScale(Double value, int scale, int roundingMode) {
		if (value == null || compare(value, 0d) == 0) {
			return 0d;
		}
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(scale, roundingMode);
		double d = bd.doubleValue();
		bd = null;
		return d;
	}
	
	/** 
	 * @Description: 传入一个Double类型的值，返回一个保留两位小数的字符串
	 * @param 
	 * @return void
	 */
	public static String setScale(Double value) {
		DecimalFormat df=new DecimalFormat("###,###.00");
		
		if(value == null || compare(value, 0d) == 0){
			df.format(0);
		}
		return df.format(value);
	}
}
