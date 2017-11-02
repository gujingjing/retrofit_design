package gjj.retrofit.design.convert

import gjj.retrofit.design.log_e

/**
 * 作者：jingjinggu on 2017/11/1 14:27
 * 邮箱：gujj512@163.com
 */
public class OkhttpCall:RetrofitCall{

    override fun excute(): String {
        return "OkhttpCall-excute"
    }

    override fun enqueue(): String {
        return "OkhttpCall-enqueue"
    }

    override fun cancel() {
        log_e("OkhttpCall-cancel")
    }

}