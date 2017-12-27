package main;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;

import bean.StringBean;
import bean.StringBean.WordsResultBean;
import utils.ChineseInital;
import utils.ImageToTextUtils;

public class ImageToText {

	public static void main(String[] args) {
		// 参数为本地图片路径
		String path = "/home/shan/桌面/share/设计稿/三宝/应用三宝/我的中心.png";
		ImageToTextUtils.start(path);
	}

}
