# 二叉树
## 二叉树节点结构
```java
class Node<V>{
    V value;
    Node left;
    Node right;
}
```

*二叉树不是数组结构，以上结构是二叉树的经典结构*。

## 用递归和非递归两种方式实现二叉树的先序、中序、后序遍历
![二叉树](https://imagebed-1259286100.cos.ap-beijing.myqcloud.com/img/20200404163807.png)
### 先序遍历
对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。(头左右)

先序:1,2,4,5,3,6,7

### 中序遍历
对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。(左头右)

中序:4,2,5,1,6,3,7

### 后序遍历
对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。(左右头)

后序:4,5,2,6,7,3,1

[先、中、后序遍历](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/Code01_PreInPosTraversal.java)  

递归方式：其实在系统后台也是用系统栈来实现的。
非递归方式：(申请一个栈)
- 先序：先将头节点压入栈，之后弹出，之后先压右节点再压左节点。
- 中序：整条左边界进栈，当无左边界，弹出打印，之后去右子树，去右子树重复操作(左子树全进栈)。
- 后序：使用先序同样代码就可以，只是先压左节点再压右节点。先`:（头右左）在打印时不打印，收集到容器中最后逆序打印容器，就是后序了。

**时间复杂度：O(N)**

**宽度优先遍历用队列**。 (队列：先进先出) 
**深度优先遍历用栈**。（栈：先进后出）

## 如何直观的打印一颗二叉树
提供一个福利函数，方便在控制台看二叉树的结构:[Code02_PrintBinaryTree](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/Code02_PrintBinaryTree.java)


## 树型dp(树型动态规划)

### 二叉树递归套路
- 前提：假设以x节点为头，左右子树可以要信息。
    - x头的树，答案根据前提列可能性(这个可能性分：x头无关；x头有关)。
    - 左右子树需要提供什么信息，支持可能性计算，
    - 左右子树要求一样，信息即要求；左右子树要求不一样，信息即全集，
    - 信息确定，开始coding。
    
### 二叉树的相关概念及其实现判断
#### 如何判断一颗二叉树是否是搜索二叉树？
- 搜索二叉树：任何一颗子树，左边节点都比头节点小；右边节点都比头节点大。

[IsBST](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/IsBST.java)

#### 如何判断一颗二叉树是完全二叉树？
- 完全二叉树：

#### 如何判断一颗二叉树是否是满二叉树？
- 满二叉树：每一层都是满的，层数:L，节点数:N；满足关系：2^L - 1 = N。

[IsFull](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/IsFull.java)

#### 如何判断一颗二叉树是否是平衡二叉树？
- 平衡二叉树：任何一颗子树，左树高度与右树高度差的绝对值不超过1。

[IsBalancedTree](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/IsBalancedTree.java)

### 给定两个二叉树的节点node1和node2，找到他们的最低公共祖先节点

- 已知node1和node2一定在这颗树上。
- 最低公共祖先：node1，node2一直往上走的汇聚点。

- 信息
    - 以x为头的树，既无node1，也无node2，那么最低公共祖先为空。
    - 以x为头的树，有node1，无node2，那么最低公共祖先为空。
    - 以x为头的树，无node1，有node2，那么最低公共祖先为空。
    - 既有node1，也有node2，那么最低公共祖先？
        - 左树既有node1，也有node2，那么最低公共祖先是左树汇报的**结果**。
        - 右树既有node1，也有node2，那么最低公共祖先是右树汇报的**结果**。
        - 左树含有node1，右树含有node2，那么最低公共祖先为x。
        - 左树含有node2，右树含有node1，那么最低公共祖先为x。
        
- 最终整理信息：
    - 对于每一颗子树，有无node1。
    - 对于每一颗子树，有无node2。
    - 你发现的最低公共祖先是谁(前两个为true的情况)
    
    
[LowestCommonAncestor](https://github.com/wangwren/algorithm/blob/master/src/basis/class05/LowestCommonAncestor.java)
