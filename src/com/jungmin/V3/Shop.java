package com.codestates.seb.V3; // 패키지 선언: 코드의 소속을 나타내며, 관리를 용이하게 합니다.

import java.util.*; // 자바 유틸리티 패키지에서 모든 클래스를 가져옵니다. 주로 컬렉션 프레임워크를 사용할 때 필요합니다.

// Shop 클래스 정의: 매장 관련 정보를 관리하는 클래스입니다.
public class Shop {
  // 인스턴스 변수 선언
  private String shopName; // 매장의 이름
  private Map<String, Integer> menus = new HashMap<>(); // 메뉴명과 가격을 저장하는 해시맵

  // 생성자: 매장 이름을 초기화합니다.
  public Shop(String shopName) {
    this.shopName = shopName;  // 매장 이름을 인스턴스 변수에 할당
  }

  // 매장 이름을 반환하는 메서드
  public String getShopName() {
    return shopName;
  }

  // 메뉴 정보를 반환하는 메서드
  public Map<String, Integer> getMenus() {
    return menus;  // 메뉴명과 가격이 저장된 맵을 반환
  }

  /**
   * addFood 메서드: 새 음식과 그 가격을 매장 메뉴에 추가합니다.
   * @param foodName 추가할 음식의 이름
   * @param price 해당 음식의 가격
   * @return boolean - 추가 성공 시 true, 실패(중복 있을 경우) 시 false를 반환합니다.
   */
  public boolean addFood(String foodName, int price) {
    if (menus.containsKey(foodName)) { // 메뉴에 이미 해당 음식이 있는지 확인
      return false;  // 이미 있으면 false 반환
    } else {
      menus.put(foodName, price);  // 없으면 메뉴에 추가
      return true;  // 성공적으로 추가되면 true 반환
    }
  }

  /**
   * isExistMenu 메서드: 특정 음식이 메뉴에 존재하는지 확인합니다.
   * @param foodName 확인할 음식의 이름
   * @return boolean - 메뉴에 음식이 존재하면 true, 존재하지 않으면 false를 반환합니다.
   */
  public boolean isExistMenu(String foodName) {
    return menus.containsKey(foodName); // 메뉴에 해당 음식이 있는지 확인하여 결과 반환
  }
}
