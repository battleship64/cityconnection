package com.mc.cityconnection.demo.dao;

import com.mc.cityconnection.demo.entity.Graph;

public class ConnectCheck {
    private boolean[] marked;
    private int[] id;  // 记录每个节点所属的连通块计数
    private int count;  //用来标记不同连通块

    public ConnectCheck(Graph g) {
        marked = new boolean[g.getVertices()];
        id = new int[g.getVertices()];
        for(int i = 0; i < g.getVertices(); i++) { //遍历所有节点
            if(!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : g.adj(v))
            if(!marked[w])
                dfs(g, w);
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }


}
