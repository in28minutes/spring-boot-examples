package com.in28minutes.springboot.support;


import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class Helper
{

    public static Object getRandVal(Class<?> fieldType) {
        Random random = new Random();
        if (fieldType.equals(String.class)) {
            return UUID.randomUUID().toString();
        } else if (Date.class.isAssignableFrom(fieldType)) {
            return Date.from(Instant.now().plus(Duration.ofDays(1 + new Random().nextInt(364))));
        } else if (Number.class.isAssignableFrom(fieldType)) {
            return random.nextInt(Byte.MAX_VALUE) + 1;
        } else if (fieldType.equals(Integer.TYPE)) {
            return random.nextInt(300);
        } else if (fieldType.equals(Long.TYPE)) {
            return random.nextInt();
        }
        else if(fieldType.equals(Double.TYPE))
        {
            return random.nextDouble();
        }
        else if (Enum.class.isAssignableFrom(fieldType)) {
            Object[] enumValues = fieldType.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        }
        else if(Set.class.isAssignableFrom(fieldType))
            return new HashSet<>();
        else if(List.class.isAssignableFrom(fieldType))
        {
            return new ArrayList<>();
        }
        else
            return null;
    }

    public static Object populate(Class cls)
    {


        Object _internal = null;
        try {
            _internal = cls.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return populate(_internal,cls);
    }

    private static Object populate(Object obj, Class cls)
    {
        Field[] objectFields= cls.getDeclaredFields();

        for(Field field:objectFields)
        {
            try {
                field.setAccessible(true);
                field.set(obj, getRandVal(field.getType()));
            }

            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
        }
        return obj;
    }



}
