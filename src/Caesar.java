public class Caesar {
    private static String abc = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public String shifr_me(String text, int key) {
        StringBuilder result = new StringBuilder();
        
//        for (int i = 0; i < text.length(); i++) {
//            char char_ = Character.toUpperCase(text.charAt(i));
        
        for (char char_ : text.toUpperCase().toCharArray()) {
            if (abc.indexOf(char_) != -1) {
                int originalPosition = abc.indexOf(char_);
                int newPosition = (originalPosition + key) % abc.length(); //33+3 = 36% 33 = 3
                result.append(abc.charAt(newPosition));
            } else {
                result.append(char_);
            }
        }
        return result.toString();
    }

    public String deshifr_me(String text, int key) {
        return shifr_me(text, abc.length() - key);
    }
}
