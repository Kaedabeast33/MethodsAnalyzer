package com.kaedb.groupmethods;

import java.util.regex.Pattern;

public class MethodIndicator {

    Boolean check1=false;
//    Boolean closeParantheses=false;
//    Boolean openCurlyBraces=false;
//    Boolean closeCurlyBraces=false;
    Integer startingIndex=0;
    Integer endingIndex=0;

    public void methodIndicatorReset(){
        setCheck1(false);
//        setCloseCurlyBraces(false);
//        setOpenParantheses(false);
//        setCloseParantheses(false);
        setStartingIndex(0);
        setEndingIndex(0);
    }

    public Boolean isMethod(){
        return getCheck1();
    }

    public Boolean getCheck1() {
        // parantheses = 0 and brackets = 2
        return check1;
    }

    public void setCheck1(Boolean check1) {
        this.check1 = check1;
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
}
