package com.nasdev.backbasechallenge.datastructures;

import java.util.HashMap;

public class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children;
    private boolean isEnd;

    public TrieNode(char c) {
        value = c;
        children = new HashMap<>();
        isEnd = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }
    public char getValue(){
        return value;
    }

    public void setIsEnd(boolean bIsEnd) {
        this.isEnd = bIsEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
