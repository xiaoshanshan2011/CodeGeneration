//流转钱包转账
@FormUrlEncoded
@POST("api/incomeAmount")
Observable<IncomeAmountBean> incomeAmount(@FieldMap Map<String, String> params);

//流转钱包数据
@Streaming
@GET("api/incunt")
Observable<IncuntBean> incunt(@QueryMap Map<String, String> params);

