package jira.model;

import java.awt.*;

public class TaskJson {

    private String Heading;
    private List MetaData = new List();


    public List getMetaData() {
        return MetaData;
    }

    public void setMetaData(List metaData) {
        MetaData = metaData;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public TaskJson getAllMetaData(){
        // synthesize and return;
        return null;
    }
}
