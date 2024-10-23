import java.util.Stack;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class stackWork
{
Scanner scan = new Scanner(System.in);
public stackWork()
{
//taskOne();
//taskTwo();
taskThree();
}

//Task one
public void taskOne()
{
Stack<Integer> stack = new Stack<Integer>();

System.out.print("Binary Number: ");
int dec = scan.nextInt();

do
{
int remain = dec%2;
dec /= 2;

stack.push(remain);
}while(dec != 0);

  System.out.print(printStackOne(stack));
}
public int printStackOne(Stack<Integer> a)
{
int ans = 0;

ans = a.peek();
a.pop();

if(!a.empty())
{

int g = printStackOne(a);
System.out.print(g);
}
return ans;
}

//Task Two
public void taskTwo()
{
Stack<String> stack = new Stack<String>();

String[] input = scan.nextLine().split("");

for(int i = 0; i < input.length; i++)
{
stack.push(input[i]);
}

  while (!stack.empty())
{
System.out.print ( stack.pop() );
if(!stack.empty())
System.out.print("");
else System.out.println();
}
}

//Task Three
public class Game
{
String name;
String genre;
String country;
String year;

public Game(String name, String genre, String country, String year)
{
this.name = name;
this.genre = genre;
this.country = country;
this.year = year;
}
}
public void taskThree()
{
File file=new File("ESport_Earnings.csv");
Stack<Game> strat = new Stack<Game>();
Stack<Game> fight = new Stack<Game>();
Stack<Game> first = new Stack<Game>();
Stack<Game> racing = new Stack<Game>();

try{
BufferedReader input=new BufferedReader(new FileReader(file));
String text;
while((text=input.readLine())!=null)
{
String[] pieces=text.split(",");
Game g;
if(pieces.length > 9)
{
g = new Game(pieces[2], pieces[3]+pieces[4], pieces[7], pieces[9]);
}
else
{
g = new Game(pieces[2], pieces[3], "\t\t" + pieces[6], "\t\t" + pieces[8]);
}
switch(pieces[3])
{
case "Strategy":
strat.push(g);
case "Fighting Game":
fight.push(g);
case "First-Person Shooter":
first.push(g);
case "Racing":
racing.push(g);
}
}
String[] gameName = {"Strategy Game", "Fighting Game", "First-Person Shooter", "Racing"};

for(int i = 0; i < 4; i++)
{
System.out.println("\n" + gameName[i]);
System.out.println("Game Name\t\tTop Country\t\tRelease Year");
switch(i)
{
case 1:
System.out.println(strat.pop());
case 2:
System.out.println(fight.pop());
case 3:
System.out.println(first.pop());
case 4:
System.out.println(racing.pop());
}
}
}catch(IOException e)
{

}
}

public static void main(String args[])
{
stackWork app=new stackWork();
}
}
