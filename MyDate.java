//package texnologia1;

class MyDate {
    private String name;
    private Double ammount;

    public MyDate(String name, Double ammount) {
       this.name = name;
       this.ammount = ammount;
    }

    public String getName() { return name; }
    public Double getAmmount(){ return ammount; }

    public void setName(String name) { this.name = name; }
    public void setAmmount(Double ammount) { this.ammount = ammount; }
 }

 /*int numOfDates = 0;
 List <MyDate> datesList = new ArrayList<MyDate>();
 for (i = 0; i < finalDates.size(); ++i) {
     if (i == 0) {
         MyDate tempDate = new MyDate(finalDates.get(i), 1.0);
         datesList.add(tempDate);
         numOfDates++;
         continue;
     }
     else {
         String curr = finalDates.get(i);
         String prev = finalDates.get(i-1);
         if (!curr.equals(prev)) {
             MyDate tempDate = new MyDate(finalDates.get(i), 1.0);
             datesList.add(tempDate);
             numOfDates++;
         }
         else {
             for (MyDate md : datesList) {
                 if (md.getDay().equals(curr)) {
                     Double v = md.getAmmount();
                     v += 1.0;
                     md.setAmmount(v);
                 }
             }
         }
     }
 }
 for (MyDate md : datesList) {
     System.out.println(md.getDay() + " " + md.getAmmount());
 }
 System.out.println(numOfDates + " --");*/
