package gjj.retrofit.design.convert

/**
 * 作者：jingjinggu on 2017/11/1 14:24
 * 邮箱：gujj512@163.com
 */
interface RetrofitCall {

    fun excute():String//同步请求网络
    fun enqueue():String//异步请求网络
    fun cancel()//取消网络请求

}