package controller.big;

import user.interf.TextLabel;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface InfoDB {
    ArrayList<TextLabel> getLabels();

    void addTextLabel (TextLabel lab);
    void removeTextLabel (TextLabel lab);
    void removeAllLabels ();
    void notifySubscribers (ResultSet rs);

}
