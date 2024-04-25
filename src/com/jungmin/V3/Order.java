package com.codestates.seb.V3; // 패키지 선언: 코드의 소속을 나타내며, 관리를 용이하게 합니다.

// Order 클래스 정의: 주문 관련 정보를 관리하는 클래스입니다.
public class Order {
  // 인스턴스 변수 선언
  private String customerName; // 고객 이름을 저장하는 변수
  private String shopName;     // 주문한 음식점의 이름을 저장하는 변수
  private String foodName;     // 주문한 음식의 이름을 저장하는 변수

  /**
   * Order 생성자: 주문 정보를 초기화합니다.
   * @param customerName 고객의 이름
   * @param shopName 주문한 음식점의 이름
   * @param foodName 주문한 음식의 이름
   */
  public Order(String customerName, String shopName, String foodName) {
    this.customerName = customerName; // 고객 이름을 인스턴스 변수에 할당
    this.shopName = shopName;         // 음식점 이름을 인스턴스 변수에 할당
    this.foodName = foodName;         // 음식 이름을 인스턴스 변수에 할당
  }

  // 고객 이름을 반환하는 메서드
  public String getCustomerName() {
    return customerName;
  }

  // 매장 이름을 반환하는 메서드
  public String getShopName() {
    return shopName;
  }

  // 음식 이름을 반환하는 메서드
  public String getFoodName() {
    return foodName;
  }

  /**
   * isExistOrder 메서드: 입력받은 고객 이름, 매장 이름, 음식 이름이 현재 주문과 일치하는지 확인합니다.
   * @param customerName 확인할 고객의 이름
   * @param shopName 확인할 매장의 이름
   * @param foodName 확인할 음식의 이름
   * @return boolean - 일치하면 true, 일치하지 않으면 false를 반환합니다.
   */
  public boolean isExistOrder(String customerName, String shopName, String foodName) {
    return this.customerName.equals(customerName) && // 고객 이름 비교
            this.shopName.equals(shopName) &&         // 매장 이름 비교
            this.foodName.equals(foodName);           // 음식 이름 비교
  }
}
