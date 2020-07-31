package it.example.Object;


public class ResponseObject {

    public OpenResponse OpenResponse;
    public DataResponse GetDataResponse;

    public it.example.Object.OpenResponse getOpenResponse() {
        return OpenResponse;
    }

    public void setOpenResponse(it.example.Object.OpenResponse openResponse) {
        OpenResponse = openResponse;
    }

    public DataResponse getGetDataResponse() {
        return GetDataResponse;
    }

    public void setGetDataResponse(DataResponse getDataResponse) {
        GetDataResponse = getDataResponse;
    }
}
