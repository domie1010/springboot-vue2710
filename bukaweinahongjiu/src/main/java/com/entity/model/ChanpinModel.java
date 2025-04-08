package com.entity.model;

import com.entity.ChanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 产品信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChanpinModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 产品名称
     */
    private String chanpinName;


    /**
     * 产品类型
     */
    private Integer chanpinTypes;


    /**
     * 单瓶净含量
     */
    private Integer chanpinJinghanlinag;


    /**
     * 保质期
     */
    private String chanpinBaozhiqi;


    /**
     * 配料表
     */
    private String chanpinPeiliao;


    /**
     * 饮酒场合
     */
    private String chanpinChanghe;


    /**
     * 产品缩略图
     */
    private String chanpinPhoto;


    /**
     * 产品单价
     */
    private Double chanpinNewMoney;


    /**
     * 产品简介
     */
    private String chanpinContent;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：产品名称
	 */
    public String getChanpinName() {
        return chanpinName;
    }


    /**
	 * 设置：产品名称
	 */
    public void setChanpinName(String chanpinName) {
        this.chanpinName = chanpinName;
    }
    /**
	 * 获取：产品类型
	 */
    public Integer getChanpinTypes() {
        return chanpinTypes;
    }


    /**
	 * 设置：产品类型
	 */
    public void setChanpinTypes(Integer chanpinTypes) {
        this.chanpinTypes = chanpinTypes;
    }
    /**
	 * 获取：单瓶净含量
	 */
    public Integer getChanpinJinghanlinag() {
        return chanpinJinghanlinag;
    }


    /**
	 * 设置：单瓶净含量
	 */
    public void setChanpinJinghanlinag(Integer chanpinJinghanlinag) {
        this.chanpinJinghanlinag = chanpinJinghanlinag;
    }
    /**
	 * 获取：保质期
	 */
    public String getChanpinBaozhiqi() {
        return chanpinBaozhiqi;
    }


    /**
	 * 设置：保质期
	 */
    public void setChanpinBaozhiqi(String chanpinBaozhiqi) {
        this.chanpinBaozhiqi = chanpinBaozhiqi;
    }
    /**
	 * 获取：配料表
	 */
    public String getChanpinPeiliao() {
        return chanpinPeiliao;
    }


    /**
	 * 设置：配料表
	 */
    public void setChanpinPeiliao(String chanpinPeiliao) {
        this.chanpinPeiliao = chanpinPeiliao;
    }
    /**
	 * 获取：饮酒场合
	 */
    public String getChanpinChanghe() {
        return chanpinChanghe;
    }


    /**
	 * 设置：饮酒场合
	 */
    public void setChanpinChanghe(String chanpinChanghe) {
        this.chanpinChanghe = chanpinChanghe;
    }
    /**
	 * 获取：产品缩略图
	 */
    public String getChanpinPhoto() {
        return chanpinPhoto;
    }


    /**
	 * 设置：产品缩略图
	 */
    public void setChanpinPhoto(String chanpinPhoto) {
        this.chanpinPhoto = chanpinPhoto;
    }
    /**
	 * 获取：产品单价
	 */
    public Double getChanpinNewMoney() {
        return chanpinNewMoney;
    }


    /**
	 * 设置：产品单价
	 */
    public void setChanpinNewMoney(Double chanpinNewMoney) {
        this.chanpinNewMoney = chanpinNewMoney;
    }
    /**
	 * 获取：产品简介
	 */
    public String getChanpinContent() {
        return chanpinContent;
    }


    /**
	 * 设置：产品简介
	 */
    public void setChanpinContent(String chanpinContent) {
        this.chanpinContent = chanpinContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
