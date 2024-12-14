public class TextWidgetConverter implements TextConverter {
 
  public String convertCharacter(String RTF) {
    return RTF.replace("C", "<Char>");
  }

  public String convertFontChange(String RTF) {
    return RTF.replace("F", "<Font>");
  }

  public String convertParagraph(String RTF) {
    return RTF.replace("P", "<Paragraph>");
  }

  public TextWidget getConvertedTextFormat(String RTF) {
    RTF = convertCharacter(RTF);
    RTF = convertFontChange(RTF);
    RTF = convertParagraph(RTF);
    return new TextWidget(RTF);
  }
}
