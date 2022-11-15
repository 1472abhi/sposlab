package sposlab;
import java.util.*;
public class fcfs_sjf {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		System.out.println("********* Menu *********");
		System.out.println("1. fcfs \n2. sjf" );
		System.out.print("enter a button 1 or 2 :- ");
		int a=sc.nextInt();
		switch(a) {
		case 1:
			System.out.println("************ fcfs *************");
			int bst[],process[],wt[],tat[],i,j,n,total=0,pos,temp;
			float wt_avg, tat_avg;
			
			System.out.print("Enter number of process :- ");
			n=sc.nextInt();
			process=new int[n];
			bst=new int[n];
			wt=new int[n];
			tat=new int[n];
			
			System.out.println("Enter cpu number");
			for(i=0;i<n;i++) {
				System.out.print("\n process["+(i+1)+"]: ");
				bst[i]=sc.nextInt();
				process[i]=i+1;
				
			}
			System.out.println("\t\t\t**********FCFS Scheduling*********");
			wt[0]=0;
			for(i=1;i<n;i++)
			{
			wt[i]=0;
			for(j=0;j<i;j++)
			wt[i]+=bst[j];
			total+=wt[i];
			}
			wt_avg=(float)total/n;
			total=0;

			System.out.println("-----------------------------------------------------------------------");
			System.out.println("\nProcess\t\t| Burst Time \t\t|Waiting Time\t\t|Turn Time");
			System.out.println("-----------------------------------------------------------------------");
			for(i=0;i<n;i++)
			{
			tat[i]=bst[i]+wt[i];
			total+=tat[i];
			System.out.println("\np"+process[i]+"\t\t|\t"+bst[i]+"\t\t|\t"+wt[i]+"\t\t|\t"+tat[i]);
			System.out.println("-----------------------------------------------------------------------");
			}
			tat_avg=(float)total/n;
			System.out.println("\n\nAverage Waiting Time: "+wt_avg);
			System.out.println("\nAverage Turnaround Time: "+tat_avg);
			
			
	        
	     break;
			
		case 2:
			System.out.println("********** sjf ***********");
			int tot=0;
			System.out.print("Enter number of process: ");
			n = sc.nextInt();
			process = new int[n];
			bst= new int[n];
			wt= new int[n];
			tat = new int[n];
			System.out.println("\nEnter Burst time:");
			for(i=0;i<n;i++)
			{
			System.out.print("\nProcess["+(i+1)+"]: ");
			bst[i] = sc.nextInt();;
			process[i]=i+1; 
			}
			System.out.println("\n \t \t*************** Shortest Job First Scheduling*********");
			
			for(i=0;i<n;i++)
			{
			 int pp=i;

			for(j=i+1;j<n;j++)
			{
			if(bst[j]<bst[pp])
			pp=j;
			}
			temp=bst[i];
			bst[i]=bst[pp];
			bst[pp]=temp;
			temp=process[i];
			process[i]=process[pp];
			process[pp]=temp;
			}
			//First process has 0 waiting time

			wt[0]=0;
			//calculate waiting time
			for(i=1;i<n;i++)
			{
			wt[i]=0;
			for(j=0;j<i;j++)
			wt[i]+=bst[j];
			tot+=wt[i];
			}
			wt_avg=(float)tot/n;
			tot=0;
			System.out.println("----------------------------------------------------------");
			System.out.println("\nProcess\t| Burst Time \t|Waiting Time\t|Turnaround Time |");
			System.out.println("----------------------------------------------------------");
			for(i=0;i<n;i++)
			{
			tat[i]=bst[i]+wt[i];
			
			tot+=tat[i];
			System.out.println("\n p"+process[i]+"\t|\t "+bst[i]+"\t|\t "+wt[i]+"\t|\t"+tat[i]+"\t|\t ");
			System.out.println("----------------------------------------------------------");
			}
			
			tat_avg=(float)tot/n;
			System.out.println("\n\nAverage Waiting Time: "+wt_avg);
			System.out.println("\nAverage Turnaround Time: "+tat_avg);
			
			break;
		}
		

	}

}
