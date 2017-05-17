package net.thucydides.ebi.cucumber.pages;


import com.fasterxml.jackson.databind.ObjectMapper;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.ebi.cucumber.framework.helpers.*;

import net.thucydides.ebi.cucumber.framework.hooks.ScenarioHook;


/**
 * Created by rakeshnbr on 02/03/2017.
 */
public class fullTextDataPipelineImpl extends PageObject {


    @FindBy(css = "body > pre")
    WebElementFacade indexText;

    public boolean compareAbsIndexData(String indexURL, String pmcID) throws Exception {
        boolean indexed = false;
        try{

            indexURL = indexURL.replace("var_PMID",pmcID);
            getDriver().get(indexURL);
            if(indexText.getText().isEmpty()){
                getDriver().get(indexURL);
            }
            if(indexText.getText()!=null | indexText.getText()!=""){
                String indexResponse = indexText.getText();
                int occurance = StringHelper.getTextOccunace(indexResponse, pmcID);
                boolean singleRecord = indexResponse.contains("\"numFound\":1");
                if(occurance > 1 & singleRecord){
                    indexed = true;
                } else {
                    ScenarioHook.getScenario().write("Abstract Check Failed : "+ pmcID + "\n"+indexText.getText() );
                }
            } else {
                ScenarioHook.getScenario().write("Abstract Index Output for PMID : "+ pmcID + "\n"+indexText.getText());
            }
        }catch (Exception e){
            return false;
        }
        return indexed;
    }


}
