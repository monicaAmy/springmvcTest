package com.su.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BeanFactory
{

    private List<BeanDefined> beanDefinedList;

    public Object getBean(String beanId)
    {
        Object instance;
        try
        {
            for (BeanDefined beanObj : beanDefinedList)
            {
                if (beanId.equals(beanObj.getBeanId()))
                {
                    String classPath = beanObj.getClassPath();
                    Class classFile = Class.forName(classPath);
                    //在默认情况下，Spring工厂是通过调用当前类默认工作方法创建实例对象
                    instance = classFile.newInstance();
                    return instance;
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
