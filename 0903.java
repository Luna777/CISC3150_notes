9/3
ex:
if(true)
		if(false)  <--
			sth…
		else
			sth…

-- this else goes to the nearest “if” (which the second one above).
-----------
ex:
		int x =1;
		int y=0;
		system.out.println( x & y);

-- output is 0.  
& is comparing x and y bit by bit. 
x is 00...001 , y is 00...000, 计算一个 and ~ 0 & 1 = 0 
-------------------
ex:
		int x =7;
		int y=4;
		system.out.println( x & y);

-- output is 4.  
	00...111 & 00...010 = 00...010 b =4
---------------------
ex: 
		int x =7;
		int y=4;
		system.out.println( x==7 && y==4); //or system.out.println( x==7 &y==4);

-- outputs are both: true.  
-------------------
ex:
		int x =4;
		x<< 1;
		System.out.println(x);

-- output is 8. 
 “<< 1”  it shift things. shift binary left one position. 把二进制的数字向左移一位
4= 00...00100  --shift left→  00..01000 =
	“<< 2” 向左移两位
-------------
ex:

		int x=0;
		x= ~x;
		System.out.println(x);

--output is -1.
	“~” means not. x= 000...00 --not-->111...11= -1 (signed number)
--------------
ex:
		int x = Integer.MAX_VALUE - 500;
		while(x>0){
			System.out.println(x);
			x=x+1;
		}
--output will print 500 number until the largest integer number and stop. 
	which is like : 
	21………….
	…..(500 numbers)...
	21……….46
	2147483647

---------------
ex:
		int x = 2147483647; // largest positive integer!
		System.out.println(x);
		
		System.out.println(x+1); //largest negative integer!
		System.out.println(x+2);

--output: 
2147483647
-2147483648
-2147483647
------------------------
ex:
		int x=-4;
		System.out.println(x >>1); //shift and put 1 to the beginning, signed shift
		System.out.println(x >>> 1); // shift and put 0 to the beginning, unsigned shift

--output: 
-2
2147483646
-----------------
ex:
		int x=2147483647; // largest positive integer! (111111….111111111111111)
		System.out.println(x << 1); 	
		System.out.println(x >>1); //shift and put 1 to the beginning, signed shift
		System.out.println(x >>> 1); // shift and put 0 to the beginning, unsigned shift

--output:
-2
1073741823
1073741823
----------------------
public static int reverse(int i)
(JAVA API)

-----------------------
ex:
int x, y, z;
		z=y=x=5;
		x=7;
		System.out.println(x); 	
		System.out.println(y); 
		System.out.println(z); 
output:
7
5
5
-------------------------
java String cannot be change (enumerable?不确定是不是这个词)

		String x= “hello”; // it means x is a reference that points to the address of a string has “hello”
		x=”world”; // this means x is reference to another address of string which has “world”. 
				// “hello” is now garbage.
-----------------------
ex:
		Object my_object = new Object();

		System.out.println(my_object);

--output: java.lang.Object@42a57993
	my_object is taking the address of “java.lang.Object@42a57993”
-------------------------
toString 
public String toString()
(JAVA API)
-------------------------
ex:
		String x= "topshop";
		String y= "top";	
		y= y+ "shop";

		if(x==y)
			System.out.println("same");
		else
			System.out.println("different");
--output: different
	这是因为这里的x==y并不是比较两个string, 而是比较x,y的address
---------------------------
ex:
String x= "hello";
		String y= "hello";
		
		if(x==y)
			System.out.println("same");
		else
			System.out.println("different");

--output: same
	如果两个string有同一个hello~ 那么为了节省~ java就会只create一个hello~ 
两个variable都point to 同一个hello， unless we force to create a new string.
看下面的例子：
--------------------------
ex:
		String x= new String("hello");
		String y= new String("hello");
		
		if(x==y)
			System.out.println("same");
		else
			System.out.println("different");
--output: different
-------------------------------
x.compareTo(y)
returns -1, 0, 1. 这个程式事实上是做 x-y. 来比较
----------------------------------
ex:
		String x= 45 + “”;
		System.out.println(x);
--output: 45
-------------------------------------
ex:
		String x= 45 + “”;
		System.out.println(x+2);
--output: 452
----------------------------------
procsmations or acrotemation or acrosmation 意思是不精确的~ 所有double的数字都是不精确的

		for(double i=0.0;i<=10.0; i=i+0.01){
			System.out.println(i);
		}// this loop will not stop

		//for(double i=0.0;(i-10.0)<=0.00001; i=i+0.01){
		for(double i=0.0;i<=10.00001; i=i+0.01){
			
			System.out.println(i);
		}// this loop will. because all double numbers are not accrosmations(?) . 

--------------------
while(true){
	while(true){
		break;
	}
}
//这个loop的话 外层的会一直run， 里层的会break. break也是只作用于最近的loop.
----------------------
label 在loop里 （像是jump）
while(true){
	while(true){
		break outside;
	}
}
outside:
	System.out.println(“Outside”); //outside在这里就是一个label

-------------------
in java, a message cannot bigger than 64kb.
ex:
int x =1;
x++;
x++;
x++;
...keep repeating 1000000000 times….
x++;
x++;

output: error, says “code too large”.
	but why it’s not going to negative value and back to positive value and so on?
-----------------------
		public static void main(String[] args){		
			String x= "1";
			String y= "2";
			swap(x, y);
			System.out.println(x + " " + y);
		
		}
	
		public static void swap(String a, String b){
			String temp =a;
			a=b;
			b=temp;
		}
	
output: 1 2
	because swap only happened inside swap method, after that, value a,b gone. 
	x,y are still its original value.
-------------------------
method need a return
but 
if(true){
	return 0;
}

this will not accept.
----------------------------
switch function is not working for double type.
ex: 
		double x=10.0
		switch(x){
			case 10.0: System.out.println(“10”);
		}
output: error. this will not work
	因为double是不精确的, 但char和int都可以. (char可以变相的看做int)
----------------------------
char x = ‘\u0041’; // same as x=’A’; same as x = 0×41;

-----------------------------















