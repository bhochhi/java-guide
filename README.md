# Enterprise JavaBeans
EJB stands of Enterprise Java Beans, used to produce highly scalable and robust enterprise level applications. EJB is an essential part of J2EE platform. It provides an architechture to develop and deploy component based application. There are three types of EJB:

|||
|------------------:|:-----------------
 **Session Bean** | Stores the data for the single session. It could be stateful or stateless. It get destroyed as soon as session terminates 
 **Entity Bean**  | used for the persistent data that can be save and retreived from database.   
 **Message Driven Bean**| used in context of JMS, consumes JMS messsages from external entities and act accordingly. 

Let's checkout the simple example.

http://www.tutorialspoint.com/ejb/ 


# Passing by value or Passing by reference

I often see people getting confused in a java program whether something is being passed by value or reference. Here is the best way to think, the simple way: In java __everything is passing by value__. Period. Just keep in mind following:
 
* If variable types are for primitives, the memory location that variable pointing contains actual value.
* If variable types are non primitives, the memory location that variable pointing contains reference to the value. 

For Instance, if you have following variables defined, see how the memory map looks like:

int a = 123;

String str = “Hello”;

BufferedString obj = new BufferedString();


![memory map](https://github.com/bhochhi/java-guide/blob/master/pass-by-value.png)


Now you can see, when we think everything is passing-by-value, we are simply passing the contains of the memory location that variable is pointing. 

