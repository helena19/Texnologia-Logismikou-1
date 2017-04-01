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
