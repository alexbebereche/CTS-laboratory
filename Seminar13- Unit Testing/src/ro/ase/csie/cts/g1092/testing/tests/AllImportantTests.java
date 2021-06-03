package ro.ase.csie.cts.g1092.testing.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.g1092.testing.tests.category.ImportantTest;
import ro.ase.csie.cts.g1092.testing.tests.category.PerformanceTest;

//@RunWith(Suite.class) //dont use the suite, use the categories

@RunWith(Categories.class)
@IncludeCategory({ImportantTest.class, PerformanceTest.class})


//@ExcludeCategory // have also this, include everything but not this...
@SuiteClasses({ TestStudent.class, TestStudentNewTests.class })
public class AllImportantTests {

}
