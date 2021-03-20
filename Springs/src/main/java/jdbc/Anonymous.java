package jdbc;

/**
 Service.java:
------------------------------------
interface Service {
		void process();
}

req: 
call the process() method it should print hello
call the process() method it should print bye

steps for [call the process() method it should print hello]:
------------------
1.create child1 class that implments Service
2.override process() method and write logic for printing "Hello"
3.create the object for child1 class
4.call the process() method using child1 obj



steps for [call the process() method it should print bye]:
------------------
1.create child2 class that implments Service
2.override process() method and write logic for printing "Hello"
3.create the object for child2 class
4.call the process() method using child2 obj

Anaonymous inner class:
-----------------------------
-> is possible only for abstract class and interface
-> class without name

adv:
- no need to create seperate child class
- create child class + override the method + create child obj 
can be done at once place using Anaonymous inner class


solution using anonymous:
-----------------------------------------------------

 */
public class Anonymous {
	interface Service {
		void process();
	}

	public static void main(String[] args) {
		Service s = new Service() {
			public void process() {
				System.out.println("hello");
			}
		};

		s.process();

		s = new Service() {

			public void process() {
				System.out.println("bye");

			}
		};

		s.process();
	}


}
