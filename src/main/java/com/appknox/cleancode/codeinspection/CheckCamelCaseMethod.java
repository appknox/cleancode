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
public class CheckCamelCaseMethod extends BaseJavaLocalInspectionTool {

    private final CheckCamelCaseMethodFix checkCamelCaseMethodFix = new CheckCamelCaseMethodFix();
    private final String checkCamelCaseMethodTemplate = "Camel Case Method";
    @NotNull
    public String getDisplayName() {
        return "Camel Case Method";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "CamelCaseMethod";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            public void visitMethod(PsiMethod method) {
                super.visitElement(method);
                if(method.getName().charAt(0)<'a' || method.getName().charAt(0)>'z'){
                    holder.registerProblem(method.getNameIdentifier(), checkCamelCaseMethodTemplate, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkCamelCaseMethodFix);
                }
            }
        };
    }
    private static class CheckCamelCaseMethodFix implements LocalQuickFix {

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
