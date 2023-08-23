package com.project.cow.mypage;

import com.project.cow.data.Data;
import com.project.cow.data.BadReviewData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.BadReview;

public class Test {
    public static void main(String[] args) {

        MyPageList myPageList = new MyPageList(Data.userList.get(1));

        myPageList.myPageScreen();

    }
}


