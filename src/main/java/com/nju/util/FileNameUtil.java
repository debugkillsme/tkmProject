package com.nju.util;

import java.util.UUID;

public class FileNameUtil {
	public static String getNewFileName(String oldName) {
		//���캯��ר�������ļ���
		return UUID.randomUUID().toString().replace("-", "")+"-"+oldName;
	}

}
