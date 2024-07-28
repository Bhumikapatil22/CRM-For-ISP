package com.bhumika.db;

public class CIdGetSet {
static int cid;
static String cmobile;
static String caddress;
static int comp_id;


public static int getComp_id() {
	return comp_id;
}

public static void setComp_id(int comp_id) {
	CIdGetSet.comp_id = comp_id;
}



public static int getCustId() {
	return cid;
}

public static void setCustId(int cid) {
	CIdGetSet.cid = cid;
}

public static String getCmobile() {
	return cmobile;
}

public static void setCmobile(String cmobile) {
	CIdGetSet.cmobile = cmobile;
}

public static String getCaddress() {
	return caddress;
}

public static void setCaddress(String caddress) {
	CIdGetSet.caddress = caddress;
}
}

