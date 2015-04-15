package reflection.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demoReflect {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class<?> hello1 = null;
		try {
			hello1 = Class.forName(helloReflect.class.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Method methods[] = hello1.getMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}

		Method setName;
		try {
			setName = hello1.getMethod("setName", String.class);
			setName.invoke(hello1.newInstance(), "Leo");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("reflection.test.helloReflect");
		
		Constructor cons = clazz.getConstructor((Class[])null);
		
		
		
		
	}

}
