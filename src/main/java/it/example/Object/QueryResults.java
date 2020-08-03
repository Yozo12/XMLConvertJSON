package it.example.Object;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("queryResults")
public class QueryResults {
    String xmlns;
    List<Record> record;
    Integer version;

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public List<Record> getRecord() {
        return record;
    }

    public void setRecord(List<Record> record) {
        this.record = record;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
