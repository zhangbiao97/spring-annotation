package com.spring.custom;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //
        return new String[]{"com.spring.entity.Blue","com.spring.entity.Red"};
    }

}
