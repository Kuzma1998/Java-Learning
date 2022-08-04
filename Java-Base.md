# Java学习

## 一、Java基础语法

### 1. 注释

### 2. 字面量

### 3. 变量

- java的变量分为局部变量和成员变量

### 4. 数据类型

### 5. 关键字和标识符

```java
static int a; a=0;
int a;//a没有初始化，不能使用
```



### 6. 类型转换

- 自动类型转换：范围小的变量可以直接赋值给范围大的变量。底层原理是拓展
- 表达式中的自动类型转换：小范围转换为大范围的再运算。最终结果是由最高类型的数据决定。在表达式中byte，short，char都当成int
- 强制类型转换：大范围的数据直接赋值给小范围的变量，会报错。底层原理是截断。强制类型转换可能会造成数据丢失。浮点型转为整形，直接丢弃小数部分。

```java
int a = 20;
byte b = (byte) a;
```

### 7. 运算符

- 算数运算符：+，-，*，/，%，两个整数做除法，结果是整数。
- +符号做连接符：字符串运算的时候做连接符。能算则算，不能算则连到一起。
- 自增自减运算符：++，--只能操作变量，不能操作字面量（c++的字面值常量）。
- 赋值运算符以及拓展赋值运算符，隐含了强制类型转换，a+=b（a=（a的类型）a+b）
- 关系运算符：大于等于小于...
- 逻辑运算符：与或非异或（&, |, !, ^）。&&短路与：左边为false，右边不执行；||短路或：左边为true右边不执行。而单与和单或左右都会执行。
- 三元运算符：条件表达式？value1：value2；
- 运算符优先级：双与优先级高于双或

### 8. 键盘录入

- 导入包
- 得到键盘扫描器对象
- 等待接收用户输入数据
- System，String是lang包的东西，默认导入

```
package com.huawei.scanner;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        
        // 得到键盘扫描器对象
        Scanner sc = new Scanner(System.in);
        // 等待用户输入数据并按下回车键
        int age = sc.nextInt();
        System.out.println("年龄是：" + age);

        String name = sc.next();
        System.out.println("名字是：" + name);

    }
}
```

### 9. 程序流程控制

- IF分支结构

```java
/*if (条件){
            做xxx
        }*/

/*if () {
        } else {
        }*/

/*if () {
        } else if () {
        } else if () {
        } else {
        }*/
```



- switch分支：适合做值匹配的选择分支
  - 先执行表达式，然后与case作比较
  - 匹配哪个case值就执行哪个case，遇到break就跳出
  - 如果都不匹配则执行default
  - 表达式类型只能是byte int short char，枚举，不支持double float long
  - case不允许重复，且只能为字面量，不能是变量
  - 不要忘记写break，否则会穿透。不写break会一直往下执行（不会匹配case）直到遇到break退出



- for循环结构：控制一段代码执行多次；也有和c++一样的增强for循环

```java
for(声明语句 : 表达式)
{
   //代码句子
}
```



- while循环：不知道循环多少次用while，知道用for

- break：跳出所在的循环或者switch
- continue：跳过这次循环执行下次循环，仅仅在循环中执行



### 10. 数组概述

- 概念：存储一批同种类型的数据的内存区域；都是在堆内存
- 静态初始化数组：定义数组的时候直接给数组赋值

```java
数据类型[] 数组名 = new 数据类型[]{元素1，元素2，元素3...}  or
数据类型 数组名[] = new 数据类型[]{元素1，元素2，元素3...}   
int[] arr = new int[] {1,2,3};
int[] arr = {1,2,3};
arr.length 代表数组的长度
```

- 基本原理：连续的一片内存，数组名存储的是数组在内存中的地址，数组是引用类型。
- 数组的访问：索引，从0开始；arr[索引]

- 动态初始化数组：定义数组的时候仅仅确定数组的元素类型和长度；

```java
int arr[] = new int[3];
```

- 元素默认值：

```java
public class ArrayDemo3 {
    public static void main(String[] args) {
        int array[] = new int[3];
        System.out.println(array[0]);

        char chars[] = new char[3];
        System.out.println((int)chars[0]); //默认也是0

        double scores[] = new double[3];
        System.out.println(scores[0]); // 默认0.0

        boolean flags[] = new boolean[3];
        System.out.println(flags[0]); // 默认false

        String names[] = new String[3];
        System.out.println(names[0]); // 默认null
        
    }
}
```

| 数据类型                         | 默认值 |
| -------------------------------- | ------ |
| short，int，byte，long           | 0      |
| float，double                    | 0.0    |
| boolean                          | false  |
| 引用类型如类，接口，数组，String | null   |

- 数组内存图：
  - 方法区：字节码文件加载时进入的内存
  - 栈内存：方法运行时所及进入的内存，变量也是放在这里
  - 堆内存：new出来的对象会在这块内存开辟空间并产生地址



### 11. 方法

- 它是一种语法结构，把一段代码封装成一个功能，以方便重复调用
- 方法的定义格式

```java
修饰符 返回值类型 方法名(形参列表){
    方法体
    return 返回值
}
```

- 调用格式：方法名(...)



## 二、Java面向对象

### 1. 类的设计和使用

- 类：是共同特征的描述；
- 对象：真实存在的具体实例；

```java
public class 类名{
    1. 成员变量
    2. 成员方法
}

类名 name = new 类名();
```

- 注意事项：
  - 类名首字母大写，驼峰模式，不能使用关键字；
  - 一个Java文件可以定义多个类，但只能一个类是public修饰，且public修饰的类名要成为文件名；
  - 成员变量的完整定义格式 public 数据类型 名字 =  初始化值；一般无需指定初始值。

### 2. 对象在内存中的运行机制

- 多个对象的内存图：
- 两个变量指向同一个对象的内存图：
- 垃圾回收：堆内存的对象没有任何对象引用，就会判定为垃圾对象。

### 3. 构造器、this

- 构造器作用：定义在类中，可以用于初始化一个对象，并返回对象的地址；

```java
修饰符 类名(参数列表){
}
```

- 有参数构造：初始化对象得到时候，成员变量都采用默认值；
- 无参数构造：初始化对象的时候，同时接受参数为对象进行赋值；
- 注意事项：任何类定义了出来，默认带了无参数构造，写不写都有；一旦定义了有参构造，无参就没有了，想要使用就要自己写。
- this关键字：可以出现在构造器和方法中，代表当前对象的地址；可以用于访问当前对象的成员变量和成员方法

### 4. 封装

- 封装：告诉我们，如何正确而设计对象属性和方法；
- 原则：对象代表什么，就得封装对应的数据，并提供行为；
- 如何更好的封装：
  - 一般对成员变量使用private关键字，仅能在当前类访问；
  - 提供接口小心暴露

### 5. 标准JavaBean

- 也叫做实体类，其对象可以用于在程序中封装数据；
- 标注JavaBean书写要求：
  - 成员变量private修饰
  - 要对成员变量提供get和set方法
  - 要求提供无参构造函数，有参可选

### 6. 成员变量和局部变量的区别

| 区别         | 成员变量                           | 局部变量                               |
| ------------ | ---------------------------------- | -------------------------------------- |
| 类中位置不同 | 类中，方法外                       | 方法内部                               |
| 初始化不同   | 有默认值，无需初始化               | 无默认值，使用前需要赋值               |
| 内存位置不同 | 堆内存                             | 栈内存                                 |
| 生命周期不同 | 随对象的创建存在，随对象消失而消失 | 随方法调用而存在，随方法运行结束而消失 |
| 作用域       |                                    | 归属大括号                             |

### 7. String简单介绍

- java.lang.String类代表字符串，用于存储字符串，提供许多字符串操作功能；

- String类是不可变字符串的原因：
  - String变量每次修改其实是产生并指向新的字符串对象；String对象存的是堆地址，但是输出做了优化
  - "ljx"存于堆内存的常量池里面
  - 原来的字符串对象没有改变，所以称为不可变字符串；
- 创建的两种方式：
  - String name = 'ljx';使用""，在字符串常量池存储，相同内容只有一份；
  - 构造器，通过构造器new对象，每次在堆内存产生一个新对象，地址不同；
- 常用API：
  - 字符串内容比较，不使用==（判断地址），使用equals，比较内容；==一般用于基础数据类型的比较

```java
// 长度
String name = "i love you, china";
System.out.println(name.length());
// 返回索引
System.out.println(name.charAt(0));
// 遍历
for (int i = 0; i < name.length(); i++) {
    System.out.println(name.charAt(i));
}
// 转为字符数组
char[] chs = name.toCharArray();
for (int i = 0; i < chs.length; i++) {
    System.out.println(chs[i]);
}
//截取
String name2 = "Java is the best language";
System.out.println(name2.substring(0, 4)); // 包前面不包后,索引

System.out.println(name2.substring(0));     //  截取全部

// 替换
String name3 = "金三胖是最强的80后，金三胖是胖子";
System.out.println(name3.replace("金三胖", "***"));

// 包含
System.out.println(name3.contains("金三胖"));

// 判断以什么开始
System.out.println(name3.startsWith("金三胖xx"));

// 分割  按照某个内容把字符串分割为字符数组
String name4 = "王宝强，陈羽凡，贾乃亮";
String[] names = name4.split(",");
```



### 8. ArrayList简单介绍

- 与数组类似，也是容器，用于装数据；数组定义之后，类型确定，长度固定
- 集合大小不确定，可以动态变化。类型选择也可以不确定，还有其他好用功能，适合做增删的业务；
- ArrayList是一种集合，支持索引；
- ArrayList泛型：ArrayList<E>,编译阶段约束集合只能操作某种数据类型。不支持基本数据类型，仅仅支持引用
  - `ArrayList<String>,ArrayList<Integer>,`
- 常用API：

```java
list.get(int index);//取索引对应的元素；
list.size(); //集合大小
list.remove(int index);// 删除某个索引位置的元素，并返回删掉的值
list.remove(object o); // 直接删除元素值，只删除第一个,成功返回true，失败false
list.set(int index，E element);//修改索引处的值为element，返回修改前的值

```

### 9. static

- static是静态的意思，可以修饰成员变量和方法
- static修饰的成员变量表示该成员变量在内存中只存储一份，可以被共享和访问，属于类，用类名访问
- static修饰变量内存机制：堆内存开辟类的静态变量区
- static修饰方法的基本作用：
  - 静态成员方法：由static修饰，类名访问；
  - 实例成员方法：属于对象，对象触发；
  - 公用方法可以定义为静态方法；
- static修饰方法的内存机制：静态方法放到方法区里面。
- 规则：
  - 静态方法只能直接访问静态成员，不能直接访问实例成员，静态方法可以直接访问其他的静态方法，不可以直接方法非静态方法；
  - 实例方法可以访问静态成员，也可以访问实例成员；
  - 静态方法不可以出现this关键字，因为this代表当前对象的地址

- 工具类：类中都是一些静态的方法，每个方法都是以完成一个共用的功能为目的。建议把工具类的构造函数定义为私有
- 代码块：用{}括起来的是代码块，在类中方法外定义。
  - 静态代码块：static{}，随着类加载而加载一次，自动触发执行，用于初始化静态资源；
  - 构造代码块：{}，属于对象，每次调用构造函数之前会先调用{}，用于初始化实例资源。
- 单例模式：保证应用该模式的类永远只有一个实例，即一个类只能创建一个对象。
  - 饿汉单例：在用类获取对象的时候，对象已经创建好了
  - 懒汉单列：真正需要的时候才创建对象

  ```java
//饿汉单例
//1. 初始化构造函数；
//2. 定义一个静态成员变量储存一个类；在用类获取对象的时候，对象已经创建好了/
public class SingleInstance {

    public static SingleInstance instance = new SingleInstance();

    private SingleInstance() {

    }
}

public class Test1 {
    public static void main(String[] args) {
        SingleInstance s1 = SingleInstance.instance;
        SingleInstance s2 = SingleInstance.instance;
        System.out.println(s1);
        System.out.println(s2);
    }
}

// 懒汉单例
// 1. 构造函数私有
// 2. 创建对象 定义为私有
// 3. 第一次调用的时候初始化instance
    
public class LazyInstance {

    private static LazyInstance instance; //创建对象 私有

    private LazyInstance() {  

    }

    public static LazyInstance getInstance() {
        if (instance == null) {
            instance = new LazyInstance();
        }
        return instance;
    }
}

public class Test2 {
    public static void main(String[] args) {
        LazyInstance s1 = LazyInstance.getInstance();
        LazyInstance s2 = LazyInstance.getInstance();
        System.out.println(s1);
        System.out.println(s2);
    }
}
  ```



### 10. 继承

- Java提供了一个extends关键字，可以让一个类与另一个类建立父子关系；
- 当子类继承了父类，子类可以得到父类的属性和行为；
- 设计规范：子类们相同的特征放到父类，独有行为放到自己的类定义里面。
- 继承的特点：
  - 子类可以继承父类的属性和行为，但不继承父类的构造器；
  - Java是单继承，一个类只能有一个直接父类；
  - Java不支持多继承，但支持多层继承；
  - Java所有类都是object类的子类；
  - 子类能否继承私有成员？可以，但是不能访问；
  - 子类是否继承静态成员？共享；
- 子类方法中访问成员变量或者方法：满足就近原则；如果想访问父类的同名成员，用super.属性即可；
- 方法重写，建议加上@override，更加安全
  - 重写方法名称，形参列表和被重写方法名称和形参列表必须一致！
  - 私有方法不能重写
  - 子类重写父类的方法时，访问权限必须要大于等于父类
  - 子类不能重写父类的静态方法
- 继承后子类构造器的特点：
  - 子类所有的构造器默认会访问都会先访问父类的无参构造器，再执行自己；
  - 子类初始化之前，先调用父类的构造器完成父类空间的初始化；
  - 子类构造器的第一行默认有个super()；默认找父类的无参构造；
  - super调用父类有参构造器，初始化继承父类的数据；
  - 父类没有无参构造器，只有有参构造器，会报错，因为子类默认调用无参构造器，需要收到调用有参；
  - this(...)可以调用本类的其他 构造器，本类其他构造器会通过super调用父类构造器，super(...)和this(...)都要放在第一行，因此二者不能共存在一个构造器。

### 11. 包

- 分门别类管理各种不同的类，类似于文件夹，利于管理程序；
- 导包：相同包的类可以直接访问，不同的包的类需要导入 import 包名.类名，如果导入了不同包的相同类名，此时默认只能导入一个类的包，另一个需要全名导入。

### 12. 权限修饰符

- 控制一个修饰的成员被访问的范围；可以修饰成员变量，方法，构造器，内部类

- 有四种修饰符：private->缺省->protected->public;

  | 修饰符    | 同一个类 | 同一个包的其他类 | 不同包的子类                                                 | 不同包下的无关类 |
  | --------- | -------- | ---------------- | ------------------------------------------------------------ | ---------------- |
  | private   | 可以     | 不行             | 不行                                                         | 不行             |
  | 缺省      | 可以     | 可以             | 不行                                                         | 不行             |
  | protected | 可以     | 可以             | 可以（可以在子类内部和被子类的对象访问，这里和c++不一样，c++仅在类内可以访问） | 不行             |
  | public    | 可以     | 可以             | 可以                                                         | 可以             |

  

### 13. final

- final关键字是最终的意思，可以修饰方式，方法，类
  - 修饰类：该类是最终类，不能被继承
  - 修饰方法：该方法是最终方法，不能被重写
  - 修饰变量：仅仅能被赋值一次。
    - final修饰基本数据类型，值不能变
    - final修饰引用，变量存储的地址值不变，地址指向的内容可以改变；引用变量存的就是地址

### 14. 常量

- 使用public final static修饰的成员变量，必须有初始化值，执行过程不能改变；
- 命名规范：英文字母全大写+下划线
- 原理：编译阶段会进行宏替换，把使用常量的地方替换成真实的字面量。
- 常量做信息标志和分类，软编码

### 15. 枚举

- 枚举是Java中的特殊类型，用于做信息的标志和信息的分类

  ```java
  修饰符 enum 枚举名称{
  	罗列的枚举类实例的名称
  }
  
  // 反编译 Compiled from "Enum.java"
  public final class Enum extends java.lang.Enum<Enum> {  //  枚举类都继承java.lang.Enum<Enum> 
    public static final Enum SPRING;
    public static final Enum SUMMER;
    public static final Enum AUTUMN;
    public static final Enum WINTER;
    public static Enum[] values();
    public static Enum valueOf(java.lang.String);
    static {};
  }
  ```

- 枚举类都继承java.lang.Enum<Enum> ；
- 枚举类都是最终类，不可以继承；
- 构造器是私有，不能对外创建对象，仅有上述定义的四个对象；
- 第一行默认罗列对象名称；
- 相当于多例模式。

### 16. 抽象类

- abstract修饰的方法和类叫做抽象方法和抽象类，比如public abstract class {}
- 抽象方法只有签名，没有方法体
- 一个类有抽象方法，也要定义为抽象类
- 和c++一样，抽象类不能实例化对象
- 抽象类的特点：
  - 类的成员变量，方法和构造器都有
  - 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
  - 一个类继承了抽象类，必须重写父类的所有抽象方法，否则还得定义为抽象类
  - 不能用abstract修饰其他东西
- 模板方法模式：模仿方法加上final

### 17. 接口

```java
// 接口用关键字interface定义
public interface 接口名(){
    
}
JDK8之前只允许常量和抽象方法
实现关键字，implements
    
public class 实现类 implements 接口1，接口2...{}

```

- 接口是一种规范，一定是公开的，所以接口里面的抽象方法的public static final可以不写
- 接口是被用来**实现**的，实现的接口成为**实现类**。实现的类可以理解为所谓的子类；
- 接口可以被类多实现，也可以被类单实现
- 接口与接口的关系：
  - 类鱼类：单继承
  - 类与接口的关系：多实现
  - 接口与接口的关系：多继承，一个接口可以继承多个接口，规范合并，整合多个接口为一个，利于实现
- `JDK8`新增接口方法：
  - 默认方法，default修饰，默认用public修饰，需要接口实现类来调用
  - 静态方法，默认用public修饰，static修饰，需要接口名调用；
  - 私有方法，必须使用private修斯，JDK9开始才有，只能在接口内部被默认方法和私有方法调用；
- 注意事项：
  - 接口不能创建对象；
  - 一个类可以实现多个接口，多个接口中相同的静态方法不冲突；原因是静态方法只能接口自己调用
  - 一个类继承了父类，同时又实现了接口，父类和接口的同名方法，默认调用父类的；**继承在前实现在后**
  - 一个类实现了多个接口，多个接口存在同名默认方法，不冲突，这个类重写即可
  - 一个接口可以继承多个接口，前提是规范；

### 18. 多态

- 定义：同类型的对象，执行一个行为，会表现不同的行为特征；

  ```JAVA
  父类 对象 = new 子类构造器
  接口 对象 = new 实现类构造器
  ```

- 方法调用：编译看左边，运行看右边；
- 变量调用：编译看左左，运行也看左；
- 前提：有继承/实现关系；父类引用指向子类对象；有方法重写；
- 优势：右边对象可以实现解耦，便于拓展维护；定义方法的时候，该方法可以接受父类的一切子类对象；
- 问题：多态不能使用子类独有的功能；
- 多态下引用数据类型的数据转换：
  - 自动类型转换：子类对象赋值给父类类型的变量指向
  - 强制类型转换：父类导子类
    发
