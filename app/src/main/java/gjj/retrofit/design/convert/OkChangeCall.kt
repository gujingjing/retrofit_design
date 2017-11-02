package gjj.retrofit.design.convert

import gjj.retrofit.design.log_e

/**
 * 作者：jingjinggu on 2017/11/1 14:34
 * 邮箱：gujj512@163.com
 */
class OkChangeCall :RetrofitCall {

    override fun excute(): String {
        return "OkChangeCall-excute"
    }

    override fun enqueue(): String {
        return "OkChangeCall-enqueue"
    }

    override fun cancel() {
        log_e("OkChangeCall-cancel")
    }
}