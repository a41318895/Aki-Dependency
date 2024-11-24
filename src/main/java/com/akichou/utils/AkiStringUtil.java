package com.akichou.utils;

/**
 * AkiStringUtil - Common string handling methods.
 */
public final class AkiStringUtil {

    private AkiStringUtil() {}

    /**
     * Check if the string instance is null.
     * @param targetStr Target string instance.
     * @return Returns true if the targetStr is null, false otherwise
     */
    public static boolean isNull(String targetStr) {

        return targetStr == null ;
    }

    /**
     * Check if the string instance is empty
     * @param targetStr Target string instance.
     * @return Returns true if the targetStr is empty (length == 0), false otherwise
     */
    public static boolean isEmpty(String targetStr) {

        if (targetStr == null) return false ;

        return targetStr.isEmpty() ;
    }

    /**
     * Check if the string instance is blank
     * @param targetStr Target string instance.
     * @return Returns true if the targetStr is null or empty (remove spaces start and end length == 0), false otherwise
     */
    public static boolean isBlank(String targetStr) {

        return targetStr == null || targetStr.trim().isEmpty() ;
    }

    /**
     * Make all chars of string uppercased.
     * @param targetStr Target string instance.
     * @return If targetStr exists, return the uppercased targetStr, or return null.
     */
    public static String toUpperCase(String targetStr) {

        return targetStr == null ?
                null :
                targetStr.toUpperCase() ;
    }

    /**
     * Check if all chars of string are uppercased.
     * @param targetStr Target string instance.
     * @return If all chars of targetStr are uppercased, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllUpperCase(String targetStr) {

        if (isBlank(targetStr)) return false ;

        for (int i = 0 ; i < targetStr.length() ; i ++) {

            if (!Character.isUpperCase(targetStr.charAt(i))) {

                return false ;
            }
        }

        return true ;
    }

    /**
     * Make string capitalized.
     * @param targetStr Target string instance.
     * @return If targetStr exists, return the capitalized targetStr, or return null.
     */
    public static String capitalize(String targetStr) {

        return targetStr == null ?
                null :
                targetStr.substring(0, 1).toUpperCase() + targetStr.substring(1) ;
    }

    /**
     * Check if the string is capitalized.
     * @param targetStr Target string instance.
     * @return If the first char of targetStr is uppercased, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isCapitalize(String targetStr) {

        if (isBlank(targetStr)) return false ;

        return Character.isUpperCase(targetStr.charAt(0)) ;
    }

    /**
     * Make all chars of string lowercased.
     * @param targetStr Target string instance.
     * @return If targetStr exists, return the lowercased targetStr, or return null.
     */
    public static String toLowerCase(String targetStr) {

        return targetStr == null ?
                null :
                targetStr.toLowerCase() ;
    }

    /**
     * Check if all chars of string are lowercased.
     * @param targetStr Target string instance.
     * @return  If all chars of targetStr are lowercased, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllLowerCase(String targetStr) {

        if (isBlank(targetStr)) return false ;

        for (int i = 0 ; i < targetStr.length() ; i ++) {

            if (!Character.isLowerCase(targetStr.charAt(i))) {

                return false ;
            }
        }

        return true ;
    }

    /**
     * Check if all chars of string are alphabet.
     * @param targetStr Target string instance.
     * @return  If all chars of targetStr are alphabet, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllAlpha(String targetStr) {

        if (isBlank(targetStr)) return false ;

        for (int i = 0 ; i < targetStr.length() ; i ++) {

            if (!Character.isLetter(targetStr.charAt(i))) {

                return false ;
            }
        }

        return true ;
    }

    /**
     * Check if all chars of string are alphabet or space.
     * @param targetStr Target string instance.
     * @return  If all chars of targetStr are alphabet or space, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllAlphaSpace(String targetStr) {

        if (isBlank(targetStr)) return false ;

        return targetStr.matches("[a-zA-Z\\s]+") ;
    }

    /**
     * Check if all chars of string are number or space.
     * @param targetStr Target string instance.
     * @return  If all chars of targetStr are number or space, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllNumberSpace(String targetStr) {

        if (isBlank(targetStr)) return false ;

        return targetStr.matches("[0-9\\s]+") ;
    }

    /**
     * Check if all chars of string are number.
     * @param targetStr Target string instance.
     * @return  If all chars of targetStr are number, return true, or return false. If targetStr is blank, also return false.
     */
    public static boolean isAllNumber(String targetStr) {

        if (isBlank(targetStr)) return false ;

        for (int i = 0 ; i < targetStr.length() ; i ++) {

            if (!Character.isDigit(targetStr.charAt(i))) {

                return false ;
            }
        }

        return true ;
    }

    /**
     * Repeat the string with specific times.
     * @param targetStr Target string instance.
     * @param times Repeat times.
     * @return Return the targetStr repeated result. If times is fewer equals than 1 or targetStr is blank, return the targetStr itself
     */
    public static String repeat(String targetStr, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("Times must be non-negative") ;
        }

        if (isBlank(targetStr) || times <= 1) return targetStr ;

        StringBuilder stringBuilder = new StringBuilder(targetStr.length() * times) ;
        for (int i = 0 ; i < times ; i ++) {

            stringBuilder.append(targetStr) ;
        }

        return stringBuilder.toString() ;
    }

    /**
     * Repeat the string with specific times and separator.
     * @param targetStr Target string instance.
     * @param times Repeat times.
     * @param separator Separator between repeated strings
     * @return  Return the targetStr repeated result with separator. If times is fewer equals than 1 or targetStr is blank, return the targetStr itself.
     */
    public static String repeat(String targetStr, int times, String separator) {

        if (times < 0) {
            throw new IllegalArgumentException("Times must be non-negative") ;
        }

        if (isBlank(targetStr) || times <= 1) return targetStr ;

        if (separator == null) separator = "" ;

        StringBuilder stringBuilder = new StringBuilder(targetStr.length() * times + separator.length() * (times - 1)) ;
        for (int i = 0 ; i < times - 1 ; i ++) {

            stringBuilder.append(targetStr).append(separator) ;
        }
        stringBuilder.append(targetStr) ;

        return stringBuilder.toString() ;
    }

    /**
     * Get the left substring
     * @param targetStr Target string instance.
     * @param separator Separator string.
     * @return Get the substring left of the separator. If targetStr is blank, the separator is null or not found in targetStr, return the targetStr itself.
     */
    public static String getLeft(String targetStr, String separator) {

        if (isBlank(targetStr)) return targetStr ;

        if (separator == null || separator.isEmpty()) return targetStr ;

        int separatorIndex = targetStr.indexOf(separator) ;
        if (separatorIndex == -1) return targetStr ;

        return targetStr.substring(0, separatorIndex) ;
    }

    /**
     * Get the right substring
     * @param targetStr Target string instance.
     * @param separator Separator string.
     * @return  Get the substring right of the separator. If targetStr is blank, the separator is null or not found in targetStr, return the targetStr itself.
     */
    public static String getRight(String targetStr, String separator) {

        if (isBlank(targetStr)) return targetStr ;

        if (separator == null || separator.isEmpty()) return targetStr ;

        int separatorIndex = targetStr.lastIndexOf(separator) ;
        if (separatorIndex == -1) return targetStr ;

        return targetStr.substring(separatorIndex + 1) ;
    }

    /**
     * Swap substrings
     * @param targetStr Target String instance.
     * @param separator Separator string.
     * @return Make separator as a center point, swap the left substring and the right substring
     */
    public static String swapViaSeparator(String targetStr, String separator) {

        if (isBlank(targetStr)) return targetStr ;

        if (separator == null || separator.isEmpty()) return targetStr ;

        int separatorIndex = targetStr.indexOf(separator) ;
        if (separatorIndex == -1) return targetStr ;

        String newLeftPart = targetStr.substring(separatorIndex + separator.length()) ;
        String newRightPart = targetStr.substring(0, separatorIndex) ;

        return newLeftPart + separator + newRightPart ;
    }

    /**
     * Count the number of substring in target string.
     * @param targetStr Target string instance.
     * @param subStr Substring which will be counted.
     * @return  Return the number of substring in targetStr. If targetStr or subStr is blank, return 0.
     */
    public static int countMatch(String targetStr, String subStr) {

        if (isBlank(targetStr) || isBlank(subStr)) return 0 ;

        int index = 0 ;
        int count = 0 ;

        while ((index = targetStr.indexOf(subStr, index)) != -1) {

            count ++ ;
            index += subStr.length() ;      // Move out of the position in targetStr
        }

        return count ;
    }

    /**
     * Trim function
     * @param targetStr Target string instance.
     * @return Return the targetStr without spaces at begin and end.
     */
    public static String trim(String targetStr) {

        if (isBlank(targetStr)) return targetStr ;

        return targetStr.trim() ;
    }

    /**
     * Trim Left function
     * @param targetStr Target string instance.
     * @return Return the targetStr without space at the beginning.
     */
    public static String trimLeft(String targetStr) {

        if (isBlank(targetStr)) return targetStr ;

        int startIndex = 0 ;
        while (startIndex < targetStr.length() && Character.isWhitespace(targetStr.charAt(startIndex))) {

            startIndex ++ ;
        }

        return targetStr.substring(startIndex) ;
    }

    /**
     * Trim Right function
     * @param targetStr Target string instance.
     * @return Return the targetStr without space at the end.
     */
    public static String trimRight(String targetStr) {

        if (isBlank(targetStr)) return targetStr ;

        int endIndex = targetStr.length() ;
        while (endIndex > 0 && Character.isWhitespace(targetStr.charAt(endIndex - 1))) {

            endIndex -- ;
        }

        return targetStr.substring(0, endIndex) ;
    }

    /**
     * Trim All function
     * @param targetStr Target string instance.
     * @return Return the targetStr without any space.
     */
    public static String trimAll(String targetStr) {

        if (isBlank(targetStr)) return targetStr ;

        return targetStr.replaceAll("\\s+", "") ;
    }
}

