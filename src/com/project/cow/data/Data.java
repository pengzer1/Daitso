package com.project.cow.data;
import java.io.*;
import java.util.*;
import com.project.cow.data.object.Member;
import com.project.cow.data.object.SellingStuff;
import com.project.cow.data.object.KeyWord;
import com.project.cow.mypage.ReviewInstance;
import com.project.cow.mypage.SoldOut;
import com.project.cow.mypage.TradeStuff;
import com.project.cow.mypage.User;
import com.project.cow.data.object.BadReview;
import com.project.cow.data.object.BlackList;

public class Data {  //txt 파일을 받아서 조작하고 데이터 입출력을 담당.
	public static ArrayList<Member> list;  //회원배열
	//public static ArrayList<LikeItem> likeList;   //찜목록배열
	public static ArrayList<BlackList> blackList;   //블랙리스트 배열
    public static ArrayList<User> userList;  //회원배열
    public static ArrayList<SoldOut> soldOutArrayList;
    public static ArrayList<KeyWord> keyWordList;   //키워드 배열
    public static ArrayList<ReviewInstance> ReviewList; // 리뷰 배열
    public static ArrayList<TradeStuff> tradeList; // 거래 배열
	
	static {
		Data.list=new ArrayList<Member>();
//		Data.likeList=new ArrayList<LikeItem>();
//		Data.blackList = new ArrayList<BlackList>();
        Data.userList = new ArrayList<User>();
        Data.soldOutArrayList = new ArrayList<>();
        keyWordList = new ArrayList<>();
        ReviewList = new ArrayList<>();
        tradeList = new ArrayList<>();
	}
	
	public static void memberLoad() {   // 회원정보txt를 배열에 load.
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\member.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				Member m = new Member(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				User u = new User(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);
				Data.list.add(m);
				Data.userList.add(u);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void memberSave() { // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\member.txt"));
			
			for(Member m : Data.list) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", m.getNo(), m.getName(), m.getId(), m.getPwd(), m.getTel(), m.getJumin(), m.getEmail(), m.getAddress(), m.getAccount(), m.getMoney(), m.getGrade()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
	public static void userSave() { // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\member.txt"));
			
            for (User user : Data.userList) {
                // 객체 정보를 텍스트 파일에 쓰는 로직
                String userInfo = user.toCsvFormat();  // User 객체를 CSV 형식으로 변환
                writer.write(userInfo);
                writer.newLine();
            }
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	}
	
//	public static void likeItemLoad() {   // 찜목록txt를 배열에 load.
//		try {
//			BufferedReader reader= new BufferedReader(new FileReader("C:\\class\\code\\java\\Daitso\\data\\likeItem.txt"));
//			
//			String line=null;
//			while((line=reader.readLine()) != null) {
//				String[] temp=line.split(",");
//				LikeItem likeItem = new LikeItem(temp[0], temp[1], temp[2]);
//				Data.likeList.add(likeItem);
//			}
//			
//			reader.close();
//		}catch(Exception e) {
//			System.out.println("at Data.load");
//			e.printStackTrace();
//		}
//	}
//	
//	public static void likeItemSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\class\\code\\java\\Daitso\\data\\likeItem.txt"));
//			
//			for(LikeItem likeItem : Data.likeList) {
//				writer.write(String.format("%s,%s,%s,%s\r\n", likeItem.getNo(), likeItem.getItemNo(), likeItem.getBuyerNo()));
//			}  //배열에 새로운 내용들을 반영시키기.
//			
//			writer.close();
//		}catch(Exception e) {
//			System.out.println("at Data.save");
//			e.printStackTrace();
//		}
//	}
//	
	public static void blackListLoad() {   // 블랙리스트 배열
		try {
			BufferedReader reader= new BufferedReader(new FileReader("data\\blackList.txt"));
			
			String line=null;
			while((line=reader.readLine()) != null) {
				String[] temp=line.split(",");
				BlackList bl = new BlackList(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10], temp[11], temp[12],temp[13]);
				Data.blackList.add(bl);
			}
			
			reader.close();
		}catch(Exception e) {
			System.out.println("at Data.load");
			e.printStackTrace();
		}
	}
	
	public static void blackListSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data\\blackList.txt"));
			
			for(BlackList bl : Data.blackList) {
				writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", bl.getNo(), bl.getName(), bl.getId(), bl.getPwd(), bl.getTel(), bl.getJumin(), bl.getEmail(), bl.getAddress(), bl.getAccount(), bl.getMoney(), bl.getGrade(), bl.getYellowCard(),bl.getAgo(),bl.getVan()));
			}  //배열에 새로운 내용들을 반영시키기.
			
			writer.close();
		}catch(Exception e) {
			System.out.println("at Data.save");
			e.printStackTrace();
		}
	
	}
	
    public static void deleteMember(User userToDelete) { // 회원 탈퇴 메서드
        String filePath = "data\\member.txt";
        String tempFilePath = "data\\temp_member.txt";

        try {
            File inputFile = new File(filePath);
            File tempFile = new File(tempFilePath);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            List<String> lines = new ArrayList<>();
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] userData = currentLine.split(",");
                if (userData.length >= 3 && userData[2].equals(userToDelete.getId())) {
                    continue; // Skip the line to delete
                }
                lines.add(currentLine);
            }

            reader.close();
            writer.close();

            BufferedWriter newWriter = new BufferedWriter(new FileWriter(inputFile));
            for (String line : lines) {
                newWriter.write(line + System.lineSeparator());
            }
            newWriter.close();

            System.out.println("계정을 삭제했습니다.");
        } catch (Exception e) {
            System.out.println("Error updating file.");
            e.printStackTrace();
        }
    }
    
    public static void soldOutLoad() {  // 판매된 목록
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data\\soldOutStuff.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                SoldOut soldOut = new SoldOut(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                soldOutArrayList.add(soldOut);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }

    public static void sellLoad() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("data\\soldOutStuff.txt"));

            String line = null;

            while ((line = reader.readLine()) != null) {

                String[] temp = line.split(",");

                SellingStuff s = new SellingStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9], temp[10]);

                SellingStuffData.sellingList.add(s);
            }
            reader.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public static void sellSave() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("data\\sellingStuff.txt"));

            for (SellingStuff s : SellingStuffData.sellingList) {

                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\r\n", s.getNo(), s.getName(), s.getCategory(), s.getPrice(), s.getMethod(), s.getPayment(), s.getCondition(), s.getFrom(), s.getUntil(), s.getLike(), s.getSellerNo()));

            }
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }


    public static void keyWordListLoad() {   // 키워드 배열
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data\\keyWord.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                String no = temp[0];
                String keyWords = temp[1]; // 첫 번째 요소는 no이므로 제외

                // temp 배열의 1번 인덱스부터 keyWords 배열로 복사
                KeyWord key = new KeyWord(no, keyWords);
                Data.keyWordList.add(key);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }

    public static void reviewLoad() {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("data\\goodReview.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                ReviewInstance reviewInstance = new ReviewInstance(temp[0], temp[1], temp[2], temp[3]);
                ReviewList.add(reviewInstance);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }


    public static void reviewSave(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data\\reviewSave.txt"));

            for (ReviewInstance review : Data.ReviewList) {
                // 객체 정보를 텍스트 파일에 쓰는 로직
                String reviewInfo = review.toCsvFormat();  // User 객체를 CSV 형식으로 변환
                writer.write(reviewInfo);
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error updating file.");
            e.printStackTrace();
        }
    }
    public static ArrayList<BadReview> badList;   //나쁜 리뷰 배열
    static {
        badList = new ArrayList<BadReview>();
    }

    public static void badReviewLoad() {   // 리뷰 txt를 배열에 load.
        try {
            BufferedReader reader= new BufferedReader(new FileReader("data\\badReview.txt"));

            String line=null;
            while((line=reader.readLine()) != null) {
                String[] temp=line.split(",");
                BadReview review = new BadReview(temp[0], temp[1], temp[2], temp[3]);
                Data.badList.add(review);
            }

            reader.close();
        }catch(Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }

    public static void badReviewSave() {   // 배열에 새로운 내용들을 반영시켜 저장하기.
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data\\badReview.txt"));

            for(BadReview review : BadReviewData.badReview) {
                writer.write(String.format("%s,%s,%s,%s\r\n", review.getNo(), review.getBuyerNo(), review.getSellerNo(), review.getWarningCnt()));
            }  //배열에 새로운 내용들을 반영시키기.

            writer.close();
        }catch(Exception e) {
            System.out.println("at Data.save");
            e.printStackTrace();
        }


    }
    public static void tradeStuffLoad() {  // 판매된 목록
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data\\tradeStuff.txt"));

            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                TradeStuff soldOut = new TradeStuff(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7], temp[8], temp[9]);
                tradeList.add(soldOut);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("at Data.load");
            e.printStackTrace();
        }
    }
}
	
	
	 
	
	
