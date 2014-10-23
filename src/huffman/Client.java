package huffman;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:20:42 PM 

public class Client {

    public static void main(String[] args) {
        
        String original = "creating a huffman tree is simple. sort this list by frequency";
        
        char[] text = original.toCharArray();
        
        EncodingTree tree = Encode.createHuffmanTree(text); 
        
        String cipherText = Encode.obfuscate(tree, text);
        
        String rawText = Decode.illuminate(tree, cipherText);
        
        System.out.println("Original text : " + original);
        System.out.println("Text after encode/decode ops : " + rawText);

    }

}
