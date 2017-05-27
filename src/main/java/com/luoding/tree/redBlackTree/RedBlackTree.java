package com.luoding.tree.redBlackTree;

/**
 * author: ding.luo
 * time: 17-4-1 下午5:29
 */
public class RedBlackTree {

    private Node root;

    public class Node {

        public Node(String color, int value, Node left, Node right, Node parent) {
            this.color = color;
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        //节点颜色
        public String color;
        //节点的值
        public int value;

        //左孩子
        public Node left;

        //右孩子
        public Node right;

        //父节点
        public Node parent;
    }

    /**
     * 对红黑树的节点(x)进行左旋转
     * <p>
     * 左旋示意图(对节点x进行左旋)：
     * px                              px
     * /                               /
     * x                               y
     * /  \      --(左旋)->           / \                #
     * lx   y                          x  ry
     * /   \                       /  \
     * ly   ry                     lx  ly
     * <p>
     * <p>
     * 注意需要设置左节点，右节点，还有父节点
     * 首先需要分清楚x是左节点还是右节点
     */
    private void leftRotate(Node x) {

        //获取右孩子
        Node y = x.right;

        //将y的左孩子设置为x右孩子
        x.right = y.left;
        //设置父节点
        if (null != y.left) {
            y.left.parent = x;
        }
        //设置y的父节点
        y.parent = x.parent;
        //如果父节点为null，则为根节点
        if (null == x.parent) {
            root = y;
        } else {
            if (x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        //将x设置为y的左孩子
        y.left = x;
        //将y设置成x的父节点
        x.parent = y;
    }

    /**
     * 对红黑树的节点(y)进行右旋转
     * <p>
     * 右旋示意图(对节点y进行左旋)：
     * py                               py
     * /                                /
     * y                                x
     * /  \      --(右旋)->            /  \                     #
     * x   ry                           lx   y
     * / \                                   / \                   #
     * lx  rx                                rx  ry
     */
    private void rightRotate(Node y) {
        Node x = y.left;
        //将x的右孩子设置为y左孩子
        y.left = x.right;
        if (null != y.left) {
            y.left.parent = y;  //设置父节点
        }

        //处理父节点
        x.parent = y.parent;
        if (null == x.parent) {
            root = y;
        } else {
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        y.parent = x;

        x.right = y;

    }

    /**
     * 新建结点(key)，并将其插入到红黑树中
     * <p>
     * 参数说明：
     * key 插入结点的键值
     */

    public void insert(int value) {

        Node node = new Node("red", value, null, null, null);

        insert(node);

    }

    /**
     * 将结点插入到红黑树中
     * <p>
     * 参数说明：
     * node 插入的结点        // 对应《算法导论》中的node
     */
    private void insert(Node node) {

        int cmp;
        Node y = null;
        Node x = this.root;
        while (null != x) {
            y = x;
            if (x.value > node.value) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (null != y) {
            if (node.value < y.value) {
                y.left = node;
            } else {
                y.right = node;
            }
        }

        node.color = "red";
        insertFixUp(node);
    }

    //平衡二叉树调整

    /**
     * 红黑树插入修正函数
     * <p>
     * 在向红黑树中插入节点之后(失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     * <p>
     * 参数说明：
     * node 插入的结点        // 对应《算法导论》中的z
     */
    private void insertFixUp(Node node) {

        Node parent;
        Node gparent;
        parent = node.parent;
        //如果父节点存在且为红色
        while ((parent = parentOf(node)) != null && isRed(parent)) {
            gparent = parentOf(parent);
            //若父节点是祖父节点的左孩子
            if (parent == gparent.left) {
                Node uncle = gparent.right;
                //case 1:叔叔节点为红色
                if (null != uncle && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                //case 2 :叔叔是黑色，且当前节点是右孩子
                if (parent.right == node) {
                    Node tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是左孩子。
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                //若父节点是祖父节点的右孩子
                //case 1:叔叔节点是红色
                Node uncle = gparent.left;
                if (null != uncle && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                // Case 2条件：叔叔是黑色，且当前节点是左孩子
                if (parent.left == node) {
                    Node tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                // Case 3条件：叔叔是黑色，且当前节点是右孩子。
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(this.root);
    }

    private void remove(Node node) {

        Node child;
        Node parent;
        String color = "";
        // 被删除节点的"左右孩子都不为空"的情况。
        if ((null != node.left) && (null != node.right)) {

            // 被删节点的后继节点。(称为"取代节点")
            // 用它来取代"被删节点"的位置，然后再将"被删节点"去掉。
            Node replace = node;
            // 获取后继节点(比要删除的大的最小的节点)
            replace = replace.right;
            while (null != replace.left) {
                replace = replace.left;
            }
            // "node节点"不是根节点(只有根节点不存在父节点)
            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.root = replace;
            }

            // child是"取代节点"的右孩子，也是需要"调整的节点"。
            // "取代节点"肯定不存在左孩子！因为它是一个后继节点。
            child = replace.right;
            parent = parentOf(replace);
            color = colorOf(replace);
            // "被删除节点"是"它的后继节点的父节点"
            if (parent == node) {
                parent = replace;
            } else {
                // child不为空
                if (child != null) {
                    child.parent = parent;
                }
                parent.left = child;

                replace.right = node.right;
                node.right.parent = replace;
            }

            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;

            if (color.equals("black")) {
                removeFixUp(child, parent);
            }
            node = null;
            return;
        }

        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        // 保存"取代节点"的颜色
        color = node.color;
        if (child != null) {
            child.parent = parent;
        }

        // "node节点"不是根节点
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            this.root = child;
        }

        if ("black".equals(color)) {
            removeFixUp(child, parent);
        }

        node = null;
    }

    /**
     * 删除结点(z)，并返回被删除的结点
     * <p>
     * 参数说明：
     * tree 红黑树的根结点
     * z 删除的结点
     */
    public void remove(int value) {

        Node node;
        if ((node = search(root, value)) != null) {
            remove(node);
        }
    }

    //搜索一个节点
    private Node search(Node root, int key) {

        return null;
    }

    /**
     * 红黑树删除修正函数
     * <p>
     * 在从红黑树中删除插入节点之后(红黑树失去平衡)，再调用该函数；
     * 目的是将它重新塑造成一颗红黑树。
     * <p>
     * 参数说明：
     * node 待修正的节点
     */
    private void removeFixUp(Node node, Node parent) {

        Node other;
        while((node == null || isBlack(node)) && (node != this.root)){
            if(parent.left == node){
                other = parent.right;
                if(isRed(other)){
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }
                if((other.left == null) || isBlack(other.left) && (other.right == null || isBlack(other.right))){
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                }else{
                    if(other.right == null || isBlack(other.right)){
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    other.color = colorOf(parent);
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.root;
                    break;
                }
            }else{
                other = parent.left;
                if(isRed(other)){
                    // Case 1: x的兄弟w是红色的
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if((other.left == null || isBlack(other.left)) && (other.right == null || isBlack(other.right))){
                    // Case 2: x的兄弟w是黑色，且w的俩个孩子也都是黑色的
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                }else{
                    if(other.left == null || isBlack(other.left)){
                        // Case 3: x的兄弟w是黑色的，并且w的左孩子是红色，右孩子为黑色。
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }
                    // Case 4: x的兄弟w是黑色的；并且w的右孩子是红色的，左孩子任意颜色。
                    other.color = parent.color;
                    setBlack(parent);
                    setBlack(other.left);
                    node = this.root;
                    break;
                }
            }
        }

        if(null != node){
            setBlack(node);
        }
    }

    private String colorOf(Node node) {

        return node.color;
    }

    private Node parentOf(Node node) {

        return node.parent;
    }

    private boolean isRed(Node node) {

        return "red" == node.color;
    }

    private boolean isBlack(Node node){

        return "black" == node.color;
    }

    private void setBlack(Node node) {

        node.color = "black";
    }

    private void setRed(Node node) {

        node.color = "red";
    }
}
