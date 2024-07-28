package com.bhumika.db;

public class SIdGetSet {
static int sid;
static String serviceCode;

public static String getServiceCode() {
	return serviceCode;
}

public static void setServiceCode(String serviceCode) {
	SIdGetSet.serviceCode = serviceCode;
}

public static int getSmanId() {
	return sid;
}

public static void setSmanId(int sid) {
	SIdGetSet.sid = sid;
}
}
