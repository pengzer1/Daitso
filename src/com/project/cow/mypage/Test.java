package com.project.cow.mypage;

import com.project.cow.data.BadReviewData;
import com.project.cow.data.MemberData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.BadReview;

public class Test {
    public static void main(String[] args) {
        Data.memberLoad();
        com.project.cow.data.Data.memberLoad();
        Data.soldOutLoad();
        Data.keyWordListLoad();
        SellingStuffData.load();
        Data.reviewLoad();
        Data.badReviewLoad();
        Data.tradeStuffLoad();
        MemberData.memberLoad();
        MyPageList myPageList = new MyPageList(MemberData.list.get(1));

        myPageList.myPageScreen();

    }
}


