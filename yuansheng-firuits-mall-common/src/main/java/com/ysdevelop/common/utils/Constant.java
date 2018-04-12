package com.ysdevelop.common.utils;

public class Constant {
  public static String MOBILE_MSG = "randomNumber";
  public static String TOKEN_NAME = "token";
	
  
  /**
   * 菜单类型
   *
   * @author oldHuang
   * @email 
   * @date
   */
  public enum QueryType {
      /**
       * 目录
       */
      SALES(0),
      /**
       * 菜单
       */
      NEW(1),
      /**
       * 按钮
       */
      DISCOUT(2);

      private int value;

      private QueryType(int value) {
          this.value = value;
      }

      public int getValue() {
          return value;
      }
  }
}
