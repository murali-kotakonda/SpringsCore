package jdbc;

import jdbc.EmployeeDao.Service;

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
