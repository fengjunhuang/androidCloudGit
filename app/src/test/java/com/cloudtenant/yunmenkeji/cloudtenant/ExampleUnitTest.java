package com.cloudtenant.yunmenkeji.cloudtenant;

import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.cloudtenant.yunmenkeji.cloudtenant.util.base64.BackAES;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);


    }
    @Test
    public void test() throws Exception {
   String s="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";
    String sss="u2OpTRuGQLNF99AaWK70E3KjZK3cU+9+R+Dk9KcUaRrZoyESV6o1UO/NegzQXUp1gG7tJH76spvgpNGqEoe9iSXcy8MD3vKkrd0r6Yej9zaGo8YF/HswmPRu3md0Jpr9uiY7Gs+3q6EObyQux4Q8baPb1WineyNP6yt/vuRAhWI=";
  String s1111="u2OpTRuGQLNF99AaWK70E3KjZK3cU+9+R+Dk9KcUaRpte4Nbyb+pO7+TEiqakE3EK5LfeEq8g/b88GCuFeIDeBaQGFyO187tpwSx230l5O62Ge07ply0QcxXK97S5J7xxBeXocBqL/H0QppEGZnMe4wHR6wSN+S5s85AyfW9m1+swJmnOFBR1Woa/R/M85KA";
    String ss= AESOperator.getInstance().decrypt(s1111);
    String system=  AESOperator.getInstance().encrypt("{page :5}");
   System.out.print("");
    }


}