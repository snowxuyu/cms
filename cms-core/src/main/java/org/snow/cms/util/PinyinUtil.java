package org.snow.cms.util;

/*import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;*/

public class PinyinUtil {
    /*private static final HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

    public static String str2Pinyin(String str, String fill) {
        try {
            StringBuffer sb = new StringBuffer();
            if (fill == null) fill = "";
            boolean isCn = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if ((i > 0) && (isCn)) {
                    sb.append(fill);
                }
                if (c == ' ') {
                    sb.append(fill);
                }

                if ((c >= '一') && (c <= 40869)) {
                    isCn = true;
                    sb.append(net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, format)[0]);
                } else {
                    if (((c >= 'a') && (c <= 'z')) || ((c >= 'A') && (c <= 'Z'))) {
                        sb.append(c);
                    }
                    isCn = false;
                }
            }
            return sb.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String strFirst2Pinyin(String str) {
        try {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if ((c >= '一') && (c <= 40869)) {
                    sb.append(net.sourceforge.pinyin4j.PinyinHelper.toHanyuPinyinStringArray(c, format)[0].charAt(0));
                }
            }

            return sb.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return null;
    }

    static {
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
    }*/
}
