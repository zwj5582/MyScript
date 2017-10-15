/*
 *  Created by ZhongWenjie on 2017-10-14 12:06
 */

package org.zhongwenjie.token;

public class NumberToken extends AbstractToken {

    private int number;

    public NumberToken(int lineNumber,int number) {
        super(lineNumber);
        this.number=number;
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
        return this.number;
    }

    @Override
    public boolean isString() {
        return super.isString();
    }

    @Override
    public String getText() {
        return Integer.toString(number);
    }
}
