package net.thucydides.ebi.cucumber.steps;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

import net.thucydides.ebi.cucumber.framework.helpers.ExcelHelper;
import net.thucydides.ebi.cucumber.framework.hooks.ScenarioHook;
import net.thucydides.ebi.cucumber.pages.fullTextDataPipelineImpl;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakeshnbr on 27/02/2017.
 */
public class DataProcessingSteps extends ScenarioSteps {
    private static String absIndexURL = null;
    private static String pmidValue = null;
    private static ArrayList<List<String>> indexedValues = new ArrayList<List<String>>();
    private static ArrayList<List<String>> pmidDBCheck = new ArrayList<List<String>>();
    private static boolean indexed = true;
    private static boolean doNotProcess = false;
    fullTextDataPipelineImpl dataPipeline = new fullTextDataPipelineImpl();

    @Given("^I have the production Index URL - Abstract to make a query$")
    public void i_have_the_production_Index_URL_Abstract_to_make_a_query() throws Throwable {
        absIndexURL = "http://ves-pg-3e:8983/solr/citations/query?q=EXT_ID:var_PMID%20AND%20SRC:MED&fl=EXT_ID";
        ScenarioHook.getScenario().write("Abstract Index URL Used :"+absIndexURL);
    }


    @Given("^I have all the newly loaded PMID's with me to check the Indexing$")
    public void i_have_all_the_newly_loaded_PMID_s_with_me_to_check_the_Indexing() throws Throwable {
        pmidDBCheck = ExcelHelper.ReadFullTextIndexPipeLineData("AbstractDataPipeLine.xlsx");
        if(pmidDBCheck.size() < 2){
            doNotProcess = true;
        }
    }

    @When("^I check the availability of each PMID using the Index query$")
    public void i_check_the_availability_of_each_PMID_using_the_Index_query() throws Throwable {
        try {
              if(!doNotProcess){
                String indexValue = null;
                ArrayList<String> currentRow = new ArrayList<String>();
                for (int counter = 1; counter < pmidDBCheck.size(); ++counter) {
                    pmidValue = pmidDBCheck.get(counter).get(1);
                    String nextPMID = null;
                    if ((counter + 1) != pmidDBCheck.size()) {
                        nextPMID = pmidDBCheck.get(counter + 1).get(1);
                    } else {
                        nextPMID = "";
                    }
                    currentRow = (ArrayList<String>) pmidDBCheck.get(counter);
                    if (!pmidValue.equalsIgnoreCase(nextPMID)) {
                        boolean pmcIndex = dataPipeline.compareAbsIndexData(absIndexURL, pmidValue);
                        if (!pmcIndex) {
                            ScenarioHook.getScenario().write("Index CHeck Second attempt for "+pmidValue);
                            pmcIndex = dataPipeline.compareAbsIndexData(absIndexURL, pmidValue);
                        }
                        if (!pmcIndex) {
                            indexValue = "no";
                            ScenarioHook.getScenario().write("PMC ID NOT Indexed : " + pmidValue);
                        } else {
                            indexValue = "yes";
                        }

                        if (!pmcIndex & indexed == true) {
                            indexed = false;
                        }
                        currentRow.set(5, indexValue);
                    } else {
                        currentRow.set(5, "");
                    }
                    indexedValues.add(counter - 1, currentRow);
                }
            }
        }catch (Exception e){
            throw new Exception("ERROR: While Checking the Abstract Indexing "+e.getMessage());
        }
    }

    //REQ
    @Then("^Index should returns the PMID details for each query$")
    public void index_should_returns_the_PMID_details_for_each_query() throws Throwable {
        Assert.assertTrue("ERROR: Index Check Failed",indexed);
    }

}
