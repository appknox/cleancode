package com.appknox.cleancode.codeinspection;

import com.intellij.codeInspection.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckPascalCaseClassName extends BaseJavaLocalInspectionTool {

    private final CheckPascalCaseClassFix checkPascalCaseClassFix = new CheckPascalCaseClassFix();
    private final String checkPascalCaseClassTemplate = "Check Paspacal Case Class";
    @NotNull
    public String getDisplayName() {
        return "Check Paspacal Case Class";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "CheckPaspacalCaseClass";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            @Override
            public void visitClass(PsiClass aClass) {
                super.visitElement(aClass);
                if(aClass.getName().charAt(0)<'A' || aClass.getName().charAt(0)>'Z'){
                    holder.registerProblem(aClass.getNameIdentifier(), checkPascalCaseClassTemplate,ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkPascalCaseClassFix);
                }
            }
        };
    }
    private static class CheckPascalCaseClassFix implements LocalQuickFix {

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
