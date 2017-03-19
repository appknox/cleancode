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
public class CheckShortMethodName extends BaseJavaLocalInspectionTool {

    private final CheckShortMethodNameFix checkShortMethodNameFix = new CheckShortMethodNameFix();
    private final String checkShortMethodNameTemplate = "Check Short Method Name";
    @NotNull
    public String getDisplayName() {
        return "Check Short Method Name";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "CheckShortMethodName";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            public void visitMethod(PsiMethod method) {
                super.visitElement(method);
                if(method.getName().length()<3){
                    holder.registerProblem(method.getNameIdentifier(), checkShortMethodNameTemplate, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkShortMethodNameFix);
                }
            }
        };
    }
    private static class CheckShortMethodNameFix implements LocalQuickFix {

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