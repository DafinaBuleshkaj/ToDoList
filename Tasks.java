import javax.swing.*;
public class SomeTasksToDo
{
 Tasks[][] tasks;
 String[][] to_do ;
  
   public SomeTasksToDo()
  {  
    tasks=new Tasks[7][24];  
    to_do=new String[7][24];}
   
   public void newTask1() 
  {
    String input = JOptionPane.showInputDialog("Assign the task day and hour in the format day:hour (X:XX) as int:int");
    String[] values = input.split(":");
    int day = new Integer(values[0]).intValue();
    int hour = new Integer(values[1]).intValue();
     
    if(day < 1 || day > 7 || hour < 0 || hour > 23)
    
      {JOptionPane.showMessageDialog(null,"Day :"+day+" or hour input :"+hour+" out of range");}
        
      else
          {
               if(tasks[day-1][hour]!=null)
                 {JOptionPane.showMessageDialog(null,"You already have a task in day : "+(day-1)+" hour: "+hour);}
              else
                  { 
                    Tasks newTask = new Tasks(day-1, hour);
                    tasks[day-1][hour] = newTask;
                    input =JOptionPane.showInputDialog("Type the task");
                    appendToTasks(input,day-1,hour);                  
                  }
          }
  }
     
   public void appendToTasks(String a,int i,int j)
  {
     String answer=a.toLowerCase().trim();
     answer=a.substring(0,1).toUpperCase()+a.substring(1).toLowerCase();
     to_do[i][j]=answer; 
  }
    
    public Tasks contents(int hour,int day)
  {   
         Tasks answer = new Tasks(hour,day);
      { answer = tasks[day][hour]; }
        return answer;
  }
  
  public String contentsOfTasks(int day,int hour)
  { 
      String answer="";
    { answer = to_do[day][hour]; }
       
    return answer;
  }

}
