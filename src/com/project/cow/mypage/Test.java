package com.project.cow.mypage;

import com.project.cow.data.BadReviewData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.BadReview;

public class Test {
    public static void main(String[] args) {
        Data.memberLoad();
        Data.soldOutLoad();
        Data.keyWordListLoad();
        SellingStuffData.load();
        Data.reviewLoad();
        Data.badReviewLoad();
        Data.tradeStuffLoad();

        MyPageList myPageList = new MyPageList(Data.userList.get(25));

        myPageList.myPageScreen();

    }
}


