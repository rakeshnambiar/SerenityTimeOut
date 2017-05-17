package net.thucydides.ebi.cucumber.framework.model;

import org.yecht.Data;

/**
 * Created by rakeshnbr on 07/03/2017.
 */
public class DataPipelineModel {
    private String index_URL;
    private String sqlDatabase;
    private String sqlUserName;
    private String sqlPassword;
    private String ftProdDatabase;
    private String ftProdUserName;
    private String ftProdPassword;
    private String litPubDatabase;
    private String litPubUserName;
    private String litPubPassword;
    private String restProdURL;

    public String getRestProdURL() {
        return restProdURL;
    }

    public void setRestProdURL(String restProdURL) {
        this.restProdURL = restProdURL;
    }

    public String getIndex_URL() {
        return index_URL;
    }

    public void setIndex_URL(String index_URL) {
        this.index_URL = index_URL;
    }

    public String getSqlDatabase() {
        return sqlDatabase;
    }

    public void setSqlDatabase(String sqlDatabase) {
        this.sqlDatabase = sqlDatabase;
    }

    public String getSqlUserName() {
        return sqlUserName;
    }

    public void setSqlUserName(String sqlUserName) {
        this.sqlUserName = sqlUserName;
    }

    public String getSqlPassword() {
        return sqlPassword;
    }

    public void setSqlPassword(String sqlPassword) {
        this.sqlPassword = sqlPassword;
    }

    public String getFtProdDatabase() {
        return ftProdDatabase;
    }

    public void setFtProdDatabase(String ftProdDatabase) {
        this.ftProdDatabase = ftProdDatabase;
    }

    public String getFtProdUserName() {
        return ftProdUserName;
    }

    public void setFtProdUserName(String ftProdUserName) {
        this.ftProdUserName = ftProdUserName;
    }

    public String getFtProdPassword() {
        return ftProdPassword;
    }

    public void setFtProdPassword(String ftProdPassword) {
        this.ftProdPassword = ftProdPassword;
    }

    public String getLitPubDatabase() {
        return litPubDatabase;
    }

    public void setLitPubDatabase(String litPubDatabase) {
        this.litPubDatabase = litPubDatabase;
    }

    public String getLitPubUserName() {
        return litPubUserName;
    }

    public void setLitPubUserName(String litPubUserName) {
        this.litPubUserName = litPubUserName;
    }

    public String getLitPubPassword() {
        return litPubPassword;
    }

    public void setLitPubPassword(String litPubPassword) {
        this.litPubPassword = litPubPassword;
    }

}
