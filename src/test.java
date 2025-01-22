public class test {
    public static void main(String[] args) {
        String s = "race a car";
        char[] charList = s.toLowerCase().toCharArray();
        int charNum;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : charList){
            charNum = (int) c;
            if ((charNum >= 48 && charNum <= 57) || (charNum >= 65 && charNum <= 122)){
                System.out.println(c + " : " + charNum);
                stringBuilder.append(c);
            }
        }
        String compare = stringBuilder.toString();
        System.out.println(compare.contentEquals(stringBuilder.reverse()));
    }
}
