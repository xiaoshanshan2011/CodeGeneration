package utils;

import java.util.List;
import java.util.Random;

import com.google.gson.Gson;

import bean.FgBean;
import bean.UrlBean;
import bean.UrlBean.DataBean;

public class CodeGenerationUtils {
	private static final String TAG1 = "//";
	private static final String TAG2 = "\n";
	private static final String TAG3 = "@Streaming";
	private static final String TAG4 = "@GET(\"";
	private static final String TAG5 = "\")";
	private static final String TAG6 = "Observable<";
	private static final String TAG7 = "Bean> ";
	private static final String TAG8 = "(@QueryMap Map<String, String> params);";

	private static final String TAG9 = "@FormUrlEncoded";
	private static final String TAG10 = "@POST(\"";
	private static final String TAG11 = "(@FieldMap Map<String, String> params);";

	/*
	 * //用户登录
	 * 
	 * @FormUrlEncoded
	 * 
	 * @POST("api/ldb/login") Observable<LoginBean> login(@FieldMap Map<String,
	 * String> params);
	 */

	/*
	 * @Streaming
	 * 
	 * @GET("api/ldb/ebaoData") Observable<EbaoDataBean> ebaoData(@QueryMap
	 * Map<String, String> params);
	 */

	/**
	 * Generation HttpService code
	 * 
	 * @param path
	 * @return
	 */
	public static void generationHttpService(String path, String time) {
		String data = FileUtil.readFileToString(path, "utf8");
		UrlBean urlBean = new Gson().fromJson(data, UrlBean.class);
		String content = "";
		for (int i = 0; i < urlBean.getData().size(); i++) {
			DataBean dataBean = urlBean.getData().get(i);
			String name;
			if (dataBean.getUrl().contains("/")) {
				String[] beanNames = dataBean.getUrl().split("/");
				name = beanNames[beanNames.length - 1];
			} else {
				name = dataBean.getUrl();
			}
			String beanName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
			if (dataBean.getType().equals("get")) {
				content = content + TAG1 + dataBean.getName() + TAG2 + TAG3 + TAG2 + TAG4 + dataBean.getUrl() + TAG5
						+ TAG2 + TAG6 + beanName + TAG7 + name + TAG8 + TAG2 + TAG2;
			} else if (dataBean.getType().equals("post")) {
				content = content + TAG1 + dataBean.getName() + TAG2 + TAG9 + TAG2 + TAG10 + dataBean.getUrl() + TAG5
						+ TAG2 + TAG6 + beanName + TAG7 + name + TAG11 + TAG2 + TAG2;
			}
			generationBeanFile(beanName, dataBean.getName(), time);
		}
		FileUtil.writeFileFromInputStream(FileUtil.readString(content), "bean/" + time + "/AAA_HttpService.java");
	}

	public static final String TAG21 = "package com.app.sanbao.bean;\n" + "\n" + "import com.app.sanbao.net.BaseBean;\n"
			+ "\n" + "/**\n" + " * ";
	public static final String TAG22 = " * Created by chenjunshan on ";
	public static final String TAG23 = "Bean extends BaseBean{\n" + "\n" + "}";
	public static final String TAG24 = "/";
	public static final String TAG25 = "Bean.java";
	public static final String TAG26 = ".\n" + " */\n" + "\n" + "public class ";

	/**
	 * 生成Bean文件
	 */
	public static void generationBeanFile(String beanName, String name, String time) {
		FileUtil.writeFileFromInputStream(
				FileUtil.readString(
						TAG21 + name + "\n" + TAG22 + TimeUtils.getTime("yyyy-MM-dd") + TAG26 + beanName + TAG23),
				"bean/" + time + TAG24 + beanName + TAG25);
	}

	public static final String TAG38 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
			+ "<layout xmlns:android=\"http://schemas.android.com/apk/res/android\">\n" + "\n" + "    <LinearLayout\n"
			+ "        android:layout_width=\"match_parent\"\n" + "        android:layout_height=\"match_parent\"\n"
			+ "        android:orientation=\"vertical\">\n" + "\n" + "    </LinearLayout>\n" + "</layout>";
	private static final String TAG51 = "package ";
	private static final String TAG52 = ";\n" + "\n" + "import android.os.Bundle;\n"
			+ "import android.support.annotation.Nullable;\n" + "import android.view.View;\n" + "\n" + "import ";
	private static final String TAG53 = ".R;\n" + "import ";
	private static final String TAG54 = ".contract.";
	private static final String TAG55 = "Contract;\n" + "import ";
	private static final String TAG56 = ".databinding.Fg";
	private static final String TAG57 = "LayoutBinding;\n" + "import ";
	private static final String TAG58 = ".net.BaseBean;\n" + "import ";
	private static final String TAG59 = ".presenter.";
	private static final String TAG60 = "Presenter;\n" + "import ";
	private static final String TAG61 = ".ui.BaseFragment;\n" + "\n" + "/**\n" + " * ";
	private static final String TAG62 = "\n" + " * Created by ";
	private static final String TAG63 = " on ";
	private static final String TAG64 = ".\n" + " */\n" + "\n" + "public class ";
	private static final String TAG65 = "Fragment extends BaseFragment<Fg";
	private static final String TAG66 = "LayoutBinding, Object> implements ";
	private static final String TAG67 = "Contract.View {\n" + "    private ";
	private static final String TAG68 = "Presenter presenter;\n" + "\n" + "    @Override\n"
			+ "    public int bindLayout() {\n" + "        return R.layout.fg_";
	private static final String TAG69 = "_layout;\n" + "    }\n" + "\n" + "    @Override\n"
			+ "    public void initTitleBar() {\n" + "        super.initTitleBar();\n" + "\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    public void initOnCreate(@Nullable Bundle savedInstanceState) {\n"
			+ "        super.initOnCreate(savedInstanceState);\n" + "        presenter = new ";
	private static final String TAG70 = "Presenter(getActivity(), this);\n" + "\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    protected void initEvent() {\n" + "        super.initEvent();\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onSuccess(BaseBean baseBean, int mTag) {\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onFailure(Throwable e, int mTag) {\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onClick(View view) {\n"
			+ "        super.onClick(view);\n" + "        switch (view.getId()) {\n" + "\n" + "        }\n" + "    }\n"
			+ "\n" + "    @Override\n" + "    public void onDestroy() {\n" + "        super.onDestroy();\n"
			+ "        presenter.cancelAllRequest();\n" + "    }\n" + "}\n" + "";
	// 列表
	private static final String TAG71 = "Presenter presenter;\n" + "\n" + "    @Override\n"
			+ "    public int bindItemLayout() {\n" + "        return R.layout.fg_";
	private static final String TAG72 = "Presenter(getActivity(), this);\n" + "\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    protected void initEvent() {\n" + "        super.initEvent();\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onSuccess(BaseBean baseBean, int mTag) {\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onFailure(Throwable e, int mTag) {\n" + "\n"
			+ "    }\n" + "\n" + "    @Override\n" + "    public void onClick(View view) {\n"
			+ "        super.onClick(view);\n" + "        switch (view.getId()) {\n" + "\n" + "        }\n" + "    }\n"
			+ "\n" + "    @Override\n" + "    public void onDestroy() {\n" + "        super.onDestroy();\n"
			+ "        presenter.cancelAllRequest();\n" + "    }\n" + "\n" + "    @Override\n"
			+ "    protected void initData() {\n" + "        super.initData();\n"
			+ "        List<Object> data = new ArrayList<>();\n" + "        for (int i = 0; i < 15; i++) {\n"
			+ "            data.add(\"\");\n" + "        }\n" + "        setData(data);\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    protected void getListVewItem(Fg";
	private static final String TAG73 = "ItemLayoutBinding, Object> implements ";
	private static final String TAG74 = "ItemLayoutBinding binding, Object item, int position) {\n"
			+ "        super.getListVewItem(binding, item, position);\n" + "\n" + "    }\n" + "\n" + "    @Override\n"
			+ "    public void onRefresh() {\n" + "        super.onRefresh();\n" + "\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    public void onLoadMore() {\n" + "        super.onLoadMore();\n" + "\n"
			+ "    }\n" + "}\n" + "";
	private static final String TAG75 = "_item_layout;\n" + "    }\n" + "\n" + "    @Override\n"
			+ "    public void initTitleBar() {\n" + "        super.initTitleBar();\n" + "\n" + "    }\n" + "\n"
			+ "    @Override\n" + "    public void initOnCreate(@Nullable Bundle savedInstanceState) {\n"
			+ "        super.initOnCreate(savedInstanceState);\n" + "        presenter = new ";
	private static final String TAG76 = "ItemLayoutBinding;\n" + "import ";
	private static final String TAG77 = ".ui.BaseFragment;\n" + "\n" + "import java.util.ArrayList;\n"
			+ "import java.util.List;\n" + "\n" + "/**\n" + " * ";
	// 生成Presenter文件
	private static final String TAG81 = ".presenter;\n" + "\n" + "import android.content.Context;\n" + "\n" + "import ";
	private static final String TAG82 = ".net.HttpRequest;\n" + "\n" + "/**\n" + " * ";
	private static final String TAG83 = "Presenter extends HttpRequest implements ";
	private static final String TAG84 = "Contract.Presenter {\n" + "    private Context context;\n" + "    private ";
	private static final String TAG85 = "Contract.View view;\n" + "\n" + "    public ";
	private static final String TAG86 = "Presenter(Context context, ";
	private static final String TAG87 = "Contract.View view) {\n" + "        this.context = context;\n"
			+ "        this.view = view;\n" + "    }\n" + "\n" + "}\n" + "";
	// 生成Contract文件
	private static final String TAG88 = ".contract;\n" + "\n" + "/**\n" + " * ";
	private static final String TAG89 = ".\n" + " */\n" + "\n" + "public interface ";
	private static final String TAG90 = "Contract {\n" + "    interface Model {\n" + "    }\n" + "\n"
			+ "    interface View extends BaseView{\n" + "    }\n" + "\n" + "    interface Presenter {\n" + "    }\n"
			+ "}\n" + "";
	private static final String TAG91 = "";

	/**
	 * 生成Fragment和layout文件
	 */
	public static void generationFgLayout(String path) {
		String time = TimeUtils.getCurrentTime();
		String time2 = TimeUtils.getTime("yyyy-MM-dd");
		String data = FileUtil.readFileToString(path, "utf8");
		FgBean fgBean = new Gson().fromJson(data, FgBean.class);
		String author = fgBean.getAuthor();// 作者
		String pakegeName = fgBean.getPakege();// 包名
		for (int i = 0; i < fgBean.getData().size(); i++) {
			List<FgBean.DataBean.MenuBean> menuBeans = fgBean.getData().get(i).getMenu();
			String mPath = fgBean.getData().get(i).getPath();// 生成文件路径
			String pakegeName2 = mPath.replaceAll("/", ".");// 与pakegeName拼接
			for (int j = 0; j < menuBeans.size(); j++) {
				FgBean.DataBean.MenuBean mBean = menuBeans.get(j);
				String name = mBean.getName();// 文件名
				String title = mBean.getTitle();
				String fgName = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
				// 生成Fragment文件
				String fgContent = "";
				if (mBean.isIsList()) {
					fgContent = TAG51 + pakegeName + "." + pakegeName2 + TAG52 + pakegeName + TAG53 + pakegeName + TAG54
							+ fgName + TAG55 + pakegeName + TAG56 + fgName + TAG76 + pakegeName + TAG58 + pakegeName
							+ TAG59 + fgName + TAG60 + pakegeName + TAG77 + title + TAG62 + author + TAG63 + time2
							+ TAG64 + fgName + TAG65 + fgName + TAG73 + fgName + TAG67 + fgName + TAG71 + name + TAG75
							+ fgName + TAG72 + fgName + TAG74;
				} else {
					fgContent = TAG51 + pakegeName + "." + pakegeName2 + TAG52 + pakegeName + TAG53 + pakegeName + TAG54
							+ fgName + TAG55 + pakegeName + TAG56 + fgName + TAG57 + pakegeName + TAG58 + pakegeName
							+ TAG59 + fgName + TAG60 + pakegeName + TAG61 + title + TAG62 + author + TAG63 + time2
							+ TAG64 + fgName + TAG65 + fgName + TAG66 + fgName + TAG67 + fgName + TAG68 + name + TAG69
							+ fgName + TAG70;
				}
				FileUtil.writeFileFromInputStream(FileUtil.readString(fgContent),
						"fragment/" + time + "/" + mPath + "/" + fgName + "Fragment.java");
				// 生成Layout文件
				if (mBean.isIsList()) {
					FileUtil.writeFileFromInputStream(FileUtil.readString(TAG38),
							"layout/" + time + "/fg_" + name + "_item_layout.xml");
				} else {
					FileUtil.writeFileFromInputStream(FileUtil.readString(TAG38),
							"layout/" + time + "/fg_" + name + "_layout.xml");
				}
				// 生成Presenter文件
				String ptContent = "";
				ptContent = TAG51 + pakegeName + TAG81 + pakegeName + TAG54 + fgName + TAG55 + pakegeName + TAG82
						+ title + TAG62 + author + TAG63 + time2 + TAG64 + fgName + TAG83 + fgName + TAG84 + fgName
						+ TAG85 + fgName + TAG86 + fgName + TAG87;
				FileUtil.writeFileFromInputStream(FileUtil.readString(ptContent),
						"fragment/" + time + "/presenter/" + fgName + "Presenter.java");
				// 生成Contract文件
				String ctContent = "";
				ctContent = TAG51 + pakegeName + TAG88 + title + TAG62 + author + TAG63 + time2 + TAG89 + fgName
						+ TAG90;
				FileUtil.writeFileFromInputStream(FileUtil.readString(ctContent),
						"fragment/" + time + "/contract/" + fgName + "Contract.java");
			}

		}
	}

}
