package com.beta.recycleitem;



public class Data {
	public static final int TYPE_ONE = 1;//类型1
	public static final int TYPE_TWO = 2;//类型22222

	public int type;//item内容 类型


	public String message;
	public Data(int type, String message) {
		this.type = type;

		this.message = message;
	}

	public static int getTypeOne() {
		return TYPE_ONE;
	}

	public static int getTypeTwo() {
		return TYPE_TWO;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
