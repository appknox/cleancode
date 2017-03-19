package com.appknox.cleancode.inspectionprovider;

import com.appknox.cleancode.codeinspection.CheckPascalCaseClassName;
import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckPascalCaseClassProvider implements InspectionToolProvider {
    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{CheckPascalCaseClassName.class};
    }
}