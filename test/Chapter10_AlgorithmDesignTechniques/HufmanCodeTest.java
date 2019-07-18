package Chapter10_AlgorithmDesignTechniques;

import org.junit.Assert;
import org.junit.Test;

public class HufmanCodeTest {

  @Test
  public void encodeAndDecode() {
    String text = "dfgluhdfvpzdfvfdubvfcfxngliuerbzcvnhfgx";
    HufmanCode hufmanCode = new HufmanCode(text);
    String encodeText = hufmanCode.encode(text);
    String decodetext = hufmanCode.decode(encodeText);
    Assert.assertEquals(decodetext, text);
  }

  @Test
  public void encodeSameCharsetString() {
    String originText = "abcdfg;ibxgmw'ETMBNCGVNP'PJGNGFZ";
    String text = "ETibxmwZc";
    HufmanCode hufmanCode = new HufmanCode(originText);
    String encodeText = hufmanCode.encode(text);
    String decodetext = hufmanCode.decode(encodeText);
    Assert.assertEquals(decodetext, text);
  }

  @Test
  public void encodeLowerLength() {
    String text = "aaaaaaaaaaaaaaaaaposhr;itsrhdhhhhhhhhhhhhhhhhhhhhhhdfffffffffffffflllllllll";
    HufmanCode hufmanCode = new HufmanCode(text);
    String encodeText = hufmanCode.encode(text);
    Assert.assertTrue(encodeText.length() < text.length() * 8);
  }

}
