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
public class CheckMethodSize extends BaseJavaLocalInspectionTool {

    private final CheckMethodSizeFix checkMethodSizeFix = new CheckMethodSizeFix();
    private final String checkMethodSizetemplate = "Check Method Size";
    @NotNull
    public String getDisplayName() {
        return "Check Method Size";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "CheckMethodSize";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            @Override
            public void visitMethod(PsiMethod method) {
                super.visitMethod(method);
                if(method.getBody().getStatements().length>20){
                    holder.registerProblem(method, checkMethodSizetemplate, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkMethodSizeFix);
                }
            }
        };
    }
    private static class CheckMethodSizeFix implements LocalQuickFix {

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

