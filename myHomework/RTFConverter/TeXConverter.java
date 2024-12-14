public class TeXConverter implements TextConverter {

  public String convertCharacter(String RTF) {
    return RTF.replace("C", "c");
  }

  public String convertFontChange(String RTF) {
    return RTF.replace("F", "_");
  }

  public String convertParagraph(String RTF) {
    return RTF.replace("P", "|");
  }

  public TeXText getConvertedTextFormat(String RTF) {
    RTF = convertCharacter(RTF);
    RTF = convertFontChange(RTF);
    RTF = convertParagraph(RTF);
    return new TeXText(RTF);
  }
}
