package com.project.cow.mypage;

import com.project.cow.data.SellingStuffData;

public class Test {
    public static void main(String[] args) {
        Data.memberLoad();
        Data.soldOutLoad();
        Data.keyWordListLoad();
        SellingStuffData.load();



        MyPageList myPageList = new MyPageList(Data.userList.get(0));

        myPageList.myPageScreen();

    }
}


