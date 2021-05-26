package com.yueqin.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtil {
	
	public static Object invoke(Object target,String methodName,Object... args) {
		
		Object result = null;
		Method method = null;
		try {
		  if(args != null && args.length > 0 ) {
			  method = target.getClass().getMethod(methodName, Object.class);
		  }else {
			  method = target.getClass().getMethod(methodName);
		  }
		  result = method.invoke(target, args);	
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
		}
		
		return result;
		
	}

}
