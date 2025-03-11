package Model;

import java.util.ArrayList;
import java.util.List;

public class HeaderBean {
    ArrayList<String> headerNames;
    ArrayList<String> headerValues;
    public HeaderBean() {
        headerNames = new ArrayList<>();
        headerValues = new ArrayList<>();
    }

    public ArrayList<String> getHeaderNames() {
        return headerNames;
    }

    public void setHeaderNames(List<String> headerNames) {
        this.headerNames = (ArrayList<String>) headerNames;
    }

    public ArrayList<String> getHeaderValues() {
        return headerValues;
    }

    public void setHeaderValues(List<String> headerValues) {
        this.headerValues = (ArrayList<String>) headerValues;
    }
}
