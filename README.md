###1. 建造者模式
一个对象，如果他的属性多而复杂，我们在创建赋值该对象的属性的时候就比较麻烦，这时候如果有一个统一管理这些属性的地方就好了。建造者模式，就可以很好的充当这个角色。
建造者，是将对象的属性分装在内部，方便调用者去使用，统一管理。就拿著名的Retrofit来看，在retrofit 内部有一个Builder对象，统一管理者retrofit创建所需要的参数。伪代码如下:

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
		    }
		}

在创建retrofit对象的时候，可以使用RetrofitBuilder对象来设置，最后通过builder方法，返回我们想要的Retrofit对象。

总结:建造者模式，主要是为了更加方便我们去统一创建管理对象的属性。

###2.依赖倒置模式
>高层模块不应该依赖低层模块，二者都应该依赖其抽象；抽象不应该依赖细节；细节应该依赖抽象。

我个人的理解，其实就是接口抽象出具体的细节方法，retrofit的OkhttpCall就是这种模式，内部实现了retrofit2.Call，实际内部实现网络call还是使用的okhttp3.call。我们来仿照写一个例子:

![convert.jpeg](http://upload-images.jianshu.io/upload_images/1387450-a4665856ff2919bb.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- RetrofitCall就是retrofit.call借口，定义了网络方面相关接口。
- OkhttpCall是retrofitCall的实现类，类似OkhttpCall，retrofit默认的网络请求类，其内部实现是通过okhttp.call实现的
- OkchangeCall也是retrofitCall的实现类，如果以后想换一种网络实现类，那就方便(当然现在还没有支持这个，但是接口入口已经很好的提供了扩展性)

总结:依赖倒置，本质是面向接口编程，很好的解耦了对象和对象之间的关系，最上层业务层的实现类内部可以做很多的扩展，但是它的核心功能都是一样的，就是接口类暴露出的方法。


###3. 适配器模式
rxjava中使用callAdapter和convertAdapter来进行适配。就拿callAdapter来举例说明。
callAdapter在ServiceMethod.build()方法中，根据接口中定义的返回类型去遍历callAdapterFactoryList来尝试创建指定的callAdapter。

这是一种对象适配模式，将我们原有的返回类型根据适配器生成不同的网络请求对象。
适配器的两种模式，可以参考这篇文章[android适配器模式](http://blog.qiji.tech/archives/5692)

![Adapter.jpeg](http://upload-images.jianshu.io/upload_images/1387450-b47b11502f097cd0.jpeg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

###4.策略模式

>策略模式定义了一些列的算法，并将每一个算法封装起来，而且使它们还可以相互替换。策略模式让算法独立于使用它的客户而独立变换。

简单的来说，就是做某些事情可能同时有多个方案，不同的时期使用不同的方案，怎样在调用的过程中尽可能的减少代码的修改。主要还是使用java的多态。

在retrofit中，RxjavaCallAdapter中使用了策略模式，分为三种不同的adapte
1. simpleAdapter
          正常的网络请求对象的返回，返回类型中不会包含response请求结果
2. ResponseCallAdapter
3. ResultCallAdapter这两个adapter在转化返回请求的时候，都会将response结果包装返回，可以方便开发人员获取到返回code



###5.装饰模式
装饰模式又称包装模式，就是在原来的类上做一些扩展，使得新的对象比原来的对象功能上更加丰富。








###引用
[Retrofit分析-漂亮的解耦套路](http://www.jianshu.com/p/45cb536be2f4)

[Retrofit分析-经典设计模式案例](http://www.jianshu.com/p/fb8d21978e38)

[从架构角度看Retrofit的作用、原理和启示](http://www.jianshu.com/p/f57b7cdb1c99)

[你真的会用Retrofit2吗?Retrofit2完全教程](http://www.jianshu.com/p/308f3c54abdd)
