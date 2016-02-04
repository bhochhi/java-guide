# Enterprise JavaBeans

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

