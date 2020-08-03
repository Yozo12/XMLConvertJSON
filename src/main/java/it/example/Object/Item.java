package it.example.Object;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.JsonArray;
import org.json.JSONPropertyIgnore;

import java.util.ArrayList;
import java.util.List;



public class Item {
    public String field;
    public String valueType;
    public String alias;
    public String resultType;
    public String fieldType;
    public Object childItem;
    public String dimSelType;
    public String dim;
    public int index;
    public int occurs;
    public String content;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Object getChildItem() {
        return childItem;
    }

    public void setChildItem(Object childItem) {
        this.childItem = childItem;
    }

    public String getDimSelType() {
        return dimSelType;
    }

    public void setDimSelType(String dimSelType) {
        this.dimSelType = dimSelType;
    }

    public String getDim() {
        return dim;
    }

    public void setDim(String dim) {
        this.dim = dim;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getOccurs() {
        return occurs;
    }

    public void setOccurs(int occurs) {
        this.occurs = occurs;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
