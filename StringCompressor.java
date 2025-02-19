public class StringCompressor {

    // Method to compress a string by replacing repeating characters with the character followed by count
    public static String compress(String input) {
        // if input is empty, return an empty string
        if (input.isEmpty()) return ""; 
        
        StringBuilder compressed = new StringBuilder(); // Store the compressed string
        int count = 1; // Count of each character
        
        // Iterate over the string starting from the second character
        for (int i = 1; i < input.length(); i++) {
            // If the current character matches the previous one, increment the count
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++; 
            } else {
                // Append the previous character and its count to the compressed result
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1; // Reset count for the new character
            }
        }
        
        // Append the last character and its count
        compressed.append(input.charAt(input.length() - 1)).append(count);
        
        return compressed.toString(); // Return result
    }

    // Method to decompress a string by expanding character count into the original string
    public static String decompress(String input) {
        // if input is empty, return an empty string
        if (input.isEmpty()) return ""; 
        
        StringBuilder decompressed = new StringBuilder(); // Store the decompressed string
        
        // Iterate through the input string
        for (int i = 0; i < input.length(); i += 2) {
            char character = input.charAt(i); // Extract the character
            int count = Character.getNumericValue(input.charAt(i + 1)); // Extract and convert count from char to integer
            
            // Append the character count times to the decompressed string
            for (int j = 0; j < count; j++) {
                decompressed.append(character);
            }
        }
        
        return decompressed.toString(); // Return result
    }

    public static void main(String[] args) {
       
        System.out.println(compress("aaabb"));  // Output: "a3b2"
        System.out.println(compress("abc"));   // Output: "a1b1c1"
        System.out.println(compress(""));      // Output: ""

        System.out.println(decompress("a3b2"));  // Output: "aaabb"
        System.out.println(decompress("a1b1c1"));// Output: "abc"
        System.out.println(decompress(""));      // Output: ""
    }
}
