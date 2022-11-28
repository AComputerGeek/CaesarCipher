import edu.duke.*;

/**
* 
* @author: Amir Armion 
* 
* @version: V.01
* 
*/
public class CaesarCipher 
{

    // Case-Sensitive
    public String encrypt(String input, int key)
    {
        String alphabet        = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        StringBuilder output   = new StringBuilder("");

        for(int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);

            if(Character.isUpperCase(currentChar)) // Character is uppercase
            {
                int positionOfCurrentChar = alphabet.indexOf(currentChar);

                if(positionOfCurrentChar != -1)
                {
                    char cryptedChar = shiftedAlphabet.charAt(positionOfCurrentChar);
                    output.append(cryptedChar);
                }
                else
                {
                    output.append(currentChar);
                }
            }
            else if(Character.isLowerCase(currentChar)) // Character is lowercase
            {
                int positionOfCurrentChar = alphabet.indexOf(Character.toUpperCase(currentChar));

                if(positionOfCurrentChar != -1)
                {
                    char cryptedChar = Character.toLowerCase(shiftedAlphabet.charAt(positionOfCurrentChar));
                    output.append(cryptedChar);
                }
                else
                {
                    output.append(currentChar);
                }
            }
            else // Character is not letter (It's punctuation or digit)
            {
                output.append(currentChar);
            }
        }

        return output.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2)
    {
        String alphabet         = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);

        StringBuilder output    = new StringBuilder("");

        for(int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i);

            if(i % 2 == 0) // Even index
            {
                if(Character.isUpperCase(currentChar))
                {
                    int positionOfCurrentChar = alphabet.indexOf(currentChar);

                    if(positionOfCurrentChar != -1)
                    {
                        char cryptedChar = shiftedAlphabet1.charAt(positionOfCurrentChar);
                        output.append(cryptedChar);
                    }
                    else
                    {
                        output.append(currentChar);
                    }
                }
                else if(Character.isLowerCase(currentChar))
                {
                    int positionOfCurrentChar = alphabet.indexOf(Character.toUpperCase(currentChar));

                    if(positionOfCurrentChar != -1)
                    {
                        char cryptedChar = Character.toLowerCase(shiftedAlphabet1.charAt(positionOfCurrentChar));
                        output.append(cryptedChar);
                    }
                    else
                    {
                        output.append(currentChar);
                    }
                }
                else
                {
                    output.append(currentChar);
                }
            }
            else // Odd index
            {
                if(Character.isUpperCase(currentChar))
                {
                    int positionOfCurrentChar = alphabet.indexOf(currentChar);

                    if(positionOfCurrentChar != -1)
                    {
                        char cryptedChar = shiftedAlphabet2.charAt(positionOfCurrentChar);
                        output.append(cryptedChar);
                    }
                    else
                    {
                        output.append(currentChar);
                    }
                }
                else if(Character.isLowerCase(currentChar))
                {
                    int positionOfCurrentChar = alphabet.indexOf(Character.toUpperCase(currentChar));

                    if(positionOfCurrentChar != -1)
                    {
                        char cryptedChar = Character.toLowerCase(shiftedAlphabet2.charAt(positionOfCurrentChar));
                        output.append(cryptedChar);
                    }
                    else
                    {
                        output.append(currentChar);
                    }
                }
                else
                {
                    output.append(currentChar);
                }
            }
        }

        return output.toString();
    }

    public void testCaesar1()
    {
        int          key      = 0;
        FileResource fr       = new FileResource();
        String       message  = fr.asString();

        System.out.println("key is " + key + "\n" + encrypt(message, key));
    }

    public void testCaesar2()
    {
        System.out.println("- Encrypted: " + encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
    }

    public void testEncryptTwoKeys()
    {
        System.out.println("- Encrypted with two keys: " + encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8));
    }
}
