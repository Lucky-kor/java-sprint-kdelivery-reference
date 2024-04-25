package com.codestates.seb.V3;

import java.util.ArrayList;
import java.util.Scanner;

// 클래스를 정의 합니다.
public class KDeliveryMain {
  private ArrayList<Shop> shops = new ArrayList<>();
  private ArrayList<Order> orders = new ArrayList<>();
  private ArrayList<Feedback> feedbacks = new ArrayList<>();

  private Scanner s; // 사용자의 입력을 받는 객체 생성

  public KDeliveryMain() {
    this.s = new Scanner(System.in);
  }

  /**
   * @close() : 프로그램 종료를 위해 사용되는 메서드
   * 사용자가 종료를 선언하면 동작합니다.
   * main()에서 활용됩니다.
   * */

  public void close() {
    s.close();
  }


  /**
   * selectMainMenu() : 기능을 나열하며, 사용자가 원하는 기능을 정수로 받습니다.
   * */
  public int selectMainMenu() {
    System.out.println("  [치킨의 민족 프로그램 V1] ");
    System.out.println("-------------------------");
    System.out.println("1) [사장님용] 음식점 등록하기");
    System.out.println("2) [고객님과 사장님용] 음식점 별점 조회하기");
    System.out.println("3) [고객님용] 음식 주문하기");
    System.out.println("4) [고객님용] 별점 등록하기");
    System.out.println("5) 프로그램 종료하기");
    System.out.println("-------------------------");
    System.out.println("[시스템] 무엇을 도와드릴까요?");

    String choiceNumber = s.nextLine();

    int choice = 6;

    if(!isValidNumber(choiceNumber)) {
      System.out.println("[시스템] 숫자만 입력해야 합니다.");
    } else {
      choice = Integer.parseInt(choiceNumber);
    }
    return choice;
  }

  /**
   * @selectAddShopMenu() : 음식점의 정보를 등록합니다.
   * */

  public void selectAddShopMenu() {
    System.out.println("[안내] 반갑습니다. 가맹주님!");
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.print(">>>");
    // 입력
    String shopName = s.nextLine();

    System.out.println("[안내] 대표 메뉴 이름은 무엇인가요?");
    System.out.print(">>>");
    // 입력
    String foodName = s.nextLine();

    System.out.println("[안내] 해당 메뉴 가격은 얼마인가요?");
    System.out.print(">>>");
    // 입력
    String priceStr = s.nextLine();
    int price;
    if(isValidNumber(priceStr)) {
      price = Integer.parseInt(priceStr);
    } else {
      System.out.println("[시스템] 숫자만 입력해야 합니다.");
      return;
    }

      int shopIndex = getShopIndex(shops, shopName);

      if(shopIndex != -1) {
        boolean isValid = shops.get(shopIndex).addFood(foodName, price);
        if(!isValid) {
          System.out.println("[시스템] 동일한 이름의 메뉴를 추가할 수 없습니다.");
          return;
        }
      } else {
        Shop shop = new Shop(shopName);
        shop.addFood(foodName, price);
        shops.add(shop);
      }
        System.out.printf("[안내] %s에 음식(%s, %d) 추가되었습니다.%n", shopName, foodName, price);
        System.out.println("[시스템] 가게 등록이 정상 처리되었습니다.");
  }

  /**
   * @selectDashboardMenu() : 해당 메서드는 등록된 가게 정보를 출력합니다.
   * Feedback.java 파일의 클래스 및 메서드를 활용합니다.
   * */
  public void selectDashboardMenu() {
    if(feedbacks.size() == 0) {
      System.out.println("[시스템] 현재 등록된 평가가 없습니다.");
    } else {
      for(Feedback feedback: feedbacks) {
        feedback.printInfo();
      }
    }
  }


  /**
   * @selectOrderMenu() : 주문 기능
   * 사용자의 입력을 받아 orders 객체에 저장
   * */

  public void selectOrderMenu() {
    System.out.println("[안내] 고객님! 메뉴 주문을 진행하겠습니다!");
    System.out.println("[안내] 주문자 이름을 알려주세요!");
    System.out.println(">>>");
    // 사용자 이름 입력
    String customerName = s.nextLine();

    System.out.println("[안내] 주문할 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    // 음식점 이름 입력
    String shopName = s.nextLine();

    System.out.println("[안내] 주문할 메뉴 이름을 알려주세요!");
    System.out.println(">>>");
    // 메뉴 이름 입력
    String foodName = s.nextLine();

      // shopName이 실제로 존재하는지 확인
      // else라면 아예 주문 자체가 불가능
      int shopIndex = getShopIndex(shops, shopName);
      if(shopIndex != -1) {
        // 이제는 상점은 찾았으니, 메뉴가 있는지 검증해야 합니다.
        if(shops.get(shopIndex).isExistMenu(foodName)) {
          Order order = new Order(customerName, shopName, foodName);
          orders.add(order);
        } else {
          System.out.printf("[시스템] %s 가게에는 해당 메뉴가 존재하지 않습니다.%n", shopName);
          return;
        }
      System.out.printf("[안내] %s님!", customerName);
      System.out.printf("[안내] %s 매장에 %s 주문이 완료되었습니다.", shopName, foodName);
    } else {
      System.out.println("[시스템] 해당 점포가 존재하지 않습니다.");
    }
  }


  /**
   * @selectFeedbackMenu() : 메뉴의 피드백을 입력받는 기능
   * */

  public void selectFeedbackMenu() {
    System.out.println("[안내] 고객님! 별점 등록을 진행합니다.");
    System.out.println("[안내] 주문자 이름은 무엇인가요?");
    System.out.println(">>>");
    // 주문자 이름 입력
    String customerName = s.nextLine();
    System.out.println("[안내] 음식점 상호는 무엇인가요?");
    System.out.println(">>>");
    // 음식점 이름 입력
    String shopName = s.nextLine();

    System.out.println("[안내] 주문하신 음식 이름은 무엇인가요?");
    System.out.println(">>>");
    // 메뉴 이름 입력
    String foodName = s.nextLine();

    boolean isChecked = false;
    for(Order order: orders) {
      if(order.isExistOrder(customerName, shopName, foodName)) {
        // 일치하는 영수증이 있을 경우
        isChecked = true;
      }
    }
    if(!isChecked) {
      System.out.println("[시스템] 주문을 다시 확인해주세요.");
      return;
    }

    System.out.println("[안내] 음식 맛은 어떠셨나요? (1점 ~ 5점)");
    System.out.println(">>>");
    // 별점 입력
    String gradeStr = s.nextLine();
    int grade;
    if(isValidNumber(gradeStr)) {
      grade = Integer.parseInt(gradeStr);
    } else {
      System.out.println("[시스템] 숫자만 입력해야 합니다.");
      return;
    }

    Feedback feedback = new Feedback(customerName, shopName, foodName, grade);
    feedbacks.add(feedback);
    System.out.println("[안내] 리뷰 등록이 완료되었습니다.");
  }

  public static void main(String[] args) {
    KDeliveryMain kDeliveryMain = new KDeliveryMain();
    int count = 5;

    do {
      count = kDeliveryMain.selectMainMenu();
      switch (count) {
        case 1:  {
          kDeliveryMain.selectAddShopMenu();
          break;
        }
        case 2: {
          kDeliveryMain.selectDashboardMenu();
          break;
        }
        case 3: {
          kDeliveryMain.selectOrderMenu();
          break;
        }
        case 4: {
          kDeliveryMain.selectFeedbackMenu();
          break;
        }
        case 5: {
          for(Shop s : kDeliveryMain.shops) {
            System.out.println(s.getShopName());
            System.out.println(s.getMenus());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=");
          }
        }
      }
    } while(count != 5);

    kDeliveryMain.close();
    System.out.println("[안내] 이용해주셔서 감사합니다.");
  }

  public int getShopIndex(ArrayList<Shop> shopList, String shopName) {
    int currentIdx = -1;
    for(int i = 0; i < shopList.size(); i++) {
      if(shopList.get(i).getShopName().equals(shopName)) {
        return i;
      }
    }
    return currentIdx;
  }

  public boolean isValidNumber(String str) {
    if(str.length() == 0) return false;
    char[] arr = str.toCharArray();
    String table = "0123456789";

      for (char c : arr) {
          if (table.indexOf(c) == -1) return false;
      }
    return true;
  }
}