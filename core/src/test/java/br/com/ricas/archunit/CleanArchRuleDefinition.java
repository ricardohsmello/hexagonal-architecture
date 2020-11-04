package br.com.ricas.archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.ricas")
class CleanArchRuleDefinition {

    @Test
    public void model_should_only_be_accessed_by_model() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("br.com.ricas");

        ArchRule myRule = classes()
                .that().resideInAPackage("br.com.ricas.model..")
                .should().onlyBeAccessed().byAnyPackage("br.com.ricas.model..");

        myRule.check(importedClasses);
    }
}
