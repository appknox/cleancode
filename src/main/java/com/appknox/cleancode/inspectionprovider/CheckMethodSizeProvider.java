package com.appknox.cleancode.inspectionprovider;

import com.appknox.cleancode.codeinspection.CheckMethodSize;
import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckMethodSizeProvider implements InspectionToolProvider {
    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{CheckMethodSize.class};
    }
}
