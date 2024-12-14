public interface TextConverter {

  public String convertCharacter(String RTF);
  public String convertFontChange(String RTF);
  public String convertParagraph(String RTF);
  public TextFormat getConvertedTextFormat(String RTF);
}
