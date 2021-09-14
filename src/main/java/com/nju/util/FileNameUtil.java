package com.nju.util;

import java.util.UUID;

public class FileNameUtil {
	public static String getNewFileName(String oldName) {
		//构造函数专门生成文件名
		return UUID.randomUUID().toString().replace("-", "")+"-"+oldName;
	}

}
