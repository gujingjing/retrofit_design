package gjj.retrofit.design.builder

/**
 *  * 作者：jingjinggu on 2017/10/31 23:02
 *  * 邮箱：gujj512@163.com
 *  
 */
class Retrofit {

    private var base_url:String?=""
    private var callAdapterFactory:String?=""
    private var convertapterFactory:String?=""
    private var client:String?=""

    constructor(base_url:String?,callAdapterFactory:String?,convertapterFactory:String?,client:String?){
        this.base_url=base_url
        this.callAdapterFactory=callAdapterFactory
        this.convertapterFactory=convertapterFactory
        this.client=client
    }

    class RetrofitBuilder {

        private var base_url:String?=""
        private var callAdapterFactory:String?=""
        private var convertapterFactory:String?=""
        private var client:String?=""

        constructor()

        fun client(client:String?): RetrofitBuilder {
            this.client=client
            return this
        }

        fun base_url(base_url:String?): RetrofitBuilder {
            this.base_url=base_url
            return this
        }

        fun convertapterFactory(converdapterFactory:String?): RetrofitBuilder {
            this.convertapterFactory=convertapterFactory
            return this
        }

        fun callAdapterFactory(callAdapterFactory:String?): RetrofitBuilder {
            this.callAdapterFactory=callAdapterFactory
            return this
        }

        /**
         * 最后组装创建retrofit对象
         */
        fun build():Retrofit{

            return Retrofit(base_url,callAdapterFactory,convertapterFactory,client)
        }
    }


    override fun toString(): String {
        return "Retrofit(base_url=$base_url, callAdapterFactory=$callAdapterFactory, convertapterFactory=$convertapterFactory, client=$client)"
    }


}
