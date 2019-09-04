package com.ssi.JDBC;

// MULTITHREADING TASK USING THREAD CLASS
public class MultiThread2 extends Thread {

	int eno;
	int salary;
	String ename;

	public MultiThread2(int eno, int salary, String ename) {
		this.eno = eno;
		this.salary = salary;
		this.ename = ename;
	}

	public void calculateSalary(int salary) {

		int hra = (int) (0.1 * salary);

		int da = (int) (0.2 * salary);
		int ca = (int) (0.1 * salary);
		System.out.println(currentThread().getName() + " " + "having enumber" + "  " + eno + "  " + "and having name :"
				+ ename + " " + " " + "has hra :" + hra + " da :" + da + " " + "ca:" + " " + ca + "....");
	}

	@Override
	public void run() {
		calculateSalary(salary);

	}

	public static void main(String args[]) {

		MultiThread2 thread1 = new MultiThread2(1001, 20000, "Anjali");
		thread1.setName("EmployeeThread1");
		MultiThread2 thread2 = new MultiThread2(1002, 40000, "Ashi");
		thread2.setName("EmployeeThread2");
		MultiThread2 thread3 = new MultiThread2(1003, 90000, "Aditi");
		thread3.setName("EmployeeThread3");
		MultiThread2 thread4 = new MultiThread2(1004, 70000, "Pooja");
		thread4.setName("EmployeeThread4");
		MultiThread2 thread5 = new MultiThread2(1005, 60000, "Sadiya");
		thread5.setName("Employee5Thread");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

	}

}
