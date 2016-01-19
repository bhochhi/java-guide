# Passing by value or Passing by reference

I often see people getting confused in the java program about whether something is being passed by value or reference. Here is the best way to think, the simple way:
In java everything is passing by value. Period. Just keep in mind following:
 
* If variable types are for primitives, the memory location that variable pointing contains actual value.
* If variable types are non primitives, the memory location that variable pointing contains reference to the value.

For Instance, if you have following variables defined, see how the memory map looks like:

int a = 123;
String str = “Hello”;
BufferedString obj = new BufferedString();



So, if you think its always passing-by-value, no confusion should exists. 

