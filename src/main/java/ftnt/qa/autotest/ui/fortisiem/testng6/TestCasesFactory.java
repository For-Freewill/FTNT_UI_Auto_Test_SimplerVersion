package ftnt.qa.autotest.ui.fortisiem.testng6;

public class TestCasesFactory extends InjectFactory {
	
    @Override
    protected void configure() {
//绑定实例对象
        bind(TestGuice.class).toInstance(new TestGuice());//使用后面的类
////绑定类
//			bind(TestGuice.class).to(TestGuice.class);
//        //bind绑定需要注入
//    }
}
}