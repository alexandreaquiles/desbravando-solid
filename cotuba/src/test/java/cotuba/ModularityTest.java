package cotuba;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packages = "cotuba")
class ModularityTest {

  @ArchTest
  static final ArchRule no_cycles =
      slices().matching("cotuba.(*)..")
          .should()
          .beFreeOfCycles();

}