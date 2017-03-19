package com.appknox.cleancode.inspectionprovider;

import com.appknox.cleancode.codeinspection.CheckShortMethodName;
import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckShortMethodNameProvider implements InspectionToolProvider {
    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{CheckShortMethodName.class};
    }
}