import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest extends Calculator{

    @Test
    void convertToPostfix() {
        String infix = "a*b/(c-a)+d*e";
        String postfix = convertToPostfix(infix);
        System.out.println("Converting " + infix + " to postfix...");
        System.out.println(postfix);

        String infix1 = "a*b/(c-a)";
        String postfix1 = convertToPostfix(infix1);
        System.out.println("Converting " + infix1 + " to postfix...");
        System.out.println(postfix1);

        String infix2 = "a*b/c";
        String postfix2 = convertToPostfix(infix2);
        System.out.println("Converting " + infix2 + " to postfix...");
        System.out.println(postfix2);

        String infix3 = "a*b^c/(c-a)+d*e";
        String postfix3 = convertToPostfix(infix3);
        System.out.println("Converting " + infix3 + " to postfix...");
        System.out.println(postfix3);

        String infix4 = "a*b";
        String postfix4 = convertToPostfix(infix4);
        System.out.println("Converting " + infix4 + " to postfix...");
        System.out.println(postfix4);

        String infix5 = "a+b";
        String postfix5 = convertToPostfix(infix5);
        System.out.println("Converting " + infix5 + " to postfix...");
        System.out.println(postfix5);

        String infix6 = "a-b";
        String postfix6 = convertToPostfix(infix6);
        System.out.println("Converting " + infix6 + " to postfix...");
        System.out.println(postfix6);

        String infix7 = "a/b";
        String postfix7 = convertToPostfix(infix7);
        System.out.println("Converting " + infix7 + " to postfix...");
        System.out.println(postfix7);

        String infix8 = "a+b+c";
        String postfix8 = convertToPostfix(infix8);
        System.out.println("Converting " + infix8 + " to postfix...");
        System.out.println(postfix8);

        String infix9 = "a+b-c";
        String postfix9 = convertToPostfix(infix9);
        System.out.println("Converting " + infix9 + " to postfix...");
        System.out.println(postfix9);

        String infix10 = "a-b+c";
        String postfix10 = convertToPostfix(infix10);
        System.out.println("Converting " + infix10 + " to postfix...");
        System.out.println(postfix10);

        String infix11 = "a-b-c";
        String postfix11 = convertToPostfix(infix11);
        System.out.println("Converting " + infix11 + " to postfix...");
        System.out.println(postfix11);

        String infix12 = "a+b*c";
        String postfix12 = convertToPostfix(infix12);
        System.out.println("Converting " + infix12 + " to postfix...");
        System.out.println(postfix12);

        String infix13 = "a*b+c";
        String postfix13 = convertToPostfix(infix13);
        System.out.println("Converting " + infix13 + " to postfix...");
        System.out.println(postfix13);

        String infix14 = "a*b*c";
        String postfix14 = convertToPostfix(infix14);
        System.out.println("Converting " + infix14 + " to postfix...");
        System.out.println(postfix14);

        String infix15 = "a*b-c";
        String postfix15 = convertToPostfix(infix15);
        System.out.println("Converting " + infix15 + " to postfix...");
        System.out.println(postfix15);

        String infix16 = "a-b*c";
        String postfix16 = convertToPostfix(infix16);
        System.out.println("Converting " + infix16 + " to postfix...");
        System.out.println(postfix16);

        String infix17 = "a/b+c";
        String postfix17 = convertToPostfix(infix17);
        System.out.println("Converting " + infix17 + " to postfix...");
        System.out.println(postfix17);

        String infix18 = "a/b-c";
        String postfix18 = convertToPostfix(infix18);
        System.out.println("Converting " + infix18 + " to postfix...");
        System.out.println(postfix18);

        String infix19 = "a/b*c";
        String postfix19 = convertToPostfix(infix19);
        System.out.println("Converting " + infix19 + " to postfix...");
        System.out.println(postfix19);

        String infix20 = "a/b/c";
        String postfix20 = convertToPostfix(infix20);
        System.out.println("Converting " + infix20 + " to postfix...");
        System.out.println(postfix20);

        String infix21 = "a+b/c";
        String postfix21 = convertToPostfix(infix21);
        System.out.println("Converting " + infix21 + " to postfix...");
        System.out.println(postfix21);

        String infix22 = "a-b/c";
        String postfix22 = convertToPostfix(infix22);
        System.out.println("Converting " + infix22 + " to postfix...");
        System.out.println(postfix22);

        String infix23 = "a*b/c";
        String postfix23 = convertToPostfix(infix23);
        System.out.println("Converting " + infix23 + " to postfix...");
        System.out.println(postfix23);

        String infix24 = "a/b^c";
        String postfix24 = convertToPostfix(infix24);
        System.out.println("Converting " + infix24 + " to postfix...");
        System.out.println(postfix24);

        String infix25 = "a^b/c";
        String postfix25 = convertToPostfix(infix25);
        System.out.println("Converting " + infix25 + " to postfix...");
        System.out.println(postfix25);

        String infix26 = "a^(b*c)";
        String postfix26 = convertToPostfix(infix26);
        System.out.println("Converting " + infix26 + " to postfix...");
        System.out.println(postfix26);
    }

    @Test
    void evaluatePostfix() {
        String postfix = "ab*ca-/de*+";
        int result = evaluatePostfix(postfix);
        System.out.println("Evaluating " + postfix + "...");
        System.out.println(result);

        String postfix1 = "ab*ca-/";
        int result1 = evaluatePostfix(postfix1);
        System.out.println("Evaluating " + postfix1 + "...");
        System.out.println(result1);

        String postfix2 = "ab*c/";
        int result2 = evaluatePostfix(postfix2);
        System.out.println("Evaluating " + postfix2 + "...");
        System.out.println(result2);

        String postfix3 = "abc^*ca-/de*+";
        int result3 = evaluatePostfix(postfix3);
        System.out.println("Evaluating " + postfix3 + "...");
        System.out.println(result3);

        String postfix4 = "ab*";
        int result4 = evaluatePostfix(postfix4);
        System.out.println("Evaluating " + postfix4 + "...");
        System.out.println(result4);

        String postfix5 = "ab+";
        int result5 = evaluatePostfix(postfix5);
        System.out.println("Evaluating " + postfix5 + "...");
        System.out.println(result5);

        String postfix6 = "ab-";
        int result6 = evaluatePostfix(postfix6);
        System.out.println("Evaluating " + postfix6 + "...");
        System.out.println(result6);

        String postfix7 = "ab/";
        int result7 = evaluatePostfix(postfix7);
        System.out.println("Evaluating " + postfix7 + "...");
        System.out.println(result7);

        String postfix8 = "ab+c+";
        int result8 = evaluatePostfix(postfix8);
        System.out.println("Evaluating " + postfix8 + "...");
        System.out.println(result8);

        String postfix9 = "ab+c-";
        int result9 = evaluatePostfix(postfix9);
        System.out.println("Evaluating " + postfix9 + "...");
        System.out.println(result9);

        String postfix10 = "ab-c+";
        int result10 = evaluatePostfix(postfix10);
        System.out.println("Evaluating " + postfix10 + "...");
        System.out.println(result10);

        String postfix11 = "ab-c-";
        int result11 = evaluatePostfix(postfix11);
        System.out.println("Evaluating " + postfix11 + "...");
        System.out.println(result11);

        String postfix12 = "abc*+";
        int result12 = evaluatePostfix(postfix12);
        System.out.println("Evaluating " + postfix12 + "...");
        System.out.println(result12);

        String postfix13 = "ab*c+";
        int result13 = evaluatePostfix(postfix13);
        System.out.println("Evaluating " + postfix13 + "...");
        System.out.println(result13);

        String postfix14 = "ab*c*";
        int result14 = evaluatePostfix(postfix14);
        System.out.println("Evaluating " + postfix14 + "...");
        System.out.println(result14);

        String postfix15 = "ab*c-";
        int result15 = evaluatePostfix(postfix15);
        System.out.println("Evaluating " + postfix15 + "...");
        System.out.println(result15);

        String postfix16 = "abc*-";
        int result16 = evaluatePostfix(postfix16);
        System.out.println("Evaluating " + postfix16 + "...");
        System.out.println(result16);

        String postfix17 = "ab/c+";
        int result17 = evaluatePostfix(postfix17);
        System.out.println("Evaluating " + postfix17 + "...");
        System.out.println(result17);

        String postfix18 = "ab/c-";
        int result18 = evaluatePostfix(postfix18);
        System.out.println("Evaluating " + postfix18 + "...");
        System.out.println(result18);

        String postfix19 = "ab/c*";
        int result19 = evaluatePostfix(postfix19);
        System.out.println("Evaluating " + postfix19 + "...");
        System.out.println(result19);

        String postfix20 = "ab/c/";
        int result20 = evaluatePostfix(postfix20);
        System.out.println("Evaluating " + postfix20 + "...");
        System.out.println(result20);

        String postfix21 = "abc/+";
        int result21 = evaluatePostfix(postfix21);
        System.out.println("Evaluating " + postfix21 + "...");
        System.out.println(result21);

        String postfix22 = "abc/-";
        int result22 = evaluatePostfix(postfix22);
        System.out.println("Evaluating " + postfix22 + "...");
        System.out.println(result22);

        String postfix23 = "ab*c/";
        int result23 = evaluatePostfix(postfix23);
        System.out.println("Evaluating " + postfix23 + "...");
        System.out.println(result23);

        String postfix24 = "abc^/";
        int result24 = evaluatePostfix(postfix24);
        System.out.println("Evaluating " + postfix24 + "...");
        System.out.println(result24);

        String postfix25 = "ab^c/";
        int result25 = evaluatePostfix(postfix25);
        System.out.println("Evaluating " + postfix25 + "...");
        System.out.println(result25);

        String postfix26 = "abc*^";
        int result26 = evaluatePostfix(postfix26);
        System.out.println("Evaluating " + postfix26 + "...");
        System.out.println(result26);


    }
}
