import javax.swing.*;

public class ToDoListManager 
{ 
   private Tasks[][] tasks;
   private boolean[][] done_tasks;
   SomeTasksToDo obj= new SomeTasksToDo();
   
   public ToDoListManager()
  { 
      tasks = new Tasks[7][24];
      done_tasks=new boolean[7][24];
  }
    
   public void run() 
  { 
     try {
      String input = JOptionPane.showInputDialog
       ("Give the action:\n 0 - to add a task,\n 1 -  to finish  a task,\n 2 - to list the tasks,"+
        "\n 3 - to see your to do list\n 4 -  to see your pending and completed tasks and  \n another number to terminate the program");
      if(input.equals("")||input==null)
          JOptionPane.showMessageDialog(null,"You have typed Ok or Cancel"); 

      int action = new Integer(input).intValue();
      
      if(action == 4)
        {JOptionPane.showMessageDialog(null, "you have to do " + howManyLeft()+" tasks ,you have finished "+ howManyFinished());}
        else
            {
             switch(action)
            {
              case 0:
                 obj.newTask1();
                 printTasks();
                 break;
              case 1:
                 taskDone();
                 break;
              case 2:
                  listTasks();
                  break;
              case 3:
                  printTasks();
                  break;
             default:
                return;
             }
           } } catch(Exception e) { System.out.println("Error"); }
           
                              
      run();
   
   
 }
   
    public void taskDone() 
   {
      String input = JOptionPane.showInputDialog("Assign the task day and hour in the format day:hour (X:XX) as int:int that you've finished or you want to delete");
      String[] values = input.split(":");
     
      if(values.length == 2)
        {
       
           int day = new Integer(values[0]).intValue(); 
           int hour = new Integer(values[1]).intValue();
       
           if(day < 1 || day > 7 || hour < 0 || hour > 23||done_tasks[day-1][hour])  // ||tasks[day][hour]==null
             {JOptionPane.showMessageDialog(null,"Bad inputs for days: "+day +"\n or hours: "+hour+"\n or you have finished this task: "+done_tasks[day-1][hour]);}
       
             else 
                 {done_tasks[day-1][hour] = true; }
        }   
        
     
      else 
          {System.out.println("Error,bad inputs");}
   }
   
     public void printTasks() 
    {
      String result = "";
      for(int i = 1; i<=7; i++)
      
         {
          String dayFormated = Tasks.getDayFormated(i);
          String dayTask = getTasksString(i);
        
          if(dayTask.length()!=0)
              result +="\n"+dayFormated + " " + dayTask+"\n";
          else 
              result += dayFormated + "\n" + dayTask +"\n";
         }
          if(howManyLeft()==0)
          System.out.println(result+ "you have no tasks to do ");
          
          else{ System.out.println();
                System.out.println(result+ "you have to do " + howManyLeft()+" tasks ,you have finished "+ howManyFinished());}
     
    }
   
    public void listTasks()
   {
     String dayString = JOptionPane.showInputDialog("For which day do you want to list the tasks(Input as integer 1-7)");
     int day = new Integer(dayString).intValue();
     String dayFormated = Tasks.getDayFormated(day);
     String result = "";
    
      if(day > 0 && day < 8)
        {result = getTasksString(day);}
      
        JOptionPane.showMessageDialog(null, dayFormated + ":\n" + result);
   }
   
    public String getTasksString(int day) 
   {
      String result = "";
      for(int hour = 0 ; hour < 24; hour++)
      {
         if((obj.contents(hour,(day-1))!= null)&&(done_tasks[day-1][hour]==true))     //if((tasks[day-1][hour] != null)&&(done_tasks[day-1][hour]==true))
 
           {result += "\n Hour: " + (obj.contents(hour,(day-1))).getHour()+" " +obj.contentsOfTasks((day-1),hour)+"+  you have finished this ";}
            
            else{
                 if((obj.contents(hour,(day-1)) != null)&&(done_tasks[day-1][hour]==false))
                    {result += "\n Hour: " + (obj.contents(hour,(day-1))).getHour()+" " 
                     +obj.contentsOfTasks((day-1),hour)+"--> you have to do this ";}                    
                 
           
                 else {if(tasks[day-1][hour] != null)
                      {result += "\n Hour: " + tasks[day-1][hour].getHour() +" " +obj.contentsOfTasks((day-1),hour);}}
                }
     }
             
      return result;
  }
       
     
   public int howManyLeft()
  {
    int count=0;
    for(int i=0;i!=tasks.length;i++)
       {
         for(int j=0;j!=tasks[0].length;j++)
             if(obj.contentsOfTasks(i,j)!=null)
             {count++;} 
       }
     return count;
  }
   
   public int howManyFinished()
  {
    int count=0;
    for(int i=0;i!=done_tasks.length;i++)
       {
         for (int j=0;j!=tasks[0].length;j++)
              if(done_tasks[i][j]==true)
              {count++;} 
       }
     return count;
   }
  
}