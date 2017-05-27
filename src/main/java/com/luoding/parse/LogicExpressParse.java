package com.luoding.parse;

import com.luoding .pb.common.util.log.PlatformLogger;

import java.util.Stack;

/**
 * 逻辑表达式解析
 */
public class LogicExpressParse extends LogicExpressParseAbstract{

    public static void main(String[] args) {

        String expression = "0 | ( 11&0)|(1|0)";
        try {
            LogicExpressParse logicExpressParse = new LogicExpressParse();
            long t1= System.nanoTime();
            for(int i=0;i<1000000;i++){
                //9834283
                //4323753075
                //8253603856
                //System.out.println(logicExpressParse.logicExpressionParse(expression));
                logicExpressParse.logicExpressionParse(expression);
            }
            System.out.println(System.nanoTime() - t1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public  Object logicExpressionParse(String expression) throws Exception {

        Stack<Character> operate = new Stack<Character>();
        Stack<String> number = new Stack<String>();
        expression = expressFormat(expression);
        int errorPosition = expressionValid(expression);
        if (-1 != errorPosition) {
            throw new Exception("错误位置 " + expression.substring(0, errorPosition));
        }
        int len = expression.length();
        String tmp = "";
        init(operate);
        int i = 0;
        try {
            for (; i < len; i++) {
                char c = expression.charAt(i);
                if (operates.contains(c)) {
                    if (!"".equals(tmp)) {
                        number.push(tmp);
                    }
                    boolean mark = false;
                    while (true) {
                        if (mark) {
                            break;
                        }
                        char top = operate.peek();
                        char relation = operateCompare(top, c);
                        switch (relation) {
                            case '>':
                                String last = number.pop();
                                String first = number.pop();
                                char op = operate.pop();
                                Object result = operate(op, first, last);
                                number.push(result.toString());
                                break;
                            case '<':
                                operate.push(c);
                                mark = true;
                                break;
                            case '=':
                                operate.pop();
                                mark = true;
                                break;
                            default:
                                throw new Exception("表达式有错误");
                        }
                    }
                    tmp = "";
                } else {
                    tmp = tmp + c;
                }
            }
            if (number.size() != 1) {
                throw new Exception("表达式不对");
            }
            return number.pop();
        } catch (Exception e) {
            PlatformLogger.error("表达式错误", e);
            throw new Exception("错误位置 " + expression.substring(0, i));
        }
    }

    public  Object operate(char operate, String first, String last) throws Exception {

        int firstValue = Integer.parseInt(first);
        int lastValue = Integer.parseInt(last);

        int result = 0;
        switch (operate) {
            case '|':
                result = firstValue | lastValue;
                break;
            case '&':
                result = firstValue & lastValue;
                break;
            default:
                throw new Exception("表达式有错误");
        }
        return result;
    }

}
