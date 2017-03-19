package com.appknox.cleancode.inspectionprovider;

import com.intellij.codeInspection.InspectionToolProvider;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckNumberOfArgumentsInFuntionProvider implements InspectionToolProvider {
    @Override
    public Class[] getInspectionClasses() {
        return new Class[]{CheckNumberOfArgumentsInFuntionProvider.class};
    }
}
