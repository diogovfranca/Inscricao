/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diogo
 */
public class ValidaCPFTest {
  
  public ValidaCPFTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   * Test of isCPF method, of class ValidaCPF.
   */
  @Test
  public void testIsCPF() {
    System.out.println("isCPF");
    String CPF = "06663510908";
    boolean expResult = true;
    boolean result = ValidaCPF.isCPF(CPF);
    assertEquals(expResult, result);
    CPF = "09734694987";
    result = ValidaCPF.isCPF(CPF);
    assertEquals(expResult, result);
    
    // TODO review the generated test code and remove the default call to fail.
  }

  /**
   * Test of imprimeCPF method, of class ValidaCPF.
   */
  @Test
  public void testImprimeCPF() {
    System.out.println("imprimeCPF");
    String CPF = "06663510908";
    String expResult = "066.635.109-08";
    String result = ValidaCPF.imprimeCPF(CPF);
    assertEquals(expResult, result);
    CPF = "06663510908";
    result = ValidaCPF.imprimeCPF(CPF);   
    assertFalse(result, false);
    assertTrue(result, true);
    // TODO review the generated test code and remove the default call to fail.
  }
}
