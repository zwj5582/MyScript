/*
 *  Created by ZhongWenjie on 2017-10-14 13:22
 */

package test;

import javax.swing.*;
import java.io.IOException;
import java.io.Reader;

public class CodeDialog extends Reader {

    private String buffer = null;
    private int pos=0;

    public int read(char[] cbuf, int off, int len) throws IOException {
        if (buffer == null){
            String in = showDialog();
            if (in == null){
                return -1;
            }else {
                System.out.println(in);
                buffer = in + "\n";
                pos=0;
            }
        }
        int size = 0;
        int length = buffer.length();
        while (pos < length && size < len){
            cbuf[off + size++] = buffer.charAt(pos++);
        }
        if (pos == length)
            buffer=null;
        return size;
    }

    public void close() throws IOException {

    }

    protected String showDialog(){
        JTextArea area = new JTextArea(20,40);
        JScrollPane pane = new JScrollPane(area);
        int result = JOptionPane.showOptionDialog(null,pane,"Input",JOptionPane.OK_CANCEL_OPTION
                    ,JOptionPane.PLAIN_MESSAGE,null,null,null);
        if (result == JOptionPane.OK_OPTION)
            return area.getText();
        else
            return null;
    }
}
