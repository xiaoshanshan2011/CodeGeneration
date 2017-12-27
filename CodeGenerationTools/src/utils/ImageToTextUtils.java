package utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.events.StartDocument;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;

import bean.StringBean;
import bean.StringBean.WordsResultBean;

public class ImageToTextUtils {
	// public static final String APP_ID = "10175298";
	// public static final String API_KEY = "SnwkrA1aZFu9bzruVCHeQxUp";
	// public static final String SECRET_KEY = "gb5kota0OrQpRGQP6sB1z3tlCBE7sEuQ";

	public static final String APP_ID = "10176622";
	public static final String API_KEY = "Hi1NjRbM2S2mGGRLWUn7NWTU";
	public static final String SECRET_KEY = "DubKzdyvGs8fPQm4fheLHkNgD93S8zGy";
	private static AipOcr client;
	private static StringBuilder sb;

	public static final String TAG1 = "<string name=\"str_";
	public static final String TAG2 = "\">";
	public static final String TAG3 = "</string>\n";

	/**
	 * 开始执行
	 * 
	 * @param path
	 */
	public static void start(String path) {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				sb = new StringBuilder();
				client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
				// 可选：设置网络连接参数
				client.setConnectionTimeoutInMillis(2000);
				client.setSocketTimeoutInMillis(60000);
				if (!FileUtils.isFileExists(path)) {
					System.out.println("文件不存在");
					return;
				}
				if (FileUtils.isFile(path)) {
					iamgeToText(path);
				} else if (FileUtils.isDir(path)) {
					List<File> files = FileUtils.listFilesInDir(path, true);
					if (files != null && files.size() > 0) {
						for (int i = 0; i < files.size(); i++) {
							File file = files.get(i);
							if (file.isFile()) {
								iamgeToText(file.getAbsolutePath());
							}
						}
					}
				}
				System.out.println(sb.toString());
			}
		}.start();
	}

	/**
	 * 获取图片中的文字
	 * 
	 * @param path
	 */
	private static void iamgeToText(String path) {
		// 通用文字识别高精度版
		JSONObject data = client.basicAccurateGeneral(path, new HashMap<String, String>());
		StringBean bean = new Gson().fromJson(data.toString(), StringBean.class);
		List<WordsResultBean> list = bean.getWords_result();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				WordsResultBean resultBean = list.get(i);
				String word = resultBean.getWords();
				if (isContainChinese(word) && !sb.toString().contains(word)) {
					String name = ChineseInital.getAllFirstLetter(word);
					sb.append(TAG1 + name + TAG2 + word + TAG3);
				}
			}
		} else if (data.toString().contains("error_msg")) {
			// 开放api每日请求限制达到
			System.out.println("开放api每日请求限制达到：" + data.toString());
		}
	}

	/**
	 * 是否含有中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}
}
