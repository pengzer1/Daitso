package com.project.cow.mypage;

public class Test {
    public static void main(String[] args) {
        Data.memberLoad();
        Data.soldOutLoad();
        Data.keyWordLoad();
        for (int i = 0; i < 30; i++) {

            Data.keyWordList.get(i);
        }
       /* MyPageList myPageList = new MyPageList(Data.userList.get(2));

        myPageList.myPageScreen();*/


    }
}

