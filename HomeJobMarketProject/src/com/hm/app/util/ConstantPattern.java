package com.hm.app.util;

import java.text.SimpleDateFormat;

public class ConstantPattern {
	public  final String namePattern = "^[A-Za-z]+";
	public  final  String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,})$";
	public final String phonePattern = "^[7-9]\\d{9}$";
	public final String datePattern = "/[00-23]:[00-59]";
	public final static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

}
