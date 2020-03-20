# algorithm
## 时间复杂度
- 常数时间操作：一个操作如果和样本数据量没有关系，每次都是固定时间内完成的操作，叫做常数操作。
- 时间复杂度为一个算法流程中，常数操作数量的一个指标。常用O(读做 big O)来表示。
- 具体来说，先要对一个算法流程非常熟悉，然后去写出这个算法流程中，发生了多少常数操作，进而总结出常数操作数量的表达式。
- 在表达式中，**只要高阶项，不要低阶项，也不要高阶项的系数**，剩下的部分如果为f(N)，那么时间复杂度为O(f(N))。
- 评价一个算法流程的好坏，先看时间复杂度的指标，然后再分析不同数据样本下的实际运行时间，也就是*常数项时间*

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
- 不用额外变量就可以交换两个值。(参考冒泡排序中的交换方法，需要保证两个数的位置不同)

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

- master公式的使用,用于算递归的时间复杂度
`T(N) = a * T(N/b) + O(N ^ d)`

- log(b,a) > d -> 复杂度为 O(N ^ log(b,a))
- log(b,a) = d -> 复杂度为 O(N ^ logN)
- log(b,a) < d -> 复杂度为 O(N ^ d)

## 归并排序
- 整体就是一个简单递归，左边排好序、右边排好序、让其整体有序。
- 让其整体有序的过程用了排外序方法。
- 时间复杂度O(N*logN);额外空间复杂度O(N)

[归并排序](https://github.com/wangwren/algorithm/blob/master/src/basis/class02/MergeSort.java)

### 归并排序扩展
#### 小和问题

#### 逆序对问题