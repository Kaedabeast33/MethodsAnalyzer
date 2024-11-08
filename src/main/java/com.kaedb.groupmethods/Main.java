package com.kaedb.groupmethods;




import java.io.*;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
        import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {



    static int bracketCount = 0;
    static int ifForTryCount = 0;
    static int paranthesisCount = 0;
    static int backBracketCount = 0;
    static int backParanthesisCount = integer();

    static public int integer() {
        return 2;
    }

    static public void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        String folderPathFrom;
        String folderPathTo;
        String pathToMethods;

        if (args.length < 2) {
            System.out.println("Please provide the folder path to parse and the folder path to add groupings data to and the path to add methods to");
            folderPathFrom = "/Users/kaedenbradshaw/Desktop/Code/Projects/GroupMethodsChatGpt";
            folderPathTo = "/Users/kaedenbradshaw/Desktop/Code/output";
            pathToMethods = "/Users/kaedenbradshaw/Desktop/Code/output/methods";
        } else {
            folderPathFrom = args[0];
            folderPathTo = args[1];
            pathToMethods = args[2];
        }


// get the methods and write them to a file

        listFiles(folderPathFrom);


//        define the methods and make a map of them
//        part of the map is tagging them with the chat classification tags
//        adds the tags to the db and their meanings
//         add them to a db that has each method, method definitions and the ids, the tags and their ids , a many to many table that has the tags and the methods ids,




    }

    public static List<List<Integer>> indexOfMatch(String regex, String inputString) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        List<List<Integer>> indexes = new ArrayList<>();


        while (matcher.find()) {
            List<Integer> matchedIndices = new ArrayList<>();
            matchedIndices.add(matcher.start());
            matchedIndices.add(matcher.end());
            indexes.add(matchedIndices);
        }
        return indexes;

    }




    public static void checkIfForTry(int character, BufferedReader reader) throws IOException {
        boolean isIfForTry = false;
        reader.mark(100);
//        if ((char) character == 'f') {
//            character = reader.read();
//            if ((char) character == 'o') {
//                character = reader.read();
//                if ((char) character == 'r') {
//
//
//
//                    while(!isIfForTry){
//                        character = reader.read();
//                        if((char)character == '(' ){
//
//                            ifForTryCount++;
//                            reader.reset();
//                            isIfForTry= true;
//                        }
//                       else if( (char)character == ' '){
//                            while((char)character == ' '){
//                                character = reader.read();
//                                if((char)character == '('){
//                                    ifForTryCount++;
//                                    reader.reset();
//                                    isIfForTry= true;
//                                }
//                            }
//                        }
//                    }
//
//
//                }
//            }
//        }
//        if ((char) character == 'w') {
//            character = reader.read();
//            if ((char) character == 'h') {
//                character = reader.read();
//                if ((char) character == 'i') {
//                    character = reader.read();
//                    if ((char) character == 'l') {
//                        character = reader.read();
//                        if ((char) character == 'e') {
//                            while (!isIfForTry) {
//                                character = reader.read();
//                                if ((char) character == '(') {
//
//                                    ifForTryCount++;
//                                    reader.reset();
//                                    isIfForTry = true;
//                                } else if ((char) character == ' ') {
//                                    while ((char) character == ' ') {
//                                        character = reader.read();
//                                        if ((char) character == '(') {
//                                            ifForTryCount++;
//                                            reader.reset();
//                                            isIfForTry = true;
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }


        //if's and whiles and fors only count if it contains brackets
//       else if ((char) character == 'i') {
//            character = reader.read();
//            if ((char) character == 'f') {
//
//
//                while(!isIfForTry){
//                    character = reader.read();
//                    if((char)character == '('){
//
//                        ifForTryCount++;
//                        reader.reset();
//                        isIfForTry= true;
//                    }
//                   else if( (char)character == ' '){
//                        while((char)character == ' '){
//                            character = reader.read();
//                            if((char)character == '('){
//                                ifForTryCount++;
//                                reader.reset();
//                                isIfForTry= true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        if((char) character=='t') {
//            System.out.println("try?");
            character = reader.read();
            if ((char) character == 'r') {
                character = reader.read();
                if ((char) character == 'y') {

                    while (!isIfForTry) {
                        character = reader.read();
                        if ((char) character == '{' || (char) character == ' ' || (char) character == '(') {

                            ifForTryCount++;
                            reader.reset();
                            isIfForTry = true;
                        }
                    }
                }
            }
        }

        else if((char)character =='c') {
            character = reader.read();
            if ((char) character == 'a') {
                character = reader.read();
                if ((char) character == 't') {
                    character = reader.read();
                    if ((char) character == 'c') {
                        character = reader.read();
                        if ((char) character == 'h') {

                            while (!isIfForTry) {
                                character = reader.read();
                                if ((char) character == '{' || (char) character == ' ' || (char) character == '(') {

                                    ifForTryCount++;
                                    reader.reset();
                                    isIfForTry = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        if(!isIfForTry){
            reader.reset();
        }

    }


    public static void listFiles(String folderPathFrom) throws IOException {
        boolean isJavaFolder = false;
        List<ClassMethods> classMethodsList = new ArrayList<>();
        File parent = new File(folderPathFrom);
        System.out.println(folderPathFrom);
        if (parent.exists() ) {
            if( parent.isDirectory()) {

                // List all files and directories in the parent directory
                File[] files = parent.listFiles();
                assert files != null;
                for (File file : files) {
                    if (file.getName().endsWith(".java")) {

                            System.out.println(file.getAbsolutePath());
                            List<ClassMethods> list= getMethods(file.getAbsolutePath());
                            classMethodsList.addAll(list);

                    }else if(file.isDirectory()){
                        if(file.getName().equals("target")|| file.getName().equals("resources"))continue;
                        listFiles(file.getAbsolutePath());
                    }


                }
            }else if(parent.getName().endsWith(".java")){
                System.out.println(parent.getAbsolutePath());
                List<ClassMethods> list = getMethods(folderPathFrom);
                classMethodsList.addAll(list);
            }
        }
        for(ClassMethods c : classMethodsList){
            System.out.println(c.toString());
        }
    }



    public static List<ClassMethods> getMethods(String folderPathFrom) throws IOException {


        List<ClassMethods> classMethodsList = new ArrayList<>();
        MethodIndicator methodIndicator = new MethodIndicator();
        MethodDetails methodDetails = new MethodDetails();
        boolean inClass=false;

        try (InputStream stream = Files.newInputStream(Paths.get(folderPathFrom));
             BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {

            int index = 0;
            int character;

            while ((character = reader.read()) != -1) {
                if((char)character == '\n'){
                    continue;
                }
//                System.out.println("index "+index+(char) character);
                index+= skipCommentedLinesAndString(character ,reader);
                if ((char) character == '(') {
                    paranthesisCount++;

                }
                if ((char) character == ')') {
                    paranthesisCount--;

                }
                if ((char) character == '{') {
                    bracketCount++;
                }
                if ((char) character == '}') {
                    bracketCount--;
                }

                index++;


                if(paranthesisCount==0 && bracketCount ==1) {

//                    System.out.println("start class");
                    ClassMethods classMethods = new ClassMethods();
                    classMethods.setStartingIndex(index);

                    inClass = true;


                    while(inClass){
                        character = reader.read();
                        if((char)character == '\n'){
                            continue;
                        }

//                        System.out.println("index "+index+(char) character);
//

                        if(bracketCount==1) {
//                            System.out.println("skip try catch");
                            index += skipTryCatch(character, reader);
                        }
                        index+= skipCommentedLinesAndString(character ,reader);

                        if ((char) character == '(') {
                            paranthesisCount++;
                        }
                        if ((char) character == ')') {
                            paranthesisCount--;
                        }
                        if ((char) character == '{') {
                            bracketCount++;

                            if (paranthesisCount == 0 && bracketCount ==2) {
//                                System.out.println("start of method");
                                methodDetails.setStartingIndex(index);
                                methodDetails.setFilePath(folderPathFrom);
                            }

                        }

                        if ((char) character == '}') {
                            bracketCount--;
                            if(bracketCount==1&& paranthesisCount==0){
//                                System.out.println("end of method");
//                                System.out.println(bracketCount);
                                methodDetails.setEndingIndex(index);

                                classMethods.addMethodDetails(methodDetails);

//                                System.out.println(methodDetails.toString());
                                methodDetails = new MethodDetails();
                                methodIndicator.methodIndicatorReset();

                            }
                            else if(bracketCount==0){
//                                System.out.println("end of class");
                                classMethods.setEndingIndex(index);
//                                System.out.println(classMethods.getEndingIndex());
//                                System.out.println(classMethods.toString());
                                classMethodsList.add(classMethods);
                                inClass=false;
                            }

                        }
                        index++;
                    }
                }
            }
        }
        ;


//        List<MethodsDefinitions> methods = new ArrayList<>();
//
//

//        readMethod(folderPathFrom,classMethodsList.get(0).getMethodDetailsList().get(0).getStartingIndex(),classMethodsList.get(0).getMethodDetailsList().get(0).getEndingIndex()+1);
        return classMethodsList;
    }

    public static void readMethod(String filePath,int startingIndex, int endingIndex) throws IOException {
        StringBuilder method = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                method.append(line);
            }
        }
        System.out.println(method.substring(startingIndex,endingIndex));

    }

    private static int skipTryCatch(int character, BufferedReader reader) throws IOException {
        int index = 0;

        checkIfForTry(character, reader);
        while(ifForTryCount>0){
            System.out.println("trys and catches");
            while((char)character != '{') {
                character = reader.read();
//                if((char)character == '\n'){
//                    continue;
//                }
                index++;
            }
            bracketCount++;
            System.out.println("start of try or catch");
            while(bracketCount>1){
                character = reader.read();
                if((char)character == '\n'){
                    continue;
                }
                index++;
                if((char)character == '{'){
                    bracketCount++;
                }
                if((char)character == '}'){
                    bracketCount--;
                }

            }
            System.out.println("end of try or catch");
            ifForTryCount--;
        }

        return index;
    }

    private static int skipCommentedLinesAndString(int character, BufferedReader reader) throws IOException {
        int readAhead = 4000;
        int index = 0;
        reader.mark(readAhead);
        boolean isCommentOrString = false;

        if ((char) character == '/') {
            character = reader.read();
            index++;
            if((char)character == '*'){
//                System.out.println("message");
                boolean end=false;
                while (!end) {
                    if((char)character == '*'){
                        character = reader.read();
                        index++;
//                        System.out.println((char)character);
//                        System.out.println("\tindex"+index);
                        if((char)character == '/'){
                            end = true;
                            isCommentOrString = true;
                        }
                    }
                    character = reader.read();
                    index++;
                }
            }
            else if ((char) character == '/') {
//                System.out.println("comment whole line");
                try {
                    String line = reader.readLine();
                    for(char c : line.toCharArray()){
//                        System.out.println(c);
//                        System.out.println("indices"+index);
                        index++;



                    }
//                    System.out.println("we made it");

                    isCommentOrString = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else if((char)character == '\"'){
            boolean end = false;
            while(!end){
                character = reader.read();
                index++;
//                System.out.println((char)character);
//                System.out.println("\tindex"+index);
                if((char)character == '"'){
//                    System.out.println("ending");
                    isCommentOrString = true;
                    end = true;
                }
            }
        }

        else if((char)character == '\''){
            boolean end = false;
            while(!end){
                character = reader.read();
                index++;
                if((char)character == '\''){
                    isCommentOrString = true;
                    end = true;
                }
            }
        }
        if(!isCommentOrString){
            reader.reset();
            index = 0;
        }else{

//            System.out.println("skip commented lines and strings");
//            System.out.println("indices: "+index);

        }
        return index;

    }


}



