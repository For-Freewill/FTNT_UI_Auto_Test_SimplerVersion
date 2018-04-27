package ftnt.qa.autotest.ui.fortisiem.testng6;

import java.lang.reflect.Constructor;

import org.testng.IObjectFactory;
import org.testng.internal.ObjectFactoryImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class InjectFactory extends AbstractModule implements IObjectFactory {

    public ObjectFactoryImpl creator = new ObjectFactoryImpl();
    private Injector injector;
    public InjectFactory(){
        injector = Guice.createInjector(this);
    }

    @Override
    public Object newInstance(Constructor constructor, Object... params) {
        Object o = creator.newInstance(constructor,params);
        System.out.println("create test :"+o);
        injector.injectMembers(o);
        return injector;
    }
}