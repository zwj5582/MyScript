/*
 *  Created by ZhongWenjie on 2017-10-14 12:13
 */

package org.zhongwenjie.token;

public class StringToken extends AbstractToken {

    private final String string;

    public StringToken(int lineNumber,String string) {
        super(lineNumber);
        this.string=string;
    }

    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }

    @Override
    public boolean isIdentifier() {
        return super.isIdentifier();
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public boolean isString() {
        return super.isString();
    }

    @Override
    public String getText() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int len = string.length() - 1;
        for (int i = 1; i < len; i++){
            char c = string.charAt(i);
            if (c == '\\' && i < (len-1) ){
                char cc=string.charAt(++i);
                if (cc == '"' || cc == '\\'){
                    c = cc ;
                }else if (cc == 'n'){
                    c = '\n';
                }
            }
            builder.append(c);
        }
        return builder.toString();
    }
}
