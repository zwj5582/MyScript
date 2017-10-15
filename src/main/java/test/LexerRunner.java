/*
 *  Created by ZhongWenjie on 2017-10-14 19:48
 */

package test;

import org.zhongwenjie.lexer.Lexer;
import org.zhongwenjie.token.Token;

import java.io.LineNumberReader;

public class LexerRunner {

    public static void main(String[] args) {
        Lexer lexer = new Lexer(new LineNumberReader(new CodeDialog()));
        Token read = null;
        while((read=lexer.read())!=Token.EOF){
            System.out.println(read.getText());
        }
    }
}
