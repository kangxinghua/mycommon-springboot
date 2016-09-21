package org.mycommon.springboot.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.mycommon.modules.utils.Dates;

/**
* sys_user 表的Model
*/
public class UserModelGen extends DataModel {

	//===========================================代码生成开始============================================

    //columns 开始
    private String userName;//用户名
    private String password;//密码
    private String salt;//盐
    private String realName;//真实名字
    private java.util.Date lastLoginTime;//
    private String lastLoginIp;//
	//columns 结束



  	/**
     * 用户名
     *
     * @param value
     */
	public void setUserName(String value) {
		this.userName = value;
	}

	/**
     * 用户名
     */
	public String getUserName() {
		return this.userName;
	}

  	/**
     * 密码
     *
     * @param value
     */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
     * 密码
     */
	public String getPassword() {
		return this.password;
	}

  	/**
     * 盐
     *
     * @param value
     */
	public void setSalt(String value) {
		this.salt = value;
	}

	/**
     * 盐
     */
	public String getSalt() {
		return this.salt;
	}

  	/**
     * 真实名字
     *
     * @param value
     */
	public void setRealName(String value) {
		this.realName = value;
	}

	/**
     * 真实名字
     */
	public String getRealName() {
		return this.realName;
	}

  	/**
     *
     *
     * @param value
     */
	public void setLastLoginTime(java.util.Date value) {
		this.lastLoginTime = value;
	}

	/**
     *
     */
	@JSONField(format = Dates.PATTERN_CLASSICAL)
	public java.util.Date getLastLoginTime() {
		return this.lastLoginTime;
	}

  	/**
     *
     *
     * @param value
     */
	public void setLastLoginIp(String value) {
		this.lastLoginIp = value;
	}

	/**
     *
     */
	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("userName",getUserName())
			.append("password",getPassword())
			.append("salt",getSalt())
			.append("realName",getRealName())
			.append("lastLoginTime",getLastLoginTime())
			.append("lastLoginIp",getLastLoginIp())
			.append("createBy",getCreateBy())
			.append("createByName",getCreateByName())
			.append("createTime",getCreateTime())
			.append("updateBy",getUpdateBy())
			.append("updateByName",getUpdateByName())
			.append("updateTime",getUpdateTime())
			.append("deleted",getDeleted())
			.append("version",getVersion())
			.toString();
	}
	//===========================================代码生成结束============================================
}

