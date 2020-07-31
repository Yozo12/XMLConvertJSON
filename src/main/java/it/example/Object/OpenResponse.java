package it.example.Object;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.json.JSONObject;


public class OpenResponse {

    public String xmlns;
    public String OpenResult;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public String getOpenResult() {
        return OpenResult;
    }

    public void setOpenResult(String openResult) {
        OpenResult = openResult;
    }
}
