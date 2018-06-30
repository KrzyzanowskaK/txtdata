package com.txtdata;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class UserList {
    private String filePath = "C:\\Users\\Bruce\\txtdata\\src\\main\\java\\com\\txtdata\\data.txt";

    public String getFileData() {
        StringBuilder fiteData = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            stream.forEach(s -> fiteData.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fiteData.toString();
    }


    public int getNumberOfUsers() {
        StringTokenizer st = new StringTokenizer(getFileData());
        int lineCount = st.countTokens()/4;

        return lineCount;
    }

    public ArrayList<String> getUsersList() {
        StringTokenizer st = new StringTokenizer(getFileData());
        ArrayList<String> userList = new ArrayList<>();

        while(st.hasMoreTokens()) {
            String firstName = st.nextToken();
            String lastName = st.nextToken();
            String dateOfBirth = st.nextToken();
            String phone = st.nextToken();

            userList.add(firstName);
            userList.add(lastName);
            userList.add(dateOfBirth);
            userList.add(phone);
        }

        return userList;
    }

    public void getOldestUser() {
        ArrayList<Integer> date = new ArrayList<>();

        LocalDateTime todayDate = LocalDateTime.now();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthDate = simpleDateFormat.parse(getUsersList().get(1));
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        for (int i=1; i<getUsersList().size(); i+=3) {
//           getUsersList().indexOf(i);
//        }
    }
}
