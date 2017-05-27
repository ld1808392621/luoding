package com.luoding.parse;

import com.luoding .pb.common.util.log.PlatformLogger;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Date：16-6-3
 * Time：下午8:22
 *
 * @author ding.luo@corp.luoding .com
 */
public class LogicExpressCalculate extends LogicExpressParseAbstract {

    private Map<String, String> logicValues = new HashMap<String, String>();

    private Map<String,String> itemDetail = new HashMap<String, String>();

    public LogicExpressCalculate(Map<String, String> logicValues) {
        this.logicValues = logicValues;
    }

    @Override
    public Object logicExpressionParse(String expression) throws Exception {
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
                        String  value = logicValues.get(tmp);
                        //记录每一项的值
                        itemDetail.put(tmp,value);
                        number.push(value);
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
                                number.push("" + result);
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

    @Override
    public Object operate(char operate, String first, String last) throws Exception {

        boolean firstValue = Boolean.parseBoolean(first);
        boolean lastValue = Boolean.parseBoolean(last);

        boolean result = false;
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
