/*
 *  Created by ZhongWenjie on 2017-10-14 10:25
 */

package org.zhongwenjie.token;

import org.zhongwenjie.exception.StoneException;

public abstract class AbstractToken implements Token {

    private int lineNumber;

    public AbstractToken(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean isIdentifier() {
        return false;
    }

    public int getNumber() {
        throw new StoneException("not number token");
    }

    public boolean isString() {
        return false;
    }

    public String getText() {
        return null;
    }

}