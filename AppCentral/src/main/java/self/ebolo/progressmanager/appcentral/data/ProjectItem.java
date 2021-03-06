package self.ebolo.progressmanager.appcentral.data;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectItem implements Serializable {
    private String subjectName;
    private int startDate;
    private int dueDate;
    private String subjectDesc;
    private ArrayList<ActivityItem> subjectActList;
    private int completePerc;
    private String color;

    public ProjectItem() {
        subjectName = "";
        subjectActList = new ArrayList<>();
        completePerc = 0;
        startDate = 0;
        dueDate = 0;
    }

    public void addAct(ActivityItem Act) {
        subjectActList.add(Act);
    }

    public int percenCalc() {
        completePerc = 0;
        if (subjectActList != null && subjectActList.size() > 0) {
            float generalTaskPerc = 100f / (float) subjectActList.size();

            for (int i = 0; i < subjectActList.size(); i++) {
                completePerc += (int) Math.ceil(subjectActList.get(i).percenCalc() * generalTaskPerc);
            }
            if (completePerc > 100)
                completePerc = 100;
        }
        return completePerc;
    }

    public int getActListCount() {
        return subjectActList.size();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String input) {
        subjectName = input;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

    public void setSubjectDesc(String input) {
        subjectDesc = input;
    }

    public int getCompletePerc() {
        return completePerc;
    }

    public void setCompletePerc(int input) {
        completePerc = input;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int date) {
        startDate = date;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int date) {
        dueDate = date;
    }

    public void setColor(String hexCode) {
        color = hexCode;
    }

    public String getColor() { return color; }
}
