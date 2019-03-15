package com.spring.custom;

import com.spring.entity.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean b1 = beanDefinitionRegistry.containsBeanDefinition("com.spring.entity.Blue");
        boolean b2 = beanDefinitionRegistry.containsBeanDefinition("com.spring.entity.Red");
        if(b1 && b2){
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            beanDefinitionRegistry.registerBeanDefinition("rainBow",rootBeanDefinition);
        }

    }

}
