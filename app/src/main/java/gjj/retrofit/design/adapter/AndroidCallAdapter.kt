package gjj.retrofit.design.adapter

import gjj.retrofit.design.log_e

/**
 * 作者：jingjinggu on 2017/11/2 14:48
 * 邮箱：gujj512@163.com
 */
class AndroidCallAdapter :CallAdapter {

    var adapterName: String=""

    constructor(adapterName: String){
        this.adapterName=adapterName
    }

    override fun adapt() {
        log_e(adapterName)
    }
}