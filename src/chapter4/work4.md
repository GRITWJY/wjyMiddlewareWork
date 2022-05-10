# 作业四

```
一份典型的学生管理模块IDL文件如下：
module StudentMgr{
    struct Student{
        string stuid;
        string sname;};
    imterface IStudentAttr{
        attribute string stuid;
        attribute string name};
    typedef sequence <Student> StudentSeq;
    interface IStudentManager{
        boolean addStudent(in Student vstud);
        boolean updateStudent(in Student vstud);
        boolean deleteStudent(in string vsid);
        StudentSeq getStudents();}; 
};

```

## 1.看懂StudentMgr.idl，使用idlj编译StudentMgr.idl，

属于客户端的类有：
```
_IStudentManagerStub
AgeIntHelper
IStudentManager
IStudentManagerHelper
IStudentManagerHolder
IStudentManagerOperations
Student
StudentHelper
StudentHolder
StudentSeqHelper
StudentSeqHolder
```
服务端的类有：
```
StudentSeqHolder
StudentSeqHelper
StudentHolder
StudentHelper
Student
IStudentManagerPOA
IStudentManagerOperations
IStudentManager
AgeIntHelper
```


## 2.请把下划线语句映射成大致的Java代码；
```
string _get_name();
void _set_name(in string name);
```



## 作业二：

定义一个接口StudentManager，该接口有一个string类型的name和返回类型为string的方法QueryStudentStatus，此方法有一个类型为long的参数studentID，该参数由客户端给入。
请按上面的描述在module StudentSys中定义接口StudentManager。
```
module StudentSys{
    interface StudentManager {
        attribute string name;
        string QueryStudentStatus(in long stuId)
    }
};

```

### 按要求完成接口StudentManager;
###解释方向参数in，out和inout含义。
- in ：由客户机在运行时声明参数的类型并赋值，服务器只能使用不能修改其值。

- out：由客户机在运行时声明参数的类型，服务器运行中为其赋值。

- inout：由客户机在运行时声明参数的类型并赋值，服务器可以使用或修改其值。


## 作业三：

阅读Apache Thrift白皮书，请说明IDL在分布式开发中的作用？

OMG IDL接口定义语言不是作为程序设计语言体现在CORBA体系结构中的，
而是用来描述产生对象调用请求的客户对象和服务对象之间的接口的语言。 


OMG IDL文件描述了服务器提供的服务功能，客户机可以根据该接口文件
描述的方法向服务器提出业务请求。 

