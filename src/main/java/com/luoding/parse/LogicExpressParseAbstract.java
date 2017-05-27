package com.luoding.parse;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date：16-6-3
 * Time：下午8:19
 *
 * @author ding.luo@corp.luoding .com
 */
public abstract class LogicExpressParseAbstract {

    protected final static Map operateMap = new HashMap<Character, List<Character>>();
    protected final static List<Character> operates = new ArrayList<Character>();

    static {
        operates.add('|');
        operates.add('&');
        operates.add('(');
        operates.add(')');
        operates.add('#');

        List<OperateRelation> relations1 = new ArrayList<OperateRelation>();
        OperateRelation op11 = new OperateRelation('|', '|', '>');
        OperateRelation op12 = new OperateRelation('|', '&', '>');
        OperateRelation op13 = new OperateRelation('|', '(', '<');
        OperateRelation op14 = new OperateRelation('|', ')', '>');
        OperateRelation op15 = new OperateRelation('|', '#', '>');
        relations1.add(op11);
        relations1.add(op12);
        relations1.add(op13);
        relations1.add(op14);
        relations1.add(op15);
        operateMap.put('|', relations1);

        List<OperateRelation> relations2 = new ArrayList<OperateRelation>();
        OperateRelation op21 = new OperateRelation('&', '|', '>');
        OperateRelation op22 = new OperateRelation('&', '&', '>');
        OperateRelation op23 = new OperateRelation('&', '(', '<');
        OperateRelation op24 = new OperateRelation('&', ')', '>');
        OperateRelation op25 = new OperateRelation('&', '#', '>');
        relations2.add(op21);
        relations2.add(op22);
        relations2.add(op23);
        relations2.add(op24);
        relations2.add(op25);
        operateMap.put('&', relations2);

        List<OperateRelation> relations3 = new ArrayList<OperateRelation>();
        OperateRelation op31 = new OperateRelation('(', '|', '<');
        OperateRelation op32 = new OperateRelation('(', '&', '<');
        OperateRelation op33 = new OperateRelation('(', '(', '<');
        OperateRelation op34 = new OperateRelation('(', ')', '=');
        OperateRelation op35 = new OperateRelation('(', '#', '>');
        relations3.add(op31);
        relations3.add(op32);
        relations3.add(op33);
        relations3.add(op34);
        relations3.add(op35);
        operateMap.put('(', relations3);

        List<OperateRelation> relations4 = new ArrayList<OperateRelation>();
        OperateRelation op41 = new OperateRelation(')', '|', '>');
        OperateRelation op42 = new OperateRelation(')', '&', '>');
        OperateRelation op44 = new OperateRelation(')', ')', '>');
        OperateRelation op45 = new OperateRelation(')', '#', '>');
        relations4.add(op41);
        relations4.add(op42);
        relations4.add(op44);
        relations4.add(op45);
        operateMap.put(')', relations4);

        List<OperateRelation> relations5 = new ArrayList<OperateRelation>();
        OperateRelation op51 = new OperateRelation('#', '|', '<');
        OperateRelation op52 = new OperateRelation('#', '&', '<');
        OperateRelation op53 = new OperateRelation('#', '(', '<');
        OperateRelation op54 = new OperateRelation('#', ')', '<');
        OperateRelation op55 = new OperateRelation('#', '#', '=');
        relations5.add(op51);
        relations5.add(op52);
        relations5.add(op53);
        relations5.add(op54);
        relations5.add(op55);
        operateMap.put('#', relations5);
    }

    /**
     * 表达是验证
     *
     * @param expression
     * @return
     */
    public  int expressionValid(String expression) {
        Pattern pattern1 = Pattern.compile("\\d+\\(");
        Matcher matcher1 = pattern1.matcher(expression);
        Pattern pattern2 = Pattern.compile("\\)\\d+");
        Matcher matcher2 = pattern2.matcher(expression);
        int position = -1;
        if (matcher1.find()) {
            position = matcher1.end();
        } else if (matcher2.find()) {
            position = matcher2.end();
        }
        return position;
    }

    public abstract Object logicExpressionParse(String expression) throws Exception ;

    public  String expressFormat(String expression) {

        expression = expression.replace("\\s+", "");
        if (!expression.matches(".*#")) {
            expression = expression + "#";
        }
        expression = expression.replaceAll("\\s+", "");
        return expression;
    }

    public abstract  Object operate(char operate, String first, String last) throws Exception;

    public  char operateCompare(char top, char out) {

        char result = ' ';
        List<OperateRelation> operateRelations = (List<OperateRelation>) operateMap.get(top);
        for (OperateRelation op : operateRelations) {
            if (op.getOut() == out) {
                result = op.getRelation();
                break;
            }
        }
        return result;
    }

    public  void init(Stack operate) {

        operate.push('#');

    }

    static class OperateRelation {

        private char top;
        private char out;
        private char relation;

        public OperateRelation(char top, char out, char relation) {
            this.top = top;
            this.out = out;
            this.relation = relation;
        }

        public char getTop() {
            return top;
        }

        public void setTop(char top) {
            this.top = top;
        }

        public char getOut() {
            return out;
        }

        public void setOut(char out) {
            this.out = out;
        }

        public char getRelation() {
            return relation;
        }

        public void setRelation(char relation) {
            this.relation = relation;
        }
    }
}
