package lab5;

public class Name {
    private String firstname;
    private String middlename;
    private String lastname;
    
    public Name(String first,String middle,String last){
        firstname=first;
        middlename=middle;
        lastname=last;
        return;
    }
    
    //getFirst
    public String getFrist(){
        return firstname;
    }
    
    //get middle name
    public String getMiddle(){
        return middlename;
    }
    
    //get Last name
    public String getLast(){
        return lastname;
    }
    
    //full name
    public String firstMiddleLast(){
        return firstname + " " + middlename + " " + lastname;
    }

    //return full name but lastname first
    public String lastFirstMiddle(){
        return lastname + ", " + firstname + " " + middlename;
    }
    
    //compare name
    public boolean equals(Name othername){
        return this.firstMiddleLast().equalsIgnoreCase(othername.firstMiddleLast());
        }
    
    //the person's initials
    public String initials(){
        String f , m , l;
        f = firstname.toUpperCase().substring(0, 1);
        m = middlename.toUpperCase().substring(0, 1);
        l = lastname.toUpperCase().substring(0, 1);
        return f + m + l;
    }
    
    public int length(){
        return firstMiddleLast().replace(" ", "").length();
        //return firstMiddleLast().length();
    }
}
