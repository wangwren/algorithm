# 链表结构、栈、队列
## 单链表的节点结构
```java
class Node<V> {
    V value;
    Node next;
}
```

以上结构的节点依次连接起来所形成的链叫单链表结构。

## 双链表的节点结构
```java
class Node<V> {
    V value;
    Node next;
    Node last;
}
```

以上结构的节点依次连接起来所形成的链叫双链表结构。

单链表和双链表结构只需要给定一个头部节点head，就可以找到剩下的所有节点。

### 反转单向和双向链表
- 分别实现反转单向链表和反转双向链表的函数。
- 如果链表长度为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)。

[ReverseList](https://github.com/wangwren/algorithm/blob/master/src/basis/class04/ReverseList.java)

### 给指定值都删除
- 注意头结点是指定值的情况

## 打印两个有序链表的公共部分
- 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
- 如果两个链表的长度之和为N，时间复杂度要求为O(N)，额外空间复杂度要求为O(1)

# 