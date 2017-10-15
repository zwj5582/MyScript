/*
 *  Created by ZhongWenjie on 2017-10-14 10:22
 */

package org.zhongwenjie.token;

public interface Token {

    Token EOF = new AbstractToken(-1){};

    String EOL = "\\n";

    int getLineNumber();

    boolean isIdentifier();

    int getNumber();

    boolean isString();

    String getText();

}
