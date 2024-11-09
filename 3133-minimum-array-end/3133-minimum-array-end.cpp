class Solution {
public:
    long long minEnd(int n, int x) {
        long long ans=x;
        vector<int>v;
        for(int i=0;i<=30;i++) {
            if(((x>>i)&1) ==1) {
                continue;
            } else
                v.push_back(i);
        }
        for(int i=31;i<=50;i++)
            v.push_back(i);
        long long k=n-1;
        int m=v.size();
        for(long long i=0;i<m;i++) {
            if(((k>>i)&1) ==1)
                ans = ans+ (long long)(1ULL<<v[i]);
        }
        return ans;
    }
};