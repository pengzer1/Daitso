package com.project.cow.mypage;

import com.project.cow.data.KeyWordData;
import com.project.cow.data.SellingStuffData;
import com.project.cow.data.object.Member;
import com.project.cow.login.Login;

public class Test {
    public static void main(String[] args) {
        Data.memberLoad();
        Data.soldOutLoad();
        KeyWordData.keyWordListLoad();
        SellingStuffData.load();
        
        Member member = Login.login;

        User user = new User(member.getNo(), member.getName(), member.getId(), member.getPwd(), member.getTel(), member.getJumin(), member.getEmail(), member.getAddress(), member.getAccount(), member.getMoney(), member.getGrade());

        MyPageList myPageList = new MyPageList(user);

        myPageList.myPageScreen();

    }
}

