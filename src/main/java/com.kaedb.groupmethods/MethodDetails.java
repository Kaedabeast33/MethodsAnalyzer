package com.kaedb.groupmethods;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class MethodDetails {
    String filePath;
    Integer startingIndex;
    Integer endingIndex;

    public MethodDetails(String methodName, Integer startingIndex, Integer endingIndex) {

        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
    }
    public static String readMethod(String filePath, int startingIndex, int endingIndex) throws IOException {
        int paranthesis = 0;
        int curlyBraces = 0;
        int semicolon = 0;
        boolean isBeginning=false;
        StringBuilder method = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                method.append(line);
            }
        }
        String goBack;
        int gobackIndex = 0;
        while (!isBeginning){
            gobackIndex++;
            goBack = method.substring(startingIndex-gobackIndex,startingIndex-gobackIndex+1);
//            System.out.println("gobakc: "+goBack);
            switch (goBack) {
                case "}":
//                    System.out.println("curlyBraces}: "+curlyBraces);
                    curlyBraces++;
                    break;
                case ")":
//                    System.out.println("paranthesis): "+paranthesis);
                    paranthesis++;
                    break;
                case "{":
//                    System.out.println("curlyBraces{: "+curlyBraces);
                    curlyBraces--;
                    break;
                case "(":
//                    System.out.println("paranthesis(: "+paranthesis);
                    paranthesis--;
                    break;
                case ";":
//                    System.out.println("colon;: "+semicolon);
                    semicolon++;
                    break;
            }
            if((curlyBraces == 1 && paranthesis == 0 )|| (curlyBraces == -1 && paranthesis == 0)|| (curlyBraces == 0 && paranthesis == 0 && semicolon == 1)){
                isBeginning = true;
            }
        }
//        System.out.println("gobackIndex: "+gobackIndex);
//        StringBuilder method = new StringBuilder();
//        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));){
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                method.append(line);
//            }
//        }
//        method.insert(startingIndex,"<(*__*<)");
//        method.insert(endingIndex,"(>*__*)>");
//        StringBuilder method2 = new StringBuilder();
//        int i = 0;
//        try(BufferedReader bufferedReader = new BufferedReader(new StringReader(method.toString()))){
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                i++;
//                if(line.contains("<(*__*<)")){
//                    method2.append(line);
//                    while ((line = bufferedReader.readLine()) != null) {
//                        i++;
//                        if(line.contains("(>*__*)>")){
//                            method2.append(line);
//
//                            break;
//                        }
//                        method2.append(line);
//                    }
//                    break;
//                }
//            }
//        }
//        System.out.println(i);
//        return method2.toString();
        // i need to take the starting index read back until i get a } and then read forward until i get a character

        return method.substring(startingIndex-gobackIndex+1,endingIndex);

    }


    public MethodDetails(){

    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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
        String method = "";
        try{
            method = readMethod(filePath,startingIndex,endingIndex+1);
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return "MethodDetails{" +
                "startingIndex=" + startingIndex +
                "endingIndex=" + endingIndex +
                ", filePath='" + filePath +
                "}  " + method;
    }
}
