package it.example.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import it.example.Object.DataResponse;
import it.example.Object.QueryResults;
import it.example.Object.ResponseObject;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class XMLServiceExport {
    private static String TEST_XML_STRING = null;

    public ResponseObject convertXML() throws IOException {
        File file = new File("C:\\Dev\\Prove\\XMLConvertJSON\\src\\main\\resources\\xml.xml");
        FileInputStream fin = new FileInputStream(file);
        byte[] xmlData = new byte[(int) file.length()];
        fin.read(xmlData);
        fin.close();
        //PARTENZA
        TEST_XML_STRING = new String(xmlData, "UTF-8");
        String xmlPiccolo = "<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><OpenResponse xmlns=\"http://bvdep.com/webservices/\"><OpenResult>CH30IATTHMAJO72</OpenResult></OpenResponse></soap:Body></soap:Envelope>";
        // JSONObject ob = XML.toJSONObject(xmlPiccolo);
        JSONObject ob = XML.toJSONObject(TEST_XML_STRING);

        ResponseObject res = toJSon(ob);
        if (res.getGetDataResponse() != null) {
            DataResponse dataResponse = res.getGetDataResponse();
            QueryResults response= convertGetDataResponseXMLIntoJSON(dataResponse.getGetDataResult());
            //SE SERVE IMPLEMENTARE IL SAVE DEI DATI IN DATABASE
        }
        return res;

    }

    private ResponseObject toJSon(JSONObject ob) throws IOException {
        ob = ob.put("envelop", ob.remove("soap:Envelope"));
        JSONObject envelop = (JSONObject) ob.get("envelop");
        envelop = envelop.put("body", envelop.remove("soap:Body"));
        JSONObject body = (JSONObject) envelop.get("body");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ResponseObject response = objectMapper.readValue(body.toString(), new TypeReference<ResponseObject>() {
        });
        return response;
    }

    private QueryResults convertGetDataResponseXMLIntoJSON(String xml) throws IOException {
        JSONObject ob = XML.toJSONObject(xml);
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject queryResults = (JSONObject) ob.get("queryResults");
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        objectMapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        QueryResults response = objectMapper.readValue(queryResults.toString(), new TypeReference<QueryResults>() {
        });
        return response;
    }
}
