package bigapp.utsav.model;

/**
 * Created by nitikaaggarwal on 15/06/16.
 */
public class Festival {
    private String title, date;

    public Festival() {
    }

    public Festival(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String year) {
        this.date = date;
    }



}
