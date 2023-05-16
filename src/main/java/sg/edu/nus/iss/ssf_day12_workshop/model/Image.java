package sg.edu.nus.iss.ssf_day12_workshop.model;

// to populate the image data
public class Image {

    public String name;
    private String path;

    // constructors
    public Image(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public Image(){

    }

    // getters and setters 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Image [name=" + name + ", path=" + path + "]";
    }

    
    
}
