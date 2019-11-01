package ru.mail.polis.ads.bst;

/**
 * AVL implementation of binary search tree.
 */
public class AvlBst<Key extends Comparable<Key>, Value>
        implements Bst<Key, Value> {
    
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int height;
        Node(Key key_,Value value_)
        {
            key=key_;
           value=value_;
           right=null;
           left=null;
        }
    }
   private Node rootNode;

    private int bfactor(Node p)
    {
        return height(p.right)-height(p.left);
    }
    private int height(Node p)
    {
        return p.height;
    }
    private void fixheight(Node p)
    {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = (hl>hr?hl:hr)+1;
    }
    private Node rotateright(Node p)
    {
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        fixheight(p);
        fixheight(q);
        return q;
    }

    private Node rotateleft(Node q)
    {
        Node p = q.right;
        q.right = p.left;
        p.left = q;
        fixheight(q);
        fixheight(p);
        return p;
    }

    private Node balance(Node p) // балансировка узла p
    {
        fixheight(p);
        if( bfactor(p)==2 )
        {
            if( bfactor(p.right) < 0 )
                p.right = rotateright(p.right);
            return rotateleft(p);
        }
        if( bfactor(p)==-2 )
        {
            if( bfactor(p.left) > 0  )
                p.left = rotateleft(p.left);
            return rotateright(p);
        }
        return p;
    }

    private Node insert(Node p, Key k,Value value)
    {
        if( p==null ) return new Node(k,value);
        if( k.compareTo(p.key)<0 )
            p.left = insert(p.left,k,value);
        else if( k.compareTo(p.key)>0 )
            p.right = insert(p.right,k,value);
        else p.value=value;
        return balance(p);
    }

    private Node findmin(Node p)
    {
        while(p.left != null){
            p = p.left;
        }
        return p;
    }

    private Node findmax(Node p)
    {
        while(p.right != null){
            p = p.right;
        }
        return p;
    }
    private Node find(Node p,Key k)
    {
        while(p != null){
            if(p.key == k) return p;
            else if (k.compareTo(p.key) > 0)
                p = p.right;
            else p = p.left;
        }
        return null;
    }
    private Node removemin(Node p)
    {
        if( p.left==null )
            return p.right;
        p.left = removemin(p.left);
        return balance(p);
    }
    private Node remove(Node p, Key k)
    {
        if( p==null ) return null;
        if( k.compareTo(p.key)<0 )
            p.left = remove(p.left,k);
        else if( k.compareTo(p.key)>0 )
            p.right = remove(p.right,k);
        else
        {
            Node q = p.left;
            Node r = p.right;
            if( r==null ) return q;
            Node min = findmin(r);
            min.right = removemin(r);
            min.left = q;
            return balance(min);
        }
        return balance(p);
    }
    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }
        @Override
    public Value get(Key key) {
            if (rootNode == null) return null;
            Node node = find(rootNode,key);
            if(node==null)
                return null;
            return node.value;
    }

    @Override
    public void put(Key key, Value value) {
        if (rootNode==null)
        {
            rootNode.height=1;
            rootNode.value=value;
            rootNode.key=key;
            rootNode.left=null;
            rootNode.right=null;
        }
        else insert(rootNode,key,value);
    }

    @Override
    public Value remove(Key key) {
        Value value;
        if (rootNode == null) return null;
        value=get(key);
        remove(rootNode,key);
        return value;
    }

    @Override
    public Key min() {
        if (rootNode == null) return null;
        Node p;
        p=findmin(rootNode);
        return p.key;
    }

    @Override
    public Value minValue() {
        if (rootNode == null) return null;
        Node p;
        p=findmin(rootNode);
        return p.value;
    }

    @Override
    public Key max() {
        if (rootNode == null) return null;
        Node p;
        p=findmax(rootNode);
        return p.key;
    }

    @Override
    public Value maxValue() {
        if (rootNode == null) return null;
        Node p;
        p=findmax(rootNode);
        return p.value;
    }

    @Override
    public Key floor(Key key) {
        if (rootNode == null) return null;
        Node node = rootNode;
        Key min = null;
        while(node != null){
            if (key.compareTo(node.key) == 0)
                return node.key;
            else if (key.compareTo(node.key) > 0) {
                if ((node.right == null) || (node.right.key.compareTo(key) > 0)){
                    min = node.key;
                }
                node = node.right;
            } else if (key.compareTo(node.key) < 0) {
                node = node.left;
            }
        }
        return min;
    }


    @Override
    public Key ceil(Key key) {
        if (rootNode == null)
            return null;
        Node node = rootNode;
        Key max = null;

        while(node != null){
            if (key.compareTo(node.key) == 0)
                return node.key;
            else if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else if (key.compareTo(node.key) < 0) {
                if ((node.left == null) ||
                        (node.left.key.compareTo(key) < 0)){
                    max = node.key;
                }
                node = node.left;
            }
        }
        return max;
    }

    @Override
    public int size() {
        if (rootNode == null)
            return 0;
        return size(rootNode);
    }


    @Override
    public int height() {
        return height(rootNode);
    };
}
