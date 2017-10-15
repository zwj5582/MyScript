/*
 *  Created by ZhongWenjie on 2017-10-14 11:25
 */

package org.zhongwenjie.lexer;

import org.zhongwenjie.token.IdToken;
import org.zhongwenjie.token.NumberToken;
import org.zhongwenjie.token.StringToken;
import org.zhongwenjie.token.Token;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {

    private static final String regexPat =
            "\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")|[a-z_A-Z][a-z_A-Z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";

    private Pattern pattern = Pattern.compile(regexPat);

    private ArrayList<Token> queue = new ArrayList<Token>(16);

    private boolean hasMore;

    private LineNumberReader reader;

    public Lexer(LineNumberReader reader) {
        hasMore=true;
        this.reader = reader;
    }

    public Token read(){
        if (fillQueue(0))
            return queue.remove(0);
        else
            return Token.EOF;
    }

    public Token peek(int index){
        if (fillQueue(index))
            return queue.get(index);
        else
            return Token.EOF;
    }

    private boolean fillQueue(int index) {
        while(index >= queue.size()){
            if (hasMore)
                readLine();
            else
                return false;
        }
        return true;
    }

    protected void readLine(){
        String line = null;
        try {
             line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line == null){
            hasMore = false;
            return;
        }
        int lineNo = reader.getLineNumber();
        Matcher matcher = pattern.matcher(line);
        matcher.useTransparentBounds(true).useAnchoringBounds(false);
        int pos = 0;
        int endPos = line.length();
        while (pos<endPos){
            matcher.region(pos, endPos);
            if (matcher.lookingAt()){
                addToken(lineNo,matcher);
                pos = matcher.end();
            }else
                throw new RuntimeException();
        }
        queue.add(new IdToken(lineNo,Token.EOL));
    }

    private void addToken(int lineNo, Matcher matcher) {
        String text = null;
        if ((text=matcher.group(1))==null || matcher.group(2)!=null )return;
        Token token = null;
        if (matcher.group(3)!=null){
            token = new NumberToken(lineNo,Integer.valueOf(text));
        }else if (matcher.group(4)!=null){
            token = new StringToken(lineNo,text);
        }else{
            token = new IdToken(lineNo,text);
        }
        queue.add(token);
    }
}
