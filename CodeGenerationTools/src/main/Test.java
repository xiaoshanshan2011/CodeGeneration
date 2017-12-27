package main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import bean.UrlBean;
import bean.UrlBean.DataBean;
import utils.CodeGenerationUtils;
import utils.FileUtil;
import utils.TimeUtils;

public class Test {

	public static void main(String[] args) {

		String path = "file/url.json";
		CodeGenerationUtils.generationHttpService(path, TimeUtils.getCurrentTime());

		String path2 = "file/fg.json";
		CodeGenerationUtils.generationFgLayout(path2);

	}

}
