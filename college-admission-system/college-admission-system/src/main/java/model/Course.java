package model;

public class Course {
    private int id;
    private String name;
    private int cutoff;

    public Course() {}

    public Course(int id, String name, int cutoff) {
        this.id = id; this.name = name; this.cutoff = cutoff;
    }

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }
    public String getName() { 
    	return name; 
    }
    public void setName(String name) { 
    	this.name = name; 
    }
    public int getCutoff() { 
    	return cutoff; 
    }
    public void setCutoff(int cutoff) { 
    	this.cutoff = cutoff;
    }
}
