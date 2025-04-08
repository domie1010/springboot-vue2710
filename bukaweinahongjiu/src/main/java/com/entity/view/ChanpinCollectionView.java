package com.entity.view;

import com.entity.ChanpinCollectionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("chanpin_collection")
public class ChanpinCollectionView extends ChanpinCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 chanpin
			/**
			* 产品名称
			*/
			private String chanpinName;
			/**
			* 产品类型
			*/
			private Integer chanpinTypes;
				/**
				* 产品类型的值
				*/
				private String chanpinValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 照片
			*/
			private String yonghuPhoto;

	public ChanpinCollectionView() {

	}

	public ChanpinCollectionView(ChanpinCollectionEntity chanpinCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, chanpinCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}







				//级联表的get和set chanpin
					/**
					* 获取： 产品名称
					*/
					public String getChanpinName() {
						return chanpinName;
					}
					/**
					* 设置： 产品名称
					*/
					public void setChanpinName(String chanpinName) {
						this.chanpinName = chanpinName;
					}
					/**
					* 获取： 产品类型
					*/
					public Integer getChanpinTypes() {
						return chanpinTypes;
					}
					/**
					* 设置： 产品类型
					*/
					public void setChanpinTypes(Integer chanpinTypes) {
						this.chanpinTypes = chanpinTypes;
					}


						/**
						* 获取： 产品类型的值
						*/
						public String getChanpinValue() {
							return chanpinValue;
						}
						/**
						* 设置： 产品类型的值
						*/
						public void setChanpinValue(String chanpinValue) {
							this.chanpinValue = chanpinValue;
						}
					/**
					* 获取： 单瓶净含量
					*/
					public Integer getChanpinJinghanlinag() {
						return chanpinJinghanlinag;
					}
					/**
					* 设置： 单瓶净含量
					*/
					public void setChanpinJinghanlinag(Integer chanpinJinghanlinag) {
						this.chanpinJinghanlinag = chanpinJinghanlinag;
					}
					/**
					* 获取： 保质期
					*/
					public String getChanpinBaozhiqi() {
						return chanpinBaozhiqi;
					}
					/**
					* 设置： 保质期
					*/
					public void setChanpinBaozhiqi(String chanpinBaozhiqi) {
						this.chanpinBaozhiqi = chanpinBaozhiqi;
					}
					/**
					* 获取： 配料表
					*/
					public String getChanpinPeiliao() {
						return chanpinPeiliao;
					}
					/**
					* 设置： 配料表
					*/
					public void setChanpinPeiliao(String chanpinPeiliao) {
						this.chanpinPeiliao = chanpinPeiliao;
					}
					/**
					* 获取： 饮酒场合
					*/
					public String getChanpinChanghe() {
						return chanpinChanghe;
					}
					/**
					* 设置： 饮酒场合
					*/
					public void setChanpinChanghe(String chanpinChanghe) {
						this.chanpinChanghe = chanpinChanghe;
					}
					/**
					* 获取： 产品缩略图
					*/
					public String getChanpinPhoto() {
						return chanpinPhoto;
					}
					/**
					* 设置： 产品缩略图
					*/
					public void setChanpinPhoto(String chanpinPhoto) {
						this.chanpinPhoto = chanpinPhoto;
					}
					/**
					* 获取： 产品单价
					*/
					public Double getChanpinNewMoney() {
						return chanpinNewMoney;
					}
					/**
					* 设置： 产品单价
					*/
					public void setChanpinNewMoney(Double chanpinNewMoney) {
						this.chanpinNewMoney = chanpinNewMoney;
					}
					/**
					* 获取： 产品简介
					*/
					public String getChanpinContent() {
						return chanpinContent;
					}
					/**
					* 设置： 产品简介
					*/
					public void setChanpinContent(String chanpinContent) {
						this.chanpinContent = chanpinContent;
					}
















				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}



}
