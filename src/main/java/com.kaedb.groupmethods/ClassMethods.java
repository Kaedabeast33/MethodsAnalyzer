package com.kaedb.groupmethods;

import java.util.ArrayList;
import java.util.List;

public class ClassMethods {
    List<MethodDetails> methodDetailsList = new ArrayList<MethodDetails>();

    Integer startingIndex;
    Integer endingIndex;

    public void setMethodDetailsList(List<MethodDetails> methodDetailsList) {
        this.methodDetailsList = methodDetailsList;
    }
    public void addMethodDetails(MethodDetails methodDetails) {
        this.methodDetailsList.add(methodDetails);
    }

    public List<MethodDetails> getMethodDetailsList() {
        return methodDetailsList;
    }

    public Integer getStartingIndex() {
        return startingIndex;
    }

    public void setStartingIndex(Integer startingIndex) {
        this.startingIndex = startingIndex;
    }

    public Integer getEndingIndex() {
        return endingIndex;
    }

    public void setEndingIndex(Integer endingIndex) {
        this.endingIndex = endingIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(MethodDetails m:methodDetailsList){
            sb.append(m.toString()).append("\n");
        }
        return "Class Methods{\n" +
              sb.toString() +
                "}" +
                "startingIndex=" + startingIndex +
                ", endingIndex=" + endingIndex;
    }
}
