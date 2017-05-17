package net.thucydides.ebi.cucumber.framework.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StringHelper {

  public static int getTextOccunace(String str, String findStr) throws Exception {
    int count = 0;
    try{
      int lastIndex = 0;
      while (lastIndex != -1) {
        lastIndex = str.indexOf(findStr, lastIndex);
        if (lastIndex != -1) {
          count++;
          lastIndex += findStr.length();
        }
      }
    }catch (Exception e){
      throw new Exception(e.getMessage());
    }
    return count;
  }

}
