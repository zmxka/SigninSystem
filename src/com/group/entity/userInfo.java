package com.group.entity;

/**
 * <p>Title: userInfo<／p>
 * <p>Description: 用户信息<／p>
 * @date 2018.11.20
 */
public class userInfo {

	private int userId;
	private String userName;
	private String passWord;
	private int sex;
	private String name;
	private String telephoneNumber;
	private String email;
	private int departmentId;
	private int type;
	private String IDCard;
	private String creditCard;

	/**
	 * 
	 */
	public userInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userId
	 * @param userName
	 * @param passWord
	 * @param sex
	 * @param name
	 * @param telephoneNumber
	 * @param email
	 * @param departmentId
	 * @param type
	 * @param iDCard
	 * @param creditCard
	 */
	public userInfo(int userId, String userName, String passWord, int sex, String name, String telephoneNumber,
			String email, int departmentId, int type, String iDCard, String creditCard) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.departmentId = departmentId;
		this.type = type;
		IDCard = iDCard;
		this.creditCard = creditCard;
	}

	/**
	 * <p>Title: <／p>
	 * <p>Description: <／p>
	 * @param userName
	 * @param passWord
	 * @param sex
	 * @param name
	 * @param telephoneNumber
	 * @param email
	 * @param departmentId
	 * @param type
	 * @param iDCard
	 * @param creditCard
	 */
	public userInfo(String userName, String passWord, int sex, String name, String telephoneNumber, String email,
			int departmentId, int type, String iDCard, String creditCard) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.name = name;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.departmentId = departmentId;
		this.type = type;
		IDCard = iDCard;
		this.creditCard = creditCard;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @param passWord the passWord to set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the iDCard
	 */
	public String getIDCard() {
		return IDCard;
	}

	/**
	 * @param iDCard the iDCard to set
	 */
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	/**
	 * @return the creditCard
	 */
	public String getCreditCard() {
		return creditCard;
	}

	/**
	 * @param creditCard the creditCard to set
	 */
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

}
