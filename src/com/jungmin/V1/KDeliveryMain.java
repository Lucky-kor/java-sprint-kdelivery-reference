package com.codestates.seb.V1; // 패키지 선언: 코드의 소속을 나타내며, 관리를 용이하게 합니다.

import java.util.Scanner; // java.util 패키지에서 Scanner 클래스를 가져옵니다. 사용자 입력을 받기 위해 필요합니다.

// KDeliveryMain 클래스 정의: 배달 서비스 프로그램의 주 실행 클래스입니다.
public class KDeliveryMain {
  // 최대 허용치 상수 정의
  private static int SHOP_MAX = 5;      // 최대 등록 가능한 음식점 수
  private static int ORDER_MAX = 5;     // 최대 주문 가능 횟수
  private static int FEEDBACK_MAX = ORDER_MAX;  // 최대 피드백 등록 가능 횟수, 주문 횟수와 동일

  // 객체 배열 선언: 여러 데이터를 저장하기 위한 배열
  private Shop[] shops;      // 음식점 정보를 저장할 배열
  private Order[] orders;    // 주문 정보를 저장할 배열
  private Feedback[] feedbacks;  // 피드백 정보를 저장할 배열

  private Scanner s;  // 사용자 입력을 받기 위한 Scanner 객체

  // KDeliveryMain 생성자: 객체 초기화와 함께 주요 변수를 설정합니다.
  public KDeliveryMain() {
    this.s = new Scanner(System.in);  // Scanner 객체 생성
    initValues();  // 객체 배열 초기화 메서드 호출
  }

  // initValues 메서드: 각 배열의 크기를 초기화합니다.
  private void initValues() {
    this.shops = new Shop[SHOP_MAX];      // Shop 객체 배열 생성
    this.orders = new Order[ORDER_MAX];   // Order 객체 배열 생성
    this.feedbacks = new Feedback[FEEDBACK_MAX];  // Feedback 객체 배열 생성
  }

  // close 메서드: Scanner 객체를 닫고 프로그램 종료 전 리소스 정리
  public void close() {
    s.close();
  }

  // selectMainMenu 메서드: 사용자로부터 주 메뉴 선택을 입력받아 반환합니다.
  public int selectMainMenu() {
    // 메인 메뉴 출력
    System.out.println("  [치킨의 민족 프로그램 V1] ");
    System.out.println("-------------------------");
    System.out.println("1) [사장님용] 음식점 등록하기");
    System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
    System.out.println("3) [고객님용] 음식 주문하기");
    System.out.println("4) [고객님용] 별점 등록하기");
    System.out.println("5) 프로그램 종료하기");
    System.out.println("-------------------------");
    System.out.println("[시스템] 무엇을 도와드릴까요?");
    // 사용자 입력 받아 정수로 변환
    return Integer.parseInt(s.nextLine());
  }

  // selectAddShopMenu 메서드: 음식점 등록을 위한 사용자 입력을 받아 처리합니다.
  public void selectAddShopMenu() {
    // 음식점 정보 입력 받기
    System.out.println("[안내] 반갑습니다. 가맹주님!");
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.print(">>>");
    String shopName = s.nextLine();  // 상호 입력 받기

    System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
    System.out.print(">>>");
    String foodName = s.nextLine();  // 메뉴 이름 입력 받기

    System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
    System.out.print(">>>");
    int price = Integer.parseInt(s.nextLine());  // 가격 입력 받기

    // Shop 객체 생성 및 메뉴 추가
    Shop shop = new Shop(shopName);
    shop.addFood(foodName, price);  // 메뉴 추가

    int currentIndex = isValidIndex(SHOP_MAX);  // 유효한 인덱스 확인
    if(currentIndex != -1) {  // 유효한 경우
      shops[currentIndex] = shop;  // 배열에 Shop 객체 저장
      System.out.printf("[안내] %s에 음식(%s, %d) 추가되었습니다.", shopName, foodName, price);
      System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");
    } else {
      System.out.println("[시스템] 더 이상 새로운 가게를 등록할 수 없습니다.");
    }
  }

  // selectDashboardMenu 메서드: 등록된 가게 정보를 출력합니다.
  public void selectDashboardMenu() {
    if(feedbacks[0] == null) {
      System.out.println("[시스템] 현재 등록된 평가가 없습니다.");
    } else {
      for(Feedback feedback: feedbacks) {  // 등록된 피드백 출력
        if(feedback == null) {
          break;
        }
        feedback.printInfo();
      }
    }
  }

  // selectOrderMenu 메서드: 사용자로부터 주문 정보를 입력받아 처리합니다.
  public void selectOrderMenu() {
    // 주문 정보 입력 받기
    System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
    System.out.println("[안내] 주문자 이름을 알려주세요!");
    System.out.println(">>>");
    String customerName = s.nextLine();  // 주문자 이름 입력 받기

    System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    String shopName = s.nextLine();  // 음식점 이름 입력 받기

    System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
    System.out.println(">>>");
    String foodName = s.nextLine();  // 메뉴 이름 입력 받기

    // Order 객체 생성 및 주문 추가
    Order order = new Order(customerName, shopName, foodName);
    int currentIndex = isValidIndex(ORDER_MAX);  // 유효한 인덱스 확인
    if(currentIndex != -1) {
      orders[currentIndex] = order;  // 배열에 Order 객체 저장
      System.out.printf("[안내] %s님!", customerName);
      System.out.printf("[안내] %s 매장에 %s 주문이 완료되었습니다.", shopName, foodName);
    } else {
      System.out.println("[시스템] 더 이상 주문을 할 수 없습니다.");
    }
  }

  // selectFeedbackMenu 메서드: 사용자로부터 피드백 정보를 입력받아 처리합니다.
  public void selectFeedbackMenu() {
    // 피드백 정보 입력 받기
    System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
    System.out.println("[안내] 주문자 이름은 무엇인가요?");
    System.out.println(">>>");
    String customerName = s.nextLine();  // 주문자 이름 입력 받기

    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    String shopName = s.nextLine();  // 음식점 이름 입력 받기

    System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
    System.out.println(">>>");
    String foodName = s.nextLine();  // 메뉴 이름 입력 받기

    System.out.println("[안내] 음식 맛은 어떠셨나요? (1점 ~ 5점)");
    System.out.println(">>>");
    int grade = Integer.parseInt(s.nextLine());  // 별점 입력 받기

    // Feedback 객체 생성 및 피드백 추가
    Feedback feedback = new Feedback(customerName, shopName, foodName, grade);
    int currentIndex = isValidIndex(FEEDBACK_MAX);  // 유효한 인덱스 확인
    if(currentIndex != -1) {
      feedbacks[currentIndex] = feedback;  // 배열에 Feedback 객체 저장
      System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
    } else {
      System.out.println("[시스템] 더 이상 리뷰 등록이 불가능합니다.");
    }
  }

  // main 메서드: 프로그램의 시작점
  public static void main(String[] args) {
    KDeliveryMain kDeliveryMain = new KDeliveryMain();  // 메인 클래스 객체 생성
    int count = 5;  // 메인 메뉴 반복 제어 변수

    // 메뉴 선택 반복
    do {
      count = kDeliveryMain.selectMainMenu();  // 메뉴 선택
      switch (count) {
        case 1:  { kDeliveryMain.selectAddShopMenu(); break; }  // 음식점 등록 처리
        case 2:  { kDeliveryMain.selectDashboardMenu(); break; }  // 별점 조회 처리
        case 3:  { kDeliveryMain.selectOrderMenu(); break; }  // 주문 처리
        case 4:  { kDeliveryMain.selectFeedbackMenu(); break; }  // 피드백 등록 처리
      }
    } while(count != 5);  // '5' 선택 시 종료

    kDeliveryMain.close();  // 리소스 정리
    System.out.println("[안내] 이용해주셔서 감사합니다.");  // 종료 메시지
  }

  // isValidIndex 메서드: 입력된 배열의 첫 번째 빈 위치를 찾아 반환합니다.
  public int isValidIndex(int maxLength) {
    int currentIdx = -1;
    for(int i = 0; i < maxLength; i++) {
      if(orders[i] == null) {
        currentIdx = i;  // 빈 위치 찾기
        break;
      }
    }
    return currentIdx;
  }
}
