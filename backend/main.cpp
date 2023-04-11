#include <iostream>
#include <cstring>
#include <algorithm>
#include <queue>
using namespace std;

#define x first
#define y second

typedef pair<int,int> PII;

const int N = 510,M = N * N;


int n,m;
char g[N][N];
int dist[N][N];
bool st[N][N];

int bfs()
{
    memset(dist,0x3f,sizeof dist);//距离初始化为正无穷
    memset(st,0,sizeof st);//判重数组初始化
    dist[0][0] = 0;//起点
    deque<PII>q;//双端队列
    q.push_back({0,0});
    
    char cs[] = "\\/\\/";//注意转义字符
    int dx[4] = {-1,-1,1,1},dy[4] = {-1,1,1,-1};
    int ix[4] = {-1,-1,0,0},iy[4] = {-1,0,0,-1};
    
    while(q.size())
    {
        PII t = q.front();//取出队头
        q.pop_front();
        
        if(st[t.x][t.y]) continue;//遍历过了
        st[t.x][t.y] = true;//打上遍历过的标记
        
        for(int i = 0;i < 4;i ++ )//遍历每个方向
        {
            int a = t.x + dx[i],b = t.y + dy[i];
            if(a < 0 || a > n || b < 0 || b > m) continue;//点比格子多1，所以不是大于等于
            
            int ca = t.x + ix[i], cb = t.y + iy[i];
            int d = dist[t.x][t.y] + (g[ca][cb] != cs[i]);
            
            if(d < dist[a][b])
            {
                dist[a][b] = d;
                
                if(g[ca][cb] != cs[i]) q.push_back({a,b});
                else q.push_front({a,b});
            }
        }
        
    }
    return dist[n][m];
}

int main()
{
    int T;
    cin >> T;
    while(T -- )
    {
        scanf("%d%d",&n,&m);//读入行列
        for(int i = 0;i < n;i ++ ) scanf("%s",g[i]);//按行读入
        
        int t = bfs();
        
        if(t == 0x3f3f3f3f) puts("NO SOLUTION");
        else printf("%d\n",t);
    }
    return 0;
}