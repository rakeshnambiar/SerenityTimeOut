package net.thucydides.ebi.cucumber.runCukes.datapipeline;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.ebi.cucumber.tags.AbsDataProcessIndex;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

/**
 * Created by rakeshnbr 16/03/2016
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(tags = {"@TC08_AbsDataProcessIndexTest"},
        format = {"pretty", "html:target/Destination/TC08_AbsDataProcessIndexTest",
                "json:target/cucumber-report/TC08_AbsDataProcessIndexTest.json"},
        features= {"src/test/resources/features/DataPipeLine/DataProcessingLog.feature"},
        glue = {"net.thucydides.ebi.cucumber"})

@Category({AbsDataProcessIndex.class})
public class TC08_AbsDataProcessIndexTest {

}
