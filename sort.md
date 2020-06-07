# 排序

## 选择排序
时间复杂度O(N^2);额外空间复杂度O(1)  \
[选择排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/SelectionSort.java)

## 冒泡排序
时间复杂度O(N^2);额外空间复杂度O(1)  
[冒泡排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/BubbleSort.java)

## 插入排序
时间复杂度O(N^2);额外空间复杂度O(1)  
[插入排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/InsertionSort.java)

算法流程按照最差情况来估计时间复杂度。

## 二分法
- 在一个**有序数组**中，找某个数是否存在。[BSExist.java](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/BSExist.java)
- 在一个**有序数组**中，找>=某个数最左侧的位置。[BSNearLeft.java](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/BSNearLeft.java)

## 异或运算
- `0 ^ N == N`,`N ^ N == 0`,性质，**不进位加**
- 异或运算满足交换律和结合律
- 不用额外变量就可以交换两个值。(参考冒泡排序中的交换方法)
- 交换两个变量的值，不申请额外的变量：(使用这种方式需要保证两个东西指的**内存**不一样，保证**内存是独立的**，哪怕值相同都没问题)

```
a = a ^ b;
b = a ^ b;
a = a ^ b;

以上代码执行后，a和b的值就交换了。
例：a = 甲; b = 乙;
a = a ^ b = 甲 ^ 乙;
b = a ^ b = (甲 ^ 乙) ^ 乙 = 甲;  ====> 根据异或运算的规律
a = a ^ b = (甲 ^ 乙) ^ 甲 = 乙;  ====> 完成交换，哪怕甲乙相等，也是一样的。

如果 a 和 b 指的内存是同一个，就出错了。
```

- 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这种数。
- 怎么把一个int类型的数，提取出最右侧的 1 来；`(N & ((~N) + 1)`
- 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两种数。

[EvenTimesOddTimes](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/EvenTimesOddTimes.java)

## 对数器
- 有一个你想要测的方法a。
- 实现复杂度不怎么好，但是容易实现的方法b。保证方法b绝对正确。
- 实现一个随机样本产生器。
- 把方法a和方法b跑相同的随机样本，看看得到的结果是否一样。
- 如果有一个随机样本使得比对结果不一致，打印样本进行人工干预，改对方法a或方法b。
- 当样本数量很多时比对测试依然正确，可以确定方法a已经正确。

[SortLogarithm](https://github.com/wangwren/algorithm/blob/master/src/basis/SortLogarithm.java)

## 递归
- 用递归方法找一个数组中的最大值？

[GetMax](https://github.com/wangwren/algorithm/blob/master/src/basis/class01/GetMax.java)

- master公式的使用,用于算递归的时间复杂度,适用与递归规模相同，b表示子问题的规模，a表示调用了几次子规模，d表示除了子问题的其他时间复杂度
`T(N) = a * T(N/b) + O(N ^ d)`

- log(b,a) > d -> 复杂度为 O(N ^ log(b,a))
- log(b,a) == d -> 复杂度为 O(N ^ d * logN)
- log(b,a) < d -> 复杂度为 O(N ^ d)

## 归并排序
- 整体就是一个简单递归，左边排好序、右边排好序、让其整体有序。
- 让其整体有序的过程用了排外序方法。
- 时间复杂度O(N*logN);额外空间复杂度O(N)

[归并排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/MergeSort.java)

### 归并排序扩展
#### 小和问题
在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组 的小和。
例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、2;
所以小和为1+1+3+1+1+3+4+2=16
[SmallSum](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/SmallSum.java)

## 堆
- 堆结构就是用数组实现的完全二叉树结构。(从左至右都有节点，不存在左侧无节点右侧有节点的情况)
- 完全二叉树中如果每棵子树的最大值都在顶部就是大根堆。(大根堆不一定就是有序的)
- 完全二叉树中如果每棵子树的最小值都在顶部就是小根堆。(小根堆不一定就是有序的)
- 堆结构的heapInsert与heapify操作
- 堆结构的增大和减少
- 优先级队列结构，就是堆结构。(PriorityQueue默认小根堆)
- 已知节点，求左子节点：2*i+1;求右子节点：2*i + 2
- 已知左右子节点，求父节点：(i - 1)/2

## 堆排序
- 先让整个数组都变成大根堆结构，建立堆的过程：
    - 两种方式：
        - 从上到下的方法，时间复杂度为O(N*logN),heapInsert实现
        - 从下到上的方法，时间复杂度为O(N),用heapify实现,(这种方式需要用户已全部给出数组，不是一个一个输入的形式)
    - 选以上两种方式的一种就行。
- 把堆的最大值和堆末尾的值交换，然后减少堆的大小之后，再去调整堆(调整的过程就是heapify的过程)，一直周而复始，时间复杂度为O(N*logN)
- 堆的大小减小成0之后，排序完成。  

[堆排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/HeapSort.java)

### 堆排序扩展
已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。

根据题意，k是小于数组长度的，可以使用java提供的PriorityQueue小根堆，一次加入k个，因为移动距离不会超过k，此时从小根堆中poll弹出一个元素，放在0位置上；
就是最小值，之后再往小根堆中加入新的元素，重复操作。整个过程的时间复杂度O(N*logk)。  
[SortArrayDistanceLessK](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/SortArrayDistanceLessK.java) 

## 快排
### 荷兰国旗问题
给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度O(1)，时间复杂度O(N)。  
[NetherlandsFlag](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/NetherlandsFlag.java)

### 不改进的快速排序
- 把数组范围中的**最后一个数**作为划分值，然后把数组通过荷兰国旗问题分成三个部分：左侧<划分值；中间=划分值；右侧>划分值。
- 对左侧范围和右侧范围，递归执行。

- 分析
    - 划分值越靠近两侧，复杂度越高；划分值越靠近中间，复杂度越低。
    - 可以轻而易举的举出最差的例子，所以不改进的快速排序时间复杂度为O(N^2)。
    
### 随机快速排序(改进的快速排序)
- 在数组范围中，**等概率随机选一个数**作为划分值，然后把数组通过荷兰国旗问题分成三个部分：左侧<划分值；中间=划分值；右侧>划分值。
- 对左侧范围和右侧范围，递归执行。
- 时间复杂度为O(N*logN)  

[快排](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/QuickSort.java)

## 比较器的使用
- 比较器的实质就是重载比较运算符。
- 比较器可以很好的应用在特殊标准的排序上。
- 比较器可以很好的应用在根据特殊标准排序的结构上。
- Java中实现`Comparator`接口。

[比较器](https://github.com/wangwren/algorithm/blob/master/src/basis/class03/Code_Comparator.java)

## 桶排序思想下的排序
- 计数排序
- 基数排序
- 分析
    - 桶排序思想下的排序都是**不基于比较**的排序。
    - 时间复杂度为O(N)，额外空间复杂度O(M)。
    - 应用范围有限，需要样本的数据状况满足桶的分化。
    
## 排序算法的稳定性及其汇总
- **同样值的个体**之间，如果不因为排序而改变相对次序，就是这个排序是有稳定性的；否则就没有。
- 不具备稳定性的排序：
    - 选择排序
    - 快速排序
    - 堆排序
- 具备稳定性的排序
    - 冒泡排序
    - 插入排序
    - 归并排序
    - 一切桶排序思想下的排序
    
| 排序   | 时间复杂度       | 空间复杂度   | 稳定性 | 备注           |
|:----:|:-----------:|:-------:|:---:|:------------:|
| 选择排序 | O(N^2)      | O(1)    | 不稳定 |              |
| 冒泡排序 | O(N^2)      | O(1)    | 稳定  | 遇到相同的不交换就稳定了 |
| 插入排序 | O(N^2)      | O(1)    | 稳定  | 遇到相同的不交换就稳定了 |
| 归并排序 | O(N*log(N)) | O(N)    | 稳定  | 合并时，先拿左边     |
| 堆排序  | O(N*log(N)) | O(1)    | 不稳定 |              |
| 快速排序 | O(N*log(N)) | O(logN) | 不稳定 |              |
    
**目前没有找到时间复杂度O(N*logN),额外空间复杂度O(N),又稳定的排序。**

- 途快：用快排，因为快排的常数时间最好。
- 途稳定：用归并。
- 途空间：用堆排序。

## 常见的坑
1. 归并排序的额外空间复杂度可以变成O(1)，(**就会失去稳定性**)，但是非常难，不需要掌握，有兴趣可以搜“归并排序 内部缓存法”。
2. “原地归并排序”的帖子都是垃圾，会让归并排序的时间复杂度变成O(N^2)。
3. 快速排序可以做到稳定性问题，但是非常难，不需要掌握，可以搜“01 stable sort”。
4. 所有的改进都不重要，因为目前没有找到时间复杂度O(N*logN)，额外空间复杂度O(N)，又稳定的排序。
5. 有一道题目，是奇数放在数组左边，偶数放在数组右边，还要求原始的相对次序不变，碰到这个问题，可以怼面试官。因为这就属于快排01问题，做不到稳定性。

## 工程上对排序的改进
1. 充分利用O(N*logN)和O(N^2)排序各自的优势。
2. 稳定性的考虑。
3. Java中，`Arrays.sort()`会走两个分支。**基础数据类型：快排；实体数据类型：归并**(通过反射看)