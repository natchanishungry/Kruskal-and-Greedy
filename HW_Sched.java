package A2;
import java.util.*;

class Assignment implements Comparator<Assignment>{
	int number;
	int weight;
	int deadline;
	
	
	protected Assignment() {
	}
	
	protected Assignment(int number, int weight, int deadline) {
		this.number = number;
		this.weight = weight;
		this.deadline = deadline;
	}
	
	
	public void tostring(ArrayList <Assignment> asses)
	{
		for(Assignment ass : asses) {
		System.out.println("number : " + ass.number + "/nweight : " + ass.weight + "/ndeadline : " + ass.deadline);
		}
	}
	/**
	 * This method is used to sort to compare assignment objects for sorting. 
	 * The way you implement this method will define which order the assignments appear in when you sort.
	 * Return 1 if a1 should appear after a2
	 * Return -1 if a2 should appear before a1
	 * Return 0 if a1 and a2 are equivalent 
	 */
	//@Override
	public int compare(Assignment a1, Assignment a2) {
		//YOUR CODE GOES HERE, DONT FORGET TO EDIT THE RETURN STATEMENT
		if(a1.deadline < a2.deadline)
		{
			if(a1.weight > a2.weight) return 1;
			if(a1.weight == a2.weight) return 1;
			else {
				return 1; //IFFY
			}
		}
		else if(a1.deadline==a2.deadline)
		{
			if(a1.weight > a2.weight) return 1;
			if(a1.weight == a2.weight) return 0;
			else {
				return -1;
			}
		}
		else {
			if(a1.weight < a2.weight) return -1;
			if(a1.weight == a2.weight) return -1;
			else
			{
				return -1; //IFFY
			}
		}
		
	}
}

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	public static int sum(int [] a)
	{
		int b = 0;
		for(int i=0; i<a.length; i++)
		{
			b+=a[i];
		}
		return b;
	}
	
	public static int [] max(int a, int [] aa, int b, int [] bb)
	{
		if(a>=b) return aa; else return bb;
	}
	
	/**
	 * 
	 * @return Array where output[i] corresponds to when assignment #i will be completed. output[i] is 0 if assignment #i is never completed.
	 * The homework you complete first will be given an output of 1, the second, 2, etc.
	 */
	
	
	public int[] SelectAssignments() {
		//Use the following command to sort your Assignments: 
		//Collections.sort(Assignments, new Assignment());
		//This will re-order your assignments. The resulting order will depend on how the compare function is implemented
		Collections.sort(Assignments, new Assignment());
		
		
		//Initializes the homeworkPlan, which you must fill out and output
		int[] homeworkPlan = new int[Assignments.size()];
	
		Assignments.get(0).tostring(Assignments);
	
		int time = Assignments.get(0).deadline;
		int [] w = new int[Assignments.size()]; 
		for(int i = 0; i< w.length; i++)
		{
			w[i] = -1;
		}
		int index = 0; //store current index we are at 
		
		for(int i= 0; i< homeworkPlan.length; i++)
		{
	
			if(time < 1) break;
			//int tempindex = 0;
			boolean b = false; //are there elements inside w array?
			for(int j = index; time>=1; j++)
			{
				if (j<homeworkPlan.length && Assignments.get(j).deadline == time)
				{
					w[index] = j;
					index++;
				}
				
				else {
					int temp = 0;
					int curI = 0;
					int tempk = -1;
					
					for(int k = 0; k < w.length; k++)
					{
						if(w[k] >=0)
						{
							int cur = Assignments.get(w[k]).weight;
							if(cur > temp)
							{
								temp = cur;
								curI = w[k];
								tempk = k;
							}
						}
					}
					homeworkPlan[Assignments.get(curI).number] = time;
					if(tempk >=0) w[tempk] = -1;
					time--;
					//Assignments.get(curI).deadline = -1;
					break;
					
				}
			}
		}
		
		
		return homeworkPlan;
		
		
		
		
		/*
		for(int i= (homeworkPlan.length-1); i>=0; i--)
		{
			int d = Assignments.get(i).deadline;
			if (d >= time)
				{	
				  if((i-1)>=0 && Assignments.get(i-1).deadline < d)
				  {
					  homeworkPlan[Assignments.get(i-1).number] = time;
					  homeworkPlan[Assignments.get(i).number] = time + 1;
					  time=time+2;
					  i++;
				  }
				  else 
				  {	
					   homeworkPlan[Assignments.get(i).number] = time;
					   time++;
				   }
				}
			else {
				
				if((i-1) >= 0 && Assignments.get(i-1).deadline < d)
				  {
					  homeworkPlan[Assignments.get(i-1).number] = time;
					  time++;
					  i++;
				  }
				homeworkPlan[Assignments.get(i).number] = 0;
			
			}
			
		}
		System.out.println("last");
		*/
		

		
		
	}
}
	/*
	 * 
	 *  Once God and Isaiah were friends.

God and Isaiah used to converse nightly, Isaiah would rush into the garden.

They conversed under the Branch, night streamed down.

From the sole of the foot to the head God would make Isaiah ring.   

Isaiah had loved God and now his love was turned to pain.   

Isaiah wanted a name for the pain, he called it sin.

Now Isaiah was a man who believed he was a nation.

Isaiah called the nation Judah and the sin Judah’s condition.   

Inside Isaiah God saw the worldsheet burning.

Isaiah and God saw things differently, I can only tell you their actions.

Isaiah addressed the nation.   

Man’s brittleness! cried Isaiah.

The nation stirred in its husk and slept again.

Two slabs of bloody meat lay folded on its eyes like wings.   

Like a hard glossy painting the nation slept.

Who can invent a new fear?

Yet I have invented sin, thought Isaiah, running his hand over the knobs.

And then, because of a great attraction between them—

which Isaiah fought (for and against) for the rest of his life—

God shattered Isaiah’s indifference.

God washed Isaiah’s hair in fire.

God took the stay.
	 * 
	 * 
	 */



