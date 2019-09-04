package com.ssi.JDBC;

// MULTITHREADING EMLOYEE TASK USING RUNNABLR INTERFACE
public class MultiThread1 implements Runnable {
	int eno;
	int salary;
	String ename;

	public MultiThread1(int eno, int salary, String ename) {
		this.eno = eno;
		this.salary = salary;
		this.ename = ename;
	}

	public void calculateSalary(int salary) {

		int hra = (int) (0.1 * salary);

		int da = (int) (0.2 * salary);
		int ca = (int) (0.1 * salary);
		System.out.println(
				Thread.currentThread().getName() + " " + "having enumber" + "  " + eno + "  " + "and having name :"
						+ ename + " " + " " + "has hra :" + hra + " da :" + da + " " + "ca:" + " " + ca + "....");
	}

	@Override
	public void run() {
		calculateSalary(salary);

	}

	public static void main(String args[]) {
		Thread t1 = new Thread(new MultiThread1(101, 20000, "ANJALI"));
		t1.setName("EmployeeThread1");
		Thread t2 = new Thread(new MultiThread1(102, 50000, "ASHI"));
		t2.setName("EmployeeThread2");
		Thread t3 = new Thread(new MultiThread1(103, 80000, "SADIYA"));
		t3.setName("EmployeeThread3");
		Thread t4 = new Thread(new MultiThread1(104, 90000, "Aditi"));
		t4.setName("EmployeeThread4");
		Thread t5 = new Thread(new MultiThread1(105, 30000, "POOJA"));
		t5.setName("EmployeeThread5");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
