package com.appknox.cleancode.codeinspection;

import com.intellij.codeInspection.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckNumberOfArgumentsInFunction extends BaseJavaLocalInspectionTool {

    private final CheckNumberOfArgumentsInFunctionFix checkNumberOfArgumentsInFunctionFix = new CheckNumberOfArgumentsInFunctionFix();
    private final String checkNumberOfArgumentsInFunctionTemplate = "Check Number Of Arguments In Function";
    @NotNull
    public String getDisplayName() {
        return "Check Number Of Arguments in Function";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "CheckNumberOfArgumentsInFunction";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            @Override
            public void visitMethod(PsiMethod method) {
                super.visitMethod(method);
                if(method.getParameterList().getParametersCount()>2){
                    holder.registerProblem(method.getParameterList(), checkNumberOfArgumentsInFunctionTemplate, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkNumberOfArgumentsInFunctionFix);
                }
            }
        };
    }
    private static class CheckNumberOfArgumentsInFunctionFix implements LocalQuickFix {

        @Nls
        @NotNull
        @Override
        public String getName() {
            return "";
        }

        @Nls
        @NotNull
        @Override
        public String getFamilyName() {
            return getName();
        }

        @Override
        public void applyFix(@NotNull final Project project, @NotNull ProblemDescriptor descriptor) {

        }
    }

    public boolean isEnabledByDefault() {
        return true;
    }
}

