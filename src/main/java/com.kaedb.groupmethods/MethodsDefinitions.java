package com.kaedb.groupmethods;

import java.util.Map;
import java.util.TreeMap;

public class MethodsDefinitions {
    String packageName;
    String filePath;
    String className;
    String[] parametersTypes;
    String returnType;
    String body;
    String name;
    String chatClassification;
    Boolean parentFunction;

    String classUsedIn;
    String filePathUsedIn;
    String methodNameUsedIn;
    //classPath + methodName
    String id;
    // essentilall it makes a tree of the methods and for each time this method is called it measures the depth of the method.

//    getData{
    //saveData{
    //  }
    //sendNotification{
    // }
    //
    //
    //
    //
    //
    //
// }
    Integer[] methodDepth;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String[] getParametersTypes() {
        return parametersTypes;
    }

    public void setParametersTypes(String[] parametersTypes) {
        this.parametersTypes = parametersTypes;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChatClassification() {
        return chatClassification;
    }

    public void setChatClassification(String chatClassification) {
        this.chatClassification = chatClassification;
    }

    public Boolean getParentFunction() {
        return parentFunction;
    }

    public void setParentFunction(Boolean parentFunction) {
        this.parentFunction = parentFunction;
    }

    public String getClassUsedIn() {
        return classUsedIn;
    }

    public void setClassUsedIn(String classUsedIn) {
        this.classUsedIn = classUsedIn;
    }

    public String getFilePathUsedIn() {
        return filePathUsedIn;
    }

    public void setFilePathUsedIn(String filePathUsedIn) {
        this.filePathUsedIn = filePathUsedIn;
    }

    public String getMethodNameUsedIn() {
        return methodNameUsedIn;
    }

    public void setMethodNameUsedIn(String methodNameUsedIn) {
        this.methodNameUsedIn = methodNameUsedIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer[] getMethodDepth() {
        return methodDepth;
    }

    public void setMethodDepth(Integer[] methodDepth) {
        this.methodDepth = methodDepth;
    }
}
