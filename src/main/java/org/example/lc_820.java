package org.example;

/**
 * @see <a href="https://leetcode.cn/problems/short-encoding-of-words/description/">820. 单词的压缩编码</a>
 * @see <a href="https://leetcode.cn/problems/iSwD2y/description/">LCR 065. 单词的压缩编码</a>
 */
public class lc_820 {

    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            add(words[i]);
        }
        return res;
    }
    Node root = new Node();
    int res = 0;
    void add(String word) {
        Node pre = root;
        int preEnd = -1;
        int preBIf = -1;
        boolean flag = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            Node node = pre.next[c - 'a'];
            if (node == null) {
                node = new Node();
                pre.next[c - 'a'] = node;
                pre.nextCount++;
                flag = true;
            }
            if (pre.isEnd) {
                preEnd = word.length() - i - 1;
            }
            if (pre.nextCount > 1){
                preBIf = word.length() - i - 1;
            }
            pre = node;
        }
        pre.isEnd = true;
        if (pre.nextCount == 0 && flag) {
            if (preEnd > preBIf) {
                res += word.length() - preEnd;
            } else {
                res += word.length() + 1;
            }
        }
    }

    static class Node {
        Node[] next;
        int nextCount;
        boolean isEnd;
        Node() {
            next = new Node[26];
            nextCount = 0;
            isEnd = false;
        }
    }
}
