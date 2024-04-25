package com.codestates.seb.V1;  // 패키지 선언: 코드가 속할 패키지를 지정합니다.

public class Feedback {  // Feedback 클래스를 선언합니다. 이 클래스를 통해 피드백 관련 데이터를 다룰 수 있습니다.

  // 클래스 변수 선언
  private String customerName;  // 고객 이름을 저장하는 변수
  private String shopName;      // 매장 이름을 저장하는 변수
  private String foodName;      // 음식 이름을 저장하는 변수
  private int grade;            // 평점을 저장하는 정수형 변수

  /**
   * Feedback 클래스의 생성자
   * @param customerName 고객의 이름
   * @param shopName 매장의 이름
   * @param foodName 주문한 음식의 이름
   * @param grade 고객이 매긴 평점
   */
  public Feedback(String customerName, String shopName, String foodName, int grade) {
    this.customerName = customerName;  // 고객 이름을 클래스 변수에 저장합니다.
    this.shopName = shopName;          // 매장 이름을 클래스 변수에 저장합니다.
    this.foodName = foodName;          // 음식 이름을 클래스 변수에 저장합니다.
    this.grade = grade;                // 평점을 클래스 변수에 저장합니다.
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
   * 평점을 별(★) 형태의 문자열로 변환하여 반환하는 메서드
   * @return 변환된 별점 문자열
   */
  private String getGrade() {
    String star = "";  // 별점을 저장할 빈 문자열 초기화
    for(int i = 0; i < this.grade; i++) {  // 평점 수만큼 반복
      star += "★";  // 별 문자를 추가
    }
    return star;  // 완성된 별점 문자열을 반환
  }

  /**
   * 고객의 피드백 정보를 출력하는 메서드
   */
  public void printInfo() {
    System.out.println(this.customerName + " [고객님]");  // 고객 이름 출력
    System.out.println("-------------------------");
    System.out.println("주문 매장 : " + this.shopName);  // 매장 이름 출력
    System.out.println("주문 메뉴 : " + this.foodName);  // 주문한 음식 이름 출력
    System.out.println("별점 : " + getGrade());  // 별점을 출력
  }
}
