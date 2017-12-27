package main;

import utils.StringZipUtils;
import utils.ZipUtils;

public class TestString {

	public static void main(String[] args) {
		try {
			
			  StringBuilder value = new StringBuilder(); value.append("java gjjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipjava gzipzip 压缩测试"); //字符串压缩为byte数组
			  byte[] values = value.toString().getBytes();
			  System.out.println("压缩前大小:" + values.length);
			  values = StringZipUtils.compress(values); 
			  System.out.println("压缩后大小:" +values.length); // 把压缩后的byte数组转为字符串 
			  String str = new String(values,"iso8859-1"); // 传输字符串 
			  System.out.println("压缩后:" + str); // 解压缩这个byte数组
			  values = StringZipUtils.decompress(values); System.out.println("解压后:" + new
			  String(values, "utf-8"));
			 

			/*String text = "hhhhhfghsdgfsjkfhsdhfshdofsdfoidfhxsdfixdfui";
			String gzip = ZipUtils.compress(text);
			System.out.println(gzip.length() + "");
			System.out.println(gzip);
			String unzip = ZipUtils.uncompress(gzip);
			System.out.println(unzip + ":" + unzip.length());*/
		} catch (Exception e) {
		}

	}

}
