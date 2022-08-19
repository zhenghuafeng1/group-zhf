package demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MeterReadingDay {

    @ExcelProperty(value = {"费用统计","资产编号"})
    private String assetNo;

    @ExcelProperty(value = {"费用统计","电表安装位置"})
    private String instAddress;

    @ExcelProperty(value = {"费用统计","用电内容"})
    private String name;

    @ExcelProperty(value = {"费用统计","电量","起始底度","总"})
    private BigDecimal bgnReadings;
    /**
     * 起始尖电量
     */
    private BigDecimal bgnReadings1;
    /**
     * 起始峰电量
     */
    private BigDecimal bgnReadings2;
    /**
     * 起始平电量
     */
    private BigDecimal bgnReadings3;
    /**
     * 起始谷电量
     */
    private BigDecimal bgnReadings4;
    /**
     * 截止底度
     */
    private BigDecimal endReadings;
    /**
     * 截止尖电量
     */
    private BigDecimal endReadings1;
    /**
     * 截止峰电量
     */
    private BigDecimal endReadings2;
    /**
     * 截止平电量
     */
    private BigDecimal endReadings3;
    /**
     * 截止谷电量
     */
    private BigDecimal endReadings4;
    /**
     * 总用电量
     */
    private BigDecimal energy;
    /**
     * 尖用电量
     */
    private BigDecimal energy1;
    /**
     * 峰用电量
     */
    private BigDecimal energy2;
    /**
     * 平用电量
     */
    private BigDecimal energy3;
    /**
     * 谷用电量
     */
    private BigDecimal energy4;
    /**
     * 总电费
     */
    private BigDecimal amount;
    /**
     * 尖用电电费
     */
    private BigDecimal amount1;
    /**
     * 峰用电电费
     */
    private BigDecimal amount2;
    /**
     * 平用电电费
     */
    private BigDecimal amount3;
    /**
     * 谷用电电费
     */
    private BigDecimal amount4;
    /**
     * 最大需量
     */
    private BigDecimal demandReadings;
    /**
     * 发生时间
     */
    private LocalDateTime occurrenceTime;
    /**
     * 需量费
     */
    private BigDecimal demandFee;
    /**
     * 总电费
     */
    private BigDecimal total;
    /**
     * 变比
     */
    private BigDecimal ratio;

}
