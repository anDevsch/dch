package com.dch.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexMatch {
	static public Boolean MimaisRight(String str){
		String patternStr = "[^a-zA-Z0-9.]";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return false;
        }
        else return true;
	}
	static public Boolean PhoneisRight(String str){
		String patternStr = "[0-9]{11}";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return true;
        }
        else return false;
	}
	static public Boolean AgeisRight(int str){
        if (0<=str&&str<=100) {
            return true;
        }
        else return false;
	}
	static public Boolean IdisRight(String str){
		String patternStr = "[0-9a-zA-Z]{32}";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return true;
        }
        else return false;
	}
	static public Boolean QQisRight(String str){
		String patternStr = "[0-9]{5,11}";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return true;
        }
        else return false;
	}
	static public Boolean EmailisRight(String str){
		String patternStr = "(.+)@(.+).com";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return true;
        }
        else return false;
	}
	static public Boolean StringisRight(String str){
		String patternStr = "((or)|(and)|(=)|(update)|(select)|(drop)|(from))";
		Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return false;
        }
        else return true;
	}

}
