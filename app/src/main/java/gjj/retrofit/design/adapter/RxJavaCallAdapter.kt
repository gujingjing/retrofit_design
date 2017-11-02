package gjj.retrofit.design.adapter

import gjj.retrofit.design.log_e

/**
 * 作者：jingjinggu on 2017/11/2 14:46
 * 邮箱：gujj512@163.com
 */
class RxJavaCallAdapter :CallAdapter {

    var adapterName: String=""

    constructor(adapterName: String){
        this.adapterName=adapterName
    }

    override fun adapt() {
        log_e(adapterName)
    }
}