package com.codestates.seb.V1; // 패키지 선언: 코드의 소속을 나타내며, 관리를 용이하게 합니다.

// Shop 클래스 정의: 매장 관련 정보를 관리하는 클래스입니다.
public class Shop {
  // 상수 선언
  private static final int FOOD_MAX = 5; // 등록 가능한 최대 음식 수
  private static final String EMPTY_FOOD = ""; // 빈 음식명 초기화를 위한 상수
  private static final int EMPTY_PRICE = 0; // 빈 가격 초기화를 위한 상수

  // 인스턴스 변수 선언
  private String shopName;     // 매장의 이름
  private String[] foodNames;  // 음식 이름을 저장하는 배열
  private int[] prices;        // 각 음식의 가격을 저장하는 배열

  /**
   * Shop 생성자: 매장 이름을 초기화하고 나머지 변수들은 initValues() 메서드를 통해 초기화합니다.
   * @param shopName 매장의 이름
   */
  public Shop(String shopName) {
    this.shopName = shopName;  // 매장 이름을 인스턴스 변수에 할당
    initValues();              // 음식명과 가격 정보 배열 초기화 메서드 호출
  }

  /**
   * initValues 메서드: 음식명과 가격 정보 배열을 생성하고 초기화합니다.
   */
  private void initValues() {
    foodNames = new String[FOOD_MAX];  // 음식명 배열 생성
    prices = new int[FOOD_MAX];        // 가격 배열 생성

    for(int i = 0; i < foodNames.length; i++) {
      foodNames[i] = EMPTY_FOOD;  // 모든 음식명을 빈 문자열로 초기화
    }
  }

  /**
   * addFood 메서드: 새 음식을 메뉴에 추가합니다.
   * @param foodName 추가할 음식의 이름
   * @param price 해당 음식의 가격
   */
  public void addFood(String foodName, int price) {
    int currentIdx = -1;  // 추가할 위치를 찾기 위한 인덱스 변수
    for(int i = 0; i < foodNames.length; i++) {
      if(foodNames[i].equals(EMPTY_FOOD)) {  // 빈 위치 찾기
        currentIdx = i;
        break;
      }
    }
    if(currentIdx != -1) {  // 빈 위치가 있으면
      foodNames[currentIdx] = foodName;  // 음식명 저장
      prices[currentIdx] = price;        // 가격 저장
    } else {
      // 예외 처리: 더 이상 추가할 수 없을 때 처리 로직
    }
  }
}
