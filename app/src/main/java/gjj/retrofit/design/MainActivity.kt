package gjj.retrofit.design

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gjj.retrofit.design.builder.Retrofit
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_builder.setOnClickListener {

            var retrofit= Retrofit.RetrofitBuilder()
                    .base_url("http://www.baidu.com")
                    .callAdapterFactory("callAdapterFactory")
                    .convertapterFactory("convertapterFactory")
                    .client("client")
                    .build()

            toast(retrofit.toString())
        }

    }
}
