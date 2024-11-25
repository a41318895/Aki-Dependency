package com.akichou.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * Chop the specific left part of targetStr.
     * @param targetStr Target string instance.
     * @param choppedString string chopped from targetStr.
     * @return  Chop the specific left part of targetStr with the indicated choppedString.
     */
    public static String chopStart(String targetStr, String choppedString) {

        if (isBlank(targetStr) || isBlank(choppedString)) return targetStr ;

        if (targetStr.startsWith(choppedString)) return targetStr.substring(choppedString.length()) ;

        return targetStr ;
    }

    /**
     * Chop the specific right part of targetStr.
     * @param targetStr Target string instance.
     * @param choppedString string chopped from targetStr.
     * @return Chop the specific right part of targetStr with the indicated choppedString.
     */
    public static String chopEnd(String targetStr, String choppedString) {

        if (isBlank(targetStr) || isBlank(choppedString)) return targetStr ;

        if (targetStr.endsWith(choppedString)) return targetStr.substring(0, targetStr.length() - choppedString.length()) ;

        return targetStr ;
    }

    /**
     * Compare string by instance.
     * @param targetStr Target string instance.
     * @param comparedStr Compared string instance.
     * @return Return true if targetStr and comparedStr are the same instance.
     */
    public static boolean equalsByInstance(String targetStr, String comparedStr) {

        return targetStr == comparedStr ;
    }

    /**
     * Compare string by value.
     * @param targetStr Target string instance.
     * @param comparedStr Compared string instance.
     * @return Return true if targetStr and comparedStr have the same actual value.
     */
    public static boolean equalsByValue(String targetStr, String comparedStr) {

        if (targetStr == null) return comparedStr == null ;

        return targetStr.equals(comparedStr) ;
    }

    /**
     * Compare string by value ignore case.
     * @param targetStr Target string instance.
     * @param comparedStr Compared string instance
     * @return Return true if targetStr and ComparedStr have the same actual value but ignore case
     */
    public static boolean equalsIgnoreCaseByValue(String targetStr, String comparedStr) {

        if (targetStr == null) return comparedStr == null ;

        return targetStr.equalsIgnoreCase(comparedStr) ;
    }

    /**
     * Fetch char by index
     * @param targetStr Target string instance
     * @param index Indicated index
     * @return Fetch the char from targetStr by indicated index
     */
    public static char getByIndex(String targetStr, int index) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        if (index < 0 || index >= targetStr.length()) throw new IndexOutOfBoundsException("Index out of bounds") ;

        return targetStr.charAt(index) ;
    }

    /**
     * Fetch string by indexes
     * @param targetStr Target string instance
     * @param indexes indicated index array
     * @return Fetch a formatted display string from targetStr by indicated index array
     */
    public static String[] getByIndex(String targetStr, int[] indexes) {

        if (targetStr == null || indexes == null) throw new IllegalArgumentException("Target string or indexes cannot be null") ;

        for (int index : indexes) {

            if (index < 0 || index >= targetStr.length()) throw new IndexOutOfBoundsException("Index out of bounds: " + index) ;
        }

        String[] result = new String[indexes.length] ;
        for (int i = 0 ; i < indexes.length ; i ++) {

            result[i] = String.valueOf(targetStr.charAt(indexes[i])) ;
        }

        return result ;
    }

    /**
     * Fetch index of char
     * @param targetStr Target string instance
     * @param chara indicated char
     * @return Fetch the 1st index of the indicated char
     */
    public static int getIndexByChar(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        return targetStr.indexOf(chara) ;
    }

    /**
     * Fetch all indexes of char
     * @param targetStr Target string instance
     * @param chara indicated char
     * @return Fetch all indexes of the indicated char
     */
    public static int[] getIndexesByChar(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        // Dynamically manage the size via list-to-array
        List<Integer> indexList = new ArrayList<>() ;
        for (int i = 0 ; i < targetStr.length() ; i ++) {

            if (targetStr.charAt(i) == chara) indexList.add(i) ;
        }

        int[] indexes = new int[indexList.size()] ;
        for (int i = 0 ; i < indexList.size() ; i ++) {

            indexes[i] = indexList.get(i) ;
        }

        return indexes ;
    }

    /**
     * Does targetStr contains substring
     * @param targetStr Target string instance
     * @param substring Sub-string instance
     * @return Return true if targetStr contains substring, false otherwise.
     */
    public static boolean contains(String targetStr, String substring) {

        if (targetStr == null) return substring == null ;

        return targetStr.contains(substring) ;
    }

    /**
     * Does targetStr contain substring (ignore case)
     * @param targetStr Target string instance
     * @param substring Sub-string instance
     * @return Return true if targetStr contains substring (ignore case), false otherwise.
     */
    public static boolean containsIgnoreCase(String targetStr, String substring) {

        if (targetStr == null) return substring == null ;

        return targetStr.toLowerCase().contains(substring.toLowerCase()) ;
    }

    /**
     * Fetch substring by char
     * @param targetStr Target string instance
     * @param fromChar Start char
     * @param toChar End char
     * @return Fetch the substring by indicated from-char and to-char(included)
     */
    public static String substringByChars(String targetStr, char fromChar, char toChar) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        int fromIndex = targetStr.indexOf(fromChar) ;
        int toIndex = targetStr.indexOf(toChar) ;

        if (fromIndex == -1 || toIndex == -1) throw new IllegalArgumentException("Characters not found in target string") ;

        if (fromIndex > toIndex) throw new IllegalArgumentException("From-char-index cannot bigger than to-char-index") ;

        return targetStr.substring(fromIndex, toIndex + 1) ;
    }

    /**
     * Fetch substring by index
     * @param targetStr Target string instance
     * @param fromIndex Start index
     * @param toIndex End index
     * @return Fetch the substring by indicated from-index and to-index(included)
     */
    public static String substringByIndex(String targetStr, int fromIndex, int toIndex) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        if (fromIndex < 0 || toIndex >= targetStr.length()) throw new IndexOutOfBoundsException("Index out of bounds") ;

        if (fromIndex > toIndex) throw new IllegalArgumentException("From-index cannot bigger than to-index") ;

        return targetStr.substring(fromIndex, toIndex + 1) ;
    }

    /**
     * Split the target string by the specified split symbol, treating consecutive split symbols as one
     * @param targetStr Target string instance
     * @param splitSymbol Split symbol
     * @return Array of substrings split by the specified split symbol
     *
     * <pre>
     * {@code
     *     .splitBy("aa--bb---cc----dd", "--")  -->
     *     [aa, bb, -cc, dd]
     *
     *     .splitBy("aa--bb---cc----dd", "---")  -->
     *     [aa--bb, cc, -dd]
     * }
     * </pre>
     */
    public static String[] splitBy(String targetStr, String splitSymbol) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;
        targetStr = targetStr.trim() ;


        if (splitSymbol == null || splitSymbol.isEmpty()) {

            throw new IllegalArgumentException("Split symbol cannot be null or empty") ;
        }

        ArrayList<String> stringList = new ArrayList<>() ;

        int substringStartIndex = 0 ;
        int splitSymbolLen = splitSymbol.length() ;
        for (int i = 0 ; i <= targetStr.length() - splitSymbolLen ; i ++) {

            if (targetStr.startsWith(splitSymbol, i)) {

                if (substringStartIndex != i) stringList.add(targetStr.substring(substringStartIndex, i)) ;

                substringStartIndex = i + splitSymbolLen ;

                i += splitSymbolLen - 1 ;
            }
        }

        // Add the last part of the string
        if (substringStartIndex < targetStr.length()) {

            stringList.add(targetStr.substring(substringStartIndex)) ;
        }

        return stringList.toArray(new String[0]) ;
    }

    /**
     * Split the target string by the specified split symbol, treating consecutive split symbols as one
     * @param targetStr Target string instance
     * @param splitSymbol Split symbol
     * @param limit Maximum number of substrings to return
     * @return Array of substrings ( len == limit ) split by the specified split symbol
     *
     * <pre>
     * {@code
     *     .splitBy("aa--bb---cc----dd", "--", 2)  -->
     *     [aa, bb]
     *
     *     .splitBy("aa--bb---cc----dd", "--", 4)  -->
     *     [aa, bb, -cc, dd]
     * }
     * </pre>
     */
    public static String[] splitBy(String targetStr, String splitSymbol, int limit) {

        if (limit <= 0) throw new IllegalArgumentException("Limit must be a positive number") ;

        String[] stringArray = splitBy(targetStr, splitSymbol) ;

        return Arrays.stream(stringArray).limit(limit).toArray(String[]::new) ;
    }

    /**
     * Replace all occurrences of the specified character with a new character
     * @param targetStr Target string instance
     * @param oldChar Old character to be replaced
     * @param newChar New character to do replacing
     * @return String with all occurrences of the old character replaced by the new character
     */
    public static String replaceChar(String targetStr, char oldChar, char newChar) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        return targetStr.replace(oldChar, newChar) ;
    }

    /**
     * Replace all occurrences of the specified string with a new string
     * @param targetStr Target string instance
     * @param oldStr Old string to be replaced
     * @param newStr New string to do replacing
     * @return String with all occurrences of the old string replaced by the new string
     */
    public static String replaceString(String targetStr, String oldStr, String newStr) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        return targetStr.replace(oldStr, newStr) ;
    }

    /**
     * Replace the first occurrence of the specified character with a new character
     * @param targetStr Target string instance
     * @param oldChar Old character to be replaced
     * @param newChar New character to do replacing
     * @return String with the first occurrence of the old character replaced by the new character
     */
    public static String replaceFirstChar(String targetStr, char oldChar, char newChar) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        return targetStr.replaceFirst(String.valueOf(oldChar), String.valueOf(newChar)) ;
    }

    /**
     * Replace the first occurrence of the specified string with a new string
     * @param targetStr Target string instance
     * @param oldStr Old string to be replaced
     * @param newStr New string to do replacing
     * @return String with the first occurrence of the old string replaced by the new string
     */
    public static String replaceFirstString(String targetStr, String oldStr, String newStr) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        return targetStr.replaceFirst(oldStr, newStr) ;
    }

    /**
     * Remove the first occurrence of the specified character
     * @param targetStr Target string instance
     * @param chara Character to remove
     * @return String with the first occurrence of the specified character removed
     */
    public static String removeFirst(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        int charaIndex = targetStr.indexOf(chara) ;
        if (charaIndex == -1) return targetStr ;

        return targetStr.substring(0, charaIndex) + targetStr.substring(charaIndex + 1) ;
    }

    /**
     * Remove the first occurrence of the specified character, ignoring its case
     * @param targetStr Target string instance
     * @param chara Character to remove
     * @return String with the first occurrence of the specified character removed, ignoring its case
     */
    public static String removeFirstIgnoreCase(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        // Make all case be lower to index
        int charaIndex = targetStr.toLowerCase().indexOf(Character.toLowerCase(chara)) ;
        if (charaIndex == -1) return targetStr ;

        return targetStr.substring(0, charaIndex) + targetStr.substring(charaIndex + 1) ;
    }

    /**
     * Remove all occurrences of the specified character, ignoring its case
     * @param targetStr Target string instance
     * @param chara Character to remove
     * @return String with all occurrences of the specified character removed, its ignoring case
     */
    public static String removeAll(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        int charaIndex = targetStr.indexOf(chara) ;
        if (charaIndex == -1) return targetStr ;

        return targetStr.replaceAll(String.valueOf(chara), "") ;
    }

    /**
     * Remove all occurrences of the specified character, ignoring its case
     * @param targetStr Target string instance
     * @param chara Character to remove
     * @return String with all occurrences of the specified character removed, its ignoring case
     */
    public static String removeAllIgnoreCase(String targetStr, char chara) {

        if (targetStr == null) throw new IllegalArgumentException("Target string cannot be null") ;

        StringBuilder stringBuilder = new StringBuilder() ;

        char lowerChara = Character.toLowerCase(chara) ;
        char upperChara = Character.toUpperCase(chara) ;
        for (char c : targetStr.toCharArray()) {

            // Excluding the char (!= input chara) in targetStr to achieve the goal implementation
            if (c != lowerChara && c != upperChara) {

                stringBuilder.append(c) ;
            }
        }

        return stringBuilder.toString();
    }
}

