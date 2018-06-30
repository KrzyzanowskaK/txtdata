package com.txtdata;

import org.junit.Assert;
import org.junit.Test;

public class UserListTest {

    @Test
    public void getNumberOfUsers() {
        //Given
        UserList userList = new UserList();

        //When
        int correctAnswer = 4;

        //Then
        Assert.assertEquals(correctAnswer, userList.getNumberOfUsers());
    }
}
