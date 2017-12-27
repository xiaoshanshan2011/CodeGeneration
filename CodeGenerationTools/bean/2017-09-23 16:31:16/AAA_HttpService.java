//版本升级信息
@Streaming
@GET("api/upgradeApk")
Observable<UpgradeApkBean> upgradeApk(@QueryMap Map<String, String> params);

