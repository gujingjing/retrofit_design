package gjj.retrofit.design

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gjj.retrofit.design.adapter.AndroidCallAdapter
import gjj.retrofit.design.adapter.RxJavaCallAdapter
import gjj.retrofit.design.builder.Retrofit
import gjj.retrofit.design.convert.OkChangeCall
import gjj.retrofit.design.convert.OkhttpCall
import gjj.retrofit.design.convert.RetrofitCall
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //建造者
        tv_builder.setOnClickListener {

            var retrofit= Retrofit.RetrofitBuilder()
                    .base_url("http://www.baidu.com")
                    .callAdapterFactory("callAdapterFactory")
                    .convertapterFactory("convertapterFactory")
                    .client("client")
                    .build()

            toast(retrofit.toString())
        }

        //依赖倒置
        tv_convert.setOnClickListener {

            var call: RetrofitCall=OkhttpCall()
//            call=OkChangeCall()

            log_e(call.enqueue())

        }

        //适配器模式
        tv_adapter.setOnClickListener {

            //rxjavaAdapter
            RxJavaCallAdapter("rxjavaAdapter").adapt()
            //androidAdapter
            AndroidCallAdapter("androidAdapter").adapt()
        }

    }
}
