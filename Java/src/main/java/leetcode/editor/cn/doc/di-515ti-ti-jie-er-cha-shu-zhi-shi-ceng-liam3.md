### 解题思路
欢迎大家关注，我会持续更新刷题题解，希望对大家有所帮助！

此题考查的是**二叉树**知识内容里的**层序遍历**。
**采用队列的原因**：队列先进先出，符合一层一层遍历的逻辑。
这种遍历方式就是图论中的**广度优先遍历**，只不过我们应用在二叉树上。
**本题与之前题解不同之处在于：取每一层的最大值。**
详情如下代码：
### 代码

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        queue<TreeNode*> que;
        vector<int> result;
        if(root!=NULL)
        {
            que.push(root);
        }
        while(!que.empty())
        {
            int size=que.size();
            int max=INT_MIN;//取每一层的最大值
            for(int i=0;i<size;i++)
            {
                TreeNode *node=que.front();
                que.pop();
                max = node->val > max ? node->val : max ;
                if(node->left)
                {
                    que.push(node->left);
                }
                if(node->right)
                {
                    que.push(node->right);
                }
            }
            result.push_back(max);//把最大值放入数组
        }
        return result;
    }
};
```