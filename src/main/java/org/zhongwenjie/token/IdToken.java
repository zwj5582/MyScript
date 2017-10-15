/*
 *  Created by ZhongWenjie on 2017-10-14 12:17
 */

package org.zhongwenjie.token;

public class IdToken extends AbstractToken {

    private final String id;

    public IdToken(int lineNumber,String id) {
        super(lineNumber);
        this.id=id;
    }

    @Override
    public int getLineNumber() {
        return super.getLineNumber();
    }

    @Override
    public boolean isIdentifier() {
        return true;
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
        return id;
    }
}
