package br.com.fiap.techchallenge.lanchonete;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "br.com.fiap.techchallenge.lanchonete",
        importOptions = ImportOption.DoNotIncludeTests.class)
class ArchitectureTest {

    @ArchTest
    static ArchRule repositoryInterfacesShouldResideInRepositoryPackage = classes().that().resideInAPackage("..adapters.repository.jpa")
            .should().haveSimpleNameEndingWith("Repository")
            .andShould().beAnnotatedWith(Repository.class)
            .as("Interfaces Repository devem ser criadas dentro do pacote adapters.repository.jpa");

    @ArchTest
    static ArchRule mapperClassesShouldResideInMapperPackage = classes().that().resideInAPackage("..adapters.repository.mapper")
            .and().resideInAPackage("..adapters.repository.mapper")
            .should().haveSimpleNameEndingWith("Mapper")
            .as("Classes Mapper devem ser implementadas dentro do pacote adapters.repository.mapper");

    @ArchTest
    static ArchRule entityClassesShouldResideInModelPackage = classes().that().areAnnotatedWith(Entity.class)
            .should().resideInAPackage("..adapters.repository.model")
            .as("Classes de entidade devem ser implementadas dentro do pacote adapters.repository.model");

    @ArchTest
    static ArchRule repositoryClassesShouldResideInRepositoryPackage = classes().that().resideInAPackage("..adapters.repository")
            .should().haveSimpleNameEndingWith("Repository")
            .andShould().beAnnotatedWith(Repository.class)
            .as("Classes Repository devem ser implementadas dentro do pacote adapters.repository");

    @ArchTest
    static ArchRule mapperClassesShouldResideInWebMapperPackage = classes().that().resideInAPackage("..adapters.web.mapper")
            .and().resideInAPackage("..adapters.web.mapper")
            .should().haveSimpleNameEndingWith("Mapper")
            .as("Classes Mapper devem ser implementadas dentro do pacote adapters.web.mapper");

    @ArchTest
    static ArchRule requestClassesShouldDependsClassesIn = classes().that().haveSimpleNameEndingWith("Request")
            .should().resideInAPackage("..adapters.web.models")
            .andShould().dependOnClassesThat().haveSimpleNameEndingWith("In")
            .as("Classes Request devem extender classes In");

    @ArchTest
    static ArchRule requestClassesShouldDependsClassesOut = classes().that().haveSimpleNameEndingWith("Response")
            .should().resideInAPackage("..adapters.web.models")
            .andShould().dependOnClassesThat().haveSimpleNameEndingWith("Out")
            .as("Classes Response devem extender classes Out");

    @ArchTest
    static ArchRule controllerClassesShouldResideInWebPackage = classes().that().haveSimpleNameEndingWith("Controller")
            .should().resideInAPackage("..adapters.web")
            .andShould().beAnnotatedWith(RestController.class)
            .as("Classes Controller devem ser implementadas dentro do pacote adapters.web");

    @ArchTest
    static ArchRule configClassesShouldResideInConfigPackage = classes().that().haveSimpleNameEndingWith("Config")
            .should().resideInAPackage("..config")
            .as("Classes Config devem ser implementadas dentro do pacote config");

    @ArchTest
    static ArchRule exceptionClassesShouldResideInExceptionPackage = classes().that().haveSimpleNameEndingWith("Exception")
            .should().resideInAPackage("..core.domain.exception")
            .as("Classes Exception devem ser implementadas dentro do pacote core.domain.exception");

    @ArchTest
    static ArchRule handlerClassesShouldResideInHandlerPackage = classes().that().haveSimpleNameEndingWith("Handler")
            .should().resideInAPackage("..core.domain.handler")
            .andShould().beAnnotatedWith(ControllerAdvice.class)
            .as("Classes Handler devem ser implementadas dentro do pacote core.domain.handler");

    @ArchTest
    static ArchRule enumsShouldHaveNameEndingWithEnum = classes().that().areEnums()
            .should().haveSimpleNameEndingWith("Enum")
            .andShould().resideInAPackage("..core.domain.models.enums")
            .as("Enums devem terminar com sufixo Enum");

    @ArchTest
    static ArchRule inputPortClassesShouldResideInPortInPackage = classes().that().haveSimpleNameEndingWith("InputPort")
            .should().resideInAPackage("..core.port.in")
            .as("Classes InputPort devem ser implementadas dentro do pacote core.port.in");

    @ArchTest
    static ArchRule outputPortClassesShouldResideInPortOutPackage = classes().that().haveSimpleNameEndingWith("OutputPort")
            .should().resideInAPackage("..core.port.out")
            .as("Classes OutputPort devem ser implementadas dentro do pacote core.port.out");

    @ArchTest
    static ArchRule userCaseClassesShouldResideInUseCasePackage = classes().that().haveSimpleNameEndingWith("UseCase")
            .should().resideInAPackage("..core.usecase")
            .andShould().dependOnClassesThat().haveSimpleNameEndingWith("InputPort")
            .as("Classes UseCase devem ser implementadas dentro do pacote core.usecase");

}