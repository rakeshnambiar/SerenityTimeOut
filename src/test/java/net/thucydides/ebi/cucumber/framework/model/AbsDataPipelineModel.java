package net.thucydides.ebi.cucumber.framework.model;

/**
 * Created by rakeshnbr on 20/03/2017.
 */
public class AbsDataPipelineModel {
    private String xmlPath;
    private String abs_Index_URL;
    private String abs_REST_URL;
    private String medlineCitiationUser;
    private String medlineCitiationPwd;
    private String medlineCitiationDB;

    public String getMedlineCitiationDB() {
        return medlineCitiationDB;
    }

    public void setMedlineCitiationDB(String medlineCitiationDB) {
        this.medlineCitiationDB = medlineCitiationDB;
    }

    public String getMedlineCitiationUser() {
        return medlineCitiationUser;
    }

    public void setMedlineCitiationUser(String medlineCitiationUser) {
        this.medlineCitiationUser = medlineCitiationUser;
    }

    public String getMedlineCitiationPwd() {
        return medlineCitiationPwd;
    }

    public void setMedlineCitiationPwd(String medlineCitiationPwd) {
        this.medlineCitiationPwd = medlineCitiationPwd;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public String getAbs_Index_URL() {
        return abs_Index_URL;
    }

    public void setAbs_Index_URL(String abs_Index_URL) {
        this.abs_Index_URL = abs_Index_URL;
    }

    public String getAbs_REST_URL() {
        return abs_REST_URL;
    }

    public void setAbs_REST_URL(String abs_REST_URL) {
        this.abs_REST_URL = abs_REST_URL;
    }


}
