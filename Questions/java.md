# 一、Java 基础知识
## 1. 基本概念
### 1.1 Java 语言的优点
* 纯面向对象
* 平台无关（解释型语言，编译器将 Java 代码变成字节码“中间代码”在 JVM 上执行）
* 提供了很多内置的类库（synchronized 管程、GC）
* 提供了对 Web 应用开发的支持
* 较好的安全性和健壮性（数组边界检测、Bytecode校验；强类型机制、GC、异常处理、安全检查机制）
* 去除了 C++ 中较难的头文件、指针、结构、单元、运算符重载、虚拟基础结构、多重继承等
<br/>
        
### 1.2 Java 与 C++ 有什么异同
* Java 为解释型语言，C++ 为编译型语言（编译和链接后生成可执行的二进制代码），Java的执行速度慢但能跨平台
* Java 为纯面向对象语言，所有代码必须在类中实现，除基本数据类型外，所有类型都是类。Java 中不存在全局变量或全局函数
* Java 没有指针，程序更安全
* Java 不支持多重继承，但是引入了接口的概念，可以实现多个接口
* C++ 需要开发者管理内存的分配，调用析构函数；Java 通过 GC 自动回收，无析构函数，但是引入了 finalize()方法
* Java 中 import 机制代替了 C++ 的预处理功能；Java 不支持运算符重载；Java 不支持 goto 语句，但其仍是保留字；Java 不支持强制类型转换，需要显式地强制类型转换了
* Java 具有平台无关性，对每种数据类型都分配固定长度，如 int 占 32 位
* Java 有很多标准库和对注释文档的内建支持 javadoc
<br/>
                        
### 1.3 为什么需要```public static void main (String[] args)```这个方法
这是 Java 程序的入口方法；
* JVM 运行时首先找到 main() 这一特数方法名；
* public 是权限修饰符，表明任何类或对象都可以访问这个方法；
* static 表明 main() 方法是一个静态方法，即存储在静态存储区，直接可以通过类名.main()直接访问；
* args 为开发者在命令行提供交互手段。
<br/>

引申：
1. 可以用 final、synchronized 来修饰 main()，但不能用 abstract 抽象类关键字来修饰（没有方法体）；
2. 每个类都可以定义 main() 方法，但是只有与文件名相同的用 public 修饰的类中的 main() 方法才能作为程序入口。
<br/>
        
### 1.4 如何在 mian() 方法执行前输出信息
静态块在类被加载时就会被调用
```java
public class Test{
    static{ 
        System.out.println("hello 1"); // 先显示
    }
    public static void main(String[] args){ 
        System.out.println("hello 2"); // 后显示
    }
}
```
<br/>
        
### 1.5 Java 程序初始化顺序
1. 静态块
    * 父类静态块>子类静态块
2. 静态父类
    * 变量>代码块>函数
3. 静态子类
    * 变量>代码块>函数
4. 非静态父类
    * 变量>代码块>函数
5. 非静态子类
    * 变量>代码块>函数
<br/> 
        
### 1.6 Java 中的作用域
变量的类型：
```java
class Person{
    String name;    // 成员变量/实例变量
    static int age; // 静态变量/类变量
    public void study(){
        float time; // 局部变量
    }
}
```    
成员变量的作用域：   
private（当前类）、default（+ 同一 package）、protected（+ 子类）、public（+ 其他 package）     
        
内部类：类中的类，才可以由 private、protected 修饰；只有 public、abstract、final 能修饰外部类。
<br/>
        
### 1.7 一个 Java 文件中是否可以定义多个类
* 一个 Java 文件可以定义多个类，但是最多只能有一个类被 public 修饰，并且这个类的类名要和文件名相同（这表示，每个编译单元都有单一的公共接口）。也可以没有 public 类。     
* 当用 javac 指令编译 .java 文件时，它会给每一个类生成一个对应的 .class 文件。
<br/>
        
### 1.8 什么是构造函数
* 构造函数必须与类的名字相同，并不能有返回值 void 型
* 每个类可以有多个 构造函数，当开发者没有提供时，编译器在编译源码时会自动创建一个无参的构造函数，但不执行任何代码。如果开发者提供了，那么编译器就不会创建
* 主要作用是完成对象的初始化工作
* 构造函数不能被继承，但是可以被重载
* 子类可以通过 super 来显式地调用父类的构造函数，当父类没有提供无参的构造函数，子类必须显式调用父类的构造函数
* 构造函数总是伴随 new 操作一起由系统调用，在对象实例化时只运行一次
<br/>
        
### 1.9 为什么有些接口没有任何方法
* 为了克服单继承的缺点，Java 引入了接口的概念。    
* 接口中成员的作用域修饰符都是 public，常量值默认使用 public static final 修饰。  
* 接口是抽象方法定义的集合，只包含方法的定义，没有方法的实现。没有任何方法声明的接口称为标识接口。使用 instanceof 来判断实例对象的类型是否实现了一个给定的标识接口。
<br/>
        
### 1.10 clone 方法的作用
* Java 没有明确提供指针的概念和用法，而实质上每个 new 语句返回的都是一个指针的引用。  
* Java 在处理基本数据类型时，都是采用按值传递，除此之外的其他类型都是按引用传递（对象使用 = 也是引用传递）。
* Java 中所有的类都继承 Object 类，其中提供了一个 clone() 方法，返回一个**新的对象**而不是一个引用。
~~~
1. 实现 clone 的类需要继承 Cloneable 标识接口；
2. 在类中重写 Object 类中的 clone() 方法；
3. 在 clone 方法中调用 super.clone()；
4. 把浅复制的引用指向原型对象新的克隆体。如：Object b = (Obj)a.clone();
~~~
当**类中包含一些对象时**，就要用到深复制。在对对象调用 clone() 方法完成复制后，接着对对象中的非基本类型的属性也调用 clone() 方法。如：o.getDate = (Date)this.getDate().clone();
<br/>
        
### 1.11 反射机制
功能：     
* 在运行时判断任意一个对象所属的类；
* 在运行时构造任意一个类的对象；
* 在运行时判断任意一个类所具有的成员变量和方法；
* 在运行时调用任意一个对象的成员变量和方法；
* 生成动态代理。
```java
public class Test{
    // 通过反射机制创建对象
    public void Test() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // 创建 com.ustc.test.Person 类
        Class clazz = com.ustc.test.Person.class;             // Class<com.ustc.test.Person> clazz = com.ustc.test.Person.class;
        com.ustc.test.Person p = (com.ustc.test.Person)clazz.newInstance(); // clazz.newInstance();

        // 调用 public 类型的成员变量
        Field f = clazz.getField("name");
        f.set(p, "Matthew");

        // 调用 private 类型的方法
        Method m = clazz.getDeclaredMethod("speak", String.class);
        m.setAccessible(true);  // 能够访问 com.ustc.test.Person 类中定义的成员变量和方法
        m.invoke(p, "China");
    }
}
```
获得 Class 类的方法：  
* Class.forName("类的路径")
* 类名.Class
* 实例.getClass()     

Java 创建对象的方法：       
* 通过 new 语句实例化一个对象
* 通过反射机制创建对象
* 通过 clone() 方式创建一个对象
* 通过反序列化的方法创建对象
<br/>
        
### 1.12 package 有什么作用
把 .java、.class、resource 文件有条理地进行一个组织，以供使用。  
package 语言需要放在代码最前面，由一组类和接口组成。
<br/>
        
### 1.13 如何实现类似于 C 语言中函数指针的功能
Java 利用接口和类实现函数指针的效果，属于策略设计模式的思想。   
```java
interface IntCompare{
    public int cmp(int a, int b);
}

class Cmp1 implements IntCompare{
    @Override
    public int cmp(int a, int b){return a;}
}

class Cmp2 implements IntCompare{
    @Override
    public int cmp(int a, int b){return b;}
}

public class Test{
    public void test(int[] a, IntCompare cmp){  // 类似函数指针
        // do something
    }
}
```
