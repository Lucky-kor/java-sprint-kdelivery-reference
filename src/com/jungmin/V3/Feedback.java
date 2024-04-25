package com.codestates.seb.V3; // 패키지 선언: 코드의 소속을 나타내며, 관리를 용이하게 합니다.

// Feedback 클래스 정의: 고객 피드백 정보를 관리하는 클래스입니다.
public class Feedback {
  // 인스턴스 변수 선언
  private String customerName; // 고객 이름을 저장하는 변수
  private String shopName;     // 주문한 음식점의 이름을 저장하는 변수
  private String foodName;     // 주문한 음식의 이름을 저장하는 변수
  private int grade;           // 고객이 매긴 평점을 저장하는 변수

  /**
   * Feedback 생성자: 피드백 정보를 초기화합니다.
   * @param customerName 고객의 이름
   * @param shopName 주문한 음식점의 이름
   * @param foodName 주문한 음식의 이름
   * @param grade 고객이 매긴 평점
   */
  public Feedback(String customerName, String shopName, String foodName, int grade) {
    this.customerName = customerName; // 고객 이름을 인스턴스 변수에 할당
    this.shopName = shopName;         // 매장 이름을 인스턴스 변수에 할당
    this.foodName = foodName;         // 음식 이름을 인스턴스 변수에 할당
    this.grade = grade;               // 평점을 인스턴스 변수에 할당
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
   * getGrade 메서드: 사용자가 입력한 평점을 별(★) 형태로 변환하여 반환합니다.
   * @return 별점 형태의 문자열
   */
  private String getGrade() {
    String star = "";  // 별점을 저장할 빈 문자열 초기화
    for (int i = 0; i < this.grade; i++) {  // 평점 수만큼 반복
      star += "★";  // 별 문자를 추가
    }
    return star;  // 완성된 별점 문자열을 반환
  }

  /**
   * printInfo 메서드: 고객의 피드백 정보를 출력합니다.
   */
  public void printInfo() {
    System.out.println(this.customerName + " [고객님]");  // 고객 이름 출력
    System.out.println("-------------------------");
    System.out.println("주문 매장 : " + this.shopName);  // 매장 이름 출력
    System.out.println("주문 메뉴 : " + this.foodName);  // 주문한 음식 이름 출력
    System.out.println("별점 : " + getGrade());  // 변환된 별점을 출력
  }
}
