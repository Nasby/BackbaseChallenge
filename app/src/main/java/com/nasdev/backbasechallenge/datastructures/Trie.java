package com.nasdev.backbasechallenge.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode((char)0);
    }

    public void insert(String word){
        int length = word.length();
        TrieNode current = root;

        for (int level = 0; level < length; level++){
            HashMap<Character, TrieNode> child = current.getChildren();
            char ch = word.charAt(level);

            if( child.containsKey(ch)){
                current = child.get(ch);
            }else{
                TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                current = temp;
            }
        }

        current.setIsEnd(true);
    }

    //Finds the node that matches the prefix
    public TrieNode find(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            TrieNode node = current.getChildren().get(c);
            if (node == null){
                return null;
            }
            current = node;
        }
        return current;
    }

    //Produce a list based off all the words that can be spelled
    //based off the passed node
    public ArrayList<String> convertNodeToList(String prefix, TrieNode node){
        ArrayList<String> matches = new ArrayList<>();
        getWord(prefix, node, new char[128], 0, matches);
        return matches;
    }

    //Recursive function that adds city to list if at the last node
    //If not the last node, goes deeper into the Trie
    private void getWord(String prefix, TrieNode node, char[] word, int pos, ArrayList<String> list){
        if (node == null){
            return;
        }

        if (node.isEnd()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < pos && i < word.length; i++){
                sb.append(word[i]);
            }
            list.add(prefix + new String(sb));
        }

        for (TrieNode value : node.getChildren().values()){
            word[pos] = value.getValue();
            getWord(prefix, value, word, pos+1, list);
        }
    }
}
