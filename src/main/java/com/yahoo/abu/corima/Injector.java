package com.yahoo.abu.corima;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;


public class Injector {
    private Hashtable<Cond, Object> ruleTable;
    
    public Injector(Hashtable<Cond, Object> ruleTable) {
        this.ruleTable = ruleTable;
    }

    public <T> T getInstance(Class<T> fromClazz) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        // resolve binding
        Cond cond = new Cond(fromClazz);
        Class<T> toClass  = (Class<T>) this.ruleTable.get(cond);
        
        // construct instance
        Constructor<T> constructor = getAnnotatedConstructor(toClass);
        if(constructor==null) { //if there is no injection, use default constructor
            return toClass.newInstance();
        } else { // annotated constructor found 
            Class<?>[] paramClazzs = constructor.getParameterTypes();
            Object[] params = new Object[paramClazzs.length];
            for(int i=0; i<paramClazzs.length; i++) {
                params[i] = this.getInstance(paramClazzs[i]);
            }
            return constructor.newInstance(params);
        }
    }

    private <T> Constructor<T> getAnnotatedConstructor(Class<T> clazz) {
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
        for(Constructor<T> constructor : constructors) {
            if(constructor.isAnnotationPresent(Inject.class))
                return (Constructor<T>) constructor;
        }

        return null;
    }
}
