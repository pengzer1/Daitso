package com.project.cow.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.project.cow.admin.AdminMenu;

public class Locker {
	Scanner scan = new Scanner(System.in);
	
	public void screen() {
		AdminMenu.printMenu("보관함 위치 찾기");
		areaList();
		AdminMenu.printLine();
		System.out.println("지역을 선택해주세요.");
		System.out.println("0을 선택하면 이전 화면으로 돌아갑니다.");
		System.out.print("번호입력:");
		areaSelect(scan.nextLine());
		
		chooseReturn();
		
	}

	private void chooseReturn() {
		System.out.println("다른 지역 보관함 위치를 보시겠습니까?");
		System.out.println();
		System.out.println("1.보기\t0.나가기");
		System.out.print("번호입력:");
		
		String no = scan.nextLine();
		
		if (no.equals("1")) {
			System.out.println();
			System.out.println();
			screen();
		}
		else if(no.equals("0")) {
			System.out.println();
			System.out.println();
			MemberMenu.membermenu();
		}
		else {
			System.out.println();
			System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			
			chooseReturn();
		}
	}
	
    private void areaSelect(String no) {
    	String area = "";
    	String id = "";
    	switch (no) {
        case "0":
        	System.out.println("Enter를 누르면 이전 화면으로 돌아갑니다.");
        	scan.nextLine();
            MemberMenu.membermenu();
            break;
        case "1":
            area = "종로3가";
            id = "MTRS13319";
            break;
        case "2":
            area = "서울";
            id = "MTRS11150";
            break;
        case "3":
            area = "용산";
            id = "MTRKR1135";
            break;
        case "4":
            area = "왕십리";
            id = "MTRS12208";
            break;
        case "5":
            area = "강변";
            id = "MTRS12214";
            break;
        case "6":
            area = "동대문";
            id = "MTRS14421";
            break;
        case "7":
            area = "상봉";
            id = "MTRKRK2K120";
            break;
        case "8":
            area = "안암";
            id = "MTRS162640";
            break;
        case "9":
            area = "미아";
            id = "MTRS14415";
            break;
        case "10":
            area = "도봉";
            id = "MTRKR10114";
            break;
        case "11":
            area = "노원";
            id = "MTRS172715";
            break;
        case "12":
            area = "연신내";
            id = "MTRS13311";
            break;
        case "13":
        	area = "서대문";
        	id = "MTRS152533";
            break;
        case "14":
            area = "홍대입구";
            id = "MTRS12239";
            break;
        case "15":
            area = "목동";
            id = "MTRS152521";
            break;
        case "16":
            area = "개화";
            id = "MTRS990901";
            break;
        case "17":
            area = "구로";
            id = "MTRKR1P141";
            break;
        case "18":
            area = "금천구청";
            id = "MTRKR1P144";
            break;
        case "19":
            area = "여의도";
            id = "MTRS152527";
            break;
        case "20":
            area = "노량진";
            id = "MTRKR1136";
            break;
        case "21":
            area = "서울대입구";
            id = "MTRS12228";
            break;
        case "22":
            area = "서초";
            id = "MTRS12224";
            break;
        case "23":
            area = "강남";
            id = "MTRS12222";
            break;
        case "24":
            area = "잠실";
            id = "MTRS12216";
            break;
        case "25":
            area = "천호";
            id = "MTRS152548";
            break;
        default:
        	System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
        	screen();
    	}
    	System.out.println();
	
		findMetro(area, id);
	}

	private void findMetro(String area, String id) {
		
    	String url = "http://apis.data.go.kr/1613000/SubwayInfoService/getKwrdFndSubwaySttnList?";
		url += "ServiceKey=oMmFtyn6y40ikar6b1ETbGrMTEdFmfRJyqTn%2B7H85I9D0W8TV2G4fFbKUfcRmGChZCArFikDa%2B2H629%2FdLIJXA%3D%3D";
		
		url += "&_type=json";
		
		url += "&numOfRows=10";
		
		url += "&pageNo=1";
		
		url += "&subwayStationName=" + URLEncoder.encode(area);
		
		try {
			
			URL obj_url = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection)obj_url.openConnection();
			
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        BufferedReader reader = null;
	        
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        
	        JSONParser parser = new JSONParser();
	        
	        JSONObject root = (JSONObject)parser.parse(reader);
	        
	        JSONObject response = (JSONObject)root.get("response");
	        
	        JSONObject body = (JSONObject)response.get("body");
	        
	        JSONObject items = (JSONObject)body.get("items");
	        
	        ArrayList<String> temp = new ArrayList<String>();
	        
	        if (items.get("item") instanceof JSONObject) {
	        	JSONObject item = (JSONObject)items.get("item");
	        	
	        	System.out.println("이 지역 보관함은 " + item.get("subwayStationName") + "역 1번 출구 옆에 있습니다.");
	        	AdminMenu.printLine();
	        }
	        else {
	        	JSONArray arr = (JSONArray)items.get("item");
	        	
	        	for (Object obj : arr) {
	        		JSONObject item = (JSONObject)obj;
	        		
	        		if (item.get("subwayStationId").equals(id)) {
	        			System.out.println("이 지역 보관함은 " + item.get("subwayStationName") + "역 1번 출구 옆에 있습니다.");
	        			AdminMenu.printLine();
	        		}
	        	}
	        			
	        }
	        
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
		
		
	}

	private void areaList(){
    String area = "1.종로구 " + " 2.중구 " + " 3.용산구 " + " 4.성동구 " + " 5.광진구\n"
            + "6.동대문구 " + " 7.중랑구 " + "8.성북구 " + " 9.강북구 " + " 10.도봉구\n"
            + "11.노원구 " + " 12.은평구 " + " 13.서대문구 " + " 14.마포구 " + " 15.양천구\n"
            + "16.강서구 " + " 17.구로구 " + " 18.금천구 " + " 19.영등포구 " + " 20.동작구\n"
            + "21.관악구 " + " 22.서초구 " + " 23.강남구 " + " 24.송파구 " + " 25.강동구\n";
    System.out.println(area);
}
}
