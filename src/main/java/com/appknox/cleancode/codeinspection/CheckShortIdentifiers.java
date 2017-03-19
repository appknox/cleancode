package com.appknox.cleancode.codeinspection;

import com.intellij.codeInspection.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaElementVisitor;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiLocalVariable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by thedarkknight on 3/18/17.
 */
public class CheckShortIdentifiers extends BaseJavaLocalInspectionTool {

    private final CheckShortIdentifiersFix checkShortIdentifiersFix = new CheckShortIdentifiersFix();
    private final String checkshortidentifierstemplate = "Short Identifier";
    @NotNull
    public String getDisplayName() {
        return "Short Identifier";
    }

    @NotNull
    public String getGroupDisplayName() {
        return "Clean Code";
    }

    @NotNull
    public String getShortName() {
        return "ShortIdentifier";
    }


    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull final ProblemsHolder holder, boolean isOnTheFly) {
        return new JavaElementVisitor() {
            @Override
            public void visitLocalVariable(PsiLocalVariable variable) {
                super.visitVariable(variable);
                if(variable.getName().length()<3){
                    holder.registerProblem(variable.getNameIdentifier(), checkshortidentifierstemplate, ProblemHighlightType.LIKE_UNKNOWN_SYMBOL, checkShortIdentifiersFix);
                }
            }
        };
    }
    private static class CheckShortIdentifiersFix implements LocalQuickFix {

        @Nls
        @NotNull
        @Override
        public String getName() {
            return "Provide descriptive identifier names";
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

