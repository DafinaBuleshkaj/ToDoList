public class Tasks {
   public int day;
   public int hour;
   
   public Tasks(int day, int hour) {
      this.day = day;
      this.hour = hour;
   }
    public int getHour() {
      return hour;
   }
   
   public static String getDayFormated(int day) {
      switch(day)
     {
         case 1:
            return "Monday";
         case 2:
            return "Tuesday";
         case 3:
            return "Wednesday";
         case 4:
            return "Thursday";
         case 5:
            return "Friday";
         case 6:
            return "Saturday";
         case 7:
            return "Sunday";
         default:
            return "Unknown";
      }
      
  }
     
}